package uk.co.buygroceries;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

import uk.co.buygroceries.impl.ShoppingCartImpl;
import uk.co.buygroceries.interfaces.Cart;

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

  

}
