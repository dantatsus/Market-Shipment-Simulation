package Interfaces;

public interface ItemI {
	
	public double getVolume();
	public String getItemCode();
	public String getSerialNumber();
	public double getCost();
	public double getPrice();
	public double getMass();
	
	public void putToBox();
	public boolean isBoxed();
	public int getCostFactor();
	public int getPriceFactor();
	public void getNumber();
}