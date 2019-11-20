//package ReservationSystem;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * This class contains a driver for 
 * restaurant reservations. 
 * 
 * Written by: Lesley Kalmin
 * Modified by: Sambhavi Pandey 
 * Last modified on June 1, 2018
 */
public class RestaurantDriver 
{
    /**
     * main method tests to ensure
     * the program for the 
     * restaurant reservation system
     * is properly working. 
     * 
     * @param args
     */
    public static void main(String[] args) 
    {
        ResManager<Table, RestaurantReservation> manager 
        = new ResManager<Table, RestaurantReservation>();
        try 
        {
            Scanner scanner =
            new Scanner(new FileInputStream("tableFile.txt"));
            while (scanner.hasNext())
            {				
                manager.addReservable(new Table(scanner));				
            }
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("file not found");
            System.exit(0);
        }
        //manager.printItems();// debugging code, prints list of Tables

        //Testing
        RestaurantReservation r1 =
            new RestaurantReservation("Chen family",3,2);
        manager.makeReservation(r1);
        RestaurantReservation r2 = 
            new RestaurantReservation("Singh party",4,8);
        manager.makeReservation(r2);
        r2 = new RestaurantReservation("Kal",4,8);
        manager.makeReservation(r2);
        r2 = new RestaurantReservation("business1",4,8);
        manager.makeReservation(r2);
        RestaurantReservation r3 = 
            new RestaurantReservation("Newmans",2,2);
        manager.makeReservation(r3);

        r2 = new RestaurantReservation("TooBig",4,11);
        manager.makeReservation(r2);
        r2 = new RestaurantReservation("party5",4,10);
        manager.makeReservation(r2);
        r3 = new RestaurantReservation("party6",4,10);
        manager.makeReservation(r3);
        r3 = new RestaurantReservation("overflow",4,10);
        manager.makeReservation(r3);

        System.out.println("Listing of reservations:");
        System.out.println(manager);

        System.out.println("\nSorted reservations");
        manager.sortReservations();
        System.out.println(manager);
    }
}