import java.util.*;

public class Board{
  // instance variables 
  ImageCollection pictureSource; 
  Picture[][] gameBoard;
  int numPics;
  int size; 
  Random randy; 
  
  public Board(int numPics){
    this.size=(int)Math.sqrt(numPics*2); 
    pictureSource= new ImageCollection();
    randy=new Random();
    gameBoard=new Picture[size][size];
    ArrayList<Integer> numberList = UniqueRandom(numPics);
    ArrayList<int[]> tupleList = UniqueRandomPos();
    //for loop 
    for(int i=0; i<numPics; i++){
      Picture pic= pictureSource.getPic(numberList.get(i).intValue());
      /*int num = randy.nextInt(32);// 0-35
      num = num+1; 
      Picture pic= pictureSource.getPic(num);*/
      gameBoard[tupleList.get(i)[0]][tupleList.get(i)[1]]=pic;
      gameBoard[tupleList.get(i+numPics)[0]][tupleList.get(i+numPics)[1]]=pic;
    }
  }
  
  // helper method to produce unique random number
  private ArrayList<int[]> UniqueRandomPos() {
    ArrayList<int[]> tupleList = new ArrayList<int[]>();
    for (int i=0; i<size; i++) {
      for(int j=0;j<size; j++){
        int[] tupleArray =new int[2];
        tupleArray[0] = i; tupleArray[1]=j;
        tupleList.add(tupleArray);
      }
    }
    Collections.shuffle(tupleList);
    return tupleList; 
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
  
  protected void printBoard() {
    for (int i = 0; i < size; i++) {
      for (int j=0; j < size; j++)
        System.out.print(gameBoard[i][j].getID() + "  ");
      System.out.print("\n");
    }
    System.out.println();
  }
  
  //main method to test 
  public static void main (String args[]){
    Board test = new Board (8);
    test.printBoard();
    System.out.println("-----------------------------------");
    Board test2 = new Board (18);
    test2.printBoard();
    System.out.println("-----------------------------------");
    Board test3 = new Board (32);
    test3.printBoard();
    System.out.println("-----------------------------------");
    System.out.println(test3.getElement(3,5).getID());
  }
}