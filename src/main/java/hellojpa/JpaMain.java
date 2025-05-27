package hellojpa;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {

			Member member = new Member();
			member.setUsername("user1");
			member.setCreatedBy("kim");
			member.setCreatedDate(LocalDateTime.now());

			em.persist(member);

			em.flush();
			em.clear();

			tx.commit();


			// Movie movie = new Movie();
			// movie.setDirector("aaaa");
			// movie.setActor("bbbb");
			// movie.setName("바람과 함께 사라지다");
			// movie.setPrice(10000);
			// em.persist(movie);
			//
			// em.flush();
			// em.clear();
			//
			// Movie findMovie = em.find(Movie.class, movie.getId());
			// System.out.println("findMovie = " + findMovie);

			// Member member = new Member();
			// member.setUsername("member1");
			//
			// em.persist(member);
			//
			// Team team = new Team();
			// team.setName("teamA");
			// //
			// team.getMembers().add(member);
			//
			// em.persist(team);


			// Team team = new Team();
			// team.setName("TeamA");
			// // team.getMembers().add(member);
			// em.persist(team);
			//
			// Member member = new Member();
			// member.setUsername("member1");
			// // member.setTeamId(team.getId());
			// member.setTeam(team);
			// em.persist(member);
			//
			// em.flush();
			// em.clear();
			//
			// Member findMember = em.find(Member.class, member.getId());
			// List<Member> members = findMember.getTeam().getMembers();
			//
			// for (Member m : members) {
			// 	System.out.println("m = " + m.getUsername());
			// }



			// Long findTeamId = findMember.getTeamId();
			// Team findTeam = em.find(Team.class, findTeamId);
			// Team findTeam = findMember.getTeam();
			// System.out.println("findTeam = " + findTeam.getName());

			// IDENTITY 전략은 em.persist() 시점에 즉시
			// INSERT SQL을 실행하고 DB에서 식별자를 조회
			/*
			Member member = new Member();
			member.setUsername("C");

			System.out.println("============");
			em.persist(member);
			System.out.println("member.id = " + member.getId());
			System.out.println("============");
			 */

			/*
			Member member = em.find(Member.class, "150L");
			member.setName("AAAA");

			em.clear();

			Member member2 = em.find(Member.class, "150L");
			 */


			/*
			Member member = new Member();
			member.setId(1L);
			member.setUsername("A");
			member.setRoleType(RoleType.USER);

			em.persist(member);
			tx.commit();
			*/

		} catch (Exception e) {
			tx.rollback();

		} finally {
			em.close();
		}

		emf.close();

	}
}