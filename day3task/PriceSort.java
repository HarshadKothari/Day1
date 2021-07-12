package day3task;

import java.util.Comparator;

public class PriceSort implements Comparator<ElectronicDevice>{

	@Override
	public int compare(ElectronicDevice arg0, ElectronicDevice arg1) {
		// TODO Auto-generated method stub
		return arg0.getPrice() - arg1.getPrice();
	}
	
}
