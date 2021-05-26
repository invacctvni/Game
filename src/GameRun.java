/**Application Purposes: Make a game "Aeroplane Chess (Pachisi)". There will be two players. The users are asked to input the player names first.
 * Then toss a 6-sided dice separately, and the user chess will move on the 13*13 chess game board subsequently. The two players each will try to get their own plane piece from the starting point (left-upper corner),
 * and across the circle of the chess to reach back to the origin point again. Note that when a player lands on an opponent's piece, the opponent returns that piece to the starting point. ]
 * There will be information such as steps board and total numbers of steps taken in each round, and congratulations message to the player who win the game! The class is used to run the game
 * Author: Jiaqi Chen
 * Date: 2021-04-12
 * Time: 12:13PM
 * */

import java.util.Random;
import java.util.Scanner;

public class GameRun {
    public static void main(String args[]) {
        //Run the Game
        FlyGamePlay.gameRun();
    }
}
