package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

//            // getReference 예제
//            Member member = new Member();
//            member.setUsername("hello");
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
////            Member findMember = em.find(Member.class, member.getId());
//            Member findMember = em.getReference(Member.class, member.getId());
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.username = " + findMember.getUsername());

//            // 타입 비교
//            Member member1 = new Member();
//            member1.setUsername("member1");
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUsername("member2");
//            em.persist(member2);
//
//            em.flush();
//            em.clear();
//
//            Member m1 = em.find(Member.class, member1.getId());
//            Member m2 = em.getReference(Member.class, member2.getId());
//
//            System.out.println("m1 == m2 : " + (m1.getClass() == m2.getClass())); // false

//            // 영속성 컨텍스트에 있는 상황에서의 호출
//            Member member = new Member();
//            member.setUsername("member");
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            Member m1 = em.find(Member.class, member.getId());
//            System.out.println("m1 = " + m1.getClass());
//
//            Member reference = em.getReference(Member.class, member.getId());
//            System.out.println("reference = " + reference.getClass());
//
//            System.out.println("a == a : " + (m1 == reference));
//
//            // 프록시를 먼저 불러왔을때
//            Member member1 = new Member();
//            member1.setUsername("member1");
//            em.persist(member1);
//
//            em.flush();
//            em.clear();
//
//            Member refMember = em.getReference(Member.class, member1.getId());
//            System.out.println("refMember = " + refMember.getClass()); // proxy
//
//            Member findMember = em.find(Member.class, member1.getId());
//            System.out.println("findMember = " + findMember.getClass()); // Member entity?
//
//            System.out.println("refMember == findMember : " + (refMember == findMember));

//            // 영속성 컨텍스트 끄고 프록시 초기화
//            Member member = new Member();
//            member.setUsername("member");
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            Member refMember = em.getReference(Member.class, member.getId());
//            System.out.println("refMember = " + refMember.getClass()); // proxy
//
//            // 영속성 컨텍스트에서 꺼냄
//            em.detach(refMember);
//            // em.close();
//
//            System.out.println("refMember = " + refMember.getUsername());

//            // 프록시 초기화 여부 확인
//            Member member = new Member();
//            member.setUsername("member");
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            Member refMember = em.getReference(Member.class, member.getId());
//            System.out.println("refMember = " + refMember.getClass()); // proxy
//            refMember.getUsername();
//            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));

//            // 영속성 전이 + 고아 객체
//            Child child1 = new Child();
//            Child child2 = new Child();
//
//            Parent parent = new Parent();
//            parent.addChild(child1);
//            parent.addChild(child2);
//
//            em.persist(parent);
//
//            em.flush();
//            em.clear();
//
//            Parent findParent = em.find(Parent.class, parent.getId());
//            em.remove(findParent);
//            // findParent.getChildList().remove(0);


            Address address = new Address("city", "street", "10000");

            Member member = new Member();
            member.setUsername("member1");
            member.setHomeAddress(address);
            em.persist(member);

            Address newAddress = new Address("NewCity", address.getStreet(), address.getZipcode());
            member.setHomeAddress(newAddress);

//            Member member2 = new Member();
//            member.setUsername("member2");
//            member.setHomeAddress(copyAddress);
//            em.persist(member2);
//
//            member.getHomeAddress().setCity("newCity");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }
}