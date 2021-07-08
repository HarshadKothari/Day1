package p3;

public class ElecDevice {
	int power;
	String bluetooth;
	int memory;
	
	public ElecDevice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ElecDevice(int power, String bluetooth, int memory) {
		super();
		this.power = power;
		this.bluetooth = bluetooth;
		this.memory = memory;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getBluetooth() {
		return bluetooth;
	}

	public void setBluetooth(String bluetooth) {
		this.bluetooth = bluetooth;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}
	
	
	
	

}
