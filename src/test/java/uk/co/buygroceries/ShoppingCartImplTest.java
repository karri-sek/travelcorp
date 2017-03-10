package uk.co.buygroceries;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uk.co.buygroceries.base.ItemEnum;
import uk.co.buygroceries.impl.GenerateCartBillImpl;
import uk.co.buygroceries.impl.HappySalesDiscountCalculatorImpl;
import uk.co.buygroceries.impl.ShoppingCartImpl;
import uk.co.buygroceries.interfaces.Cart;
import uk.co.buygroceries.interfaces.GenerateCartBill;
import uk.co.buygroceries.model.Bread;
import uk.co.buygroceries.model.Butter;
import uk.co.buygroceries.model.Milk;

public class ShoppingCartImplTest {

    Cart shoppingCart;
    GenerateCartBill generateBill;

    static Double milkCost = 1.15D;
    static Double breadCost = 1D;
    static Double butterCost = 0.80D;

    @Before
    public void setUp() {
	shoppingCart = new ShoppingCartImpl();
	generateBill = new GenerateCartBillImpl(new HappySalesDiscountCalculatorImpl());
    }

    public void testShoppingCartIsEmpty() {
	assertEquals("test When No items added, then the cart should be empty.", shoppingCart.listItems().isEmpty(), true);
    }

    @Test
    public void testOnlyOneItemInCart() {
	shoppingCart.addItem(new Milk(ItemEnum.Milk.toString(), 1, milkCost));
	assertEquals("test When 1 items added, then the cart should contain only those 1 items in total.", shoppingCart.listItems().size(), 1);
    }

    @Test
    public void testOnlyTwoItemsInCart() {
	shoppingCart.addItem(new Milk(ItemEnum.Milk.toString(), 1, milkCost));
	shoppingCart.addItem(new Bread(ItemEnum.Bread.toString(), 1, breadCost));
	assertEquals("test When 2 items added, then the cart should contain only those 2 items in total.", shoppingCart.listItems().size(), 2);
    }

    @Test
    public void testOnlyThreeItemsInCart() {
	shoppingCart.addItem(new Milk(ItemEnum.Milk.toString(), 1, milkCost));
	shoppingCart.addItem(new Bread(ItemEnum.Bread.toString(), 1, breadCost));
	shoppingCart.addItem(new Butter(ItemEnum.Butter.toString(), 1, butterCost));
	assertEquals("test When 3 items added, then the cart should contain only those 3 items in total.", shoppingCart.listItems().size(), 3);
    }

    @Test
    public void testCartShouldContainsOnlyThreeMilkItems() {
	shoppingCart.addItem(new Milk(ItemEnum.Milk.toString(), 3, milkCost));
	assertEquals("test When 3 Milk items added, then the cart should contain only those 3 Milk items.", 3, shoppingCart.listItems().get(0).getQuantity());
    }

    @Test
    public void testCartShouldContainsOnly4BreadItems() {	
	shoppingCart.addItem(new Bread(ItemEnum.Bread.toString(), 4, breadCost));	
	assertEquals("test When 4 Bread items added, then the cart should contain only those 4 Bread items.", 4, shoppingCart.listItems().get(0).getQuantity());
    }

    @Test
    public void testCartShouldContainsOnly2ButterItems() {	
	shoppingCart.addItem(new Butter(ItemEnum.Butter.toString(), 2, butterCost));	
	assertEquals("test When 2 Butter items added, then the cart should contain only those 2 Butter items.", 2, shoppingCart.listItems().get(0).getQuantity());
    }

    @Test
    public void testWhen1Bread1ButterAnd1MilkThenTotalShouldBe2Pounds95Pence() {
	shoppingCart.addItem(new Milk(ItemEnum.Milk.toString(), 1, milkCost));
	shoppingCart.addItem(new Bread(ItemEnum.Bread.toString(), 1, breadCost));
	shoppingCart.addItem(new Butter(ItemEnum.Butter.toString(), 1, butterCost));
	double totalAmount = generateBill.generateBill(shoppingCart);
	assertEquals("test When 1 Butter, 1 Bread then the total amount Should be 2 Pounds 95 Pence.", 2.95D, totalAmount, 0.01);
    }

