package ItemPackage;

public class BoxOfMilk extends Item {
	
	public BoxOfMilk() {
		super(null);
	}
	
	public BoxOfMilk(double volume, String serialnumber) {
		super("M1", volume, serialnumber, 5, 11);
	}

	public BoxOfMilk(BoxOfMilk milk) {
		super(milk.getItemCode(),
				milk.getVolume(),
				milk.getSerialNumber(),
				milk.getCostFactor(),
				milk.getPriceFactor());
	}
	
	public double getMass() {
		throw new UnsupportedOperationException("EX: Countable items don't use getMass method.");
	}
	
	public void getNumber(){
		
	}
	
	public double getCost(){
		return getVolume()*getCostFactor();
	}

}