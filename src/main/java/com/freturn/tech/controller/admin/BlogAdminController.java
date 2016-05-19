package com.freturn.tech.controller.admin;

import com.freturn.tech.biz.domain.User;
import com.freturn.tech.biz.manager.BlogManager;
import com.freturn.tech.biz.manager.UserManager;
import com.freturn.tech.security.login.LoginUserHolder;
import com.freturn.tech.support.constant.PathConstant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author yangtao.lyt
 * @version $Id: BlogController, v 0.1 2016-04-27 19:51 yangtao.lyt Exp $
 */
@Controller
public class BlogAdminController {

    @Resource
    private BlogManager     blogManager;

    @Resource
    private UserManager userManager;

    @Resource
    private LoginUserHolder loginUserHolder;

    @RequestMapping(value = "/admin/blog/edit/{type}", method = RequestMethod.GET)
    public String getUserHome(@PathVariable String type, ModelMap modelMap) {

        if (loginUserHolder.isNotLogin()) {
            modelMap.addAttribute("msg", "提示:您需要先登录,才能发表博客!");
            return PathConstant.BLOG_EDIT;
        }

        modelMap.addAttribute("active", type.toLowerCase());

        User user = userManager.getUserById(loginUserHolder.getId());

        modelMap.addAttribute("user", user);

        return PathConstant.BLOG_EDIT;
    }

    @RequestMapping(value = "/admin/blog/create", method = RequestMethod.POST)
    public String createStandardBlog(@RequestParam String title, @RequestParam String content, @RequestParam String category,
                                     ModelMap modelMap) {

        if (loginUserHolder.isNotLogin()) {
            modelMap.addAttribute("msg", "提示:您需要先登录,才能发表博客!");
            return PathConstant.BLOG_EDIT;
        }

        String blogId = blogManager.createStandardBlog(title, content, category);

        return "redirect:/blog/" + blogId;
    }

    @RequestMapping(value = "/admin/gallery/create", method = RequestMethod.POST)
    public String createGallery(@RequestParam MultipartFile[] images, @RequestParam String desc, @RequestParam String category,
                                     ModelMap modelMap) {

        if (loginUserHolder.isNotLogin()) {
            modelMap.addAttribute("msg", "提示:您需要先登录,才能发表博客!");
            return PathConstant.BLOG_EDIT;
        }

        String blogId = blogManager.createGalleryBlog(images, desc, category);

        return "redirect:/blog/" + blogId;

    }

    @RequestMapping(value = "/admin/link/create", method = RequestMethod.POST)
    public String createLink(@RequestParam String title, @RequestParam String url, @RequestParam String category,
                                ModelMap modelMap) {

        if (loginUserHolder.isNotLogin()) {
            modelMap.addAttribute("msg", "提示:您需要先登录,才能发表博客!");
            return PathConstant.BLOG_EDIT;
        }


        String blogId = blogManager.createLinkBlog(title, url, category);

        return "redirect:/blog/" + blogId;

    }

    @RequestMapping(value = "/admin/quote/create", method = RequestMethod.POST)
    public String createQuote(@RequestParam String cite, @RequestParam String content, @RequestParam String category,
                             ModelMap modelMap) {
        if (loginUserHolder.isNotLogin()) {
            modelMap.addAttribute("msg", "提示:您需要先登录,才能发表博客!");
            return PathConstant.BLOG_EDIT;
        }


        String blogId = blogManager.createQuoteBlog(cite, content, category);

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
