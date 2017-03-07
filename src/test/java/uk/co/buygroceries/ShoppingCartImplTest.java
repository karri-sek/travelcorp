package uk.co.buygroceries;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uk.co.buygroceries.base.ItemEnum;
import uk.co.buygroceries.impl.ShoppingCartImpl;
import uk.co.buygroceries.interfaces.Cart;
import uk.co.buygroceries.model.Bread;
import uk.co.buygroceries.model.Butter;
import uk.co.buygroceries.model.Item;
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

  @Test
  public void testOnlyTwoItemsInCart() {
    shoppingCart.addItem(new Milk(ItemEnum.Milk.toString(), 1, milkCost));
    shoppingCart.addItem(new Bread(ItemEnum.Bread.toString(), 1, breadCost));
    assertEquals(
        "test When 2 items added, then the cart should contain only those 2 items in total.",
        shoppingCart.listItems().size(), 2);
  }

  @Test
  public void testOnlyThreeItemsInCart() {
    shoppingCart.addItem(new Milk(ItemEnum.Milk.toString(), 1, milkCost));
    shoppingCart.addItem(new Bread(ItemEnum.Bread.toString(), 1, breadCost));
    shoppingCart.addItem(new Butter(ItemEnum.Butter.toString(), 1, butterCost));
    assertEquals(
        "test When 3 items added, then the cart should contain only those 3 items in total.",
        shoppingCart.listItems().size(), 3);
  }

  @Test
  public void testCartShouldContainsOnlyThreeMilkItems() {
    int milkItemsCount = 0;
    shoppingCart.addItem(new Item(ItemEnum.Milk.toString(), 3, milkCost));
    for (Item item : shoppingCart.listItems()) {
      if ("Milk".equalsIgnoreCase(item.getName())) {
        milkItemsCount = item.getQuantity();
        break;
      }
    }
    assertEquals(
        "test When 3 Milk items added, then the cart should contain only those 3 Milk items.", 3,
        milkItemsCount);
  }

  @Test
  public void testCartShouldContainsOnly4BreadItems() {
    int breadItemsCount = 0;
    shoppingCart.addItem(new Item(ItemEnum.Bread.toString(), 4, breadCost));
    for (Item item : shoppingCart.listItems()) {
      if ("Bread".equalsIgnoreCase(item.getName())) {
        breadItemsCount = item.getQuantity();
        break;
      }
    }
    assertEquals(
        "test When 4 Bread items added, then the cart should contain only those 4 Bread items.", 4,
        breadItemsCount);
  }



}
