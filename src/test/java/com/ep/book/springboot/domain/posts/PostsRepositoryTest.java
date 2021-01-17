package com.ep.book.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    private PostsRepository postsRepository;

    // junit이 단위 테스트가 끝날 때마다 실행 되는 메서드
    // 배포 전 전체 테스트를 수행할 때 테스트간 데이터 침범을 막기 위해 사용

    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void post(){

        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        // save는 id가 있으면 update, 없으면 insert를 실행시킨다.
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("ep@aaa.com")
                .build());

        // findAll()은 테이블에 있는 모든 데이터를 가져온다.
        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }

    @Test
    public void BaseTimeEntity_register() {
        //given
        LocalDateTime now = LocalDateTime.of(2021,1,17,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>> creaDate=" + posts
                .getCreatedDate()+", modifiedDate=" + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);

    }

}