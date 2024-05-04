package Interfaces;

import ItemPackage.Item;

public interface NumberBoxI<T extends Item> extends BoxI<T> {
	
	public int getNumberOfItems();
	public int getNumberCapacity();
	
}