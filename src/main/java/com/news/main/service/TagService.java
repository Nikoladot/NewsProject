package com.news.main.service;

import com.news.main.entity.Tag;
import com.news.main.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    TagRepository tagRepository;

    // List of tags
    public List<Tag> getTags() {

        return tagRepository.findAll();
    }


}
