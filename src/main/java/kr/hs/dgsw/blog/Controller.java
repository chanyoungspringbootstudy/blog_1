package kr.hs.dgsw.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    Service service;

    @GetMapping("/list")
    public List<Post>listPost(){
        return this.service.listPost();
    }

    @PostMapping("/add")
    public Post addPost(@RequestBody Post post){
        return this.service.addPost(post);
    }

    @PostMapping("/update/{id}")
    public Post updatePost(@RequestBody Post post,@PathVariable Long id){
        return this.service.updatePost(post,id);
    }

    @DeleteMapping("/remove/{id}")
    public boolean removePost(@PathVariable Long id){
        return this.service.removePost(id);
    }
}
