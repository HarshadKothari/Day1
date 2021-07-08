package p3;

public class MainClass {
	
	public static void main(String[] args) {
		
		ElecDevice lap = new Laptop(10,"Yes",512);
		System.out.println(lap.getPower());
		
		ElecDevice mob = new Mobile(10,"Yes",128);
		System.out.println(mob.getPower());
	}
}
