package com.softserveacademy.task2.converters;

import com.softserveacademy.task2.dto.ArticleDto;
import com.softserveacademy.task2.dto.UserDto;
import com.softserveacademy.task2.model.Article;
import com.softserveacademy.task2.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class ArticleConverter {


    public ArticleDto convert (Article article){
        ArticleDto dto = new ArticleDto();
        dto.setName(article.getName());
        dto.setText(article.getText());
        UserService userService = null;
        assert false;
        UserDto userDto = userService.findById(article.getUser().getId());
        dto.setUserName(userDto.getName());
        return dto;
    }

}
