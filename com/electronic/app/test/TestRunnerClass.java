package com.electronic.app.test;

import java.util.List;

import com.electronic.app.dao.ElectronicDeviceImpl;
import com.electronic.app.dao.IElectronicDeviceDAO;
import com.electronic.app.model.ElectronicDevice;

public class TestRunnerClass {
	
	public static void main(String[] args) {
		
		try {
			IElectronicDeviceDAO dao = new ElectronicDeviceImpl();
			
			/*
			ElectronicDevice el = new ElectronicDevice("Mobile", 5, "Realme", 20000, 10, 7, "Red");
			
			boolean a = dao.addDevice(el);
			System.out.println(a);
			
			
			List<ElectronicDevice> list = dao.getAllDevices();
			list.stream().forEach((ele)->System.out.println(ele));
			
			boolean b = dao.changeDevicePrice(2, 28000);
			System.out.println(b);
			
			
			boolean c = dao.changeDeviceRating(1, 7);
			System.out.println(c);
			
			
			boolean d = dao.deleteDevice(3);
			System.out.println(d);
			
			
			List<ElectronicDevice> list1 = dao.geDevicesBasedOnBrandNameAndType("OnePlus", "Mobile");
			list1.stream().forEach((ele1)->System.out.println(ele1));
			
			
			int e = dao.countDeviceType("Mobile");
			System.out.println( "Return of countDeviceType " + e);
			
			
			int f = dao.getSumofPriceBasedOnType("Mobile");
			if(f>0)
				System.out.println("Sum is "+f);
			
			*/
			
			List<ElectronicDevice> list2 = dao.getDeviceBasedOnPriceRangeAndType(20000, 30000, "Mobile");
			list2.stream().forEach((dev)->System.out.println(dev));
			
			
		} catch (Exception e) {
			
			System.out.println("Problem ~ " + e);
		}
	}
}
