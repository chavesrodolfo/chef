package com.chavesrodolfo.chef.service;

import com.chavesrodolfo.chef.model.Tag;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService {

    private static List<Tag> tags = new ArrayList<Tag>();

    static {
        Tag tagA = new Tag();
        tagA.setId(1L);
        tagA.setNome("TAG A");
        Tag tagB = new Tag();
        tagB.setId(1L);
        tagB.setNome("TAG B");
    }

    public List<Tag> listarTags() {
        return tags;
    }

    public void criarTag(Tag tag) {
        tags.add(tag);
    }

}
