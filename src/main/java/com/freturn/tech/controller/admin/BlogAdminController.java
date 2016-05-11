package com.freturn.tech.controller.admin;

import com.freturn.tech.biz.domain.Blog;
import com.freturn.tech.biz.manager.BlogManager;
import com.freturn.tech.security.login.LoginUserHolder;
import com.freturn.tech.support.constant.BlogStatus;
import com.freturn.tech.support.constant.BlogType;
import com.freturn.tech.support.constant.Device;
import com.freturn.tech.support.constant.PathConstant;
import com.freturn.tech.support.constant.SeeScope;
import com.freturn.tech.support.utils.BlogIdGenerator;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author yangtao.lyt
 * @version $Id: BlogController, v 0.1 2016-04-27 19:51 yangtao.lyt Exp $
 */
@Controller
public class BlogAdminController {

    @Resource
    private BlogManager     blogManager;

    @Resource
    private LoginUserHolder loginUserHolder;

    @RequestMapping(value = "/admin/blog/edit", method = RequestMethod.GET)
    public String getUserHome(ModelMap modelMap) {
        return PathConstant.BLOG_EDIT;
    }

    @RequestMapping(value = "/admin/blog/edit", params = "type=standard", method = RequestMethod.POST)
    public String createStandardBlog(@RequestParam String title, @RequestParam String content,
                                     ModelMap modelMap) {

        if (loginUserHolder.isNotLogin()) {
            modelMap.addAttribute("msg", "提示:您需要先登录,才能发表博客!");
            return PathConstant.BLOG_EDIT;
        }

        Blog blog = new Blog();

        String blogId = BlogIdGenerator.getBlogId();

        blog.setId(blogId);
        blog.setTitle(title);
        blog.setCreatorId(loginUserHolder.getId());
        blog.setCreatorNickName(loginUserHolder.getNickName());
        blog.setType(BlogType.STANDARD);
        blog.setCategory("默认");
        blog.setSeeScope(SeeScope.PRIVATE);
        blog.setStatus(BlogStatus.FINISH);
        blog.setDevice(Device.PC);
        blog.setLocation("四川成都");

        Map<String, String> contentMap = Maps.newHashMap();
        contentMap.put("title", title);
        contentMap.put("content", content);

        blog.setContentMap(contentMap);

        blogManager.createBlog(blog);

        return "redirect:/blog/" + blogId;
    }

    @RequestMapping(value = "/admin/blog/addComment", method = RequestMethod.POST)
    public String addComment(@RequestParam String blogId, @RequestParam String blogTitle,
                             @RequestParam String content, @RequestParam Long parentId, ModelMap modelMap) {

        if (loginUserHolder.isNotLogin()) {
            modelMap.addAttribute("msg", "提示:您需要先登录,才能发表评论!");
            return "redirect:/blog/" + blogId;
        }

        blogManager.addComment(blogId, blogTitle, content, parentId);

        return "redirect:/blog/" + blogId;
    }

}
