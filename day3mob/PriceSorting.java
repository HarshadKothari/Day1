package day3mob;

import day3mob.Mobile;

import java.util.Comparator;

public class PriceSorting implements Comparator<Mobile>{

	@Override
	public int compare(Mobile dev1, Mobile dev2) {
		// TODO Auto-generated method stub
		return dev1.getPrice() - dev2.getPrice();
	}
	
}
