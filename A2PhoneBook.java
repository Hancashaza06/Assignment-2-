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
       
        
        
        
        
        PhoneBook.add("David");
        PhoneBook.add("Rukashaza-Hancock");
        PhoneBook.add("5555555555");
        PhoneBook.add("783 my home");
        PhoneBook.add("Bellingham");
        
        PhoneBook.add("Jake");
        PhoneBook.add("Holems");
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
        
        int start = 0;

        
        //System.out.println("What do you want, 1: fn 2: ln 3: pn 4: ad 5: city?");
        System.out.println("who do you want");
      String play = input.next();
      
while(!PhoneBook.get(start).equals(play)){
    start++;
    
}
      switch (start % 5) {
         
           case 0:// fallthrough
            
            break;
          
          case 1:// fallthrough
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
            System.out.println("try again");           
            play = input.next();
            break;
      }

        
        
        
        
         System.out.println(PhoneBook.get(start));
         System.out.println(PhoneBook.get(start + 1));
         System.out.println(PhoneBook.get(start + 2));
         System.out.println(PhoneBook.get(start + 3));
         System.out.println(PhoneBook.get(start + 4));
        System.out.print(PhoneBook);
        
        
    }
}
