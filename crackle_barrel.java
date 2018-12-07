import java.util.Arrays;
import java.util.Scanner;


class crackle_barrel {

   public static boolean isNumeric(String str)
   {
     return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
   }



   public static boolean valid_move(int[] move_array ){
      int [][] legal_moves = new int[][] {
         {0, 1, 3},
         {0, 2, 5},
         {1, 3, 6},
         {1, 4, 8},
         {2, 4, 7},
         {2, 5, 9},
         {3, 6, 10},
         {3, 7, 12},
         {4, 7, 11},
         {4, 8, 13},
         {5, 8, 12},
         {5, 9, 14},
         {3, 4, 5},
         {6, 7, 8},
         {7, 8, 9},
         {10, 11, 12},
         {11, 12, 13},
         {12, 13, 14},
      };
      for(int i = 0; i < legal_moves.length; i++){
         if (Arrays.equals(legal_moves[i], move_array)){
            return true;
         }
      }
      return false;
   }

   public static int[] find_index(int move){
      int[] temp;
         if(move == 0){
            temp = new int[] {0, 0};
         }else if( move == 1){
            temp = new int[] {1, 0};
         }else if( move == 2){
            temp = new int[] {1, 1};
         }else if( move == 3){
            temp = new int[] {2, 0};
         }else if( move == 4){
            temp = new int[] {2, 1};
         }else if( move == 5){
            temp = new int[] {2, 2};
         }else if( move == 6){
            temp = new int[] {3, 0};
         }else if( move == 7){
            temp = new int[] {3, 1};
         }else if( move == 8){
            temp = new int[] {3, 2};
         }else if( move == 9){
            temp = new int[] {3, 3};
         }else if( move == 10){
            temp = new int[] {4, 0};
         }else if( move == 11){
            temp = new int[] {4, 1};
         }else if( move == 12){
            temp = new int[] {4, 2};
         }else if( move == 13){
            temp = new int[] {4, 3};
         }else if( move == 14){
            temp = new int[] {4, 4};
         } else{
            temp = null;
         }
         return temp;
   }

   public static int[][] make_move(int [][] board, int[] move){
      int [][] new_board = new int[board.length][];
      for(int i = 0; i < board.length; i++){
         new_board[i] = board[i].clone();
      }
      int[] first_move = find_index(move[0]);
      int[] second_move = find_index(move[1]);
      int[] third_move = find_index(move[2]);
      if(board[first_move[0]][first_move[1]] == 0 
      && board[second_move[0]][second_move[1]] == 1 
      && board[third_move[0]][third_move[1]] == 1){
         new_board[first_move[0]][first_move[1]] = 1;
         new_board[second_move[0]][second_move[1]] = 0;
         new_board[third_move[0]][third_move[1]] = 0;

      }
      else {
         System.out.println("ERROR: invalid move");
      }
      return new_board;
   }
   

   
   public static void printboard(int [][] board){


      System.out.println("Board printing... \n");

      System.out.println("        " + board[0][0]);
      System.out.println("      " + board[1][0] + "  " +board[1][1]);
      System.out.println("    " + board[2][0] + "  " +board[2][1] + "  " + board[2][2]);
      System.out.println("  " + board[3][0] + "  " +board[3][1] + "  " + board[3][2] + "  " +board[3][3]);
      System.out.println(board[4][0] + "  " + board[4][1] + "  " + board[4][2] + "  " +board[4][3] + "  " + board[4][4] + "\n");
  
      
   }
   public static void main(String args[]){
      int[][] board = new int[][]{
         {0, 0, 0, 0, 0},
         {1, 1, 0, 0, 0},
         {1, 1, 1, 0, 0},
         {1, 1, 1, 1, 0},
         {1, 1, 1, 1, 1}
      };

      printboard(board);
       
      Scanner scan = new Scanner(System.in);

      while(true){
         String temp;
         Integer temp2;
         int move[] = new int[3];
         for(int i = 0; i < 3; i++){
            if( i == 0)
            {
               System.out.print("Enter the first move number: ");
               temp = scan.nextLine();
               if(isNumeric(temp))
               {
                  //populate move number 1
                  temp2 = Integer.parseInt(temp);
                  move[0] = temp2;
               }
               else {
                  //otherwise populate the move array
                  //System.out.print(temp);
                  System.out.println("ERROR: Invalid input");
                  printboard(board);
                  i = -1;
                  continue;
               }
            }
            else if(i == 1)
            {
               System.out.print("Enter the second move number: ");
               temp = scan.nextLine();
               if(isNumeric(temp)){
                  //populate move number 1
                  temp2 = Integer.parseInt(temp);
                  move[1] = temp2;
               }else {
                 
                  System.out.println("ERROR: Invalid input");
                  printboard(board);
                  i = -1;
                  continue;
               }   
            }
            else {
               System.out.print("Enter the third move number: ");
               
               temp = scan.nextLine();
               if(isNumeric(temp)){
                  //populate move number 1
                  temp2 = Integer.parseInt(temp);
                  move[2] = temp2;
               }
               else {
                  //otherwise populate the move array
                  //System.out.print(temp);
                  System.out.print("ERROR: Invalid input");
                  printboard(board);
                  i = -1;
                  continue;
               }
            }
            
         }

         boolean is_good_move = valid_move(move);

         if(is_good_move){
            System.out.println("//////////Move Successful!");
            board = make_move(board, move);

         } else {
            System.out.println("////////Move failed, not a valid move");
         }
         printboard(board);
      }
      
           
          
   }
}
  