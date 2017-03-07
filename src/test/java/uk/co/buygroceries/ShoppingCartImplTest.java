package uk.co.buygroceries;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uk.co.buygroceries.base.ItemEnum;
import uk.co.buygroceries.impl.ShoppingCartImpl;
import uk.co.buygroceries.interfaces.Cart;
import uk.co.buygroceries.model.Milk;

public class ShoppingCartImplTest {

  Cart shoppingCart;

  static Double milkCost = 1.15D;
  static Double breadCost = 1D;
  static Double butterCost = 0.80D;

  @Before
  public void setUp() {
    shoppingCart = new ShoppingCartImpl();
  }

  public void testShoppingCartIsEmpty() {
    assertEquals("test When No items added, then the cart should be empty.", shoppingCart
        .listItems().isEmpty(), true);
  }

  @Test
  public void testOnlyOneItemInCart() {
    shoppingCart.addItem(new Milk(ItemEnum.Milk.toString(), 1, milkCost));
    assertEquals(
        "test When 1 items added, then the cart should contain only those 1 items in total.",
        shoppingCart.listItems().size(), 1);
  }



}
