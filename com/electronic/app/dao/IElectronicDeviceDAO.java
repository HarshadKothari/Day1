package com.electronic.app.dao;

import java.sql.SQLException;
import java.util.List;

import com.electronic.app.exce.NoDeviceFoundException;
import com.electronic.app.model.ElectronicDevice;

public interface IElectronicDeviceDAO {
	
	public boolean addDevice(ElectronicDevice device);
	public List<ElectronicDevice> getAllDevices();
	
	public boolean changeDevicePrice(int deviceId,int newPrice)throws NoDeviceFoundException;
	public boolean changeDeviceRating(int deviceId,int newRating)throws NoDeviceFoundException;
	
	public boolean deleteDevice(int deviceId)throws NoDeviceFoundException;
	
	public List<ElectronicDevice> geDevicesBasedOnBrandNameAndType(String brandName,String type);
	public int countDeviceType(String type);
	public int getSumofPriceBasedOnType(String type) throws SQLException, NoDeviceFoundException;
	public List<ElectronicDevice> getDeviceBasedOnPriceRangeAndType(int range1, int range2, String type)throws SQLException, NoDeviceFoundException;

}
