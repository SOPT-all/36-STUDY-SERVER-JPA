package hellojpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItem {

  @Id
  @GeneratedValue
  @Column(name = "ORDER_ITEM_ID")
  private Long id;

//  @Column(name = "ORDER_ID")
//  private Long orderId;

  @ManyToOne
  @JoinColumn(name = "ORDER_ID")
  private Order order;

//  @Column(name = "ITEM_ID")
//  private Long itemId;

  @ManyToOne
  @JoinColumn(name = "ITEM_ID")
  private Item item;

  public Order getOrder() {
    return order;
  }

  public void setOrder(final Order order) {
    this.order = order;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(final Item item) {
    this.item = item;
  }

  private int orderPrice;

  private int count;

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }


  public int getOrderPrice() {
    return orderPrice;
  }

  public void setOrderPrice(final int orderPrice) {
    this.orderPrice = orderPrice;
  }

  public int getCount() {
    return count;
  }

  public void setCount(final int count) {
    this.count = count;
  }
}
