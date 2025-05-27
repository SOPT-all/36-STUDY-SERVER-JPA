package hellojpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Member extends BaseEntity {

    public Member() {
    }
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;


    @Column(name = "name")
    private String name;

    private String city;
    private String street;
    private String zipcode;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(final String zipcode) {
        this.zipcode = zipcode;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(final RoleType roleType) {
        this.roleType = roleType;
    }





    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setTeam(final Team team) {
        this.team = team;
    }

    private Integer age;

    // DB 에는 ENUM TYPE 이 없기 때문에, @Enumerated 를 붙이면 된다.
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    // LocalDate, LocalDateTime 을 사용할때는 애노테이션 안 붙여도 된다 .
    // @Temporal(TemporalType.TIMESTAMP)
    // private Date createdDate;

    // @Temporal(TemporalType.TIMESTAMP)
    // private Date lastModifiedDate;

    @Lob // blob, clob 매핑
    private String description;
//    @Column(name = " TEAM_ID")
//    private Long teamId;


    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    // @ManyToMany
    // @JoinTable(name = "MEMBER_PRODUCT")
    // private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>();





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return name;
    }

    public void setUsername(final String name) {
        this.name = name;
    }

//    public Long getTeamId() {
//        return teamId;
//    }
//
//    public void setTeamId(final Long teamId) {
//        this.teamId = teamId;
//    }


    public Team getTeam() {
        return team;
    }

    // 연관관계 편의 메소드
    public void changeTeam(final Team team) {
        this.team = team;
        team.getMembers().add(this);
    }

}
