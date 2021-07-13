package com.electronic.app.exce;

public class NoDeviceFoundException extends Exception{
	private int id;
	
	public NoDeviceFoundException(int id)
	{
		this.id = id;
	}
	
	public String toString()
	{
		return "Invalid Device Id" + id;
	}
}
