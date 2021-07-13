package com.electronic.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import com.electronic.app.exce.NoDeviceFoundException;
import com.electronic.app.model.ElectronicDevice;

public class ElectronicDeviceImpl implements IElectronicDeviceDAO {
	
	Connection con = null;

	String insertElectronicQuery = "insert into electronic.electronicdevice values(?,?,?,?,?,?,?)";
	String selectAllDevices = "select * from electronic.electronicdevice";
	String changePrice = "update electronic.electronicdevice set cost=? where deviceId=?";
	String changeRatings = "update electronic.electronicdevice set starRatings=? where deviceId=?";
	String deleteDev = "delete from electronic.electronicdevice where deviceId=?";
	String deviceByBrandAndType = "select * from electronic.electronicdevice where brandName=? AND deviceType=?";
	String countDevice = "select deviceType, COUNT(deviceType)as Count FROM electronic.electronicdevice group by deviceType";
	String sumOfPrice = "select SUM(cost) AS Total from electronic.electronicdevice where deviceType=?";
	String deviceInRange = "SELECT * from electronic.electronicdevice where deviceType=?";
	
	@Override
	public boolean addDevice(ElectronicDevice d) {
		con = DatabaseUtil.getConnection();
		boolean isInserted = false;
		
		if(con != null) {
			
		//Step 1 : extract details from d object
			int id = d.getDeviceId();
			String type = d.getDeviceType();
			String name = d.getBrandName();
			int price = d.getCost();
			int pwr = d.getPower();
			int ratings = d.getStarRatings();
			String clr = d.getColor();
		
			
			//Step 2 : code to create complete insert query with data
			try {
			PreparedStatement ps = con.prepareStatement(insertElectronicQuery);
			ps.setInt(1, id);
			ps.setString(2, type);
			ps.setString(3, name);
			ps.setInt(4, price);
			ps.setInt(5, pwr);
			ps.setInt(6, ratings);
			ps.setString(7, clr);
			
			int i = ps.executeUpdate();
			
			if(i>0)
				isInserted = true;
				
			} catch(Exception e) {
				System.out.println(e);
			}
		}
		
		return isInserted;
	}

