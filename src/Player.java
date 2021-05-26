/**Application Purposes: Make a game "Aeroplane Chess (Pachisi)". There will be two players. The users are asked to input the player names first.
 * Then toss a 6-sided dice separately, and the user chess will move on the 13*13 chess game board subsequently. The two players each will try to get their own plane piece from the starting point (left-upper corner),
 * and across the circle of the chess to reach back to the origin point again. Note that when a player lands on an opponent's piece, the opponent returns that piece to the starting point. ]
 * There will be information such as steps board and total numbers of steps taken in each round, and congratulations message to the player who win the game!
 * Author: Jiaqi Chen
 * Date: 2021-04-12
 * Time: 12:13PM
 * */
/*Instantiate Player Class*/
public class Player {
    //Instantiate the instance variables: id, chess, name, respectively.
    //instance  variable id with integer type
    private int id;
    //Instantiate chessArray with Chess[] type. When an array is declared, only a reference of array is created.
    private Chess chess;
    //playerName with String type
    private String playerName;
    //Constructor building, the variable chess is determined by id so use id to interpret chess.
    //Constructor that takes id and player name
    public Player(int id,String playerName){
        this.id=id;
        this.playerName=playerName;
        /*Create an array object called chessArray*/
        if(id==1){
            chess=new Chess('A');
        }
        else if(id==2){
            chess=new Chess('B');
        }
    }

    /*method overloading*/
    public Player(){
    }

    //getter for Chess
    public Chess getChess() {
        return chess;
    }

    //setter for Chess
    public void setChess(Chess chess) {
        this.chess = chess;
    }

    //Getter of getName
    public String getName() {
        return playerName;
    }
    //Setter of SetName
    public void setName(String playerName) {this.playerName = playerName;}
    //Setter of id
    public void setId(int id) {
        this.id = id;
    }
    //Getter of id
    public int getId(){
        return id;
    }
}
