package uk.co.buygroceries.model;

public class Bread extends Item {

  public Bread(String name, int quantity, Double price) {
    super(name, quantity, price);
  }

  @Override
  public Double getItemDiscount() {
    return this.getPrice() / 2;
  }

}
