package com.news.main.service;

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

        List<News> news = new ArrayList<>();
        newsRepository.findAll()
                .forEach(news::add);

        return news;
    }
}
