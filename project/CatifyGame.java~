/* 
 * CatifyGame.java
 * Back-end version of Catify game can be played in this class
 * Bugs in the GUI version have been fixed in this version 
 * 
 * @author Huihan Li(hli3),Lisa Huang(rhuang2), Tina Zhang (yzhang16) 
 * @since 12/17/2017
 * 
 */
import java.util.*;

public class CatifyGame{
  
  //Instance variables
  private Board board;
  private int[][] found; //a 2-D array to check if the picture has been found 
  private int click, attempts, pairsFound, numPics;
  private int x1, x2, y1, y2;
  private LinkedList<Picture> userClicks; //a LinkdList to store the pictures that users have clicked in one round 
  
  /* Constructor: create & initialize instance variables */ 
  public CatifyGame(){
    //Instance variables 
    numPics = 0;
    click = 0; 
    attempts = 0;
    pairsFound = 0;
    x1 = x2 = y1 = y2 = -1;
    userClicks = new LinkedList<Picture>();
  }
  
  /* Set the game by creating the board and other instance variables 
   * @param number of pictures 
   */ 
  public void setGame(int numPictures){
    //create instance variables again (for restart function) 
    numPics = numPictures;
    click = 0;
    attempts = 0;
    pairsFound = 0;
    x1 = x2 = y1 = y2 = -1;
    userClicks = new LinkedList<Picture>();
    int size = (int)Math.sqrt(numPics*2);
    board = new Board(numPics); 
    found = new int[size][size];
  }
  
  /*getter method to return number of pictures 
   * @return numPics 
   */ 
  public int getNumPics(){
    return numPics;
  }
  
  /*getter method to return attempts 
   * @return attempts 
   */
  public int getAttempts(){
    return attempts; 
  }
  
  /*getter method to return how many pairs the user has found 
   *@return pairFound 
   */ 
  public int getPairsFound(){
    return pairsFound; 
  }
  
  /*getter method to reuturn how many clicks the user has used 
   *@reutrn click 
   */
  public int getClick(){
    return click; 
  }
  
  /*getter method to return the LinkedList that store the user clicked pictures
   *@ reutrn userClicks 
   */
  public LinkedList<Picture> getUserClicks() {
    return userClicks; 
  }
  
  /*takeOneClick method that store the selected picture in the queue 
   *it throws ArrayIndexOutOfBoundsException if the user's input is bigger than size  
   *@param x & y that indicates the picture that user selected 
   */ 
  public void takeOneClick(int x, int y) throws ArrayIndexOutOfBoundsException{
    //Do nothing if the user click on the picture that already found or if the first picture & second are the same
    if (!(found[x][y]!=0 || (x1 == x && y1 == y))){
      Picture pic = board.getElement(x,y);
      //add the selected picture into the LinkedList 
      userClicks.add(pic); 
      click ++;
      //store the position of the selected picture 
      if(click==1){
        x1 = x; y1=y;  
      }
      else if (click ==2){
        x2=x; y2=y;
      }
    }
    
  }
  
  /*findOnePair check if the two pictures in the LinkedList are the same 
   *@return T/F if the two pictures are the same  
   */
  public boolean findOnePair(){
    boolean isFound = false;
    if (click == 2){
      Picture pic1 = userClicks.getFirst();
      Picture pic2 = userClicks.getLast();
      //if pic1 and pic2 are the same, change the the number in found[][] from 0 to the pictures' ID number & update 
      //the instance variables 
      if (pic1.compareTo(pic2) == 0){
        found[x1][y1] = pic1.getID();
        found[x2][y2] = pic2.getID();
        pairsFound++;
        isFound = true;
      }
      //if two pictures are not the same, reset click & update attempts 
      click = 0;
      attempts++;
      //debug 
      //System.out.println(pic1.getID());
      //System.out.println(pic2.getID());
    }
    return isFound;
  }
  
  /*clearChoices reset clear the LinkedList in order to prepare for next round*/
  public void clearChoices(){
    click = 0;
    x1 = x2 = y1 = y2 = -1;
    userClicks.clear();
  }
  
  /*isFinish checks if the game is finished 
   *@return T/F if the game is finished  
   */
  public boolean isFinish(){
    return pairsFound == numPics; 
  }
  
  /*printBoard prints the gameboard (all pictures' locations)
   *@return string 
   */   
  public String printBoard(){
    return board.toString(); 
  }
  
  /*getter method that return the board 
   *@return board 
   */ 
  public Board getBoard(){
    return board; 
  }
  
  /*toString method represents the string for the found[][] board. if not found, the position appears 0, if found the 
   *position appears as the picture ID
   *@return string 
   */ 
  public String toString(){
    String s = "Pictures found in positions:\n";
    int size = (int)Math.sqrt(numPics*2);
    for (int i = 0; i < size; i++) {
      for (int j=0; j < size; j++)
        s += found[i][j]+" ";
      s+="\n";
    }
    return s; 
    
  }
  
  /*play method can be invoked to play the game 
   *@param number of pictures  
   */ 
  public void play(int i){
    //create a game 
    this.setGame(i);
    //show the board for testing purpose 
    System.out.println(this.printBoard());
    int size = (int)Math.sqrt(numPics*2);
    
    Scanner scan = new Scanner(System.in);
    int X1,Y1,X2,Y2;
    
    while (!this.isFinish()){
      do{
        //user type in the x,y coordinators for the first picture she selects 
        System.out.println("Type x for the first picture: ");
        X1 = scan.nextInt(); 
        System.out.println("Type y for the first picture: ");
        Y1= scan.nextInt();
      }while(X1 > size-1 || Y1 > size-1 || found[X1][Y1] != 0); //if the user type in a number that bigger than the size 
      //or if the user click on a picture that has already been found, then the game will keep asking the user for 
      //correct inputs 
      
      //if user's input is valid, take one click 
      this.takeOneClick(X1,Y1);
      
      do{
        System.out.println("Type x for the second picture: ");
        X2 = scan.nextInt(); 
        System.out.println("Type y for the second picture: ");
        Y2 = scan.nextInt();
      }while (X2 > size-1 || Y2 > size-1 || found[X2][Y2] != 0 || (X1 == X2 && Y1 == Y2)); //same as the previous step 
      // if the user click on the same picture as last time, it counts as invalid and the system will keep asking for 
      // her input 
      
      this.takeOneClick(X2,Y2);
      
      //debug: System.out.println("x1: "+x1+ "y1: "+y1+"x2: "+x2+"y2 "+y2);
      System.out.println("Picture1 and Picture2 are same? " + this.findOnePair());
      this.clearChoices();
      System.out.println("You took " + this.getAttempts() + " attempts.");
      System.out.println("You found " + this.getPairsFound() + " pairs.");
      System.out.println("\nBoard right now: \n" + this);
      
    }
    
    System.out.println("Congratulations! You found all pairs!");
    System.out.println("You took " + this.getAttempts() + " attempts.");
    System.out.println("You found " + this.getPairsFound() + " pairs.");
    scan.close();
    
  }
  
  //main method to play the game 
  public static void main(String args[]){
    CatifyGame testGame= new CatifyGame();
    testGame.play(8);
    
    
  }
  
}