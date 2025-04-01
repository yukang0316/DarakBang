package hello.imagine.community.service;

import hello.imagine.community.model.CommunityCategory;
import hello.imagine.community.model.CommunityCategory;
import hello.imagine.community.model.Post;
import hello.imagine.community.repository.CategoryRepository;
import hello.imagine.community.repository.PostRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PostRepository postRepository;

    // 고정된 카테고리 목록을 정의합니다.
    private final List<CommunityCategory> fixedCategories = Arrays.asList(
            new CommunityCategory(1L, "요리"),
            new CommunityCategory(2L, "운동"),
            new CommunityCategory(3L, "취업"),
            new CommunityCategory(4L, "만화"),
            new CommunityCategory(5L, "패션"),
            new CommunityCategory(6L, "여행")
    );

    // 애플리케이션 시작 시 실행되는 메서드
    @PostConstruct
    public void init() {
        // 고정된 카테고리를 데이터베이스에 저장합니다.
        for (CommunityCategory category : fixedCategories) {
            if (!categoryRepository.existsById(category.getId())) {
                categoryRepository.save(category);
            }
        }
    }

    public List<CommunityCategory> getAllCategories() {
        return categoryRepository.findAll();
    }

    // 카테고리 ID로 게시글 목록 가져오는 메서드
    public List<Post> getPostsByCategoryId(Long categoryId) {
        // PostRepository를 이용해 해당 카테고리 ID로 게시글 가져오기
        return postRepository.findByCategoryId(categoryId);
    }

    public CommunityCategory findByName(String name) {
        Optional<CommunityCategory> category = categoryRepository.findByName(name);
        return category.orElse(null);
    }
}