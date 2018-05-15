package com.baekjoon.yeon.exam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Test0001 {

   public static void main(String[] args) {
      
      String[] input = null;
      Scanner scan = new Scanner(System.in);
      String str = scan.nextLine();
      input = str.split(" "); 
      
      goGame(input);
   }

   public static void goGame(String[] input) {
      ArrayList<String> items = new ArrayList<String>();
      ArrayList<String> results = new ArrayList<String>();
      int count = 0;
      
      for(int i=0; i<input.length; i++) {
         
         if( items.size() < 3 ) {
            items.add( input[i] );
         }
         else if( items.size() == 3 ) {
            for( int j=0; j<items.size(); j++ ) {
               if( items.get(j).equals(input[i]) ) {
                  items.remove(j);
                  items.add(input[i]);
               }
               else if( j==2 && !(items.get(j).equals(input[i])) ) {
                  results.add(items.get(0));
                  items.remove(0);
                  items.add(input[i]);
               }
            }
         }
      }
      
      Iterator iterator = results.iterator();
      
      if(!(iterator.hasNext())) {
    	  
         System.out.print(0);
      }
      while(iterator.hasNext()) {
         if(count != 0) {
            System.out.println("");
         }
         count++;
         System.out.print(iterator.next());
      }
   }

}
