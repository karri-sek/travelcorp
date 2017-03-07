package uk.co.buygroceries.impl;

import uk.co.buygroceries.interfaces.Cart;
import uk.co.buygroceries.interfaces.DiscountCalculator;
import uk.co.buygroceries.interfaces.GenerateCartBill;
import uk.co.buygroceries.model.Item;

public class GenerateCartBillImpl implements GenerateCartBill {

  DiscountCalculator happySalesDiscountCalculator;

  public GenerateCartBillImpl(DiscountCalculator shoppingCartDiscountCalculator) {
    this.happySalesDiscountCalculator = shoppingCartDiscountCalculator;
  }

  public Double generateBill(Cart cart) {
    Double totalCost = 0D;
    for (Item item : cart.listItems()) {
      totalCost += (item.getPrice() * item.getQuantity());
    }
    return totalCost - happySalesDiscountCalculator.calculateDiscount(cart);
  }


}