    @Test
    public void testWhen2ButterAnd2BreadThenTotalShouldBe3Pounds10Pence() {
	shoppingCart.addItem(new Bread(ItemEnum.Bread.toString(), 2, breadCost));
	shoppingCart.addItem(new Butter(ItemEnum.Butter.toString(), 2, butterCost));
	double totalAmount = generateBill.generateBill(shoppingCart);
	assertEquals("test When 2 Butter, 2 Bread then the total amount Should be 3 Pounds 1 Pence.", 3.10D, totalAmount, 0.01);
    }

    @Test
    public void testWhen4MilkThenTotalShouldBe3Pounds45Pence() {
	shoppingCart.addItem(new Milk(ItemEnum.Milk.toString(), 4, milkCost));
	double totalAmount = generateBill.generateBill(shoppingCart);
	assertEquals("test When 4 Milk, then the total amount Should be 3 Pounds 45 Pence.", 3.45D, totalAmount, 0.01);
    }

    @Test
    public void testWhen2Butter1BreadAnd8MilkThenTotalShouldBe9Pounds() {
	shoppingCart.addItem(new Milk(ItemEnum.Milk.toString(), 8, milkCost));
	shoppingCart.addItem(new Bread(ItemEnum.Bread.toString(), 1, breadCost));
	shoppingCart.addItem(new Butter(ItemEnum.Butter.toString(), 2, butterCost));
	double totalAmount = generateBill.generateBill(shoppingCart);
	assertEquals("test When 2 Butter, 1 Bread and 8 Milk, then the total amount Should be 9 Pounds 0 Pence.", 9.0D, totalAmount, 0.01);
    }

    @Test
    public void testWhen4Butter4BreadAnd6MilkThenTotalShouldBe10Pounds8Pence() {
	shoppingCart.addItem(new Milk(ItemEnum.Milk.toString(), 6, milkCost));
	shoppingCart.addItem(new Bread(ItemEnum.Bread.toString(), 4, breadCost));
	shoppingCart.addItem(new Butter(ItemEnum.Butter.toString(), 4, butterCost));
	double totalAmount = generateBill.generateBill(shoppingCart);
	assertEquals("test When 4 Butter, 4 Bread and 6 Milk, then the total amount Should be 10 Pounds 8 Pence.", 10.8D, totalAmount, 0.01);
    }

    @Test
    public void testWhen10MilkThenTotalShouldBe8Pounds05Pence() {
	shoppingCart.addItem(new Milk(ItemEnum.Milk.toString(), 10, milkCost));
	double totalAmount = generateBill.generateBill(shoppingCart);
	assertEquals("test When 10 Milk then the total amount Should be 8 Pounds 05 Pence.", 8.05D, totalAmount, 0.01);
    }

    @Test
    public void testWhen100MilkThenTotalShouldBe76Pounds66Pence() {
	shoppingCart.addItem(new Milk(ItemEnum.Milk.toString(), 100, milkCost));
	double totalAmount = generateBill.generateBill(shoppingCart);
	assertEquals("test When 100 Milk then the total amount Should be 76 Pounds 66 Pence.", 76.66D, totalAmount, 0.55);
    }

    @Test
    public void testWhen100Milk100ButterThenTotalShouldBe155Pounds() {
	shoppingCart.addItem(new Bread(ItemEnum.Bread.toString(), 100, breadCost));
	shoppingCart.addItem(new Butter(ItemEnum.Butter.toString(), 100, butterCost));
	double totalAmount = generateBill.generateBill(shoppingCart);
	assertEquals("test When 100 Bread and 100 Butter then the total amount Should be 155 Pounds 0 Pence.", 155.00D, totalAmount, 0.00);
    }

    @After
    public void tearDown() {
	shoppingCart = null;
	generateBill = null;
    }

}
