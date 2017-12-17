/**
 * CatifyGame.java
 * */
import java.util.*;

public class CatifyGame{
  //variable
  private Board board;
  private int[][] found;
  private int click, attempts, pairsFound, numPics;
  private int x1, x2, y1, y2;
  private LinkedList<Picture> userClicks;
  
  //constructor
  public CatifyGame(int numPics){
    int size = (int)Math.sqrt(numPics*2);
    this.numPics = numPics; 
    board = new Board(numPics); 
    userClicks = new LinkedList<Picture>();
    found = new int[size][size];
  }
  
  public int getAttempts(){
   return attempts; 
  }
  
  public int getPairsFound(){
   return pairsFound; 
  }
  
  public void takeOneClick(int x, int y){
    Picture pic = board.getElement(x,y);
    //debug
    System.out.println("clicked picture id is " +pic.getID());
    userClicks.add(pic); 
    click ++;
    if(click==1){
      x1 = x; y1=y;  
    }
    else if (click ==2){
      x2=x; y2=y;
    }
  }
  
  public boolean findOnePair(){
    boolean isFound = false;
    if (click == 2){
      Picture pic1 = userClicks.removeFirst();
      Picture pic2 = userClicks.removeFirst();
      
      if (pic1.compareTo(pic2) == 0){
        found[x1][y1] = pic1.getID();
        found[x2][y2] = pic2.getID();
        pairsFound++;
        isFound = true;
      }
      else
        userClicks.clear();
      
      click = 0;
      attempts++;
    }
    return isFound;
  }
  
  public boolean isFinish(){
   return pairsFound == numPics; 
  }
  
  public String printBoard(){
   return board.toString(); 
  }
  
  public String toString(){
    String s = "Pictures found in positions:\n";
    int size = (int)Math.sqrt(numPics*2);
    for (int i = 0; i < size; i++) {
      for (int j=0; j < size; j++)
        s += found[i][j];
      s+="\n";
    }
    return s; 
    
  }
  
  
  //main method to test
  public static void main(String args[]){
    CatifyGame testGame= new CatifyGame(8);
    System.out.println(testGame.printBoard());
    Scanner scan = new Scanner(System.in);
    
    while (!testGame.isFinish()){
    System.out.println("Type x for the first picture: ");
    int X1 = scan.nextInt(); 
    System.out.println("Type y for the first picture: ");
    int Y1= scan.nextInt();
    
    testGame.takeOneClick(X1,Y1);
    
    System.out.println("Type x for the second picture: ");
    int X2 = scan.nextInt(); 
    System.out.println("Type x for the second picture: ");
    int Y2 = scan.nextInt();
    
    testGame.takeOneClick(X2,Y2);
    
    System.out.println("Picture1 and Picture2 are same? " + testGame.findOnePair());
    
    System.out.println("You took " + testGame.getAttempts() + " attempts.");
    System.out.println("You found " + testGame.getPairsFound() + " pairs.");
    System.out.println("\nBoard right now: \n" + testGame);
    }
    
    System.out.println("Congratulations! You found all pairs!");
    System.out.println("You took " + testGame.getAttempts() + " attempts.");
    System.out.println("You found " + testGame.getPairsFound() + " pairs.");
    
    
    
  }
  
}