package hellojpa;


import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager(); // 쉽게 말해서
        // 데이터베이스 커넥션을 받았다고 생각하면 됨
        //code

        EntityTransaction tx = em.getTransaction();
        tx.begin(); // 트랜잭션 시작

        try {

            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            em.persist(member);

            List<Member> result = em.createNamedQuery("Member.findByUsername", Member.class)
                .setParameter("name", "회원1")
                .getResultList();

            em.createQuery("update Member m set m.age = 20")
                .executeUpdate();

            // String query =
            //     "select case when m.age <=10 then '학생요금'"
            //         + "when m.age >= 60 then '경로요금'"
            //         + "else '일반요금'"
            //         + "end"
            //         + "from Member m";
            // em.createQuery(query, String.class)
            //     .getResultList()





            // Member result = em.createQuery("select m from Member m where m.name = :username", Member.class)
            //     .setParameter("username", "member1")
            //     .getSingleResult();
            //
            // List<Team> result2 = em.createQuery("select t from Member m join m.team t", Team.class)
            //     .getResultList();
            //
            // List<Object[]> resultList = em.createQuery("select m.name , m.age from Member m")
            //     .getResultList();
            //
            // List<MemberDto> resultList1 = em.createQuery("select new hellojpa.MemberDto(m.name, m.age) from Member m")
            //     .getResultList();
            //
            // List<Member> result3 = em.createQuery("select m from Member m order by m.age desc", Member.class)
            //     .setFirstResult(0)
            //     .setMaxResults(10)
            //     .getResultList();



            //             Member member = new Member();
//             member.setUsername("member1");
//             member.setAddress(new Address("homeCity", "street", "10000"));
//
//             member.getFavoriteFoods().add("치킨");
//             member.getFavoriteFoods().add("족발");
//             member.getFavoriteFoods().add("피자 맛있겠다");
//
//             member.getAddressHistory().add(new Address("old1", "street" , "10000"));
//             member.getAddressHistory().add(new Address("old2", "street" , "10000"));
//
//             em.persist(member);
//
//             //homecity -> newcity
//             // member.setAddress(new Address("newCity", ~~ ~~ ));
//
//             // 치킨을 한식으로 바꾸고 싶음
//             member.getFavoriteFoods().remove("치킨");
//             member.getFavoriteFoods().add("한식");
//
//             member.getAddressHistory().remove(new Address("old1", "street", "10000"));
//             member.getAddressHistory().add(new Address("new1", "street", "10000"));
//
//
//             // Member member = new Member();
//             // member.setAddress(address);
//             //
//             // Member member2 = new Member();
//             // member2.setAddress(address);
//             //
//             // member.getAddress().setCity("newCity");
//
//
//             Child child1 = new Child();
//             Child child2 = new Child();
//
//             Parent parent = new Parent();
//             parent.addChild(child1);
//             parent.addChild(child2);
//
//             em.persist(parent);
//             em.persist(child1);
//             em.persist(child2);
//
//             Member member1= new Member();
//             member1.setUsername("member1");
//             em.persist(member1);
//
//             Member member2= new Member();
//             member1.setUsername("member2");
//             em.persist(member2);
//
//             em.flush();
//             em.clear();
//
//             Member m1 = em.find(Member.class, member1.getId());
//             // m1.getClass 출력해보면 Member 나옴
//             // 이상황에서,
//             Member reference = em.getReference(Member.class, member1.getId());
//             // reference.getClass 하면?
//             Member m2 = em.find(Member.class, member2.getId());
//
//             System.out.println(m1.getClass() == m2.getClass());
//
//             //            Member findMember = em.find(Member.class, 1L);
// //            findMember.setName("hellojpa");
// //
// //            List<Member> result = em.createQuery("select m from Member m", Member.class)
// //                    .getResultList();
// //
// //            for (Member member : result) {
// //                System.out.println("member.name = " + member.getName());
// //            }
//
//             Movie movie = new Movie();
//             movie.setDirector("aaaa");
//             movie.setActor("bbbb");
//             movie.setName("바람과함께사라지다");
//             movie.setPrice(10000);
//
//             em.persist(movie);
//
//             em.flush();
//             em.clear();
//
//             Movie findMovie = em.find(Movie.class, movie.getId());
//             System.out.println("findMovie = " + findMovie);

            // // 저장
            // Team team = new Team();
            // team.setName("TeamA");
            //
            // em.persist(team);
            //
            // Member member = new Member();
            // member.setUsername("member1");
            // member.changeTeam(team); // setTeam 할때, 연관관계 편의메소드 설정하자.
            // em.persist(member);
// 컬렉션에 추가한다고 해서, db 에 반영되지 않음 .
//            team.getMembers().add(member); // members 는 읽기전용 매핑이므로

//            Member member = new Member();
////            member.setTeamId(team.getId()); // 외래키를 직접 다루므로 JOIN 을 직접 적어주어야한다.
//            member.setTeam(team);
//            em.persist(member);


            // em.flush();
            // em.clear();
            //
            // Member findMember = em.find(Member.class, member.getId());
            //
            // List<Member> members = findMember.getTeam().getMembers();
            //
            // for (Member member1 : members) {
            //     System.out.println("m = " + member.getUsername());
            //
            // }

//            System.out.println("findMember.getUsername() = " + findMember.getUsername());
//
//
//
//            // 객체지향스럽지 않은 방식이다.
////            Long findTeamId = findMember.getTeamId();
//            Team findTeam = findMember.getTeam();
////            Team findTeam = em.find(Team.class, findTeamId);
//
//            System.out.println("findTeam.getName() = " + findTeam.getName());


            tx.commit(); // 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }


}
