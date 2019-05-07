package kr.hs.dgsw.blog;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    @Autowired
    Repository repository;

    @PostConstruct
    void init() {
        this.repository.save(new Post("작성자1", "제목1", "내용1"));
        this.repository.save(new Post("작성자2", "제목2", "내용2"));
        this.repository.save(new Post("작성자3", "제목3", "내용3"));
    }

    @Override
    public List<Post> listPost() {
        return this.repository.findAll();
    }

    @Override
    public Post addPost(Post post) {
        return this.repository.save(post);
    }

    @Override
    public Post updatePost(Post post,Long id) {
        Optional<Post> found = this.repository.findById(id);
        if (found.isPresent()) {
            Post p = found.get();
            p.setTitle(post.getTitle());
            p.setContent(post.getContent());
            return this.repository.save(p);
        } else {
            return null;
        }
    }

    @Override
    public boolean removePost(Long id) {
        Optional<Post> found = this.repository.findById(id);
        if (found.isPresent()){
            this.repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
