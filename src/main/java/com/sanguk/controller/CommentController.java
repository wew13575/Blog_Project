package com.sanguk.controller;

import lombok.extern.log4j.Log4j;
import scala.collection.mutable.Map;

import java.security.Principal;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sanguk.domain.CommentVO;
import com.sanguk.domain.UserVO;
import com.sanguk.mapper.UserMapper;
import com.sanguk.security.domain.CustomUser;
import com.sanguk.service.ArticleServiceimpl;
import com.sanguk.service.CommentServiceimpl;
import com.sanguk.service.UserServiceimpl;
import com.sanguk.util.CommentUtils;
import com.sanguk.util.ProfileUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/comment")
@Log4j
public class CommentController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    CommentServiceimpl commentService;

    @Autowired
    ArticleServiceimpl articleService;


    @PostMapping("/write")
    @ResponseBody
    @Transactional
	public ResponseEntity<?> registerComment(@RequestBody CommentVO commentVO) {
        commentService.registerComment(commentVO);
        commentVO = commentService.getComment(commentVO.getId());
        return ResponseEntity.ok().body(commentVO);
    }
    
	@PostMapping("/delete")
    @Transactional
	public ResponseEntity<?> deleteComment(@RequestBody ObjectNode objectNode) {
        
        String commentid = objectNode.get("commentId").asText();
        int commentId = Integer.parseInt(commentid);
        log.info(commentId+"");

		UserVO userVO = ProfileUtils.getProfile(userMapper);
		CommentVO commentVO = commentService.getComment(commentId);

		if(!CommentUtils.isCommentAuthor(commentVO, userVO)){
            return ResponseEntity.badRequest().build();
        }
        

		commentService.deleteComment(commentVO.getId());
		return ResponseEntity.ok().build();
	}

}
