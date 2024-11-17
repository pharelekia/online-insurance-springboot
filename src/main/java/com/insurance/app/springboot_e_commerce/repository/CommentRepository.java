package com.insurance.app.springboot_e_commerce.repository;

import com.insurance.app.springboot_e_commerce.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
