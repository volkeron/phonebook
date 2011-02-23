package P1;

import simpleIO.*;
/**
 * Write a description of class MAIN here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MAIN
{
    
    
    private UserDialog ud;
    private int totalBaggage;
    private int totalPrice;
    private int totalPass;
    private boolean stop;
    public MAIN()
    {
       ud = new UserDialog();
       totalBaggage = 0;
       totalPrice = 0;
       totalPass = 0;
       stop = false;
    }

    public String ticketType() {
        String[] options = {"60", "55", "50"};
        return ud.selectString("Select ticket price(60�-meal, 55�-drink, 50�-budget: ", options);        
        
    }
    public int extraBaggage() {
       int x = ud.getInt("20kg free baggage, please enter total weight in kg(max allowed is "+(3000-totalBaggage)+"kg):");
        if(totalBaggage+x<=3000) {
	    totalBaggage += x;
	    return x;
	   }
	   else {
	      ud.showMessage("Baggage limit exceeded, maximum is "+(3000-totalBaggage)+" kg."); 
	      return -1;
	   }

    }
    public void stopBoarding() {
        stop = ud.getBoolean("Stop boarding? Remaining passengers - "+(120-totalPass)+", baggage - "+(3000-totalBaggage)+"kg.");
    }
    public void ticketPrice() {
        while(totalPass<120 && totalBaggage<3000 && !stop) {
            int x = Integer.parseInt(ticketType());
            int y = extraBaggage();
            if(y != -1) {
              if(y>20) {
            totalPrice+=x+(y-20);
            totalPass++;
            System.out.println("Ticket for passenger no. "+totalPass+": total price-"+(x+(y-20))+", total baggage weight-"+y+".");
        }
        else{
            totalPrice+=x;
            totalPass++;
            System.out.println("Ticket for passenger no. "+totalPass+": total price-"+x+", total baggage weight-"+y+".");
        }
        }
        if(totalBaggage<3000 && totalPass<120) {
        stopBoarding();
        }
        }
        System.out.println("Summary of flight: ");
        System.out.println("Total passengers: "+totalPass);
        System.out.println("Total revenue: "+totalPrice);
        System.out.println("Total baggage weight: "+totalBaggage);
    }
    
}
