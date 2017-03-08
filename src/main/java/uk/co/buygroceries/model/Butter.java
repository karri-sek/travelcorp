package uk.co.buygroceries.model;

public class Butter extends Item {

  public Butter(String name, int quantity, Double price) {
    super(name, quantity, price);
  }

  @Override
  public Double getItemDiscount() {
    return 0D;
  }
}
