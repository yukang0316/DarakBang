package hello.DarakBang.community.controller;

import hello.DarakBang.community.model.Post;
import hello.DarakBang.community.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts/popular")
public class PopularPostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getPopularPosts() {
        return ResponseEntity.ok(postService.getPopularPosts());
    }
}
