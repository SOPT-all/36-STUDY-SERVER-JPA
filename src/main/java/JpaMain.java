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

			tx.commit();
		} catch (Exception e) {
			tx.rollback();

		} finally {
			em.close();
		}

		emf.close();

	}
}