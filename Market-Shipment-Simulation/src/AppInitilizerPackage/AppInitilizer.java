package AppInitilizerPackage;

import java.util.ArrayList;
import java.util.StringTokenizer;

import BoxPackage.*;
import ContainerPackage.Container;
import Exceptions.AlreadyBoxedException;
import Exceptions.SerialNumberDoesntExistException;
import Exceptions.UsedException;
import FileIO.FileReader;
import ItemPackage.*;


public class AppInitilizer {
	
	String[] readProces;
	ArrayList<String> serialNumbers = new ArrayList<String>();   		// to check the same serial number exception (items).
	ArrayList<Item> producedItems = new ArrayList<Item>();      		// Hold produced items
	ArrayList<String> boxSerials = new ArrayList<String>();      		// to check the same serial number exception (boxes).
	ArrayList<Box<Item>> producedBoxes = new ArrayList<Box<Item>>();	// Hold produced boxes
	ArrayList<String> containerSerials = new ArrayList<String>();		// to check the same serial number exception (containers).
	ArrayList<Container<Box<Item>>> producedContainers = new ArrayList<Container<Box<Item>>>();
	double revenue = 0;
	double unearnedRevenue = 0;
	
	public void initializeTheApp(){
		
		FileReader reader = new FileReader();
		String[] readProcess = reader.getDatasFromFile("src/ExampleCommands.csv");

		for (String line : readProcess) {

			StringTokenizer stringTokenizer = new StringTokenizer(line, ",");
			if (!stringTokenizer.hasMoreTokens()){break;}
			int command = Integer.parseInt(stringTokenizer.nextToken());

			switch (command) {
				case 1:
					// PRODUCE CASE
					String code = stringTokenizer.nextToken();
					switch (code) {//We wrote break into cases but it says its unnecessary
						case "M1" -> {
							double volume = Double.parseDouble(stringTokenizer.nextToken());
							String serialNumber = stringTokenizer.nextToken();
							if (!(serialNumbers.contains(serialNumber))) {
								serialNumbers.add(serialNumber);
								Item milk = new BoxOfMilk(volume, serialNumber);
								producedItems.add(milk);
								revenue -= milk.getCost();
								System.out.print(volume + " liter of box of milk has been produced with the serial number " + serialNumber);
							} else {
								System.out.print("Item with serial number " + serialNumber + " cannot produced. (EX: existing serial number)");
							}
							System.out.println("     Revenue: " + revenue +"₺");
							break;
						}
						case "W1" -> {
							double volume = Double.parseDouble(stringTokenizer.nextToken());
							String serialNumber = stringTokenizer.nextToken();
							if (!(serialNumbers.contains(serialNumber))) {
								serialNumbers.add(serialNumber);
								Item water = new BoxOfWater(volume, serialNumber);
								producedItems.add(water);
								revenue -= water.getCost();
								System.out.print(volume + " liter of box of water has been produced with the serial number " + serialNumber);
							} else {
								System.out.print("Item with serial number " + serialNumber + " cannot produced. (EX: existing serial number)");
							}
							System.out.println("     Revenue: " + revenue +"₺");
							break;
						}
						case "O1" -> {
							double volume = Double.parseDouble(stringTokenizer.nextToken());
							String serialNumber = stringTokenizer.nextToken();
							if (!(serialNumbers.contains(serialNumber))) {
								serialNumbers.add(serialNumber);
								Item oil = new BoxOfOil(volume, serialNumber);
								producedItems.add(oil);
								revenue -= oil.getCost();
								System.out.print(volume + " liter of box of oil has been produced with the serial number " + serialNumber);
							} else {
								System.out.print("Item with serial number " + serialNumber + " cannot produced. (EX: existing serial number)");
							}
							System.out.println("     Revenue: " + revenue +"₺");
							break;
						}
						case "S1" -> {
							double mass = Double.parseDouble(stringTokenizer.nextToken());
							double volume = Double.parseDouble(stringTokenizer.nextToken());
							String serialNumber = stringTokenizer.nextToken();
							if (!(serialNumbers.contains(serialNumber))) {
								serialNumbers.add(serialNumber);
								Item sugar = new Sugar(volume, serialNumber, mass);
								producedItems.add(sugar);
								revenue -= sugar.getCost();
								System.out.print(mass + " kilograms of sugar has been produced with serial number " + serialNumber);
							} else {
								System.out.print("Item with serial number " + serialNumber + " cannot produced. (EX: existing serial number)");
							}
							System.out.println("     Revenue: " + revenue +"₺");
							break;
						}
						case "F1" -> {
							double mass = Double.parseDouble(stringTokenizer.nextToken());
							double volume = Double.parseDouble(stringTokenizer.nextToken());
							String serialNumber = stringTokenizer.nextToken();
							if (!(serialNumbers.contains(serialNumber))) {
								serialNumbers.add(serialNumber);
								Item flour = new Flour(volume, serialNumber, mass);
								producedItems.add(flour);
								revenue -= flour.getCost();
								System.out.print(mass + " kilograms of flour has been produced with serial number " + serialNumber);
							} else {
								System.out.print("Item with serial number " + serialNumber + " cannot produced. (EX: existing serial number)");
							}
							System.out.println("     Revenue: " + revenue +"₺");
							break;
						}
						case "P1" -> {
							double mass = Double.parseDouble(stringTokenizer.nextToken());
							double volume = Double.parseDouble(stringTokenizer.nextToken());
							String serialNumber = stringTokenizer.nextToken();
							if (!(serialNumbers.contains(serialNumber))) {
								serialNumbers.add(serialNumber);
								Item pasta = new Pasta(volume, serialNumber, mass);
								producedItems.add(pasta);
								revenue -= pasta.getCost();
								System.out.print(mass + " kilograms of pasta has been produced with serial number " + serialNumber);
							} else {
								System.out.print("Item with serial number " + serialNumber + " cannot produced. (EX: existing serial number)");
							}
							System.out.println("     Revenue: " + revenue +"₺");
							break;
						}
						case "R1" -> {
							double mass = Double.parseDouble(stringTokenizer.nextToken());
							double volume = Double.parseDouble(stringTokenizer.nextToken());
							String serialNumber = stringTokenizer.nextToken();
							if (!(serialNumbers.contains(serialNumber))) {
								serialNumbers.add(serialNumber);
								Item rice = new Rice(volume, serialNumber, mass);
								producedItems.add(rice);
								revenue -= rice.getCost();
								System.out.print(mass + " kilograms of rice has been produced with serial number " + serialNumber);
							} else {
								System.out.print("Item with serial number " + serialNumber + " cannot produced. (EX: existing serial number)");
							}
							System.out.println("     Revenue: " + revenue +"₺");
							break;
						}
						case "B1" -> {
							int numberOfItems = Integer.parseInt(stringTokenizer.nextToken());
							double volume = Double.parseDouble(stringTokenizer.nextToken());
							String serialNumber = stringTokenizer.nextToken();
							if (!(boxSerials.contains(serialNumber))) {
								boxSerials.add(serialNumber);
								NumberBox<Item> box = new NumberBox<Item>(volume, serialNumber, numberOfItems);
								producedBoxes.add(box);
								revenue -= box.getBoxCost();
								System.out.print(volume + " liters of number box has been produced with capacity of " + numberOfItems + " with the serial number " + serialNumber);
							} else {
								System.out.print("Box with serial number " + serialNumber + " cannot produced. (EX: existing serial number)");
							}
							System.out.println("     Revenue: " + revenue +"₺");
							break;
						}
						case "B2" -> {
							double mass = Double.parseDouble(stringTokenizer.nextToken());
							double volume = Double.parseDouble(stringTokenizer.nextToken());
							String serialNumber = stringTokenizer.nextToken();
							if (!(boxSerials.contains(serialNumber))) {
								boxSerials.add(serialNumber);
								MassBox<Item> box = new MassBox<Item>(volume, serialNumber, mass); // SORUN VAR!
								producedBoxes.add(box);
								revenue -= box.getBoxCost();
								System.out.print(volume + " liters of mass box has been produced with capacity of " + mass + " kg with the serial number " + serialNumber);
							} else {
								System.out.print("Box with serial number " + serialNumber + " cannot produced. (EX: existing serial number)");
							}
							System.out.println("     Revenue: " + revenue +"₺");
							break;
						}
						case "C1" -> {
							double volume = Double.parseDouble(stringTokenizer.nextToken());
							String serialNumber = stringTokenizer.nextToken();
							if (!(containerSerials.contains(serialNumber))) {
								containerSerials.add(serialNumber);
								Container<Box<Item>> container = new Container<Box<Item>>(volume, serialNumber);
								producedContainers.add(container);
								revenue -= container.getContainerCost();
								System.out.print(volume + " liters of container has been produced with serial number " + serialNumber);
							}
							System.out.println("     Revenue: " + revenue +"₺");
							break;
						}
					}
					break;
				case 2:
					String loadingItemSerialNumber = stringTokenizer.nextToken();
					String holderSerialNumber = stringTokenizer.nextToken();

					if(loadingItemSerialNumber.charAt(0) == 'B'){
						//If the loading item is a box
						//Get Box and Container
						try {
							Box<Item> boxToPut = findBoxBySerialNumber(loadingItemSerialNumber);
							Container<Box<Item>> holderContainer = findContainerBySerialNumber(holderSerialNumber);
							if(holderContainer.isShipped()){throw new UsedException();}else{
							holderContainer.put(boxToPut);
							boxToPut.putToContainer();
							System.out.println("Box " + loadingItemSerialNumber + " has been placed to the container " + holderSerialNumber);}
						}catch(SerialNumberDoesntExistException e){
							System.out.println(e.getMessage());
						} catch (UsedException e) {
							System.out.println("Container is already shipped");
						}catch(Exception e){
							System.out.println("Container with serial number " + holderSerialNumber + " is full");
						}
					}else{
						//If the loading item is an item
						//Get Item and Box
						try {
							Item itemToPut = findItemBySerialNumber(loadingItemSerialNumber);
							Box<Item> holderBox = findBoxBySerialNumber(holderSerialNumber);
							if(holderBox.isInContainer()){throw new UsedException();}else {
								holderBox.put(itemToPut);
								System.out.println("Item " + loadingItemSerialNumber + " has been placed to the box " + holderSerialNumber);
							}
							}catch(SerialNumberDoesntExistException e){
							System.out.println(e.getMessage());
						}catch(UnsupportedOperationException e){
							System.out.println("Cannot loaded. EX: Type of item " + loadingItemSerialNumber + " and box type does not match.");
						} catch (UsedException e) {
							System.out.println("Cannot loaded. EX: Box with serial number " + holderSerialNumber + " is in container. Item serial: " + loadingItemSerialNumber);
						}catch(AlreadyBoxedException e){
							System.out.println("Cannot loaded. EX: Item with serial number " + loadingItemSerialNumber + " is already in a box");
						}catch (Exception e){
							System.out.println("Cannot loaded. EX: Box with serial number " + holderSerialNumber + " is full. Item serial: " + loadingItemSerialNumber);
						}
					}
					break;
				case 3:
					String containerToShipSerialNumber = stringTokenizer.nextToken();
					try {
						Container<Box<Item>> containerToShip = findContainerBySerialNumber(containerToShipSerialNumber);
						revenue += containerToShip.ship();
						System.out.println("Container " + containerToShipSerialNumber + " has been shipped." + "     Revenue: " + Math.ceil(revenue)+"₺");
					}catch(SerialNumberDoesntExistException e){
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					int operation = Integer.parseInt(stringTokenizer.nextToken());
					switch(operation){
						case 1:
							for(Container<Box<Item>> container: producedContainers){
								if(!container.isShipped()){
									unearnedRevenue += container.getTotalPrice();
								}
							}
							for(Box<Item> box : producedBoxes){
								if(!box.isInContainer()){
									unearnedRevenue += box.getTotalPrice();
								}
							}
							for(Item item: producedItems){
								if(!item.isBoxed()){
									unearnedRevenue += item.getPrice();
								}
							}

							System.out.println("Unearned Revenue: " + (double) Math.round(unearnedRevenue*100.0)/100+"₺");
							break;
						case 2:
							System.out.println("Total revenue :" + (double) Math.round(revenue*100.0)/100+"₺");
							break;
					}
					break;
				default:
					System.out.println("EX: No such command."); 
			}
			
		}
	}

	private Container<Box<Item>> findContainerBySerialNumber(String holderSerialNumber) throws SerialNumberDoesntExistException {
		for(Container<Box<Item>> container : producedContainers) {

			if (container.getSerialNumber().equals(holderSerialNumber)) {
				return container;
			}
		}throw new SerialNumberDoesntExistException();

	}

	private Box<Item> findBoxBySerialNumber(String holderSerialNumber) throws SerialNumberDoesntExistException{
		for(Box<Item> box: producedBoxes){
			if(box.getSerialNumber().equals(holderSerialNumber)){
				return box;
			}
		}throw new SerialNumberDoesntExistException();
	}

	private Item findItemBySerialNumber(String loadingItemSerialNumber) throws SerialNumberDoesntExistException {
		for(Item item: producedItems){

			if(item.getSerialNumber().equals(loadingItemSerialNumber)) {
				return item;
			}
		}throw new SerialNumberDoesntExistException();

	}


}
