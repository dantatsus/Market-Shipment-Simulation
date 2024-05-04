package ItemPackage;

import Interfaces.CountableI;

public class BoxOfOil extends Item implements CountableI{

	public BoxOfOil() {
		super(null);
	}

	public BoxOfOil(double volume, String serialnumber) {
		super("O1", volume, serialnumber, 20, 45);
	}

	public BoxOfOil(BoxOfOil oil) {
		super(oil.getItemCode(),
				oil.getVolume(),
				oil.getSerialNumber(),
				oil.getCostFactor(),
				oil.getPriceFactor());
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