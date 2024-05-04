package ItemPackage;

import Interfaces.UncountableI;

public class Sugar extends Item implements UncountableI {

	private double mass;

	public Sugar() {
		super(null);
		this.mass = 0;
	}
	
	public Sugar(double volume, String serialnumber, double mass) {
		super("S1", volume, serialnumber, 13, 25);
		this.mass = mass;
	}

	public Sugar(Sugar sugar) {
		super(sugar.getItemCode(),
				sugar.getVolume(),
				sugar.getSerialNumber(),
				sugar.getCostFactor(),
				sugar.getPriceFactor());
		this.mass = sugar.getMass();
	}
	
	public double getMass(){
		return mass;
	}
	
	@Override
	public void getNumber() {
		throw new UnsupportedOperationException();
	}
	
	public double getCost(){
		return getMass()*getCostFactor();	
	}
	
}