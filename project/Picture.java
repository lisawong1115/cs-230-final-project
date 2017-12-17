/*
 * Picture.java
 * */

public class Picture implements Comparable<Picture>{
  // Instance variable 
  String picFileName;
  int picID; 
  
  public Picture (int picID, String picFileName){
    this.picFileName = picFileName; 
    this.picID = picID; 
  }
  
  public int getID(){
    return picID;
  }
  
  public String getFileName(){
    return picFileName;
  }
  
  //return -1, 0, 1 
  public int compareTo(Picture Pic2){
    if(this.getID()>Pic2.getID()){
      return 1; 
    }
    else if(this.getID()==Pic2.getID()){
      return 0;
    }
    else{
      return -1;
    }
  }
  
  //main method to test 
  public static void main (String args[]){
    Picture testpic = new Picture (0, "../cat_pics/pic3.jpg");
    System.out.println(testpic.getID());
    System.out.println(testpic.getFileName());
  }

}