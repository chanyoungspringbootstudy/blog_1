package kr.hs.dgsw.blog;

import java.util.List;

public interface Service {
    List<Post> listPost();          //조회
    Post addPost(Post post);        //작성
    Post updatePost(Post post,Long id);     //수정
    boolean removePost(Long id);    //삭제
}
