package day3mob;
import day3mob.Mobile;
import java.util.Comparator;

public class NameSorting implements Comparator<Mobile>{

	@Override
	public int compare(Mobile mob1, Mobile mob2) {
		// TODO Auto-generated method stub
		
		return mob1.getMobName().compareTo(mob2.getMobName());
	}
	
	

}
