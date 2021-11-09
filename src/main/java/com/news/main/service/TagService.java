package com.news.main.service;

import com.news.main.entity.Tag;
import com.news.main.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService {

    @Autowired
    TagRepository tagRepository;

    //METHOD GET ALL TAGS
    public List<Tag> getAllTags(){
    	
    	List<Tag> tags = new ArrayList<>();
    	tagRepository.findAll()
    	.forEach(tags::add);
    	
    	return tags;
    				
    }
    
    //METHOD GET TAG BY ID
    public Tag getTagById(int id) {
        return tagRepository.findById(id).get();
    }
    
    //METHOD ADD NEW TAG
    public void addTag(Tag tag) {
       tagRepository.save(tag);
    }
    
    //METHOD DELETE TAG
    public void deleteTag(int id) {
    	tagRepository.deleteById(id);
    }
    
    //METHOD UPDATE TAG
    public void updateTag(Tag tag, int id) {
    	tagRepository.save(tag);
    }


}
