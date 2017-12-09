/*timer class testimg */ 
import java.util.*; 
public class timercountdown{
    static Thread thread = new Thread(); 
    public static void main (String[] args)throws InterruptedException{
      for (int i=5; i>=0; i--){
        thread.sleep(1000);
        System.out.println(i);
      }
      
    }
  }