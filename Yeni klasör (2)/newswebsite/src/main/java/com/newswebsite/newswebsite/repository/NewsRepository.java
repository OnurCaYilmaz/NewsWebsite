package com.newswebsite.newswebsite.repository;

import com.newswebsite.newswebsite.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    
    // Kategoriye göre haberleri getir
    List<News> findByCategory(String category);
    
    // Son eklenen haberleri getir
    @Query("SELECT n FROM News n ORDER BY n.createdAt DESC")
    List<News> findLatestNews();
    
    // Başlığa göre haber ara
    @Query("SELECT n FROM News n WHERE n.title LIKE %:keyword%")
    List<News> searchByTitle(String keyword);
}