import java.util.*;
  
class LinkedList {
  
   private Node head; // unique first value of list, starts as empty
    
   static LinkedList phoneBook = new LinkedList(); // empty list
  
   public static void main(String[] args) {
   
        // SAMPLE VALUES
      phoneBook = createNode(phoneBook, "Jake", "Holmes", "111-111-1111", "123 Fake St", "Birch Bay");
      phoneBook = createNode(phoneBook, "Ben", "Diskin", "222-222-2222", "123 Fake St", "Bellingham");
      phoneBook = createNode(phoneBook, "Jaspreet", "Khatkar", "333-333-3333", "123 Fake St", "Lynden");
      phoneBook = createNode(phoneBook, "David", "R-H", "222-222-2222", "123 Fake St", "Bellingham");
        
   
        // add menu
      mainMenu();
           
   } // end of main
    
    // Method to print the LinkedList.
   public static void viewDirectory(LinkedList phoneBook)
   {
      Node currentNode = phoneBook.head; // starts by looking at head value
      System.out.println("\nPHONE DIRECTORY:");
        // Traverse through the LinkedList
      while (currentNode != null) {
         System.out.println(currentNode.firstName + " " + currentNode.lastName + ":");
         System.out.println(currentNode.phone + ", " + currentNode.address + ", " + currentNode.city + ".");
         currentNode = currentNode.next; // go to the next node
      } // end of while
      loop();
   } // end viewDirectory
    
    // Method to create a new node
   public static LinkedList createNode(LinkedList phoneBook, String firstName, String lastName, String phone, String address, String city)
   {
      Node node = new Node(firstName, lastName, phone, address, city); // create a new node object from the data parameter
   
      if (phoneBook.head == null) { phoneBook.head = node; } // If linked list is empty, make new node head
      else {
            // Else traverse till the end and add the new node
         Node tail = phoneBook.head; // start of the linkedList
         while (tail.next != null) { // only last node will have next = null;
            tail = tail.next; // moves to the next node
         } // end while
         tail.next = node; // changes next value of last node to data value of new node
      }
      return phoneBook; // ends method
   } // end of createNode method
    
// program main menu
   public static void mainMenu() {
      int menu = 0;
      Scanner input = new Scanner(System.in); // creates scanner method
      while (menu < 1 || menu > 5) {
         try {
            System.out.println("Please Choose An Option:");
            System.out.println("1. View Phone Directory");
            System.out.println("2. Edit Phone Book Entry");
            System.out.println("3. Delete Phone Book Entry");
            System.out.println("4. Add An Entry To The Phone Book");
            System.out.println("5. End The Program");
            menu = input.nextInt();
         } catch (InputMismatchException e) {
            String error = input.nextLine();
         }
         if (menu < 1 || menu > 5) {
            System.out.println("Error: Not A Valid Response");
         }
      } // end of while
   
      if (menu == 1) { // View Entire Directory
         viewDirectory(phoneBook);
      } // end view if
      else if (menu == 2) { // Edit
         editEntry(phoneBook);
      } // end name search if
      else if (menu == 3) { // Delete
         deleteEntry(phoneBook);
      }
      else if (menu == 4) { // add entry
         addEntry(phoneBook);
      }
      else { // end program
         System.out.println("Program Shutting Down...");
         System.exit(0);
      } // end of else
   } // end of main menu
   
   public static void addEntry(LinkedList phoneBook) {
      Scanner input = new Scanner(System.in); // creates scanner method
      int answer;
      System.out.println("Where In The Phone Book Would You Like To Add The New Entry? 1 = Beginning 2 = Middle 3 = End");
      answer = input.nextInt();
   
      if(answer == 1) { addEntryBeginning(phoneBook); }
      else if(answer == 2) { addEntryMiddle(phoneBook); }
      else { addEntryEnd(phoneBook); }
      loop();
   }
   
   // method to add an entry after a user
   public static void addEntryMiddle(LinkedList phoneBook) {
      Scanner input = new Scanner(System.in); // creates scanner method
      String firstName; // data value of node
      String lastName; // data value of node
      String phone; // data value of node
      String address; // data value of node
      String city; // data value of node

      System.out.println("Please Provide The Preceding Entry.");
      Node entry = findEntry(phoneBook);

      System.out.println("NEW ENTRY:");

      System.out.print("Provide First Name:\t");
      firstName = input.next();
   
      System.out.print("Provide Last Name:\t");
      lastName = input.next();
        
      System.out.print("Provide Phone Number:\t");
      phone = input.next();
        
      System.out.print("Provide Address:\t");
      address = input.nextLine(); // clears input
      address = input.nextLine();
        
      System.out.print("Provide City:\t");
      city = input.nextLine();

      Node newEntry = new Node(firstName, lastName, phone, address, city); // new entry added

      newEntry.next = entry.next; // connects newEntry to node after entry
      entry.next = newEntry; // connects entry to newEntry
   }
   
