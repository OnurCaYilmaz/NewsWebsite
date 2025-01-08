package com.newswebsite.newswebsite.service;

import com.newswebsite.newswebsite.model.News;
import com.newswebsite.newswebsite.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NewsService {
    
    @Autowired
    private NewsRepository newsRepository;
    
    // Tüm haberleri getir
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }
    
    // ID'ye göre haber getir
    public Optional<News> getNewsById(Long id) {
        return newsRepository.findById(id);
    }
    
    // Yeni haber ekle
    public News saveNews(News news) {
        return newsRepository.save(news);
    }
    
    // Haber güncelle
    public News updateNews(News news) {
        return newsRepository.save(news);
    }
    
    // Haber sil
    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }
    
    // Kategoriye göre haberleri getir
    public List<News> getNewsByCategory(String category) {
        return newsRepository.findByCategory(category);
    }
    
    // Son eklenen haberleri getir
    public List<News> getLatestNews() {
        return newsRepository.findLatestNews();
    }
    
    // Başlığa göre haber ara
    public List<News> searchNews(String keyword) {
        return newsRepository.searchByTitle(keyword);
    }
}