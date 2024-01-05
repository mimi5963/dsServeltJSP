package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "USER") //유저테이블로 쿼리나감
public class Member { //관례를 따라서 추측
    @Id
    private Long id;

    //@Column(name = "username") //특정 컬럼이랑 맵핑
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
