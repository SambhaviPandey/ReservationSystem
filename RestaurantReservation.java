/**
 * class RestaurantReservation is a 
 * derived from the Reservation class.
 * This class represents a request for 
 * a restaurant reservation at a specific
 * time slot. 
 *
 * @author (Sambhavi Pandey)
 * @version (Last modified on June 1, 2018)
 */
public class RestaurantReservation extends Reservation 
{
    //Declaring instance variable
    private int numSeatsNeeded;
    /**
     * Constructor for objects of class 
     * RestaurantReservation.
     * This constructor takes one String 
     * argument and two int 
     * arguments. The purpose of this 
     * constructor is to call the superclass
     * constructor and to initialize the instance
     * variable. 
     * 
     * @param name
     * @param startTime
     * @param numSeatsNeeded 
     */
    public RestaurantReservation(String name, 
                                 int startTime,
                                 int numSeatsNeeded)
    {
       super(name,startTime);
       this.numSeatsNeeded = numSeatsNeeded;
    }
    
    /**
     * getNumSeatsNeeded is a method 
     * that returns an int value. This
     * method returns a value pertaining
     * to the number of seats that are 
     * needed for the reservation. 
     */
    public int getNumSeatsNeeded()
    {
        return numSeatsNeeded;
    }

    /**
     * toString method returns a value 
     * of type String. This method calls
     * the super class and returns the 
     * number of customer seats needed as a String. 
     */
    @Override
    public String toString()
    {
        return super.toString() + " customer seats: " 
               + getNumSeatsNeeded();
    }
}