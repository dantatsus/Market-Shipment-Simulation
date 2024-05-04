package Interfaces;

public interface ContainerI<T extends BoxI<?>> {
	
	public String getContainerCode();
	public double getVolumeCapacity();
	public double getVolume();
	public String getSerialNumber();
	
	public double ship();
	public boolean isShipped();
	
	public double getContainerCost();
	public double getTotalCost();
	public double getTotalPrice();
	
	public boolean put(T box) throws Exception;
	
}
