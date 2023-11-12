package System;

import UI.SystemUI;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * PlayGroundSchedule class used to show and manage playground schedule
 * @author Mohamed_El_Laithy
 */
public class PlayGroundSchedule {
String SlotsStatus;
ArrayList<ArrayList<String>> schedule;
int timeSlotPerHour;
int begins;
int ends;
Scanner input = new Scanner(System.in);
SystemUI obj = new SystemUI();

public PlayGroundSchedule()
{
	schedule = new ArrayList<ArrayList<String>>();
}
/**
 * displaying all the booking slots
 */
public void displayAllSlots()
{
	for(int i=0; i<schedule.size(); i++)
    {
    	System.out.println("Booking slot Time: "+schedule.get(i).get(0));
    	System.out.println("On days: sunday Monday TuesDay WendesDay Friday Saturday");
    }
    
}
/**
 * setting the booking schedule
 */
public void setschedule()
{
	String temp;
    System.out.println("Enter the beggining time of booking for your playground");
    temp = input.nextLine();
    int getBegin = obj.stringToInt(temp);
    begins=getBegin;
    System.out.println("Enter the end time of booking for your playground");
    temp = input.nextLine();
    int getEnd = obj.stringToInt(temp);
    ends=getEnd;
    for(int i=0; i<(getEnd-getBegin); i++)
    {
    	schedule.add(new ArrayList<String>());
    	schedule.get(i).add(0,Integer.toString((getBegin+i)));
    	schedule.get(i).add(1,"sunday");
    	schedule.get(i).add(2,"monday");
    	schedule.get(i).add(3,"tuesday");
    	schedule.get(i).add(4,"wednesday");
    	schedule.get(i).add(5,"thursday");
    	schedule.get(i).add(6,"friday");
    	schedule.get(i).add(7,"saturday");
    }
    displayAllSlots();
}
/**
 * Set playground price per hour
 */
public void setPrice()
{
	String temp;
    System.out.println("Enter the price per hour");
    temp = input.nextLine();
    timeSlotPerHour= obj.stringToInt(temp);
}
/**
 * displaying the available booking slots
*/
public void displayFreeSlots()
{
	 for(int i=0; i<schedule.size(); i++)
	 {
	     System.out.println("Booking slot Time: "+schedule.get(i).get(0));
		 System.out.println("Available on days: ");
		 if(schedule.get(i).get(1).equalsIgnoreCase("sunday"))
	    	{
	    		System.out.println("Sunday");
	    	}
	    	if(schedule.get(i).get(2).equalsIgnoreCase("monday"))
	    	{
	    		System.out.println("monday");
	    	}
	    	if(schedule.get(i).get(3).equalsIgnoreCase("tuesday"))
	    	{
	    		System.out.println("tuesday");
	    	}
	    	if(schedule.get(i).get(4).equalsIgnoreCase("wednesday"))
	    	{
	    		System.out.println("wendesday");
	    	}
	    	if(schedule.get(i).get(5).equalsIgnoreCase("thursday"))
	    	{
	    		System.out.println("thursday");
	    	}
	    	if(schedule.get(i).get(6).equalsIgnoreCase("friday"))
	    	{
	    		System.out.println("friday");
	    	}
	    	if(schedule.get(i).get(7).equalsIgnoreCase("saturday"))
	    	{
	    		System.out.println("saturday");
	    	}
	    }
	    
}
/**
 * get playground Time Slot Per Hour
 * @return timeSlotPerHour
 */
public int getTimeSlotPerHour()
{
return timeSlotPerHour;
}
/**
 * get begin time 
 * @return begins
 */
public int getBegin()
{
	return begins;
}
/**
 * get end time
 * @return ends
 */
public int getEnd()
{
	return ends;
}
/**
 * getting index of the day
 * @param day
 * @return day index in week
 */
public int getDayIndex(String day) {
	if(day.equalsIgnoreCase("sunday"))
	{
		return 1;
	}
	else if(day.equalsIgnoreCase("monday"))
	{
		return 2;
	}
	else if(day.equalsIgnoreCase("tuesday"))
	{
		return 3;
	}
	else if(day.equalsIgnoreCase("wendesday"))
	{
		return 4;
	}
	else if(day.equalsIgnoreCase("thursday"))
	{
		return 5;
	}
	else if(day.equalsIgnoreCase("friday"))
	{
		return 6;
	}
	else if(day.equalsIgnoreCase("saturday"))
	{
		return 7;
	}
	return -1;
}
/**
 * editing the booking slot to be booked for a player or to be cancelled
 * @param player String player name
 * @param time String time
 * @param day String day
 */
public void bookSlot(String player, String time,String day)
{
	for(int i=0; i<schedule.size(); i++)
	{
		if(time.equalsIgnoreCase(schedule.get(i).get(0)))
		{
			int getDay=getDayIndex(day);
			schedule.get(i).set(getDay,player);
			break;
		}
	}
}
/**
 * update playground slots 
 * @param day String day
 * @param time String time
 * @param player String player
 */
public void updateSlot(String day,String time,String player)
{
	for(int i=0; i<schedule.size(); i++)
	{
		if(time.equalsIgnoreCase(schedule.get(i).get(0)))
		{
			int getDay=getDayIndex(player);
			schedule.get(i).set(getDay,day);
			break;
		}
	}	
}

}
