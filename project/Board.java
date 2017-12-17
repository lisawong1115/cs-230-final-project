import java.util.*;

public class Board{
  // instance variables 
  private final ImageCollection pictureSource =new ImageCollection() ; 
  private Picture[][] gameBoard;
  private int numPics;
  private int size;
  
  public Board(int numPics){
    this.size=(int)Math.sqrt(numPics*2); 
    gameBoard=new Picture[size][size];
    ArrayList<Integer> whichPicList = UniqueRandom(32);
    ArrayList<Integer> positionList = UniqueRandom(numPics*2);
    //ArrayList<int[]> tupleList = UniqueRandomPos();
    //for loop 
    for(int i=0; i<numPics; i++){
      int picID = whichPicList.get(i).intValue();
      Picture pic= pictureSource.getPic(picID);
      int firstPos = positionList.get(2*i) - 1;
      int secondPos = positionList.get(2*i+1) - 1;
      
      int x1,y1,x2,y2;
      x1 = firstPos/size;
      //System.out.println("x1:"+ x1);
      y1 = firstPos%size; 
      // System.out.println("y1:"+ y1);
      x2 = secondPos/size;
      //System.out.println("x2:"+ x2);
      y2 = secondPos%size;
      // System.out.println("y2:"+ y2);
      
      gameBoard[x1][y1] = pic;
      gameBoard[x2][y2] = pic;
    }
  }
  
  private ArrayList<Integer> UniqueRandom(int numPics) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    for (int i=1; i<=numPics; i++) {
      list.add(new Integer(i));
    }
    Collections.shuffle(list);
    return list; 
  }
  
  
  public Picture getElement (int x, int y) {
    return gameBoard[x][y];
  }
  
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
    System.out.println(test);
    System.out.println("-----------------------------------");
    Board test2 = new Board (18);
    System.out.println(test2);
    System.out.println("-----------------------------------");
    Board test3 = new Board (32);
    System.out.println(test3);
    System.out.println("-----------------------------------");
    System.out.println(test3.getElement(3,5).getID());
  }
}