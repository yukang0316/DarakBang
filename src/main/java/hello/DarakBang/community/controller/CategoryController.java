package hello.DarakBang.community.controller;

import hello.DarakBang.community.dto.PostDTO;
import hello.DarakBang.community.model.CommunityCategory;
import hello.DarakBang.community.model.Post;
import hello.DarakBang.community.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CommunityCategory>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    // 카테고리 ID로 해당하는 게시글 목록 가져오기
    @GetMapping("/{categoryId}/posts")
    public ResponseEntity<List<PostDTO>> getPostsByCategory(@PathVariable Long categoryId) {
        List<Post> posts = categoryService.getPostsByCategoryId(categoryId);
        List<PostDTO> postDTOs = posts.stream()
                .map(PostDTO::new)
                .collect(Collectors.toList());
        Collections.reverse(postDTOs);
        return ResponseEntity.ok(postDTOs);
    }


}