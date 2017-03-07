package uk.co.buygroceries.impl;

import uk.co.buygroceries.interfaces.Cart;
import uk.co.buygroceries.interfaces.GenerateCartBill;
import uk.co.buygroceries.model.Item;

public class GenerateCartBillImpl implements GenerateCartBill {

  public Double generateBill(Cart cart) {
    Double totalCost = 0D;
    for (Item item : cart.listItems()) {
      totalCost += (item.getPrice() * item.getQuantity());
    }
    return totalCost;
  }


}
