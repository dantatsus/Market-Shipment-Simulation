package ItemPackage;


import Interfaces.UncountableI;

public class Flour extends Item implements UncountableI {

	private double mass;

	public Flour() {
		super(null);
		this.mass = 0;
	}

	public Flour(double volume, String serialnumber, double mass) {
		super("F1", volume, serialnumber, 5, 12);
		this.mass = mass;
	}
	
	public Flour(Flour flour) {
		super(flour.getItemCode(),
				flour.getVolume(),
				flour.getSerialNumber(),
				flour.getCostFactor(),
				flour.getPriceFactor());
		this.mass = flour.getMass();
	}
	
	public double getMass(){
		return mass;	
	}
	
	public double getCost(){
		return getMass()*getCostFactor();
	}
	
	@Override
	public void getNumber() {
		throw new UnsupportedOperationException();
	}
}
