package ItemPackage;

import Interfaces.UncountableI;

public class Pasta extends Item implements UncountableI{

	private double mass;

	public Pasta() {
		super(null);
		this.mass = 0;
	}

	public Pasta(double volume, String serialnumber, double mass) {
		super("P1", volume, serialnumber, 12, 28);
		this.mass = mass;
	}	
	
	public Pasta(Pasta pasta) {
		super(pasta.getItemCode(),
				pasta.getVolume(),
				pasta.getSerialNumber(),
				pasta.getCostFactor(),
				pasta.getPriceFactor());
		this.mass = pasta.getMass();
	}
	
	public double getMass(){
		return mass;
	}
	
	public void getNumber(){
		throw new UnsupportedOperationException();
	}
	
	public double getCost(){
		return getMass()*getCostFactor();
	}
	
}
