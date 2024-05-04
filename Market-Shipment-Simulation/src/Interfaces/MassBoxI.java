package Interfaces;

import ItemPackage.Item;

public interface MassBoxI<T extends Item> extends BoxI<T> {
	
	public double getMass();
	public double getMassCapacity();
}
