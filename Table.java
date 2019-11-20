import java.util.Scanner;
/**
 * class Table is derived from Reservable 
 * and represents a table in the restaurant. 
 *
 * @author (Sambhavi Pandey)
 * @version (Last modified on June 1, 2018)
 */
public class Table extends ReservableItem 
{
    //Declaring instance variable 
    private int numSeats;
    /**
     * Constructor that takes an argument of 
     * type Scanner. This method calls the 
     * super class constructor (which is from 
     * the ReservableItem class).
     */
    public Table(Scanner fileIn)
    {
        super(new Scanner(fileIn.next()));
        numSeats = fileIn.nextInt();
    }

    /**
     * getNumSeats is a method that 
     * returns an int value. The purpose 
     * of this method is to return the 
     * number of seats. 
     */
    public int getNumSeats()
    {
        return numSeats;
    }

    /**
     * findFitnessValue method takes an argument 
     * of type Reservation and returns an int value.
     * The purpose of this method is to determine 
     * the fitness value of the reservation.
     * 
     * @param res
     */
    @Override
    public int getFitnessValue(Reservation res) 
    {
        //if time slot if filled
        if (getReservations()[res.getTime()] 
            != null) 
        {
            return 0;
        }
        
        //if the reservation is of the restaurant 
        if (res instanceof RestaurantReservation == true) 
        {
            //table has exact number of seats needed 
            if(((RestaurantReservation)res).
               getNumSeatsNeeded() == numSeats)
            {
                return 100;
            }
            //number of seats that are needed is greater than 
            //the number of table seats
            else if(((RestaurantReservation)res).
                   getNumSeatsNeeded() > numSeats)
            {
                return 0;
            }
            else 
            { 
                //determines the difference between the 
                //seats at the table and seats that are 
                //needed
                int difference = 
                numSeats-((RestaurantReservation)res).
                getNumSeatsNeeded();
                //returns a value similar to a percent 
                return (10-difference)*10;
            }
        }
        //Otherwise, it is not a restaurant reservation
        else 
        { 
            System.out.println("Not a restaurant reservation");
            return -1;
        }
    }
}