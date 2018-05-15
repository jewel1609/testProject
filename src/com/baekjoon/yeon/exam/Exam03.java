package com.baekjoon.yeon.exam;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Exam03 {
   
   
   
   public static void main(String[] args) {
      int cashSize = 5;
      String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
      
      Exam03 exam3 = new Exam03();
      
      int answer = 0;
      
      answer = exam3.cashCount(cashSize,cities);
      
      System.out.println(answer);
   }

   public int cashCount(int cashSize, String[] cities) {
      int citiesCount = cities.length;
      int countHit = 0;
      int countFail = 0;
      int tempCount = 0;
      
//      String[][] strPage = new String{};
      ArrayList<Page> listPage = new ArrayList<Page>();
      
      for(int i = 0; i<citiesCount; i++) {
         Page page = new Page();
         page.city = cities[i].toUpperCase();
         page.num = i+1;
   
         listPage.add(page);
         Iterator iterator = listPage.iterator();
         while(iterator.hasNext()) {
            Page p = (Page)iterator.next();
            System.out.print(" "+p.city+" , ");
         }
         System.out.println(" size : "+listPage.size()+" : "+i);
         
         if(cashSize == 0) {
            countFail++;
         }
         else if(i >= cashSize) {
            for(int j=0; j<cashSize; j++) {
               String cityName = listPage.get(j).city;
               if(page.city.equals(cityName)) {
                  
                  
                  listPage.remove(j);
                  countHit++;
                  
                  
                  break;
               }
               tempCount++;
               if(j+1==cashSize) {
                  countFail++;
                  tempCount = 0;
                  listPage.remove(0);
               }
            }
         }
         else if(i < cashSize) {
            countFail++;
         }
      }
      
      return countHit*1 + countFail*5;
   }
}

class Page{
   public String city = "";
   public int num = 0;
}