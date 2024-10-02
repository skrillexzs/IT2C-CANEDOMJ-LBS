
package it2c.cañedomj.lbs;

import java.util.Scanner;

public class IT2CCAÑEDOMJLBS {


    public void addBooks() {
        
        Scanner sc = new Scanner(System.in);
        config cf = new config();
        
        System.out.print("Book Name: ");
        String bkname = sc.next();
        System.out.print("Author: ");
        String auth = sc.next();
        System.out.print("Genre: ");
        String gen = sc.next();
        
        String sql = "INSERT INTO  books (bk_name, author, genre) VALUES ( ?, ?, ?)";
        
        cf.addBooks (sql, bkname, auth, gen);
    }
    
    public static void main  (String[] args){
        
        Scanner sc = new Scanner (System.in);
        String response;
        
        do{
            System.out.println("Welcome to Library Borrowing System");
            System.out.println("---------------------------------------");
            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");
            System.out.println("---------------------------------------");

            System.out.print("Enter Action: ");
            int action = sc.nextInt();

            switch (action){
            
                case 1:
                    
                    IT2CCAÑEDOMJLBS lbs = new IT2CCAÑEDOMJLBS();
                    lbs.addBooks();
                
                break;
            }
            
            System.out.println("Continue? (yes/no): ");
            response = sc.nextLine();
        }while(response.equalsIgnoreCase("yes"));
        System.out.println("Thank You, See you again!");
    }
}