	@Override
	public List<ElectronicDevice> getAllDevices() {
		con = DatabaseUtil.getConnection();
		
		List<ElectronicDevice> elList = new ArrayList<>();
		if(con != null) {
			
			try {
			PreparedStatement ps = con.prepareStatement(selectAllDevices);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ElectronicDevice temp = new ElectronicDevice();
				
				temp.setDeviceId(rs.getInt(1));
				temp.setDeviceType(rs.getString("DeviceType"));
				temp.setBrandName(rs.getString("BrandName"));
				temp.setCost(rs.getInt(4));
				temp.setPower(rs.getInt(5));
				temp.setStarRatings(rs.getInt(6));
				temp.setColor(rs.getString("Color"));
				
				elList.add(temp);
			}
			
			}catch (Exception e) {
				System.out.println(e);
			}
		}
		return elList;
	}

	@Override
	public boolean changeDevicePrice(int deviceId, int newPrice) throws NoDeviceFoundException {
		
		con = DatabaseUtil.getConnection();
		boolean isChanged = false;
		if(con != null) {
			
			try {
			PreparedStatement ps = con.prepareStatement(changePrice);
			ps.setInt(1, newPrice);
			ps.setInt(2, deviceId);
			
			int i = ps.executeUpdate();
			
			if(i>0)
				isChanged = true;
		
			}catch(Exception e) {
				System.out.println("In changeDevicePrice" + e);
			}
		}
		
		
		
		return isChanged;
	}

	@Override
	public boolean changeDeviceRating(int deviceId, int newRating) throws NoDeviceFoundException {
		con = DatabaseUtil.getConnection();
		boolean isChanged = false;
		if(con != null) {
			
			try {
			PreparedStatement ps = con.prepareStatement(changeRatings);
			ps.setInt(1, newRating);
			ps.setInt(2, deviceId);
			
			int i = ps.executeUpdate();
			
			if(i>0)
				isChanged = true;
		
			}catch(Exception e) {
				System.out.println("In changeDeviceRatings" + e);
			}
		}
		return isChanged;
	}

	@Override
	public boolean deleteDevice(int deviceId) throws NoDeviceFoundException {
		
		con = DatabaseUtil.getConnection();
		boolean isDeleted= false;
		
		if(con != null) {
			
			try {
			PreparedStatement ps = con.prepareStatement(deleteDev);
			
			ps.setInt(1, deviceId);
			
			int i = ps.executeUpdate();
			
			if(i>0)
				isDeleted = true;
		
			}catch(Exception e) {
				System.out.println("In deleteDevice" + e);
			}
		}
		
		return isDeleted;
	}

	@Override
	public List<ElectronicDevice> geDevicesBasedOnBrandNameAndType(String brandName, String type) {
		
		con = DatabaseUtil.getConnection();
		List<ElectronicDevice> elList = new ArrayList<>();
		if (con != null) {
			
			try {
			
			PreparedStatement ps = con.prepareStatement(deviceByBrandAndType);
			ps.setString(1, brandName);
			ps.setString(2, type);

			ResultSet rs = ps.executeQuery();
		

			while (rs.next()) {
		
				ElectronicDevice temp = new ElectronicDevice();

				temp.setDeviceId(rs.getInt(1));
				temp.setDeviceType(rs.getString("DeviceType"));
				temp.setBrandName(rs.getString("BrandName"));
				temp.setCost(rs.getInt(4));
				temp.setPower(rs.getInt(5));
				temp.setStarRatings(rs.getInt(6));
				temp.setColor(rs.getString("Color"));

				elList.add(temp);
			}

			}catch(Exception e) {
				System.out.println("geDevicesBasedOnBrandNameAndType"+e);
			}


		}
		
		
		return elList;
	}

	@Override
	public int countDeviceType(String type) {
		con = DatabaseUtil.getConnection();
		int cnt=0;
		if(con!=null) {
			try {
				
				PreparedStatement ps = con.prepareStatement(countDevice);
			
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					cnt = rs.getInt("Count");
					String type1 = rs.getString("deviceType");
					System.out.println(type1 + " - " + cnt);
				}
			} catch (Exception e) {
				System.out.println("countDeviceType " + e);
			}

		}
		return cnt;
	}

	@Override
	public int getSumofPriceBasedOnType(String type)throws SQLException, NoDeviceFoundException {
		con = DatabaseUtil.getConnection();
		
		
		int sum=0;
		if(con!=null)
		{
			
			PreparedStatement ps=con.prepareStatement(sumOfPrice);
			ps.setString(1, type);
			ResultSet rs=ps.executeQuery();
			boolean isFound=false;
			while(rs.next())
			{
				isFound=true;
				sum=rs.getInt(1);
			}
			if(!isFound)
			{
				throw new NoDeviceFoundException(0);
			}
		}
		return sum;
	}

	@Override
	public List<ElectronicDevice> getDeviceBasedOnPriceRangeAndType(int range1, int range2, String type)
	throws SQLException, NoDeviceFoundException
	{
		
		con = DatabaseUtil.getConnection();
		List<ElectronicDevice> list = new ArrayList<>();
		
		if(con!=null) {
			
			PreparedStatement ps = con.prepareStatement(deviceInRange);
			ps.setString(1, type);
			
			ResultSet rs = ps.executeQuery();
			boolean isFound = false;
			
			while(rs.next()) {
				isFound = true;
				ElectronicDevice temp = new ElectronicDevice();
				
				temp.setDeviceId(rs.getInt(1));
				temp.setDeviceType(rs.getString("DeviceType"));
				temp.setBrandName(rs.getString("BrandName"));
				temp.setCost(rs.getInt(4));
				temp.setPower(rs.getInt(5));
				temp.setStarRatings(rs.getInt(6));
				temp.setColor(rs.getString("Color"));

				list.add(temp);
				
			}
			if(!isFound)
				throw new NoDeviceFoundException(0);
			else {
				
				list=list.stream().filter(dev->{
					return dev.getCost()>=range1 && dev.getCost()<=range2; 
				}).collect(Collectors.toList());
			}
			}
		
		return list;
	}
	
	

}
