package ItemPackage;

import Interfaces.ItemI;

public abstract class Item implements ItemI {

    private String itemCode;

    private double volume;

    private String serialNumber;

    private int costFactor;

    private int priceFactor;
    private boolean isBoxed = false;


    public Item() {

    }

    public Item(String itemCode,double volume, String serialnumber,int costFactor,int priceFactor) {
        this.itemCode = itemCode;
        this.volume = volume;
        this.serialNumber = serialnumber;
        this.costFactor = costFactor;
        this.priceFactor = priceFactor;
    }

    public Item(Item item) {
        itemCode = item.getItemCode();
        volume = item.getVolume();
        serialNumber = item.getSerialNumber();
        costFactor = item.getCostFactor();
        priceFactor = item.getPriceFactor();
    }

    @Override
    public double getVolume() {
        return volume;
    }

    @Override
    public String getItemCode() {
        return itemCode;
    }

    @Override
    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public abstract double getCost();

    public void putToBox() {
        isBoxed = true;
    }
    public boolean isBoxed(){return isBoxed;}
    @Override
    public double getPrice() {
        return volume*priceFactor;
    }


    public int getCostFactor() {
        return costFactor;
    }

    public int getPriceFactor() {
        return priceFactor;
    }

    public abstract void getNumber();
}
