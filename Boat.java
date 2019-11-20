import java.util.Scanner;
import java.util.ArrayList;
/**
 * class Boat is derived from ReservableItem
 * class.
 * 
 * @author (Sambhavi Pandey)
 * @version (Last modified on June 1,2018)
 */
public class Boat extends ReservableItem
{
    /**
     * Boat class constructor that takes 
     * an argument of type Scanner. This 
     * constructor calls the superclass
     * (which is ReservableItem). 
     * 
     * @param fileIn
     */
    public Boat(Scanner fileIn)
    {
        super(fileIn);
    }

    /**
     * getFitnessValue method takes an 
     * argument of type Reservation. The 
     * purpose of this method is to determine
     * the appropriate fitness value for the boat.
     *
     * @param res
     */
    @Override 
    public int getFitnessValue(Reservation res)
    {
        //if the time slot is full
        if(getReservations()[res.getTime()] != null)
        {
            return 0;
        }
        //If it is a boat reservation
        if (res instanceof BoatReservation == true) 
        {
            //Declaring/initializing variables 
            ArrayList<String> pref = 
            ((BoatReservation) res).getPreferences();
            //Declaring variable
            int index = 0;
            //Going through the array
            for (int i = 0; i < pref.size();i++) 
            {
                //To find the best fit value 
                if (pref.get(i).equals(this.getId())) 
                {
                    index = 100 - i;
                }
            }
            return index;
        }
        //Reservation is not a boat type 
        else 
        { 
            return 0;
        }
    }
}