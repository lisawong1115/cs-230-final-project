/* 
 * ImageCollection.java
 * Create a hashtable for all the images 
 * 
 * @author Huihan Li(hli3),Lisa Huang(rhuang2), Tina Zhang (yzhang16) 
 * @since 12/17/2017
 * 
 */
import java.util.*;

public class ImageCollection{
  
  //instance variable 
  Hashtable<Integer, Picture> images;
  
  /*Constructor contructs a hashtable*/ 
  public ImageCollection(){
     //create a hash table that has integer as key and picture object as element 
     images = new Hashtable<Integer, Picture>(43);
     //put the pictures into the hashtable, the key is equal to the picture ID 
     for(int i=1;i<=32;i++){
       Picture pic = new Picture (i,"../cat_pics/pic"+i+".jpg");
       images.put(i, pic);
     }
  }
  
  /* get method that return a picture according to its picture ID 
   * @param picture ID
   * @return picture 
   */
  public Picture getPic(int picID){
    return images.get(picID);
  }
  
  //main method to test 
  public static void main(String args[]){
    ImageCollection test = new ImageCollection();
    System.out.println ("Printing out the hashtable in the format of *Picture ID: URL*");
    for(int i=1;i<=32;i++){
      Picture pic = test.getPic(i);
      System.out.println(i+":"+pic.getFileName());
     }
  }
}