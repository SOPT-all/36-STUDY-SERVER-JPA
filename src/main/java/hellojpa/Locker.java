package hellojpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Locker {

	@Id @GeneratedValue
	public Long id;

	private String name;

	// 양방향으로 설정하고 싶다면
	@OneToOne(mappedBy = "locker") // 연관관계 주인은 locker
	private Member member;

}
