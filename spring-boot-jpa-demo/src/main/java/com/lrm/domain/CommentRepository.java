package com.lrm.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends JpaRepository<Comment,Long> {


    //暴力删除方法，存在问题
    @Modifying
    @Query("delete from Comment c where c.id = ?1")
    void deleteBy(Long id);

}
