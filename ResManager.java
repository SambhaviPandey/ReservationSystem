import java.util.ArrayList;
/**
 * class ResManager is the manager for 
 * Reservations. It holds a list of 
 * reservables and a list of reservations.
 * It is implemented as a Generic class of 
 * the types ItemType and ResType where 
 * ItemType pertains to ReservableItem and 
 * ResType pertains to Reservation.
 *
 * @author (Sambhavi Pandey)
 * @version (Last modified on June 1, 2018)
 */
public class ResManager<ItemType extends ReservableItem,
ResType extends Reservation> 
{
    //Declaring instance variables 
    private ArrayList<ResType> reservation;
    private ArrayList<ItemType> reservable;

    /**
     * No-argument constructor. Initializes
     * the instance variables. 
     */
    public ResManager()
    {
        reservation = new ArrayList<ResType>();
        reservable = new ArrayList<ItemType>();
    }

    /**
     * addReservable method takes an argument of 
     * type ReservableItem. The purpose of this method 
     * is to add an item to the manager.
     * 
     * @param item 
     */
    public void addReservable(ReservableItem item)
    {
        //Typecasting
        ItemType it = (ItemType) (item);
        //Adding the item 
        reservable.add(it);
    }

    /**
     * makeReservation method takes an argument 
     * of type Reservation and returns a 
     * value of type Reservation. The purpose of this
     * method is to attempt to take a reservation 
     * based on the information in trialRes.If it fails,
     * it returns null.
     * 
     * @param trialRes
     */
    public Reservation makeReservation(Reservation trialRes)
    {
        //index variable tracks best fit index
        //for the reservation
        int bestIndex = 0;
        //Tracks fitness value
        int fitVal = 0;
        //Goes through the ArrayList
        for(int i = 0; i < reservable.size(); i++)
        {
            //looking for the best fit 
            if(reservable.get(i).
            getFitnessValue(trialRes) > fitVal)
            {
                //updates index 
                bestIndex = i;
                fitVal = reservable.get(i).getFitnessValue(trialRes);
                //finds best fit 
                if(fitVal == 100)
                {
                    //loop ends 
                    break;
                }
            }			
        }
        //if the fitness value is not 0
        if(fitVal != 0)
        {
            //sets resource id if the reservation is successful
            trialRes.setResourceId(reservable.get(bestIndex).getId());
            //adds reservation to array list 
            reservation.add((ResType) trialRes);
            //adds reservation to time slot 
            reservable.get(bestIndex).getReservations()
            [trialRes.getTime()] = trialRes;
            return trialRes;
        }
        //if the fitness value is 0
        else
        {
            System.out.print("Unsuccessful reservation: "); 
            System.out.println(trialRes);
            return null;
        } 
    }
    
     /**
     * sortReservations method sorts the list 
     * of reservations by customer name. It uses
     * insertion sort.
     */
    public void sortReservations()
    {
        for (int i = 0; i < reservation.size(); i++)
        {
            Reservation r = reservation.get(i);
            //variable for the hole
            int h = i; 
            while (i > 0 && (reservation.get(i-1)).
            getCustomer().compareTo(r.getCustomer()) > 0)
            {
                //data slides to the left, which moves the hole left 
                reservation.set(i,reservation.get(i-1));
                i--;
            }
            reservation.set(i,(ResType)r);
            i = h;
        }
    }
        
    /**
     * toString method returns a value of 
     * type String that creates a
     * string listing of reservations.
     */
    public String toString()
    {
        //Variable needed for the method
        String s = "";
        //Going through the arraylist 
        for (int i = 0; i < reservation.size(); i++)
        {
            s += reservation.get(i).toString() + " \n";
        }
        return s;
    }
}