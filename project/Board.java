/* 
 * Board.java
 * Represents a board object that creates a board for the game 
 * 
 * @author Huihan Li(hli3),Lisa Huang(rhuang2), Tina Zhang (yzhang16) 
 * @since 12/17/2017
 * 
 */

import java.util.*;

public class Board{
  
  // instance variables 
  private final ImageCollection pictureSource =new ImageCollection() ; //create the hashtable from ImageCollection 
  private Picture[][] gameBoard; //2-D array 
  private int numPics;
  private int size;
  
  /*Constructor that creates the game board that puts random pictures into random positions in the board
   * @param number of pictures needed for the game (easy-8, medium-18, hard-32)
   * @return board 
   */ 
  public Board(int numPics){
    //calcuate board's (2-D array) size 
    this.size=(int)Math.sqrt(numPics*2); 
    //create empty board 
    gameBoard=new Picture[size][size];
    //generate a list of numbers from 0-32 in random order  
    ArrayList<Integer> whichPicList = uniqueRandom(32);
    //generate a list of numbers in randm order 
    ArrayList<Integer> positionList = uniqueRandom(numPics*2); 
    //randomly select numPics of pictures from the pictureSource and put it in a random position in the board 
    for(int i=0; i<numPics; i++){
      //get a non-repeated random picture 
      int picID = whichPicList.get(i).intValue() + 1;
      Picture pic= pictureSource.getPic(picID);
      // generate two random number 
      int firstPos = positionList.get(2*i);
      int secondPos = positionList.get(2*i+1);
      //convert the two random numbers to two positions in the board 
      int x1,y1,x2,y2;
      x1 = firstPos/size;
      // debug: System.out.println("x1:"+ x1);
      y1 = firstPos%size; 
      // debug: System.out.println("y1:"+ y1);
      x2 = secondPos/size;
      // debug: System.out.println("x2:"+ x2);
      y2 = secondPos%size;
      // debug: System.out.println("y2:"+ y2);
      gameBoard[x1][y1] = pic;
      gameBoard[x2][y2] = pic;
    }
  }
  
  /* helper function to generate a list of number in random order 
   * @param number of pictures 
   * @return an arrayList 
   */
  private ArrayList<Integer> uniqueRandom(int numPics) {
    //use ArrayList in order to shuffle in next step 
    ArrayList<Integer> list = new ArrayList<Integer>();
    for (int i=0; i<numPics; i++) {
      list.add(new Integer(i));
    }
    //generate random order 
    Collections.shuffle(list);
    return list; 
  }
  
  /*get method to return the picture stored the position
   *@param x, y that indicates which position 
   *@return the picture 
   */
  public Picture getElement (int x, int y) {
    return gameBoard[x][y];
  }
  
  /*toString method that create a string of the board 
   *@return string representation of the board 
   */
  public String toString() {
    String s = ""; 
    for (int i = 0; i < size; i++) {
      for (int j=0; j < size; j++)
        s+=gameBoard[i][j].getID() + "  ";
      s+="\n";
    }
    return s; 
  }
  
  //main method to test 
  public static void main (String args[]){
    Board test = new Board (8);
    System.out.println("Easy game board (4*4 board, randomly assigned position)");
    System.out.println("-----------------------------------");
    System.out.println(test);
    System.out.println("\nMedium game board (6*6 board, randomly assigned position)");
    System.out.println("-----------------------------------");
    Board test2 = new Board (18);
    System.out.println(test2);
    System.out.println("\nHard game board (8*8 board, randomly assigned position)");
    System.out.println("-----------------------------------");
    Board test3 = new Board (32);
    System.out.println(test3);
    System.out.println("-----------------------------------");
    System.out.println("The element at (3,5) is "+test3.getElement(3,5).getID());
  }
}