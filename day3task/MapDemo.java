package day3task;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import day3mob.PriceSorting;
import day3task.ElectronicDevice;
import day3task.Laptop;
import day3task.Mobile;
import day3task.AirConditioner;

public class MapDemo {
	
	public static void main(String[] args) {
		
		Map<String, List<ElectronicDevice>> eleMap = new HashMap<>();
		
		ElectronicDevice e1 = new Laptop("HP", 50000, 8);
		ElectronicDevice e2 = new Laptop("Dell", 80000, 9);
		ElectronicDevice e3 = new Laptop("Asus", 40000, 7);
		
		List<ElectronicDevice> lapList = new ArrayList<>();
		lapList.add(e1);
		lapList.add(e2);
		lapList.add(e3);
		
		ElectronicDevice e4 = new Mobile("Oneplus", 55000, 9);
		ElectronicDevice e5 = new Mobile("Iphone", 70000, 9);
		ElectronicDevice e6 = new Mobile("Redmi", 20000, 8);
		
		List<ElectronicDevice> mobList = new ArrayList<>();
		mobList.add(e4);
		mobList.add(e5);
		mobList.add(e6);
		
		ElectronicDevice e7 = new AirConditioner("Whirlpool", 35000, 7);
		ElectronicDevice e8 = new AirConditioner("LG", 60000, 8);
		ElectronicDevice e9 = new AirConditioner("Samsung", 75000, 9);
		
		List<ElectronicDevice> acList = new ArrayList<>();
		acList.add(e7);
		acList.add(e8);
		acList.add(e9);
		
		
		
		eleMap.put("Laptop", lapList);
		eleMap.put("Mobile", mobList);
		eleMap.put("AC", acList);
		
		//Fetch Product price 50,000 - 80,000
		System.out.println("-----50,000 - 80,0000-----");
		Iterator<String> itr = eleMap.keySet().iterator();
		
		while(itr.hasNext()){
			String gadgetName = itr.next();
			
		//	if(gadgetName.equals("Laptop")){
				List<ElectronicDevice> ed = eleMap.get(gadgetName);
				
				for(ElectronicDevice obj : ed){
					if(obj.getPrice()>=50000 && obj.getPrice()<=80000){
						System.out.println(obj);
					}
				}
			}//while
		
		System.out.println("Choose Gadget \n1. Laptop\n2. Mobile\n3. AC");
		Scanner sc = new Scanner(System.in);
		int ch = sc.nextInt();
		

		System.out.println("1. Sort according to Price\n2. Sort according to Ratings");
		int ch1 = sc.nextInt();
		
		if(ch==1){
				sortDemo(lapList, ch1);
		} else if(ch==2){
			sortDemo(mobList, ch1);
		}else  if(ch==3){
			sortDemo(acList, ch1);
		}   

		
		
		}//main
	
		public static void sortDemo(List<ElectronicDevice> list,int n){
			if(n==1){
				Collections.sort(list, new RatingSort());
				doPrint(list);
			} else if(n==2) {
				Collections.sort(list, new PriceSort());
				doPrint(list);
			} 
		}
		

		public static void doPrint(Collection<ElectronicDevice> coll){
			for(ElectronicDevice device : coll){
				System.out.println(device);
			}
		}
		
		
	}

// }
