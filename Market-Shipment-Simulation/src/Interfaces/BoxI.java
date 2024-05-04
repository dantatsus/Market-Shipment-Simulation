package Interfaces;

import Exceptions.AlreadyBoxedException;
import ItemPackage.Item;

public interface BoxI<T extends Item> {
	
	public double getVolumeCapacity();
	public double getVolume();
	// private boolean checkVolume(T item);
	
	public String getSerialNumber();
	public String getBoxCode();
	
	public void putToContainer();
	public void checkIfExist(T item) throws AlreadyBoxedException;
	
	public double getBoxCost();
	public double getTotalCost();
	public double getTotalPrice();
	
	public boolean put(T item) throws Exception;
	
	
}
