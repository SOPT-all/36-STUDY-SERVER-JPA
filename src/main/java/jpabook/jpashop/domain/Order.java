// package jpabook.jpashop.domain;
//
// import java.time.LocalDateTime;
//
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.EnumType;
// import jakarta.persistence.Enumerated;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
//
// @Entity
// @Table(name = "ORDERS")
// public class Order {
//
// 	@Id
// 	@GeneratedValue
// 	@Column(name = "ORDER_ID")
// 	private Long id;
//
//	@ManyToOne
// 	@JoinColumn(name = "MEMBER_ID")
// 	private Long memberId;
//
// 	private LocalDateTime orderDate;
//
// 	@Enumerated(EnumType.STRING)
// 	private OrderStatus status;
//
//	== 연관 관계 메소드 ==
//  public void setMember(Member member) {
//  //기존 관계 제거
//	if (this.member != null) {
//		this.member.getOrders().remove(this);
//	}
//  this.member = member;
//	member.getOrders().add(this);
//	}

//  public void addOrderItem(OrderItem orderItem) {
//		orderItems.add(orderItem);
//		orderItem.setOrder(this);
//	}
// }
