package uk.co.buygroceries.impl;

import uk.co.buygroceries.base.ItemEnum;
import uk.co.buygroceries.interfaces.Cart;
import uk.co.buygroceries.interfaces.DiscountCalculator;
import uk.co.buygroceries.model.Item;

public class HappySalesDiscountCalculatorImpl implements DiscountCalculator {

  private static final String BREAD = "BREAD";

  public Double calculateDiscount(Cart cart) {
    Double discount = 0D;
    for (Item item : cart.listItems()) {
      switch (ItemEnum.valueOf(item.getName())) {
        case Milk:
          discount += item.getItemDiscount();
          break;
        case Butter:
          discount += (item.getQuantity() / 2) * getBreadDiscountPrice(cart);
          break;
        default:
          break;
      }
    }
    return discount;
  }

  private Double getBreadDiscountPrice(Cart cart) {
    for (Item item : cart.listItems()) {
      if (BREAD.equalsIgnoreCase(item.getName())) {
        return item.getItemDiscount();
      }
    }
    return 0D;
  }


}
