package com.ecommerce.order.model;


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
public class Orders {
    @Id
    @Column(nullable = false, length = 256)
    private String orderId;

    @Column(nullable = false, length = 256)
    private String userId;

    @Column( length = 256)
    private String name;

    @Column(nullable = false, length = 256)
    private String productId;

    @Column
    private int quantity;

    @Column
    private int unitPrice;

    @Column
    private int totalPrice;

    @CreationTimestamp
    private Timestamp createDate;
}
