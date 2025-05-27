package hellojpa;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public class Item {

  @Id
  @GeneratedValue @Column(name = "ITEM_ID")
  private Long id;

  private String name;
  private int price;

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

  // private int stockQuantity;
  //
  // @ManyToMany(mappedBy = "items")
  // private List<Category> categories = new ArrayList<>();
  //
  // public Long getId() {
  //   return id;
  // }
  //
  // public void setId(final Long id) {
  //   this.id = id;
  // }
  //
  // public String getName() {
  //   return name;
  // }
  //
  // public void setName(final String name) {
  //   this.name = name;
  // }
  //
  // public int getPrice() {
  //   return price;
  // }
  //
  // public void setPrice(final int price) {
  //   this.price = price;
  // }
  //
  // public int getStockQuantity() {
  //   return stockQuantity;
  // }
  //
  // public void setStockQuantity(final int stockQuantity) {
  //   this.stockQuantity = stockQuantity;
  // }
}
