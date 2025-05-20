package hellojpa;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
// @TableGenerator(
// 	name = "MEMBER_SEQ_GENERATOR",
// 	table = "MY_SEQUENCES",
// 	pkColumnValue = "MEMBER_SEQ", allocationSize = 1)
public class Member {
	@Id
	@GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;

	@Column(name = "USERNAME")
	private String username;

	@ManyToOne
	@JoinColumn(name = "TEAM_ID", insertable = false, updatable = false) //읽기 전용
	private Team team;

	@OneToOne
	@JoinColumn(name = "LOCKER_ID")
	private Locker locker;

	// @ManyToMany
	// @JoinTable(name = "MEMBER_PRODUCT") // 테이블 명을 적어주면 된다.
	// private List<Product> products = new ArrayList<>();
	@OneToMany(mappedBy = "member")
	private List<MemberProduct> memberProducts = new ArrayList<>();

	// @Column(name = "TEAM_ID")
	// private Long teamId;

	// @ManyToOne
	// @JoinColumn(name = "TEAM_ID")
	// private Team team;

	protected Member() {

	}

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

	// public Team getTeam() {
	// 	return team;
	// }
	//
	// public void setTeam(Team team) {
	// 	this.team = team;
	// }

	// 필드와 컬럼 매핑
	/*
	private int age;

	@Enumerated(EnumType.STRING)
	private RoleType roleType;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	private LocalDate testLocalDate;
	private LocalDateTime testLocalDateTime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifinedDate;

	@Lob
	private String description;

	@Transient
	private int temp;

	protected Member() {

	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifinedDate() {
		return lastModifinedDate;
	}

	public void setLastModifinedDate(Date lastModifinedDate) {
		this.lastModifinedDate = lastModifinedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}
	*/

}
