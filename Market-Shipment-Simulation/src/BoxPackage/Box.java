package BoxPackage;

import java.util.ArrayList;

import Exceptions.AlreadyBoxedException;
import Exceptions.OutOfVolumeCapacityException;
import Interfaces.BoxI;
import ItemPackage.Item;

public abstract class Box<T extends Item> implements BoxI<T> {
	
	private String boxCode;
    private double volumeCapacity;
    private double volume;
    private boolean initialized = false;
    private String boxSerialNumber;
    private ArrayList<T> box;

    private boolean inContainer = false;
    
    public Box(){
        //default Constructor
    }
    
    public Box(String boxCode, double volumeCapacity, String boxSerialNumber){
        this.boxCode = boxCode;
        this.volumeCapacity = volumeCapacity;
        this.boxSerialNumber = boxSerialNumber;
        volume = 0;
        initialized = true;


		ArrayList<T> tempBox = new ArrayList<T>();
        box = tempBox;
    }
    
    public String getSerialNumber() {
        checkInitialization();
        return boxSerialNumber;
    }

    public String getBoxCode() {
        checkInitialization();
        return boxCode;
    }

    public double getVolume() {
        checkInitialization();
        return volume;
    }
    
    public double getVolumeCapacity() {
        checkInitialization();
        return volumeCapacity;
    }
    
    public void checkVolume(T item) throws OutOfVolumeCapacityException {
        checkInitialization();
        if (!(item.getVolume() + volume <= volumeCapacity))
            throw new OutOfVolumeCapacityException();
    }
    
    public double getTotalCost() {
        checkInitialization();
        double total = 0;
        for(T item : box) {
            total += item.getCost();
        }
        return total + getBoxCost();
    }

    public double getTotalPrice() {
        checkInitialization();
        double total = 0;
        for(T item : box) {
            total += item.getPrice();
        }
        return total;
    }
    
    public void increaseVolume(double volume){
        this.volume += volume;
    }
    
    void addToBox(T item) {
        box.add(item);
    }
    public void putToContainer(){inContainer = true;}
    
    public abstract boolean put(T item) throws Exception;

    public abstract double getBoxCost();

    public void checkIfExist(T item) throws AlreadyBoxedException {
        for(Item element: box){
            if(element.getSerialNumber().equals(item.getSerialNumber())){throw new AlreadyBoxedException();}
        }
    }

    public void checkInitialization() throws SecurityException {
        if (!initialized)
            throw new SecurityException("Box object is not initialized");
    }

    public boolean isInContainer(){
        return inContainer;
    }
}
