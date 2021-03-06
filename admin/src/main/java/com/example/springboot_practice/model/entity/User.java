package com.example.springboot_practice.model.entity;

// Entity : JAP에서는 테이블을 자동으로 생성해주는 기능 존재
// DB Table == JPA Entity

// Annotation           용도
// @Entity              해당 Class가 Entity임을 명시
// @Table               실제 DB테이블의 이름을 명시
// @Id                  Index primary key를 명시
// @Column              실제 DB Column의 이름을 명시
// @GeneratedValue      Primary key 식별키의 전략 설정

// carmelCase와 snake_case는 자동으로 매칭 시켜줌

import com.example.springboot_practice.model.enumclass.UserStatus;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = {"orderGroup"})
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
// @Table(name = "user") // table과 class의 이름이 동일하면 선언하지 않아도 됨
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String account;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private String email;

    private String phoneNumber;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy // component에서 return 하는 값을 가지게 됨
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<OrderGroup> orderGroupList;


//    // FetchType : LAZY = 지연로딩, EAGER = 즉시로딩
//
//    // LAZY = SELECT * FROM item where id = ?
//    // 따로 method, orderDetailist에 대해 get method를 호출 하지 않는 이상, 연관관계가 설정된 테이블에 대해서 select를 하지 않겠다.
//
//    // EAGER = 모든 조인을 다 마치고 where item.id = ?
//    // 즉시 모든 것을 다 로딩 하겠다. 연관관계가 설정된 모든 테이블에 대해 join을 실행
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user") // user는 orderDetail의 변수명과 동일해야함
//    private List<OrderDetail> orderDetailList;

}
