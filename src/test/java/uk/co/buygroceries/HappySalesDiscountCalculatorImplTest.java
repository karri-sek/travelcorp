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
import uk.co.buygroceries.model.Milk;

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

  @Test
  public void testWhen4MilkTheDiscountShouldBe1Pound15Pence() {
    shoppingCart.addItem(new Milk(ItemEnum.Milk.toString(), 4, milkCost));
    Double discount = discountCalculator.calculateDiscount(shoppingCart);
    assertEquals("test When 4 Milk, then the discount should be 1 pound 15 pence.", 1.15D,
        discount, 0.01);
  }
  
  @Test
  public void testWhen2Butter1Bread8MilkTheDiscountShouldBe2Pounds8Pence() {
    shoppingCart.addItem(new Milk(ItemEnum.Milk.toString(), 8, milkCost));
    shoppingCart.addItem(new Butter(ItemEnum.Butter.toString(), 2, butterCost));
    shoppingCart.addItem(new Bread(ItemEnum.Bread.toString(), 1, breadCost));
    Double discount = discountCalculator.calculateDiscount(shoppingCart);
    assertEquals("test When 4 Milk, then the discount should be 1 pound 15 pence.", 2.8D,
        discount, 0.01);
  }
  
  @Test
  public void testWhen1Butter1Bread1MilkTheDiscountShouldBe0() {
    shoppingCart.addItem(new Milk(ItemEnum.Milk.toString(), 1, milkCost));
    shoppingCart.addItem(new Butter(ItemEnum.Butter.toString(), 1, butterCost));
    shoppingCart.addItem(new Bread(ItemEnum.Bread.toString(), 1, breadCost));
    Double discount = discountCalculator.calculateDiscount(shoppingCart);
    assertEquals("test When 4 Milk, then the discount should be 1 pound 15 pence.", 0D,
        discount, 0.01);
  }

}
