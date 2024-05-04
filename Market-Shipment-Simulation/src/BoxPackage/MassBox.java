package BoxPackage;

import Exceptions.OutOfMassCapacityException;
import Exceptions.OutOfVolumeCapacityException;
import Interfaces.MassBoxI;
import ItemPackage.Item;

public class MassBox<T extends Item> extends Box<T> implements MassBoxI<T> {
	private double massCapacity;
	private double mass;
	
	public MassBox() {
		//default Constructor
	}

	public MassBox(double volumeCapacity, String boxSerialNumber, double massCapacity) {
		super("B2", volumeCapacity, boxSerialNumber);
		this.massCapacity = massCapacity;
		mass = 0;
	}
	public MassBox(MassBox<T> massBox){
		super("B2",massBox.getVolumeCapacity(),massBox.getSerialNumber());
		this.massCapacity = massBox.getMassCapacity();
		mass = 0;
	}

	@Override
	public void checkVolume(T item) throws OutOfVolumeCapacityException {
		super.checkVolume(item);
	}


	public double getBoxCost() {
		checkInitialization();
		return getVolumeCapacity() * 3;
	}

	
	public double getMass() {
		return mass;
	}
	
	public double getMassCapacity() {
		return massCapacity;
	}
	
	private void checkMassCapacity(T item) throws OutOfMassCapacityException {
		if (!(item.getMass() + mass <= massCapacity))
			throw new OutOfMassCapacityException();
	}

	@Override
	public boolean put(T item) throws Exception{
	    checkInitialization();
	    checkMassCapacity(item);
	    checkVolume(item);
		checkIfExist(item);
		addToBox(item);
		increaseVolume(item.getVolume());
		mass += item.getMass();
		item.putToBox();
		return true;
	}



}
