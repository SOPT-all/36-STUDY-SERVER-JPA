package hellojpa;

import hellojpa.domain.Order;
import hellojpa.domain.OrderItem;
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
            Order order = new Order();
//            order.addOrderItem(new OrderItem());
            // 양방향 연관관계 아니어도 아무 문제 없음
            em.persist(order);

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);

            em.persist(orderItem);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}