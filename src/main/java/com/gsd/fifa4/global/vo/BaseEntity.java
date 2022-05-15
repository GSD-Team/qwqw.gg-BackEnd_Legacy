//package com.gsd.fifa4.global.vo;
//
//import java.time.LocalDateTime;
//import javax.persistence.Column;
//import javax.persistence.EntityListeners;
//import javax.persistence.MappedSuperclass;
//import lombok.Getter;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedDate;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//
///**
// * Created by Yohan lee
// * Created on 2021-03-22.
// **/
//@Getter
//@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
//public abstract class BaseEntity {
//
//    @CreatedDate
//    @Column(name = "created_date", nullable = false)
//    private LocalDateTime createdDate;
//
//    @LastModifiedDate
//    @Column(name = "updated_date")
//    private LocalDateTime updatedDate;
//}
