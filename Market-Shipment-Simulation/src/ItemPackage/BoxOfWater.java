package ItemPackage;

import Interfaces.CountableI;

public class BoxOfWater extends Item implements CountableI {

	public BoxOfWater() {
		super(null);
	}

	public BoxOfWater(double volume, String serialnumber) {
		super("W1", volume, serialnumber, 1, 3);
	}
	
	public BoxOfWater(BoxOfWater water) {
		super(water.getItemCode(),
				water.getVolume(),
				water.getSerialNumber(),
				water.getCostFactor(),
				water.getPriceFactor());
	}
	
	public void getNumber() {

	}
	
	public double getCost(){
		return getVolume()*getCostFactor();
	}
	
	public double getMass() {
		throw new UnsupportedOperationException("EX: Countable items don't use getMass method.");
	}
}