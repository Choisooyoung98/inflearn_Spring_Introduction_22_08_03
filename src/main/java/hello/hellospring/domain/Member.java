package hello.hellospring.domain;

import javax.persistence.*;

@Entity // jpa는 orm 객체의 오브젝트와 relation database 테이블을 mapping 한다. Jpa가 관리하는 Entity이다.
public class Member {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 디비가 알아서 생성해주는 primarykey? 라고 보면된다.
    private Long id;

    @Column(name = "username") // DB 컬럼 명이 "username" 이면 이렇게 명시해준다.
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
