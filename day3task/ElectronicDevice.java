package day3task;

public class ElectronicDevice implements Comparable<ElectronicDevice>{
	private String brandN;
	private int price;
	private int ratings;
	
	public ElectronicDevice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ElectronicDevice(String brandN, int price, int ratings) {
		super();
		this.brandN = brandN;
		this.price = price;
		this.ratings = ratings;
	}

	public String getBrandN() {
		return brandN;
	}

	public void setBrandN(String brandN) {
		this.brandN = brandN;
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
		return ratings + " " + brandN + " " + price;
	}

	
	//Rating sorting
	@Override
	public int compareTo(ElectronicDevice obj) {
		// TODO Auto-generated method stub
		return this.getRatings() - obj.getRatings();
	}
	
	

}
