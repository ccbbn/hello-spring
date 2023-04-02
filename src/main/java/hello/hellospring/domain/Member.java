package hello.hellospring.domain;

import jakarta.persistence.*;

@Entity //jpa사용을 위해 선언
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)  // jpa 사용을 위해,,, id: 기본키, generate: db에서 자동으로 만들어지도록
    private Long id;

    //@Column(name = "username") db의 유저네임 컬럼이랑 연결
    private String name;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
