
/**
 *
 * @author dylan
 */

import java.util.Scanner;
import java.io.IOException;

public class Walkthrough {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String table = "nflPlayers";
        
        String createVals;
        createVals = "NAME VARCHAR (20), AGE INT, TEAM VARCHAR (20), YEAR INT";
        
        Trans.create(table, createVals);
        
        String[] player1 = {"Dak Prescott", "28", "Cowboys", "6"};
        String[] player2 = {"JaMarr Chase", "21", "Bengals", "1"};
        String[] player3 = {"Tyron Smith", "30", "Cowboys", "11"};
        String[] player4 = {"Jalen Ramsey", "27", "Rams", "6"};
        String[] player5 = {"Justin Tucker", "32", "Ravens", "10"};
        
        Trans.write (table, player1);
        Trans.write (table, player2);
        Trans.write (table, player3);
        Trans.write (table, player4);
        Trans.write (table, player5);
        
        String cols = "name, type";
        String cond = "where age > 6";
        int attributes = 2;
        
        String [] result = Trans.read (table, cols, cond);
        
        for (int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
        
        boolean repeat = true;
        int attr;
        
        while (repeat){
            System.out.println("Please select an option by enterring a number. \n\n\t1. Create a new table \n\t2. Insert records \n\t3. Select records\n\t4. Quit");
            int select = input.nextInt();
            input.nextLine();
            
            switch(select){
                case 1:
                    System.out.println("What should the table be named?");
                    table = input.next();
                    input.nextLine();
                    System.out.println("What values should the table use?");
                    createVals = input.nextLine();
                    Trans.create(table, createVals);
                    break;
                    
                case 2:
                    System.out.println("Which table are you adding a record for?");
                    table = input.next();
                    input.nextLine();
                    
                    System.out.println("How many attributes are you setting?");
                    attr = input.nextInt();
                    input.nextLine();
                    
                    String[] entry = new String[attr];
                    
                    for(int i = 0; i < attr; i++){
                        entry[i] = input.nextLine();
                    }
                    Trans.write(table, entry);
                    
                    break;
                    
                case 3:
                    System.out.println("Which table should info be gotten from?");
                    table = input.next();
                    input.nextLine();
                    
                    System.out.println("Which attribute(s) are you selecting");
                    cols = input.nextLine();
                    
                    System.out.println("Please enter any restrictions.");
                    cond = input.nextLine();
                    
                    result = Trans.read(table, cols, cond);
                    
                    for (int i = 0; i < result.length; i++){
                        System.out.println(result[i]);
                    }
                    input.nextLine();
                    
                    break;
                    
                case 4:
                    repeat = false;
                    break;
                default:
                    break;
            }
        }
    }
    
}
