import java.util.ArrayList;
/**
 * class BoatReservation is derived from 
 * the Reservation class. The purpose 
 * of this class is to reserve a boat 
 * reservation. 
 *
 * @author (Sambhavi Pandey)
 * @version (Last modified on June 1,2018)
 */
public class BoatReservation extends Reservation
{
   //Declaring instance variables
   private ArrayList<String> prefer;
   /**
    * Constructor that takes an argument of type
    * int and an argument of type String. 
    * The purpose of this constructor is to 
    * call the superclass (which is the Reservation
    * class) along with initializing the instance 
    * variable. 
    * 
    * @param timeslot
    * @param customerName
    */
   public BoatReservation(int timeSlot, String customerName)
   {
       super(customerName,timeSlot);
       prefer = new ArrayList<String>();
    }
   
   /**
    * addBoatPreference method takes an argument of
    * type String. The purpose of this method is to 
    * add a boat name to an internal list of preferences in
    * the reservation. 
    * 
    * @boatName
    */
   public void addBoatPreference(String boatName)
   {
       prefer.add(boatName);
   }
  
   /**
    * Returns the String ArrayList.
    * The purpose of this method is 
    * to return the preferences of the 
    * boat reservation. 
    */
   public ArrayList <String> getPreferences()
   {
       return prefer;
    }
}