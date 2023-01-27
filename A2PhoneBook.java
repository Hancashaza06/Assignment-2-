import java.util.*; 
public class A2PhoneBook {

private static String firstName;
private static String lastName;
private static String phoneNumber;
private static String address;
private static String city;
        
private static int menu;
private static int node = 0;
private static LinkedList<String> PhoneBook = new LinkedList<String>();


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // creates scanner method
       
        // Sample Phone Book
        PhoneBook.add("David");
        PhoneBook.add("Rukashaza-Hancock");
        PhoneBook.add("5555555555");
        PhoneBook.add("783 my home");
        PhoneBook.add("Bellingham");
        
        PhoneBook.add("Jake");
        PhoneBook.add("Holmes");
        PhoneBook.add("6666666666");
        PhoneBook.add("123 fake streat");
        PhoneBook.add("Blaine");
        
        PhoneBook.add("Ben");
        PhoneBook.add("Diskin");
        PhoneBook.add("6969696969");
        PhoneBook.add("420 boulavard");
        PhoneBook.add("Bellingham");
        
        PhoneBook.add("Jaspreet");
        PhoneBook.add("Khatkar");
        PhoneBook.add("1000000000");
        PhoneBook.add("somewhere over the rainbow");
        PhoneBook.add("Lynden");
        
