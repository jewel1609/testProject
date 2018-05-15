package ebay.yeon.quest;
import java.util.Scanner;

public class Main {
   public static void main(String arge[])
   {   
      Scanner scanner = new Scanner(System.in);
      int month = scanner.nextInt();
      int day = scanner.nextInt();
      int temp = 0;
      
      String today[] = {"SUN", "MON", "TUE", "WED", "THU","FRI","SAT"};
         
      for(int i = 1 ; i < month ; i++)
      {
         if(i==2)
         {
            temp = temp+28;
         }else if(i%2 == 1)
         {
            temp = temp + 31;
         }else {
            temp = temp + 30;
         }
      }
      temp = temp + day;
      
      System.out.println(today[temp%7]);
   }
}