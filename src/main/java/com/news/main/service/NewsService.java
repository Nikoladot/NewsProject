package com.news.main.service;

import com.news.main.entity.News;
import com.news.main.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {

    @Autowired
    NewsRepository newsRepository;

    public List<News> getAllNews(){
// List of all tags
        List<News> news = new ArrayList<News>();
        newsRepository.findAll()
                .forEach(news::add);

        return news;
    }
// One tag by id
    public News getNewsById(int id) {

        return newsRepository.findById(id).get();
    }
    //method to add new post
    public void addNews(News news) {

        newsRepository.save(news);
    }

    //delete tag
    public void deleteNews(int id) {

        newsRepository.deleteById(id);
    }

    // method to update post
    public void updateNews(News news, int id) {

        newsRepository.save(news);
    }

}
