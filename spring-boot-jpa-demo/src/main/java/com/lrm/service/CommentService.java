package com.lrm.service;

import com.lrm.domain.Comment;

public interface CommentService{

    Comment saveComment(Comment comment);

    void deleteComment(Long id);

}
