package uk.co.buygroceries.base;

public enum ItemEnum {
  Bread("Bread"), Butter("Butter"), Milk("Milk");

  private final String value;

  private ItemEnum(final String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }

}
