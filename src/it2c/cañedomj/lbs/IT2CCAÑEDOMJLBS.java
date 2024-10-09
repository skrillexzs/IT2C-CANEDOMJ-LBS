
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
    
    private void viewBooks() {
        String qry = "SELECT * FROM books";
        String[] hdrs = {"ID", "Book Name", "Author Name", "Book Genre"};
        String[] clms = {"id", "bk_name", "author", "genre"};
        config cf = new config();
        cf.viewRecords(qry, hdrs, clms);
    }
     
    private void updateBooks(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        
        System.out.print("Enter Book Name: ");
        String bkname = sc.next();
        
        System.out.print("Enter Author Name: ");
        String auth = sc.next();
        
        System.out.print("Enter Book Genre: ");
        String gen = sc.next();


        String qry = "UPDATE books SET bk_name = ?, author = ?, genre = ? WHERE id = ?";


        config cf = new config();
        cf.updateBooks(qry, bkname, auth, gen, id);
    }
      
    private void deleteBooks() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Book ID to Delete: ");
        int id = sc.nextInt();
        
        String sqlDelete = "Delete from books WHERE id = ?";
        config cf = new config();
        cf.deleteBooks(sqlDelete, id);
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
            
            IT2CCAÑEDOMJLBS lbs = new IT2CCAÑEDOMJLBS();
            switch (action){
            
                case 1:
                    lbs.addBooks();
                break;
                
                case 2:
                    lbs.viewBooks();
                break;
                
                case 3:
                    lbs.viewBooks();
                    lbs.updateBooks();
                break;
                
                case 4:
                    lbs.viewBooks();
                    lbs.deleteBooks();
                    lbs.viewBooks();
                break;
                
                case 5:
                    System.out.println("Exiting...");
                break;
                default:
                    System.out.println("Invalid action, Please Try Again.");
            }
            
            System.out.println("Continue? (yes/no): ");
            response = sc.next();
        }while(response.equalsIgnoreCase("yes"));
        System.out.println("Thank You, See you again!");
    }
}
