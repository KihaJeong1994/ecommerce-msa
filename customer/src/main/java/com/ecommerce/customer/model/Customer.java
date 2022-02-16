package com.ecommerce.customer.model;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity //db의 테이블과 1대1 매칭
public class Customer {
    @Id
    @Column(nullable = false, length = 256)
    private String userid;

    @Column(nullable = false, length = 256)
    private String pwd;

    @Column(nullable = false, length = 256)
    private String name;

    @Column(nullable = false, length = 256, unique = true)
    private String email;

    @CreationTimestamp
    private Timestamp createDate;
}
