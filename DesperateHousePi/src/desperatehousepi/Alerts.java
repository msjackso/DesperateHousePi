package desperatehousepi;

import java.io.IOException;


public class Alerts{


        public static String used(Crust crust, itemType item){
                String itemName = item.name();
                String crustName = crust.first_name;
                String alertString = crustName + " has used " + itemName;
                return alertString;
        }

        public static String consumed(Crust crust, itemType item){
                String itemName = item.name();
                String crustName = crust.first_name;
                String alertString = crustName + " has consumed " + itemName;
                return alertString;
        }

        public static String created(itemType item){
                String itemName = item.name();
                String alertString = "Created " + itemName;
                return alertString;
        }

        public static String destroyed(itemType item){
                String itemName = item.name();
                String alertString = "Destoyed " + itemName;
                return alertString;
        }

        public static String saved(Crust crust){
                String crustName = crust.first_name;
                String alertString = crustName + " saved";
                return alertString;
        }

        public static String hungry(Crust crust){
                String crustName = crust.first_name;
                String alertString = crustName + " is hungry";
                return alertString;
        }

        public static String tired(Crust crust){
                String crustName = crust.first_name;
                String alertString = crustName + " is tired";
                return alertString;
        }

        public static String bored(Crust crust){
                String crustName = crust.first_name;
                String alertString = crustName + " is bored";
                return alertString;
        }

}
