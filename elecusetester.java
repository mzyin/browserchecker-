import java.util.HashMap;
import java.util.Scanner;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.applet.Applet; // needed by every applet
import java.awt.Color;     // needed to change default color
import java.awt.Font;      // needed to change style of text drawn
import java.awt.Graphics;  // needed by every applet
import javax.swing.JOptionPane;   // for Dialog box for data entry


public class elecusetester extends Applet
{ 
	String state;
	double comCost;
	String dl;
	String screenType;
	double screenSize;
	double diskSize; 
	String CPUspeed;
	double years;
	double hours;
	String yn;
	double bCost;
	double eCost;
	double totalCost; 
	double elecRate;
	double diskElec;
	double SpeedCoreBrand;
	double months;
	double totalWatts;
	double cBattery;
	double mBattery;
	double screenElec;
	
	public void init()
	{
		
		 // Create a hash map
	      HashMap states = new HashMap();
	      
	      // Put elements to the map
	      states.put("MA", new Double(18.37));
	      states.put("CT", new Double(20.05));
	      states.put("ME", new Double(14.87));
	      states.put("NH", new Double(17.73));
	      states.put("RI", new Double(19.68));
	      states.put("VT", new Double(17.33));
	      states.put("NJ", new Double(15.55));
	      states.put("NY", new Double(18.38));
	      states.put("PA", new Double(14.49));
	      states.put("IL", new Double(13.47));
	      states.put("IN", new Double(11.77));
	      states.put("MI", new Double(14.59));
	      
	      states.put("OH", new Double(12.89));
	      states.put("WI", new Double(14.87));
	      states.put("IA", new Double(11.70));
	      states.put("KS", new Double(12.34));
	      states.put("MN", new Double(12.76));
	      states.put("MS", new Double(11.07));
	      states.put("NE", new Double(10.95));
	      states.put("ND", new Double(10.59));
	      
	      states.put("SD", new Double(11.70));
	      states.put("DE", new Double(14.40));
	      states.put("DC", new Double(13.90));
	      states.put("FL", new Double(11.61));
	      states.put("GA", new Double(11.09));
	      states.put("MD", new Double(15.35));
	      states.put("NC", new Double(12.11));
	      states.put("SC", new Double(12.65));
	      
	      states.put("VA", new Double(11.52));
	      states.put("WV", new Double(10.98));
	      states.put("AL", new Double(12.00));
	      states.put("KY", new Double(10.74));
	      states.put("MS", new Double(11.16));
	      states.put("TN", new Double(10.63));
	      states.put("AR", new Double(10.00));
	      states.put("LA", new Double(9.55));
	      states.put("OK", new Double(11.12));
	      states.put("TX", new Double(11.41));
	      states.put("AZ", new Double(12.22));
	      states.put("CO", new Double(11.74));
	      states.put("ID", new Double(10.32));
	      states.put("MT", new Double(11.29));
	      
	      states.put("NV", new Double(12.99));
	      states.put("NM", new Double(12.71));
	      states.put("UT", new Double(10.58));
	      states.put("WY", new Double(11.56));
	      states.put("CA", new Double(14.98));
	      states.put("OR", new Double(10.93));
	      states.put("WA", new Double(9.41));
	      states.put("AK", new Double(20.62));
	      states.put("HI", new Double(28.22));
	      
	      //user input state
	      state = JOptionPane.showInputDialog("Enter the abbreviation of your state (in capital letters):");
		 
		  
		  elecRate = ((Double)states.get(state)).doubleValue();
		  //END OF STATES' HASHMAP
		
	
		//computer cost stored based on user input 
		comCost = Double.parseDouble(JOptionPane.showInputDialog("Enter the cost of your candidate computer (Enter an integer):"));
		
		
		//desktop or laptop
		String laptop="no";
		String desktop="no";
		dl = JOptionPane.showInputDialog("Is your computer a laptop or desktop?");
		
	
		if (dl.equals("laptop"))
		{
			laptop="yes";
		}
		if (dl.equals("desktop"))
		{
			desktop="yes";
		}
		
		//type of screen 
		screenType = JOptionPane.showInputDialog("Enter the type of screen (LCD, CRT, or LED): ");
		
		
		//electricity use based on the size of screen 
		screenSize = Double.parseDouble(JOptionPane.showInputDialog("Enter the size of screen in inches (please enter an integer in the range 11-35): "));
		
		screenElec = 0; 
		
		if (screenSize<17 && screenType.equals("LCD"))
		{
			screenElec=20;
		}
		if (screenSize>=17 && screenSize<=19 && screenType.equals("LCD"))
		{
			screenElec=30;
		}
		if (screenSize>=20 && screenSize<=24 && screenType.equals("LCD"))
		{
			screenElec=50;
		}
		if (screenSize>=25 && screenSize<=35 && screenType.equals("LCD"))
		{
			screenElec=80;
		}
		if (screenSize<17 && screenType.equals("LED"))
		{
			screenElec=18;
		}
		if (screenSize>=17 && screenSize<=20 && screenType.equals("LED"))
		{
			screenElec=24;
		}
		if (screenSize>=21 && screenSize<=26 && screenType.equals("LED"))
		{
			screenElec=30;
		}
		if (screenSize>=27 && screenSize<=37 && screenType.equals("LED"))
		{
			screenElec=70;
		}
		if (screenSize<17 && screenType.equals("CRT"))
		{
			screenElec=60;
		}
		if (screenSize>=17 && screenSize<=20 && screenType.equals("CRT"))
		{
			screenElec=80;
		}
		if (screenSize>=21 && screenSize<=24 && screenType.equals("CRT"))
		{
			screenElec=110;
		}
		if (screenSize>=25 && screenSize<=35 && screenType.equals("CRT"))
		{
			screenElec=130;
		}
		
		//size of hard disk electricity use
		diskSize = Double.parseDouble(JOptionPane.showInputDialog("Enter the size of hard disk in inches (please enter either 2.5 or 3.5): "));
		
		diskElec = 0;
		
		if (diskSize==2.5)
		{
			diskElec=1.85;
		}
		if (diskSize==3.5)
		{
			diskElec=7.75;
		}
		
		//Ask for CPU speed, number of cores, CPU brand and store corresponding electricity use in variable SpeedCoreBrand
		CPUspeed = JOptionPane.showInputDialog("Select your computer CPU brand, speed, and number of cores (enter a letter a-g:) "
				+ "a: Intel low speed 2 cores"
				+ "b: Intel medium speed 4 cores"
				+ "c: Intel high speed 6 cores"
				+ "d: Intel top speed 8 cores"
				+ "e: AMD low speed 2 cores"
				+ "f: AMD medium speed 4 cores"
				+ "g: AMD high speed 4 cores");
		
		System.out.println("a: Intel low speed 2 cores");
		System.out.println("b: Intel medium speed 4 cores");
		System.out.println("c: Intel high speed 6 cores");
		System.out.println("d: Intel top speed 8 cores");
		System.out.println("e: AMD low speed 2 cores");
		System.out.println("f: AMD medium speed 4 cores");
		System.out.println("g: AMD high speed 4 cores");
		

		SpeedCoreBrand = 0;
				
		if (CPUspeed.equals("a")) 
		{
			SpeedCoreBrand=64;
		}
		if (CPUspeed.equals("b"))
		{
			SpeedCoreBrand=84;
		}
		if (CPUspeed.equals("c")) 
		{
			SpeedCoreBrand=86;
		}
		if (CPUspeed.equals("d")) 
		{
			SpeedCoreBrand=140;
		}
		if (CPUspeed.equals("e")) 
		{
			SpeedCoreBrand=80;
		}
		if (CPUspeed.equals("f")) 
		{
			SpeedCoreBrand=95;
		}
		if (CPUspeed.equals("g")) 
		{
			SpeedCoreBrand=110;
		}
		
		//taking in how long the user will use the computer
		years = Double.parseDouble(JOptionPane.showInputDialog("How many years do you expect to keep your computer? (please enter an integer) "));
		
		months = years*12;
		
		//how many hours the user uses the computer/day
		hours = Double.parseDouble(JOptionPane.showInputDialog("On average, how many hours a day do you leave the power on? (please enter an integer) "));
		
		
		//considering mouse battery
		String mouse="no";
		yn = JOptionPane.showInputDialog("Does your mouse need a battery? (enter no if you don't have a mouse) ");
		
		
		if (yn.equals("yes"))
		{
			mouse="yes";
		}
		
		
		mBattery=0;
	
		if (mouse.equals("yes"))
		{
			mBattery=2*(months-2);
			if (mBattery<=0)
			{
				mBattery=0;
			}
		}
		if (yn.equals("no"))
		{
			mBattery=0;
		}
		
		//cost of replacing computer battery (using least integer function!!!!!!!)
		cBattery = 0;
		
		if (desktop.equals("yes"))
		{
			cBattery=0;
		}
		if (laptop.equals("yes"))
		{
			cBattery=Math.ceil((double)(years-5)/5)*150; 
			if (cBattery<0)
			{
				cBattery=0;
			}
		}
		 
		//calculating battery cost
		bCost = mBattery + cBattery; 
		
		//electricity cost
		totalWatts=screenElec + diskElec + SpeedCoreBrand +2.5; //+ 2.5 is RAM
		eCost= totalWatts*hours/1000*365*years*elecRate; 
		
		
		//calculating total cost
		totalCost = comCost + eCost + bCost;
		
		//final print statements to display answers
		System.out.println("");
		System.out.println("here is the approximate costs of your computer:");
		System.out.println("Computer cost = $" + comCost);
		System.out.println("Electricity cost = $" + eCost);
		System.out.println("Battery cost = $" + bCost);
		System.out.println("Total cost = $" + totalCost);	
	
}
		
	public void paint(Graphics g) {

		Font f = new Font("Helvetica", Font.BOLD, 30);
		g.setFont(f);

		g.setColor(new Color(64, 64, 255));

		g.drawString("Computer cost = $" + comCost , 5, 60);
		g.drawString("Electricity cost = $" + eCost , 5, 90);
		g.drawString("Battery cost = $" + bCost , 5, 120);
		g.drawString("Total cost = $" + totalCost , 5, 150);
	}
}

