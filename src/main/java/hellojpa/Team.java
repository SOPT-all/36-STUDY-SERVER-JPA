package hellojpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

  @Id @GeneratedValue
  @Column(name = "TEAM_ID")
  private Long id;
  private String name;


  @OneToMany(mappedBy = "team") // Member 의 team 이 연관관계의 주인이다.
  // 여기서는 조회만 가능.
  private List<Member> members = new ArrayList<>();

  public List<Member> getMembers() {
    return members;
  }

  public void setMembers(final List<Member> members) {
    this.members = members;
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }
}
