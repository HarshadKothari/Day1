package day3mob;

public class Mobile implements Comparable<Mobile> {
	
	private String mobName;
	private int price;
	private int ratings;
	
	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mobile(String mobName, int price, int ratings) {
		super();
		this.mobName = mobName;
		this.price = price;
		this.ratings = ratings;
	}

	public String getMobName() {
		return mobName;
	}

	public void setMobName(String mobName) {
		this.mobName = mobName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	
	public String toString(){
		return ratings+ " - " + mobName + " - " + price;
	}

	
	@Override
	public int compareTo(Mobile ob) {
		// TODO Auto-generated method stub
		return this.getRatings() - ob.getRatings();
		
	}
	
	
	
	
}
