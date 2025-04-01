package hello.DarakBang.community.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class CommunityCategory {

    // 기본 생성자 (JPA용)
    public CommunityCategory() {
    }

    // ID와 이름을 설정하는 생성자
    public CommunityCategory(Long communityCategoryId, String name) {
        this.id = communityCategoryId;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "community_category_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Post> posts;
}
