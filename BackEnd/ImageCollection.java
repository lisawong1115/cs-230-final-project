import java.util.*;

public class ImageCollection{
  //instance variable 
  Hashtable<Integer, Picture> images;
  
 
  public ImageCollection(){
     images = new Hashtable<Integer, Picture>(40);
     for(int i=1;i<=32;i++){
       Picture pic = new Picture (i,"../cat_pics/pic"+i+".jpg");
       images.put(i, pic);
     }
  }
  
  public Picture getPic(int picID){
    return images.get(picID);
  }
  
  //main method to test 
  public static void main(String args[]){
    ImageCollection test = new ImageCollection();
    for(int i=1;i<=32;i++){
      Picture pic = test.getPic(i);
      System.out.println(i+":"+pic.getFileName());
     }
  }
}