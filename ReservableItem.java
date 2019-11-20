import java.util.Scanner;
import java.io.File;
/**
 * Class ReservableItem is an abstract class
 * that represents an item that can be reserved.
 * Each ReservableItem has 10 time slots that 
 * can be reserved/requested by the user. 
 *
 * @author (Sambhavi Pandey)
 * @version (Last modified on June 1, 2018)
 */
public abstract class ReservableItem
{
    //Declaring instance variables
    //Length of array
    private static final int TIMESLOT = 10;
    //Tracks available time slots 
    private Reservation[] res = new Reservation[TIMESLOT];
    //Tracks id of the class
    private String id;
    /**
     * Constructor that takes an argument of 
     * type Scanner. The purpose of this 
     * constructor is to read the next line
     * from the Scanner of an input file that
     * has already been opened. This constructor 
     * also initializes the instance variable. 
     * 
     * @param fileIn
     */
    public ReservableItem(Scanner fileIn)
    {
        id = fileIn.nextLine();
    }
    
    /**
     * getId method returns a value of 
     * type String. The purpose of this method
     * is to return the value of the id variable.
     */
    public String getId()
    {
        return id;
    }
    
    /**
     * getFitnessValue method is an abstract method 
     * that takes an argument of type Reservation 
     * and returns an int value.This method is 
     * implemented in the subclasses of
     * ReservableItem. The purpose of this method 
     * is to return an integer between 0 and 100 
     * which tells the caller how well fit a 
     * reservation is for the reservable item. 
     * 
     * @res 
     */
    public abstract int getFitnessValue(Reservation res);
    
    /**
     * getReservation method returns an array 
     * that corresponds to the list of 
     * reservation times.
     */
    public Reservation[] getReservations()
    {
        return res;
    }
}