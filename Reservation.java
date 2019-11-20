/**
 * class Reservation represents a request by 
 * the user to reserve an item, and if successful, 
 * represents the reservation for the item. This 
 * class implements Comparable, for sorting by customer 
 * name. 
 *
 * @author (Sambhavi Pandey)
 * @version (Last modified on June 1,2018)
 */
public class Reservation implements Comparable<Reservation>
{
    //Declaring instance variables 
    private String name; 
    private int time;
    private String Id;
    /**
     * Reservation constructor takes an argument of type
     * String and an argument of type int. The 
     * purpose of this constructor is to 
     * create a reservation request for a name, and slot.
     * This constructor also initializes the instance 
     * variables. 
     * 
     * @param customerName
     * @param timeslot 
     */
    public Reservation(String customerName, int timeslot)
    {
        name = customerName;
        time = timeslot;
        Id = "";
    }
    
    /**
     * getCustomer method returns a String value.
     * The purpose of this method is to return 
     * a value pertaining to the customer's
     * name. 
     */
    public String getCustomer()
    {
        return name;
    }
    
    /**
     * getTime method returns an int value. 
     * The purpose of this method is to return
     * the time of the reservation. 
     */
    public int getTime()
    {
        return time; 
    }
    
    /**
     * toString method method returns a value of 
     * type String. The purpose of this method is 
     * to write out the reservation by 
     * printing out the name of the customer 
     * and the time of the reservation, along with the 
     * id.
     */
    public String toString()
    
    {
        return "Reservation name: " + name + " time: " 
                + time + " id: " + Id;
    }
    
    /**
     * setResourceId method takes an argument of 
     * type String. The purpose of this method is to 
     * set the id of the reservableItem. 
     * 
     * @param id 
     */
    public void setResourceId(String id)
    {
        Id = id;
    }
   
    /**
     * compareTo method takes an argument of type
     * Reservation and returns a value of type int. This
     * method compares the customer name (declared 
     * as an instance variable) to the customer name passed
     * in the parameter. This method is utilized to sort 
     * the customer name. 
     * 
     * @param res
     */
    public int compareTo(Reservation res)
    {
        //calling compareTo method to compare customer name
	return this.getCustomer().compareTo(res.getCustomer());
    }
}