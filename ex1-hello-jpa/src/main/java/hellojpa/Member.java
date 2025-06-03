package hellojpa;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Member {

//    // 직접 할당
//    @Id
//    private String id;

    // SEQUENCE 전략
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "username") //db 컬럼명
    private String username;

    // 기간 Period
    @Embedded
    private Period workPeriod;

    // 주소
    @Embedded
    private Address homeAddress;

//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "city", column = @Column(name = "work_city")),
//            @AttributeOverride(name = "street", column = @Column(name = "work_street")),
//            @AttributeOverride(name = "zipcode", column = @Column(name = "work_zipcode"))
//    })
//    private Address workAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Period getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(Period workPeriod) {
        this.workPeriod = workPeriod;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    //    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn
//    private Team team;
//
//    public Member() {
//
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public Team getTeam() {
//        return team;
//    }
//
//    public void setTeam(Team team) {
//        this.team = team;
//    }

    //    필드와 컬럼 매핑

//    private Integer age;

//    @Enumerated(EnumType.STRING)
//    private RoleType roleType;

//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;
//
//    private LocalDate testLocalDate; // 년,월
//    private LocalDateTime testLocalDateTime; // 년,월,일
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;

//    @Lob
//    private String description;

}
