/* 
 * Picture.java
 * Represents a picture object that contains a picture ID and a picture URL 
 * 
 * @author Huihan Li(hli3),Lisa Huang(rhuang2), Tina Zhang (yzhang16) 
 * @since 12/17/2017
 * 
 */

public class Picture implements Comparable<Picture>{
  
  // Instance variables
  String picFileName;
  int picID; 
  
  /* Constructor,create a picture object 
   * @param an integer that represents the picture's ID 
   * @param picture's URL 
   */
  public Picture (int picID, String picFileName){
    this.picFileName = picFileName; 
    this.picID = picID; 
  }
  
  /* get method that return picture's ID
   * @return picture's ID
   */
  public int getID(){
    return picID;
  }
  
  /* get method that return picture's URL
   * @return picture's URL 
   */
  public String getFileName(){
    return picFileName;
  }
  
  /* Implements comparable intereface, compare two picture's ID 
   * @override 
   * @param comparable picture 
   * @return 1 if pic1 ID > pic2 ID; 
   *         0 if pic1 ID = pic2 ID; 
   *        -1 if pic1 ID < pic2 ID; 
   */ 
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
    Picture testpic = new Picture (3, "../cat_pics/pic3.jpg");
    System.out.println("Pic N0.3's ID is " + testpic.getID());
    System.out.println("Pic N0.3's URL is " + testpic.getFileName());
  }

}