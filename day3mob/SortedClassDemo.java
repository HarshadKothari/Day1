package day3mob;

import java.util.Set;
import java.util.TreeSet;
import day3mob.Mobile;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class SortedClassDemo {
	public static void main(String[] args) {
		
		Set<Mobile> mobSet = new TreeSet<>();
		mobSet.add(new Mobile("Redmi", 15000, 8));
		mobSet.add(new Mobile("OnePlus", 45000, 10));
		mobSet.add(new Mobile("Iphone", 60000, 9));
		
		//Default sorting
		doPrint(mobSet,"Default sorting(Rating)");
		
		//Sorting based on Price
									//Step 1 : Convert Set to List
		List<Mobile> priceList = new ArrayList<>();
		priceList.addAll(mobSet);
				
									//Step 2 : 
		Collections.sort(priceList, new PriceSorting());
		doPrint(priceList,"Sorted according to price");
		
		//Sorting according to names
		List<Mobile> nameList = new ArrayList<>();
		nameList.addAll(mobSet);
		
		Collections.sort(nameList, new NameSorting());
		doPrint(nameList, "Sorted according to names");
		
	}
	
	public static void doPrint(Collection<Mobile> coll, String tagLine){
		System.out.println("-----"+tagLine+"-----");
		for(Mobile device : coll){
			System.out.println(device);
		}
	}
}
