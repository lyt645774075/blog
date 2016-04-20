package com.freturn.tech.controller.ajax;

import com.google.common.collect.Maps;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author yangtao.lyt
 * @version $Id: AjaxController, v 0.1 2016-04-12 15:17 yangtao.lyt Exp $
 *
 *
 * demo场景:接收ajax请求,返回json数据的
 *
 */
@Controller
public class AjaxController {

    @RequestMapping(value = "/testGetJson", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> doGetJson(){
        Map<String,Object> jsonMap = Maps.newHashMap();

        jsonMap.put("success", true);
        jsonMap.put("desc", "测试获取json数据的场景,如果你看到此文字,说明工程能够正常获取json数据");


        return jsonMap;
    }


}
