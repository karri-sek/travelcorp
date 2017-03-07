package uk.co.buygroceries.interfaces;

import java.util.List;

import uk.co.buygroceries.model.Item;

public interface Cart {

    public void addItem(Item item);
    
    public void deleteItem(Item item);
    
    public List<Item> listItems();
}