   // method to add another entry to the beginning of the phone book
   public static void addEntryBeginning(LinkedList phoneBook) {
   
      Scanner input = new Scanner(System.in); // creates scanner method
      String firstName; // data value of node
      String lastName; // data value of node
      String phone; // data value of node
      String address; // data value of node
      String city; // data value of node
   
   
      Node oldHead = new Node(phoneBook.head.firstName, phoneBook.head.lastName, phoneBook.head.phone, phoneBook.head.address, phoneBook.head.city);
      oldHead.next = phoneBook.head.next; // copies values from linklist head
   
      System.out.print("Provide First Name:\t");
      firstName = input.next();
   
      System.out.print("Provide Last Name:\t");
      lastName = input.next();
        
      System.out.print("Provide Phone Number:\t");
      phone = input.next();
        
      System.out.print("Provide Address:\t");
      address = input.nextLine(); // clears input
      address = input.nextLine();
        
      System.out.print("Provide City:\t");
      city = input.nextLine();
   
   // replaces current head values with new values
      phoneBook.head.firstName = firstName; 
      phoneBook.head.lastName = lastName;
      phoneBook.head.phone = phone;
      phoneBook.head.address = address;
      phoneBook.head.city = city;
      phoneBook.head.next = oldHead;
   
      System.out.println("ENTRY SUCCESSFULLY ADDED:");
      System.out.println(phoneBook.head.firstName + " " + phoneBook.head.lastName + ":");
      System.out.println(phoneBook.head.phone + ", " + phoneBook.head.address + ", " + phoneBook.head.city);
      System.out.println();
   }// end of addEntryBeginning
   
   // method to add another entry to the end of the phone book
   public static void addEntryEnd(LinkedList phoneBook) {
      String firstName; // data value of node
      String lastName; // data value of node
      String phone; // data value of node
      String address; // data value of node
      String city; // data value of node
      Scanner input = new Scanner(System.in); // creates scanner method
   
   
      System.out.print("Provide First Name:\t");
      firstName = input.next();
   
      System.out.print("Provide Last Name:\t");
      lastName = input.next();
        
      System.out.print("Provide Phone Number:\t");
      phone = input.next();
        
      System.out.print("Provide Address:\t");
      address = input.nextLine(); // clears input
      address = input.nextLine();
        
      System.out.print("Provide City:\t");
      city = input.nextLine();
        
      createNode(phoneBook, firstName, lastName, phone, address, city); // creates the new node at the end
                
      System.out.println("ENTRY SUCCESSFULLY ADDED:");
      System.out.println(firstName + " " + lastName + ":");
      System.out.println(phone + ", " + address + ", " + city);
      System.out.println();
   } // end add entry
   
   // method to edit entry
   public static void editEntry(LinkedList phoneBook) {
      System.out.println("Please Provide The Entry You Would Like To Edit.");
      Node entry = findEntry(phoneBook);
      
      
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
            entry.firstName = edit; 
         
            break;
      
         case 2:
            System.out.println("Provide New Last Name:\t");
            edit = input.next();
            entry.lastName = edit;
            break;
      
         case 3:
            System.out.println("Provide New Phone Number:\t");
            edit = input.next();
            entry.phone = edit;
            break;
      
         case 4:
            System.out.println("Provide New Address:\t");
            edit = input.next();
            entry.address = edit;
            break;
      
         case 5:
            System.out.println("Provide New City:\t");
            edit = input.next();
            entry.city = edit;
            break;
      
         default:
            break;
      
      }//end of the switch
      loop();
   } // end edit
   
    // method to delete entry
   public static void deleteEntry(LinkedList phoneBook) {
      System.out.println("Please Provide The Entry You Would Like To Delete.");
      Node entry = findEntry(phoneBook);
      
      //if entry is head node cody next node info and unlink to next node
      if (entry.firstName.equals(phoneBook.head.firstName)&& entry.lastName.equals(phoneBook.head.lastName)){
         entry.firstName = entry.next.firstName; 
         entry.lastName = entry.next.lastName;
         entry.phone = entry.next.phone;
         entry.address = entry.next.address;
         entry.city = entry.next.city;
         entry.next = entry.next.next;
      }
      // if entry is not the head 
      else{  
         Node beforeEntry = phoneBook.head; // start of the linkedList
         while (beforeEntry.next != entry) { // only last node will have next = null;
            beforeEntry = beforeEntry.next; // moves to the next node
         } // end while

        if(beforeEntry.next.next != null) { // if theres a node after node we want to delete, connect to it
         beforeEntry.next = beforeEntry.next.next;
        }
        else { // cut connection
        beforeEntry.next = null;
        }
        entry.next = null; // cuts entry's connection to next node
      }
      
      loop();
   } // end edit
   
   // method to search entries by first and last name
   public static Node findEntry(LinkedList phoneBook) {
      Scanner input = new Scanner(System.in); // creates scanner method
      String firstName; // data value of node
      String lastName; // data value of node
      int answer = 0;
   
      System.out.print("First Name:\t");
      firstName = input.next();
   
      System.out.print("Last Name:\t");
      lastName = input.next();
   
      Node entry = phoneBook.head; // start of the linkedList
      while (entry.next != null && !entry.firstName.equals(firstName) && !entry.lastName.equals(lastName)) { // only last node will have next = null;
         entry = entry.next; // moves to the next node
      } // end while
      if(!entry.firstName.equals(firstName)) { 
         System.out.println("Entry Could Not Be Found");
         loop();
      }
      return entry;
   } // end of search method
   
   public static void loop() {
      Scanner input = new Scanner(System.in); // creates scanner method
      int answer = 0;
      System.out.print("\nWhat Would You Like To Do? 1 = Return To Main Menu 2 = End Program\t");
      answer = input.nextInt();
      if (answer == 1) {
         mainMenu();
      } else {
         System.out.println("Program Shutting Down");
         System.exit(0);
      }  // end of loop
   }  // end of end
} // end of phonebook class

class Node {
  
   protected String firstName; // data value of node
   protected String lastName; // data value of node
   protected String phone; // data value of node
   protected String address; // data value of node
   protected String city; // data value of node
   protected Node next; // pointer that connects nodes together because there is no index. its value will be the following node
  
   // Constructor
   Node(String firstName, String lastName, String phone, String address, String city)
   {
      this.firstName = firstName;
      this.lastName = lastName;
      this.phone = phone;
      this.address = address;
      this.city = city;
      next = null; // value will be set by next node
   }
} // end of class node
