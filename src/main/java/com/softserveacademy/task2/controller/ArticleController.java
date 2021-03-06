package com.softserveacademy.task2.controller;

import com.softserveacademy.task2.dto.ArticleDto;
import com.softserveacademy.task2.model.Article;
import com.softserveacademy.task2.model.User;
import com.softserveacademy.task2.service.impl.ArticleServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Controller
public class ArticleController {

    private final ArticleServiceImpl articleService;

    public ArticleController(ArticleServiceImpl articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/article")
    public String findAll(Model model){
        List<Article> article = articleService.findAll();
        model.addAttribute("users", article);
        return "article-list";
    }

    @GetMapping("/article-create")
    public String createUserForm(User user){
        return "user-create";
    }

    @PostMapping("/article-create")
    public String createArticle(Article article){
        articleService.saveArticle(article);
        return "redirect:/articles";
    }

    @GetMapping("/article-delete/{id}")
    public String deleteArticle(@PathVariable("id") UUID id){
        articleService.deleteById(id);
        return "redirect:/articles";
    }

    @GetMapping("/article-update/{id}")
    public String updateArticleForm(@PathVariable("id") UUID id, Model model){
        Article article = articleService.findById(id);
        model.addAttribute("user", article);
        return "article-update";
    }

    @PostMapping("/article-update")
    public String updateArticle(Article article){
        articleService.saveArticle(article);
        return "redirect:/articles";
    }
}
