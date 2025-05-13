package hellojpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {

  @Id @GeneratedValue
  @Column(name = "ORDER_ID")
  private Long id;

//  @Column(name = "MEMBER_ID")
//  private Long memberId;

  @ManyToOne
  @JoinColumn(name = "MEMBER_ID")
  private Member member;

  @OneToMany(mappedBy = "order")
  private List<OrderItem> orderItems = new ArrayList<>();
  public Member getMember() {
    return member;
  }

  // 연관관계 편의 메소드 (여기 있어도 되고 OrderItem 쪽에 있어도 됨)
  public void addOrderItem(OrderItem orderItem) {
    orderItems.add(orderItem);
    orderItem.setOrder(this); // 찐 연관관계 세팅
  }

  public void setMember(final Member member) {
    this.member = member;
  }

  private LocalDateTime orderDate;

  @Enumerated(EnumType.STRING)
  private OrderStatus status;




}
