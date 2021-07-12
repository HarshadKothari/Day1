package day3task;
import java.util.Comparator;

import day3task.ElectronicDevice;
public class RatingSort implements Comparator<ElectronicDevice>{

	@Override
	public int compare(ElectronicDevice a, ElectronicDevice a1) {
		// TODO Auto-generated method stub
		return a.getRatings() - a1.getRatings();
	}
	
}
