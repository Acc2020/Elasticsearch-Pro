package com.node.controller;

import com.node.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/*
    @author www.github.com/Acc2020
    @date  2020/4/8
*/
@RestController
public class ContentController {
    @Autowired
    private ContentService contentService;
    @GetMapping("/parse/{keywords}")
    public Boolean parse(@PathVariable("keywords") String keywords) throws IOException {
        return contentService.parseContent(keywords);
    }

    @GetMapping("/search/{keywords}/{pageNo}/{pageSize}")
    public List<Map<String , Object>> search(@PathVariable("keywords") String keywords,
                                             @PathVariable("pageNo") int pageNo,
                                             @PathVariable("pageSize")int pageSize) throws IOException {
        // contentService.parseContent(keywords);
        return contentService.searchPageHighlighter(keywords,pageNo,pageSize);
    }
}
