package Snakegame;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;



public class Snake{
  Queue<Node> queue= new LinkedList<Node>();
  private char [][] board = null;

  public Snake(int row, int col){
    this.board= new char[row][col];
    queue.add(new Node(0,0));
    this.board[1][0]='X';
    this.board[2][2]='X';
    this.board[2][4]='X';
    this.board[5][4]='X';
  }
  public void  snakemove(int row, int col){
    if(row>=0 && row<board.length && col>=0 && col<board.length){
      if(board[row][col]=='.'){
        System.out.println("GAME OVER");
        System.exit(0);
      }
      queue.add(new Node(row,col));
      if(board[row][col]!='X'){
        Node node =queue.poll();
        int r=node.getRow();
        int c=node.getCol();
        board[r][c]='\0';
      }
      board[row][col]='.';
      while(!queue.isEmpty()){
        printboard();
        System.out.println("Enter the direction: ");
        Scanner s= new Scanner(System.in);
        char Directions =s.next().charAt(0);
        switch(Directions){
          case 'U':
            snakemove(--row,col);
            break;
          case 'D':
            snakemove(++row,col);
            break;
          case 'L':
            snakemove(row,--col);
            break;
          case 'R':
            snakemove(row,++col);
            break;
          default:
            System.out.println("Invalid Input");
        } 
      }

    }
    else{
      System.out.println("Invalid move");
    }
  }
  public void printboard(){
    for(int i=0;i<board.length;i++){
      for(int j=0;j<board[0].length;j++){
        System.out.print(board[i][j]+" ");
      }
      System.out.println();
    }
   }
}