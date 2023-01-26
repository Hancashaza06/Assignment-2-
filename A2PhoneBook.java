/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.a2phonebook;

import java.util.LinkedList;
import java.util.*; // imports util. library for random number generator

/**
 *
 * @author rukaD
 */
public class A2PhoneBook {

    public static void main(String[] args) {
        LinkedList PhoneBook = new LinkedList();
        Scanner input = new Scanner(System.in); // creates scanner method
        
        String firstName;
        String lastName;
        String phoneNumber;
        String address;
        String city;
        
        int menu;
        int start = 0;
       
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
        System.out.println("Please Choose An Option:");
        System.out.println("1. Find A Person In The Phone Book");
        System.out.println("2. Add A Person To the Phone Book");
        
        menu = input.nextInt();

        if(menu == 1) {
        //Searching By Name
        System.out.println("Provide A First Name:");
        firstName = input.next();
        System.out.println("Provide A Last Name:");
        lastName = input.next();
      
while(!PhoneBook.get(start).equals(firstName) && !PhoneBook.get(start + 1).equals(lastName)){
    start++;
    
}
      switch (start % 5) {
         
           case 0:
            
            break;
          
          case 1:
            start --;
            break;
         case 2:
            start = start - 2;
            break;
            
        case 3:
            start = start - 3;
            break;
            
        case 4:
            start = start - 4;
            break;
            
        
            
         default:
            System.out.println("Error: Name Not Found:");
            System.out.println("Provide A New First Name:");
            firstName = input.next();
            System.out.println("Provide A New Last Name:");
            lastName = input.next();
            break;
      }

        
        
        
        
         System.out.println(PhoneBook.get(start));
         System.out.println(PhoneBook.get(start + 1));
         System.out.println(PhoneBook.get(start + 2));
         System.out.println(PhoneBook.get(start + 3));
         System.out.println(PhoneBook.get(start + 4));
        System.out.print(PhoneBook);
        } // end of if
        
        else {System.out.println("More Features Coming Soon!"); }
        
    } // end of main
} // end of class
