package uk.co.buygroceries;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uk.co.buygroceries.base.ItemEnum;
import uk.co.buygroceries.impl.HappySalesDiscountCalculatorImpl;
import uk.co.buygroceries.impl.ShoppingCartImpl;
import uk.co.buygroceries.interfaces.Cart;
import uk.co.buygroceries.interfaces.DiscountCalculator;
import uk.co.buygroceries.model.Bread;
import uk.co.buygroceries.model.Butter;

public class HappySalesDiscountCalculatorImplTest {

  Cart shoppingCart;
  DiscountCalculator discountCalculator;

  static Double milkCost = 1.15D;
  static Double breadCost = 1D;
  static Double butterCost = 0.80D;

  @Before
  public void setUp() {
    shoppingCart = new ShoppingCartImpl();
    discountCalculator = new HappySalesDiscountCalculatorImpl();
  }

  @Test
  public void testWhen2ButterAnd2BreadThenTotalShouldBe3Pounds10Pence() {
    shoppingCart.addItem(new Butter(ItemEnum.Butter.toString(), 2, butterCost));
    shoppingCart.addItem(new Bread(ItemEnum.Bread.toString(), 2, breadCost));
    Double discount = discountCalculator.calculateDiscount(shoppingCart);
    assertEquals("test When 2 Butter, 2 Bread then the discount should be 0.5 pence.", 0.5D,
        discount, 0.01);
  }

}
