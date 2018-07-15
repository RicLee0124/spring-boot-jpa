package com.lrm.service;

import com.lrm.domain.Comment;
import com.lrm.domain.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Transactional
    @Override
    public void deleteComment(Long id) {
//        commentRepository.deleteById(id);
//        commentRepository.deleteBy(id);
        Optional<Comment> opt = commentRepository.findById(id);
        if(opt.isPresent()){
            Comment comment = opt.get();
            //解除关联关系
            comment.clearComment();
            commentRepository.deleteById(id);
        }
    }
}
