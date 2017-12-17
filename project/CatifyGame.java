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
  public CatifyGame(){
    numPics = 0;
    click = 0;
    attempts = 0;
    pairsFound = 0;
    x1 = x2 = y1 = y2 = -1;
    userClicks = new LinkedList<Picture>();
  }
  
  public void setGame(int numPictures){
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
  
  public int getNumPics(){
    return numPics;
  }
  
  public int getAttempts(){
   return attempts; 
  }
  
  public int getPairsFound(){
   return pairsFound; 
  }
  
  public int getClick(){
   return click; 
  }
  
  public LinkedList<Picture> getUserClicks() {
   return userClicks; 
  }
  
  public void takeOneClick(int x, int y) throws ArrayIndexOutOfBoundsException{
    //check if the user click on the picture that already found, do nothing 
    //check if the first picture & second are the same
    if (!(found[x][y]!=0 || (x1 == x && y1 == y))){
      //debug: System.out.println("I'm in line 55");
      Picture pic = board.getElement(x,y);
      userClicks.add(pic); 
      click ++;
      if(click==1){
        x1 = x; y1=y;  
      }
      else if (click ==2){
        x2=x; y2=y;
      }
    }

  }
  
  public boolean findOnePair(){
    boolean isFound = false;
    if (click == 2){
      //debug: System.out.println("I am line 78!");
      Picture pic1 = userClicks.getFirst();
      Picture pic2 = userClicks.getLast();
      
      if (pic1.compareTo(pic2) == 0){
        found[x1][y1] = pic1.getID();
        found[x2][y2] = pic2.getID();
        pairsFound++;
        isFound = true;
      }

      
      click = 0;
      attempts++;
      System.out.println(pic1.getID());
      System.out.println(pic2.getID());
    }
    return isFound;
  }
  
  //remove function
  public void clearChoices(){
   click = 0;
   x1 = x2 = y1 = y2 = -1;
   userClicks.clear();
  }
  
  public boolean isFinish(){
   return pairsFound == numPics; 
  }
  
  public String printBoard(){
   return board.toString(); 
  }
  
  public Board getBoard(){
   return board; 
  }
  
  public String toString(){
    String s = "Pictures found in positions:\n";
    int size = (int)Math.sqrt(numPics*2);
    for (int i = 0; i < size; i++) {
      for (int j=0; j < size; j++)
        s += found[i][j];
        s += "  ";
      s+="\n";
    }
    return s; 
    
  }
  
  public void play(int i){
    this.setGame(i);
    System.out.println(this.printBoard());
    int size = (int)Math.sqrt(numPics*2);
    
    Scanner scan = new Scanner(System.in);
    int X1,Y1,X2,Y2;
    
    while (!this.isFinish()){
      do{
    System.out.println("Type x for the first picture: ");
    X1 = scan.nextInt(); 
    System.out.println("Type y for the first picture: ");
    Y1= scan.nextInt();
      }while(X1 > size-1 || Y1 > size-1 || found[X1][Y1] != 0);
      
    this.takeOneClick(X1,Y1);
    
    do{
    System.out.println("Type x for the second picture: ");
    X2 = scan.nextInt(); 
    System.out.println("Type y for the second picture: ");
    Y2 = scan.nextInt();
    }while (X2 > size-1 || Y2 > size-1 || found[X2][Y2] != 0 || (X1 == X2 && Y1 == Y2));
    
    this.takeOneClick(X2,Y2);
      
    System.out.println("x1: "+x1+ "y1: "+y1+"x2: "+x2+"y2 "+y2);
    System.out.println("Picture1 and Picture2 are same? " + this.findOnePair());
    this.clearChoices();
    System.out.println("You took " + this.getAttempts() + " attempts.");
    System.out.println("You found " + this.getPairsFound() + " pairs.");
    System.out.println("\nBoard right now: \n" + this);

    }
    
    System.out.println("Congratulations! You found all pairs!");
    System.out.println("You took " + this.getAttempts() + " attempts.");
    System.out.println("You found " + this.getPairsFound() + " pairs.");
    
    
  }
  
  //main method to test
  public static void main(String args[]){
    CatifyGame testGame= new CatifyGame();
    testGame.play(8);
    
    
  }
  
}