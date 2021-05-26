/**Application Purposes: Make a game "Aeroplane Chess (Pachisi)". There will be two players. The users are asked to input the player names first.
 * Then toss a 6-sided dice separately, and the user chess will move on the 13*13 chess game board subsequently. The two players each will try to get their own plane piece from the starting point (left-upper corner),
 * and across the circle of the chess to reach back to the origin point again. Note that when a player lands on an opponent's piece, the opponent returns that piece to the starting point. ]
 * There will be information such as steps board and total numbers of steps taken in each round, and congratulations message to the player who win the game!
 * Author: Jiaqi Chen
 * Date: 2021-04-12
 * Time: 12:13PM
 * */

import java.util.Random;
import java.util.Scanner;
/*Instantiate a public class first*/
public class FlyGamePlay {
    //Build the chessboard. Size: 13*13 Instance Variable IT IS STATIC VARIABLE to be referenced into
    // static class
    //static Character-type reference of array is instantiated.
    //char arrayMap[][] is array declaration that has two components: the type and name.
    static char arrayMap[][] = new char[13][13];//Allocating memory to the array
    //total amount of steps used
    public static final int TOTALSTEP=48;
    //Instantiate the static variable to count the numbers of steps for A
    public static int stepA=0;
    //Instantiate the static variable to count the numbers of steps for B
    public static int stepB=0;
    //Instantiate the total number of rounds
    public static int stepsTotal=0;
    //Instantiate the static variable Chess for player A
    private static Chess chessOne;
    //Instantiate the static variable Chess for player B
    private static Chess chessTwo;
    //Instantiate the static variable select to decide odds or even rounds
    public static int select;
    public static void gameRun(){
            //ChessBoard
            ChessBoardInitial();

            //GamePlay
            GamePlay();

            //Print Chessboard
            boardPrint();
        }
        //ChessBoard Creation
        public static void ChessBoardInitial(){
        //Described the Map, the four corner represent the number of
        // remaining chess for the player.
        // Create board
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                arrayMap[i][j] = '#';
                if((i>0&&i<=6)&&(j>0&&j<=6)){
                    arrayMap[i][j]=' ';
                }
                else if((i>=6&&i<=11)&&(j>=6&&j<=11)){
                    arrayMap[i][j]=' ';
                }
                else if((i>6&&i<=11)&&(j>0&&j<6)){
                    arrayMap[i][j]=' ';
                }
                else if((i>0&&i<6)&&(j>6&&j<=11)){
                    arrayMap[i][j]=' ';
                }
                /*if((i==1&&j==1)||(i==11&&j==1)||(i==1&&j==11)||(i==11&&j==11)){
                    arrayMap[i][j]='*';
                }*/
                /*if((i==0&&j==0)||(i==12&&j==12)||(i==0&&j==12)||(i==12&&j==0)){
                    arrayMap[i][j]='X';*/
                }
            }
        }
        //Print board function. Instantiate two static integer variables for the cases that a plane lands on opponent's piece.
        public static int kickA=0;
        public static int kickB=0;
        public static void boardPrint(){
        for (int i = 0; i < 13; i++) {
          for (int j = 0; j < 13; j++) {
              /*Assign value and update first*/
              arrayMap[i][j]='#';
              if((i>0&&i<=6)&&(j>0&&j<=6)){
                  arrayMap[i][j]=' ';
              }
              else if((i>=6&&i<=11)&&(j>=6&&j<=11)){
                  arrayMap[i][j]=' ';
              }
              else if((i>6&&i<=11)&&(j>0&&j<6)){
                  arrayMap[i][j]=' ';
              }
              else if((i>0&&i<6)&&(j>6&&j<=11)){
                  arrayMap[i][j]=' ';
              }
              /*when stepA is not equal to stepB then it means that one plane landed on another plane, indicating one plane will not be kicked back to the starting point*/
              if(stepA!=stepB) {
                  arrayMap[chessOne.getRow()][chessOne.getColumn()] = chessOne.getName();
                  arrayMap[chessTwo.getRow()][chessTwo.getColumn()] = chessTwo.getName();
              }
              /*Four cases regarding one plane land on another plane's location*/
              /*case 1: the array is empty and i and j matches for player 1*/
              //else if(arrayMap[i][j]=='#'&&i==chessOne.getRow() && j==chessOne.getColumn()){
              //    arrayMap[i][j]=chessOne.getName();
              //}
              /*case 2: the array is empty and i and j matches for player 2*/
              //else if(arrayMap[i][j]=='#'&&i==chessTwo.getRow() && j==chessTwo.getColumn()){
              //    arrayMap[i][j]=chessTwo.getName();
              //}
              /*case 3: kick player 1 chess to the origin point*/
              else if(i==chessTwo.getRow() && j==chessTwo.getColumn()){
                  arrayMap[i][j]=chessTwo.getName();
                  kickA=1;
              }
              /*case 4: kick player 2 chess to the origin point*/
              else if(i==chessOne.getRow() && j==chessOne.getColumn()){
                  arrayMap[i][j]=chessOne.getName();
                  kickB=1;
              }
            System.out.print(arrayMap[i][j]+" ");
        }
        System.out.print("\n");
        }
        }
        //Game Prep and Playing
        public static void GamePlay(){
            //1.Input Player one and Player two names
            System.out.println("Please input Player 1 Name");
            //Instantiate a new object(player)
            Scanner sr1=new Scanner(System.in);
            Player playerOne=new Player(1,sr1.nextLine());
            //System.out.println(chessOne.getName());
            System.out.println("Please input Player 2 Name");
            Scanner sr2=new Scanner(System.in);
            /*playerTwo*/
            Player playerTwo=new Player();
            /*Instantiate the object using default constructor (method overloading)*/
            playerTwo.setName(sr2.nextLine());
            playerTwo.setId(2);
            /*The class Chess should create chess B*/
            playerTwo.setChess(new Chess('B'));
            chessOne=playerOne.getChess();
            chessTwo=playerTwo.getChess();
            /*2. Game Start*/
            /*Count the round, even round player one go, odd round player two go*/
            do {
                switch (stepsTotal % 2) {
                    case 1:
                        select = 1;
                        break;
                    case 0:
                        select = 0;
                        break;
                }
                /*the player go*/
                /*ask the user to input r to roll a dice in order to play*/
                if (select == 0) {
                    System.out.println("Player 1 will start rolling a dice, please press 'r' to roll");
                    Scanner sr3 = new Scanner(System.in);
                    String pressButton = sr3.nextLine();
                    if (pressButton.equals("r")) {
                        //Make Dice from 1 to 6;
                        Random dice = new Random();
                        //nextInt goes from 0 to 5; so 1+nextInt goes from 1 to 6. Instantiate an object called result
                        int result = 1 + dice.nextInt(6);
                        /*count the number of total steps stepA+=result means stepA=stepA+result*/
                        stepA += result;
                        //Two cases, if result is not 6, then goes the chess on the chessboard.
                        //Else if the result is 6, then let the user choose which chess will go.
                        /*The chess cannot exceed the boundary*/
                        /*Case 1: i==0 and j <13 upper line*/
                        /*case 9: if the player 1 chess was kicked by player 2*/
                        if(kickA==1){
                            chessOne.setColumn(0);
                            chessOne.setRow(0);
                            kickA=0;
                        }
                        else if (chessOne.getRow() == 0 && chessOne.getColumn() + result < 13) {
                            chessOne.setColumn(result + chessOne.getColumn());
                            chessOne.setRow(0);
                        }
                        /*Case 2: i==0 and j>12 upper-line vs right line Corner*/
                        else if (chessOne.getRow() == 0 && result + chessOne.getColumn() > 12) {
                            chessOne.setRow(chessOne.getColumn() + result - 12);
                            chessOne.setColumn(12);
                        }
                        /*Case 3: right line i==12 j<12*/
                        else if (chessOne.getRow() + result <= 12 && chessOne.getColumn() == 12) {
                            chessOne.setRow(chessOne.getRow() + result);
                            chessOne.setColumn(12);
                        }

                        /*Case 4: right-line to bottom line corner*/
                        else if (chessOne.getRow() + result > 12 && chessOne.getColumn() == 12 && chessOne.getRow() != 0 && chessOne.getRow() != 12) {
                            chessOne.setColumn(12 - (result - (13 - (chessOne.getRow()+1))));
                            chessOne.setRow(12);
                        }
                        /*case 5: the bottom line where row==12*/
                        else if (chessOne.getRow() == 12 && chessOne.getColumn() - result >= 0) {
                            chessOne.setRow(12);
                            chessOne.setColumn(chessOne.getColumn() - result);
                        }
                        /*case 6: corner to left line*/
                        else if (chessOne.getRow() == 12 && chessOne.getColumn() - result < 0 && chessOne.getColumn() != 12) {
                            chessOne.setRow(12 - (result - chessOne.getColumn()));
                            chessOne.setColumn(0);
                        }
                        /*case 7 left line*/
                        else if (chessOne.getColumn() == 0 && (chessOne.getRow() - result) > 0) {
                            chessOne.setRow(chessOne.getRow() - result);
                            chessOne.setColumn(0);
                        }
                        /*case 8 to win and Acknowledge the winner*/
                        else if (chessOne.getColumn() == 0 && (chessOne.getRow() - result) <= 0) {
                            System.out.println("Congratulations! The winner is " + playerOne.getName());
                            break;
                        }
                        /*count the total rounds*/
                        stepsTotal++;
                        System.out.println("***************Round "+ stepsTotal+"******************");
                        /*case when player A landed on player B's piece player B's steps return to 0, row, column location return to 0*/
                        if(stepA==stepB){
                            stepB=0;
                            chessTwo.setRow(0);
                            chessTwo.setColumn(0);
                        }
                        System.out.println("Watch out!Player "+playerOne.getName()+" walked " + stepA + " Steps in total! ");
                        System.out.println("Watch out!Player "+playerTwo.getName()+" walked " + stepB + " Steps in total! ");
                        System.out.println("------------------------------------------------------------------------------------");
                        System.out.println("for player "+playerOne.getName()+" the row is: " +chessOne.getRow() + " col is " + chessOne.getColumn());
                        System.out.println("------------------------------------------------------------------------------------");
                        System.out.println("After rolling dice, you get " + result);
                        /*Print the real-time board*/
                        boardPrint();
                    }
                }/*while(chessOne.getRow()>=0||chessOne.getColumn()!=0);*/
                /*player B same situation as player A*/
                else if (select == 1) {
                    System.out.println("Player 2 will start rolling a dice, please press 'r' to roll");
                    Scanner sr3 = new Scanner(System.in);
                    /*try-catch*/
                    String pressButton = sr3.nextLine();
                    if (pressButton.equals("r")) {
                        //Make Dice from 1 to 6;
                        Random dice = new Random();
                        //nextInt goes from 0 to 5; so 1+nextInt goes from 1 to 6. Instantiate an object called result
                        int result = 1 + dice.nextInt(6);
                        stepB += result;
                        //Two cases, if result is not 6, then goes the chess on the chessboard.
                        //Else if the result is 6, then let the user choose which chess will go.
                        /*The chess cannot exceed the boundary*/
                        /*Case 0: i==0 and j <13 upper line*/
                        if(kickB==1){
                            chessTwo.setColumn(0);
                            chessTwo.setRow(0);
                            kickB=0;
                        }
                        /*case 1 the upper line*/
                        else if (chessTwo.getRow() == 0 && chessTwo.getColumn() + result < 13) {
                            chessTwo.setRow(0);
                            chessTwo.setColumn(result + chessTwo.getColumn());
                        }
                        /*Case 2: i==0 and j>12 upper-line vs right line Corner*/
                        else if (chessTwo.getRow() == 0 && result + chessTwo.getColumn() > 12) {
                            chessTwo.setRow(chessTwo.getColumn() + result - 12);
                            chessTwo.setColumn(12);
                        }
                        /*Case 3: right line i==12 j<12*/
                        else if (chessTwo.getRow() + result <= 12 && chessTwo.getColumn() == 12) {
                            chessTwo.setRow(chessTwo.getRow() + result);
                            chessTwo.setColumn(12);
                        }

                        /*Case 4: right-line to bottom line corner*/
                        else if (chessTwo.getRow() + result > 12 && chessTwo.getColumn() == 12 && chessTwo.getRow() != 0 && chessTwo.getRow() != 12) {
                            chessTwo.setColumn(12 - (result - (12 - chessTwo.getRow())));
                            chessTwo.setRow(12);
                        }
                        /*case 5: the bottom line where row==12*/
                        else if (chessTwo.getRow() == 12 && chessTwo.getColumn() - result >= 0) {
                            chessTwo.setRow(12);
                            chessTwo.setColumn(chessTwo.getColumn() - result);
                        }
                        /*case 6: corner to left line*/
                        else if (chessTwo.getRow() == 12 && chessTwo.getColumn() - result < 0 && chessTwo.getColumn() != 12) {
                            chessTwo.setRow(12 - (result - chessTwo.getColumn()));
                            chessTwo.setColumn(0);
                        }
                        /*case 7 left line*/
                        else if (chessTwo.getColumn() == 0 && (chessTwo.getRow() - result) > 0) {
                            chessTwo.setRow(chessTwo.getRow() - result);
                            chessTwo.setColumn(0);
                        }
                        /*case 8 to win and Acknowledge the winner*/
                        else if (chessTwo.getColumn() == 0 && (chessTwo.getRow() - result) <= 0) {
                            System.out.println("Congratulations! The winner is " + playerOne.getName());
                            break;
                        }
                        stepsTotal=stepsTotal+1;
                        System.out.println("***************Round "+ stepsTotal+"******************");
                        if(stepA==stepB){
                            stepA=0;
                            chessOne.setRow(0);
                            chessOne.setColumn(0);
                        }
                        /*Print out the round information*/
                        System.out.println("Watch out!Player "+playerOne.getName()+" walked " + stepA + " Steps in total! ");
                        System.out.println("Watch out!Player "+ playerTwo.getName()+" walked " + stepB + " Steps in total! ");
                        System.out.println("------------------------------------------------------------------------------------");
                        System.out.println("in this round, player "+playerTwo.getName()+" the row is: " + chessTwo.getRow() + " col is " + chessTwo.getColumn());
                        System.out.println("------------------------------------------------------------------------------------");
                        System.out.println("After rolling dice, you get "+ result);
                        /*Print the real-time board*/
                        boardPrint();
                    }
                }
            } while(chessTwo.getRow()>=0||chessTwo.getColumn()!=0||chessOne.getRow()>=0||chessOne.getColumn()!=0||stepA<=TOTALSTEP||stepB<=TOTALSTEP);
            /*3. Declare winners System.out.println("the winner is "+playerOne.getName());*/
            System.out.println("end of the game, enjoy your day!Rerun the application to start playing again!");
        }
}