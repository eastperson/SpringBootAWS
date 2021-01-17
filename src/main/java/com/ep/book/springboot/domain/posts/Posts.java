package com.ep.book.springboot.domain.posts;

import com.ep.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// Entity 쿨래스는 Setter 메서드를 만들지 않는다.
// 이유는 set의 기능을 활용할 때는 명확한 의도와 목적이 있어야 하고, 그 의도가 메서드명에 반영이 되어있어야 하기 때문이다.
// 기본적인 구조는 생성자를 통해 값을 채우는 것이다.
@Getter
@NoArgsConstructor
// 주요 어노테이션을 클래스에 가깝게 작성한다.
// 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭한다.
@Entity
public class Posts extends BaseTimeEntity {


    // PK 필드를 나타낸다.
    @Id
    // PK의 생성 규칙을 나타낸다.
    // 스프링 부트 2.0에서는 GenerationType.IDENTITY옵션을 추가하면 auto_increment가 된다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Column은 굳이 선언하지 않아도 클래스의 필드는 모두 칼럼이 된다.
    // @Column은 타입을 설정할 수 있다.
    // bigint
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;

    private String author;

    // 빌드를 생성자에 적용하면 해당 생성자에 한해서만 빌드 패턴으 구현된다.
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }


}
