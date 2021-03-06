package com.chavesrodolfo.chef.rest;

import com.chavesrodolfo.chef.model.Tag;
import com.chavesrodolfo.chef.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @RequestMapping("/tags.json")
    public @ResponseBody
    List<Tag> listarTags() {
        return tagService.listarTags();
    }

    @RequestMapping(value = "/cria/{tag}", method = RequestMethod.POST)
    public @ResponseBody
    void criarTag(@PathVariable("tag") Tag tag) {
        tagService.criarTag(tag);
    }

}
