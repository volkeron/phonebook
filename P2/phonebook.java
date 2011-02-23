import simpleIO.*;
import java.util.*;


/**
 * Write a description of class phonebook here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class phonebook
{
    private ArrayList<entry> entries;
    private boolean populated;
    UserDialog ud;    
    
    public phonebook()
    {
        entries = new ArrayList<entry>();
        ud = new UserDialog();
        populated = false;
    }
    public void populate() {
        if(!populated) {
        entries.add(new entry("Ion","15353151"));
        entries.add(new entry("Mike","123"));
        entries.add(new entry("Ergun","456"));
        entries.add(new entry("Rares","173"));
        entries.add(new entry("Chris","2475734"));
        entries.add(new entry("Jon","123145"));
        populated = true;
    }
    }
    public void addEntry() {
        String name = ud.getString("Enter new user name: ");
        String number = ud.getString("Now enter user number: ");
        entries.add(new entry(name, number));
    }
    public void searchPhonebook() {
        String x = ud.getString("Insert name to search for:");
        boolean found = false;
        for(entry s:entries){
            if(x.equals(s.name)){
                ud.showMessage("FOUND! User: "+ s.name+", number: "+s.number);
                found=true;
            }
        }
        if(!found) {
            ud.showMessage("The name you entered was not found in the phonebook.");
        }
    }
    public void removeEntry() {
        String x = ud.getString("To remove entry, enter it's name or number:");
        boolean found = false;
        for (int index = 0; index < entries.size();index++){
            if(x.equals(entries.get(index).name) || x.equals(entries.get(index).number)){
                entries.remove(index);
                found = true;
            }
        }
        if(!found) {
            ud.showMessage("No entry found.");
        }
        }
        public void changeEntry() {
            boolean found = false;
            String x = ud.getString("Enter name: ");
            String y = ud.getString("Now enter new number for "+x+":");
            for(int index = 0; index < entries.size();index++) {
                if(x.equals(entries.get(index).name)){
                    entries.get(index).number = y;
                    found = true;
                }
            }
            if(!found) {
                ud.showMessage("Entry not found.");
            }
        }
        public void listAll() {
            String x="";
            for(entry s:entries) {
                x += "Name: "+s.name+", number: "+s.number+"\n";
            }
            ud.showTextMessage(x);
        }
        //github test2
    }

