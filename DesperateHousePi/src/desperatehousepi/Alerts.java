package desperatehousepi;

import java.io.IOException;

import desperatehousepi.Crust.Crust;
import desperatehousepi.Items.ItemSet.itemType;


//As the crust performs actions or its needs drop below a certain
//point, the Commands class functions call these functions. Each 
//creates a string and fills it with the appropriate statement,
//depending on the action or need
//@author Brad
public class Alerts{


        //when the crust uses an object, return 'used' string
        public static String used(Crust crust, String iN){
                String itemName = iN;
                String crustName = crust.get("firstName");
                String alertString = crustName + " has used " + itemName;
                return alertString;
        }

        //when the crust consumes an object, return 'consumed' string
        public static String consumed(Crust crust, String iN){
                String itemName = iN;
                String crustName = crust.get("firstName");
                String alertString = crustName + " has consumed " + itemName;
                return alertString;
        }

        //when an object is created, return a 'created' string
        public static String created(itemType item){
                String itemName = item.name();
                String alertString = "Created " + itemName;
                return alertString;
        }

        //when an object is destroyed, return a 'destroyed' string
        public static String destroyed(itemType item){
                String itemName = item.name();
                String alertString = "Destoyed " + itemName;
                return alertString;
        }

        //when the crust is saved to file, return 'saved' string
        public static String saved(Crust crust){
                String crustName = crust.get("firstName");
                String alertString = crustName + " saved";
                return alertString;
        }

        //when the crust is hungry, return 'hungry' string
        public static String hungry(Crust crust){
                String crustName = crust.get("firstName");
                String alertString = crustName + " is hungry";
                return alertString;
        }
        
        //when the crust is tired, return 'tired' string
        public static String tired(Crust crust){
                String crustName = crust.get("firstName");
                String alertString = crustName + " is tired";
                return alertString;
        }

        //when the crust is bored, return 'bored' string
        public static String bored(Crust crust){
                String crustName = crust.get("firstName");
                String alertString = crustName + " is bored";
                return alertString;
        }

}
