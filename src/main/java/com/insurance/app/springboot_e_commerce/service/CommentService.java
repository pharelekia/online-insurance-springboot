package com.insurance.app.springboot_e_commerce.service;

import com.insurance.app.springboot_e_commerce.entity.Comment;
import com.insurance.app.springboot_e_commerce.exception.ProductNotFoundException;
import com.insurance.app.springboot_e_commerce.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }

    public Comment getComment(Long id){
        return commentRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("Comment not found"));
    }

    public Comment saveComment(Comment comment){
        return commentRepository.save(comment);
    }

    public Comment updateComment(Long id, Comment comment){
        Comment comment1 = getComment(id);
        comment1.setContent(comment.getContent());

        return commentRepository.save(comment1);
    }

    public String deleteComment(Long id){
        Comment comment = getComment(id);
        commentRepository.delete(comment);

        return "Comment deleted";
    }
}
