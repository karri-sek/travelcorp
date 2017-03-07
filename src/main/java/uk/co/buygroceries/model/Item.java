package uk.co.buygroceries.model;

public class Item {

  private String name;
  private int quantity;
  private Double price;

  public Item(String name, int quantity, Double price) {
    super();
    this.name = name;
    this.quantity = quantity;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }


  public Double getItemDiscount() {
    return 0D;
  }

}