        //Starting menu
        mainMenu();   
    } // end of main
    
    //---------------------------------- METHODS:
    
    // program main menu
    public static void mainMenu() {
    Scanner input = new Scanner(System.in); // creates scanner method
    while(menu < 1 || menu > 5) {
         try {
                  System.out.println("Please Choose An Option:");
                  System.out.println("1. View Entire Phone Directory");
                  System.out.println("2. Search For Contact Entry By First And Last Name");
                  System.out.println("3. Search All Contact Entries By City");
                  System.out.println("4. Add An Entry To the Phone Book");
                  System.out.println("5. End The Program");
                  menu = input.nextInt();
              }
         catch (InputMismatchException e){ String error = input.nextLine(); }
                  if(menu < 1 || menu > 5) { System.out.println("Error: Not A Valid Response"); }
        } // end of while
      
     if( menu == 1) { // View Entire Directory
        viewDirectory();
     } // end view if
     
     else if(menu == 2) { // Search By Name
        findByName(); // method to find resident by name
     } // end name search if
     
     else if(menu == 3) { // Search By City
        findByCity();
     } // end of city search
     
     else if(menu == 4) { // Add Contact
     System.out.println("More Features Coming Soon!"); }
    
     else { // end program
     System.out.println("Program Shutting Down...");
     System.exit(0); 
     } // end of else
     } // end of main menu
    
    // method to view all contacts
    public static void viewDirectory() {
     System.out.println("PHONE DIRECTTORY:");
         for(int i = 0; i < PhoneBook.size() ; i++) {
            if(i % 5 == 0) {
               System.out.print(PhoneBook.get(i) + " " + PhoneBook.get(i + 1) + ": ");
               System.out.println(PhoneBook.get(i + 2) + ", " + PhoneBook.get(i + 3) + ", " + PhoneBook.get(i + 4));
            } // end of if
         } // end of for-loop
    }
    // method to search contacts by first + last name
    public static void findByName() {
    Scanner input = new Scanner(System.in); // creates scanner method
    System.out.print("Provide A First Name:\t");
        firstName = input.next();
        System.out.print("Provide A Last Name:\t");
        lastName = input.next();
        try // for index out of bounds
        {
            while(!PhoneBook.get(node).equals(firstName) && !PhoneBook.get(node + 1).equals(lastName)){
               node++;
            } // end of while
        }
        catch (IndexOutOfBoundsException e) {  
           System.out.println("I'm Sorry. The Contact Information You Are Searching For Cannot be Found. Try Again");
           node = 0;
           findByName();
           } 
            switch (node % 5) {
         
               case 0:
               break;
          
               case 1:
                node --;
               break;
               
               case 2:
                  node = node - 2;
               break;
            
               case 3:
                  node = node - 3;
               break;
            
               case 4:
                  node = node - 4;
               break;
            
               default:
                  System.out.println("Error: Name Not Found:");
                  System.out.println("Provide A New First Name:");
                  firstName = input.next();
                  System.out.println("Provide A New Last Name:");
                  lastName = input.next();
               break;
          } // end of switch case
         
         System.out.println();
         System.out.println(PhoneBook.get(node) + " " + PhoneBook.get(node + 1) + ":");
         System.out.println(PhoneBook.get(node + 2) + ", " + PhoneBook.get(node + 3) + ", " + PhoneBook.get(node + 4));
         System.out.println();
         System.out.print("Would You Like To Update Contact Information for " + PhoneBook.get(node) + " " + PhoneBook.get(node + 1) +"? ");
         System.out.print("1 = Yes 2 = No\t");
         int answer = input.nextInt();
         if(answer == 1) { update(); }
         else { end(); }
    } // end find by name
    
    // method to find all residents of specific city
    public static void findByCity() {
    int checkValid = 0; // to check if anyone appears
    Scanner input = new Scanner(System.in); // creates scanner method
    ArrayList<String> cities = new ArrayList<String>(); // array to capture cities
    
    System.out.println("CITIES WITHIN THIS DIRECTORY:");
    for(int i = 0; i < PhoneBook.size(); i++) {
      if((i + 1) % 5 == 0) {  // cities in the linked list
      cities.add(PhoneBook.get(i));
      } // end of if
    } // end of for-loop i
    
    for (int i = 0; i < cities.size(); i++) {
      for( int j = 0; j  < cities.size(); j++) {
      if(cities.get(i).equals(cities.get(j)) && i != j) { // checks city name against other city names
         cities.remove(j); // removes duplicate copy of city name
      }
      } 
    }
    
    System.out.println(cities.toString());
    
    System.out.print("Provide The Name Of The City You Are Searching:\t");
     city = input.next();
     System.out.println(city.toUpperCase() + " RESIDENTS:");
         for(int i = 0; i < PhoneBook.size(); i++) {
            if(PhoneBook.get(i).equals(city)) {
               System.out.print(PhoneBook.get(i - 4) + " " + PhoneBook.get(i - 3) + ": ");
               System.out.println(PhoneBook.get(i - 2) + ", " + PhoneBook.get(i - 1));
               checkValid++;
            } // end of if
         } // end of for-loop
         if(checkValid == 0) { System.out.println("Unfortunalely, There Are No Contacts From " + city);}
    } // end of findByCity
    
    //method to edit contact information
    public static void update() {
    Scanner input = new Scanner(System.in); // creates scanner method
    int answer = 0;
    String edit;
    
    System.out.println("What Information Would You Like To Update?");
    System.out.print("1 = First Name, 2 = Last Name, 3 = Phone Number, 4 = Adress, 5 = City\t");
    answer = input.nextInt();
      switch (answer) {
         
               case 1:
               System.out.println("Provide New First Name:\t");
               edit = input.next();
               PhoneBook.set(node, edit);
               break;
          
               case 2:
               System.out.println("Provide New Last Name:\t");
               edit = input.next();
               PhoneBook.set(node + 1, edit);
               break;
               
               case 3:
               System.out.println("Provide New Phone Number:\t");
               edit = input.next();
               PhoneBook.set(node + 2, edit);
               break;
            
               case 4:
               System.out.println("Provide New Address:\t");
               edit = input.next();
               PhoneBook.set(node + 3, edit);
               break;
            
               case 5:
               System.out.println("Provide New City:\t");
               edit = input.next();
               PhoneBook.set(node + 4, edit);
               break;
            
               default:
               break;
          } // end of switch case
          System.out.println("UPDATE COMPLETE:");
          System.out.println(PhoneBook.get(node) + " " + PhoneBook.get(node + 1) + ":");
          System.out.println(PhoneBook.get(node + 2) + ", " + PhoneBook.get(node + 3) + ", " + PhoneBook.get(node + 4));
          System.out.println();
          System.out.print("Would you like To Edit Any Additional Information for " + PhoneBook.get(node) + "? 1 = Yes 2 = No\t");
          answer = input.nextInt();
          if(answer == 1) { update(); }
          else { end(); }
    } // end update
    
    // prompt to end program or return to main menu
    public static void end() {
    Scanner input = new Scanner(System.in); // creates scanner method
    int answer = 0;
    System.out.print("\nWhat Would You Like To Do? 1 = Return To Main Menu 2 = End Program\t");
    answer = input.nextInt();
    if(answer == 1) { 
    menu = 0; // resets menu value for mainMenu method
    mainMenu(); }
    else {
    System.out.println("Program Shutting Down");
    System.exit(0);
    }
    }  // end of end
    
} // end of class
