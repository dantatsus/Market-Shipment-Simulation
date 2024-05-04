package BoxPackage;

import Exceptions.OutOfNumberCapacityException;
import Exceptions.OutOfVolumeCapacityException;
import Interfaces.NumberBoxI;
import ItemPackage.Item;

public class NumberBox<T extends Item> extends Box<T> implements NumberBoxI<T>{

	private int numberCapacity;
	private int numberOfItems;
	
	public NumberBox() {
		// default constructor
	}
	
	public NumberBox(double volumeCapacity, String boxSerialNumber, int numberCapacity) {
		super("B1", volumeCapacity, boxSerialNumber);
		this.numberCapacity = numberCapacity;
		numberOfItems = 0;
	}
	public NumberBox(NumberBox<T> numberBox){
		super("B1",numberBox.getVolumeCapacity(),numberBox.getSerialNumber());
		this.numberCapacity = numberBox.getNumberCapacity();
		numberOfItems = 0;
	}
	public double getBoxCost() {
		checkInitialization();
		return getVolumeCapacity() * 2;
	}

	public int getNumberOfItems() {
		checkInitialization();
		return numberOfItems;
	}
	
	public int getNumberCapacity() {
		checkInitialization();
		return numberCapacity;
	}

	@Override
	public void checkVolume(T item) throws OutOfVolumeCapacityException {
		super.checkVolume(item);
	}
	private void checkNumberCapacity() throws OutOfNumberCapacityException{
		if(!(numberOfItems + 1 <= numberCapacity))
			throw new OutOfNumberCapacityException();
	}

	public boolean put(T item) throws Exception{
		checkInitialization();
		item.getNumber();
		checkNumberCapacity();
		checkVolume(item);
		checkIfExist(item);
		addToBox(item);
		increaseVolume(item.getVolume());
		numberOfItems++;
		item.putToBox();
		return true;
	}

}
