package com.newswebsite.newswebsite.controller;

import com.newswebsite.newswebsite.model.News;
import com.newswebsite.newswebsite.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NewsController {
    
    @Autowired
    private NewsService newsService;
    
    // Ana sayfa
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("latestNews", newsService.getLatestNews());
        return "index";
    }
    
    // Haber detay sayfası
    @GetMapping("/news/{id}")
    public String newsDetail(@PathVariable Long id, Model model) {
        newsService.getNewsById(id).ifPresent(news -> model.addAttribute("news", news));
        return "news-detail";
    }
    
    // Kategori sayfası
    @GetMapping("/category/{category}")
    public String category(@PathVariable String category, Model model) {
        model.addAttribute("categoryNews", newsService.getNewsByCategory(category));
        model.addAttribute("category", category);
        return "category";
    }
    
    // Haber ekleme sayfası
    @GetMapping("/add-news")
    public String showAddNewsForm(Model model) {
        model.addAttribute("news", new News());
        return "add-news";
    }
    
    // Haber kaydetme
    @PostMapping("/save-news")
    public String saveNews(@ModelAttribute News news) {
        newsService.saveNews(news);
        return "redirect:/";
    }
    
    // Haber düzenleme sayfası
    @GetMapping("/edit-news/{id}")
    public String showEditNewsForm(@PathVariable Long id, Model model) {
        newsService.getNewsById(id).ifPresent(news -> model.addAttribute("news", news));
        return "edit-news";
    }
    
    // Haber güncelleme
    @PostMapping("/update-news")
    public String updateNews(@ModelAttribute News news) {
        newsService.updateNews(news);
        return "redirect:/news/" + news.getId();
    }
    
    // Haber silme
    @GetMapping("/delete-news/{id}")
    public String deleteNews(@PathVariable Long id) {
        newsService.deleteNews(id);
        return "redirect:/";
    }
    
    // Haber arama
    @GetMapping("/search")
    public String searchNews(@RequestParam String keyword, Model model) {
        model.addAttribute("searchResults", newsService.searchNews(keyword));
        return "search-results";
    }
}