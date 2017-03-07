package uk.co.buygroceries.impl;

import java.util.ArrayList;
import java.util.List;

import uk.co.buygroceries.interfaces.Cart;
import uk.co.buygroceries.model.Item;

public class ShoppingCartImpl implements Cart {

  private List<Item> shoppingCartProducts = new ArrayList<Item>();



  public void addItem(Item product) {
    shoppingCartProducts.add(product);
  }

  public void deleteItem(Item product) {
    // TODO provide some implementation to delete products from card
  }

  public List<Item> listItems() {
    return shoppingCartProducts;
  }

}
