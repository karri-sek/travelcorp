package uk.co.buygroceries.model;

public class Milk extends Item {

  public Milk(String name, int quantity, Double price) {
    super(name, quantity, price);
  }

  @Override
  public Double getItemDiscount() {
    return (this.getQuantity() / 3) * this.getPrice();
  }
}
