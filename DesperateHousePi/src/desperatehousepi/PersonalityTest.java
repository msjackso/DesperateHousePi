package desperatehousepi;

import java.io.IOException;
import java.util.Scanner;

public class PersonalityTest{

        //*************************************************
        // pTest takes in a crust object as an argument,
        // whose personality traits will be modified
        // based on the test results that the user will
        // take. There are 16 questions, one for each
        // trait, each presenting two opposing statements
        // in respect to that personality trait. The user
        // is asked to enter a rating (between -5 and 5)
        // in relation to which statement best suits
        // their own personality. A rating on the negative
        // spectrum corresponds with the first statement
        // given and a positive rating corresponds with the
        // second. 0 represents a neutral rating.
        // @author Brad
        // ************************************************
        public static void pTest(Crust crust) throws IOException{

                // tArray holds the String name for the 16 traits
                String[] tArray;
                tArray = new String[16];
                tArray[0] = "privateness";
                tArray[1] = "abstractedness";
                tArray[2] = "apprehensivness";
                tArray[3] = "dominance";
                tArray[4] = "emotionalStability";
                tArray[5] = "liveliness";
                tArray[6] = "opennessToChange";
                tArray[7] = "perfectionism";
                tArray[8] = "reasoning";
                tArray[9] = "ruleConsciousness";
                tArray[10] = "selfReliance";
                tArray[11] = "sensitivity";
                tArray[12] = "socialBoldness";
                tArray[13] = "tension";
                tArray[14] = "vigilance";
                tArray[15] = "warmth";


                //qArray contains each of the questions to ask the user
                String[] qArray;
                qArray  = new String[16];
                qArray[0] = "I prefer to be around others (-5) OR I prefer to be alone (5)\n";
                qArray[1] = "I am a practical thinker (-5) OR I am very imaginative (5) \n";
                qArray[2] = "I am usually very calm (-5) OR I tend to worry a lot (5) \n";
                qArray[3] = "I try to avoid conflicts (-5) OR I am a competitive person (5) \n";
                qArray[4] = "I am quick to anger (-5) OR I am not easily irritated (5) \n";
                qArray[5] = "I like to plan things out (-5) OR I do things spontaneously (5) \n";
                qArray[6] = "I enjoy things done traditionally (-5) OR I enjoy flexibility (5) \n";
                qArray[7] = "Disorder doesn't bother me (-5) OR Everything needs to be organized (5) \n";
                qArray[8] = "I view things in detail (-5) OR I view things abstractedly  (5) \n";
                qArray[9] = "I resist authority (-5) OR I follow the rules (5) \n";
                qArray[10] = "I need the company of others (-5) OR I need time to myself (5) \n";
                qArray[11] = "I am tough-minded (-5) OR I am tender-hearted (5) \n";
                qArray[12] = "I have trouble approaching people (-5) OR I am comfortable around strangers (5) \n";
                qArray[13] = "Traffic doesn't bother me (-5) OR I get frustrated in traffic (5) \n";
                qArray[14] = "People are generally good (-5) OR People are generally bad (5) \n";
                qArray[15] = "I am reserved (-5) OR I am outgoing (5) \n";

                //initial prompt giving user instructions for the test
                System.out.println("Please enter a number, between -5 and 5, that you feel "
                                   +"best matches your personality based on the two "
                                   +"statements given. For example, if you relate more to "
                                   +"the first statement, enter a number between -1 and -5 "
                                   +"(with -5 being more extreme and -1 being more neutral)."
                                   +" The same goes for the second statement and the numbers "
                                   +"1 to 5 (again, with 5 being more extreme and 1 being "
                                   +"more neutral. If you feel that you don't relate to one "
                                   +"more than the other or neither apply to you, enter 0.\n\n");

                // for each question
                for(int i = 0; i <= 15; i++){

                        //print it out and initialize input variables
                        System.out.println(qArray[i]);
                        Scanner scan = new Scanner(System.in);
                        String rating = "";

                        //used to determine valid input
                        boolean isValid = false;
                        //keep requesting an answer until it is valid
                        while(!isValid){
                                System.out.print("Enter Rating: ");
                                //user input
                                rating = scan.nextLine();
                                //for valid input, assign appropriate value to Crust's trait
                                //and continue to next question
                                switch(rating){
                                        case("-5"):
                                                crust.set(tArray[i], "-100");
                                                isValid = true;
                                                break;
                                        case("-4"):
                                                crust.set(tArray[i], "-80");
                                                isValid = true;
                                                break;
                                        case("-3"):
                                                crust.set(tArray[i], "-60");
                                                isValid = true;
                                                break;
                                        case("-2"):
                                                crust.set(tArray[i], "-40");
                                                isValid = true;
                                                break;
                                        case("-1"):
                                                crust.set(tArray[i], "-20");
                                                isValid = true;
                                                break;
                                        case("0"):
                                                crust.set(tArray[i], "0");
                                                isValid = true;
                                                break;
                                        case("1"):
                                                crust.set(tArray[i], "20");
                                                isValid = true;
                                                break;
                                        case("2"):
                                                crust.set(tArray[i], "40");
                                                isValid = true;
                                                break;
                                        case("3"):
                                                crust.set(tArray[i], "60");
                                                isValid = true;
                                                break;
                                        case("4"):
                                                crust.set(tArray[i], "80");
                                                isValid = true;
                                                break;
                                        case("5"):
                                                crust.set(tArray[i], "100");
                                                isValid = true;
                                                break;
                                        //invalid input
                                        default:
                                                System.out.println("Incorrect value, rating must be a "
                                                                  +"number between -5 and 5\n");
                                                isValid = false;
                                }
                        }
                        scan.close();

               }
        }

}
