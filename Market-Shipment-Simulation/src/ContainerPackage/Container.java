package ContainerPackage;

import java.util.ArrayList;

import Exceptions.OutOfVolumeCapacityException;
import Interfaces.BoxI;
import Interfaces.ContainerI;

public class Container<T extends BoxI<?>> implements ContainerI<T> {

	public final String containerCode = "C1";
	public double volumeCapacity;
	public double volume;
	public String containerSerialNumber;
	
	private ArrayList<T> container;
	private boolean initialized = false;

	private boolean isShipped = false;

	public Container() {

	}

	public Container(double volumecapacity, String containerserialnumber) {
		this.volumeCapacity = volumecapacity;
		this.containerSerialNumber = containerserialnumber;
		initialized = true;
		volume = 0;

		ArrayList<T> tempContainer = new ArrayList<T>();
		container = tempContainer;
	}

	public String getSerialNumber() {
		checkInitialization();
		return containerSerialNumber;
	}

	public String getContainerCode() {
		checkInitialization();
		return containerCode;
	}

	public double getVolume() {
		checkInitialization();
		return volume;
	}

	public double getVolumeCapacity() {
		checkInitialization();
		return volumeCapacity;
	}

	private void checkVolume(T box) throws OutOfVolumeCapacityException {
		checkInitialization();
		if (!(box.getVolumeCapacity() + volume < volumeCapacity))
			throw new OutOfVolumeCapacityException();
	}

	public double getContainerCost() {
		checkInitialization();
		return volumeCapacity;
	}

	public double getTotalCost() {
		checkInitialization();
		double total = 0;
		for(T box : container) {
			total += box.getTotalCost();
		}
		return total + getContainerCost();
	}

	public double getTotalPrice() {
		checkInitialization();
		double total = 0;
		for(T box : container) {
			total += box.getTotalPrice();
		}
		return total;
	}

	public boolean put(T box) throws Exception{
		checkInitialization();
		checkVolume(box);
		container.add(box);
		volume += box.getVolumeCapacity();
		return true;
	}

	public boolean isShipped(){
		return isShipped;
	}
	private void checkInitialization() {
		if (!initialized)
			throw new SecurityException("Container object is not initialized");
	}
	
	public double ship() {
		isShipped = true;
		return getTotalPrice();
	}
	
}
