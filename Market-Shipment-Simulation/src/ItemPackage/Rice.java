package ItemPackage;

import Interfaces.UncountableI;

public class Rice extends Item implements UncountableI{

	private double mass;

	public Rice() {
		super(null);
		this.mass = 0;
	}
	
	public Rice(double volume, String serialnumber, double mass) {
		super("R1", volume, serialnumber, 16, 32);
		this.mass = mass;
	}

	public Rice(Rice rice) {
		super(rice.getItemCode(),
				rice.getVolume(),
				rice.getSerialNumber(),
				rice.getCostFactor(),
				rice.getPriceFactor());
		this.mass = rice.getMass();
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
