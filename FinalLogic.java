import java.util.Scanner;

public class FinalLogic {

    //pls don't change these
    static int SHIP_AMOUNT = 5;
    static int BOARD_SIZE = 8;

    public static void gameTime(){
        int oneOrTwo;
        System.out.println("Welcome to BattleShip!");
        System.out.println("\nSelect one player(versus computer) or 2 player (input 1 or 2)");
        oneOrTwo = new Scanner(System.in).nextInt();
        if(oneOrTwo == 2){
            char[][] PlayerBoard1 = PlayerBoard.createBoardPlayer(BOARD_SIZE, SHIP_AMOUNT);
            char[][] PlayerBoard2 = PlayerBoard.createBoardPlayer(BOARD_SIZE, SHIP_AMOUNT);

            PlayGame.letsPlay2Player(PlayerBoard1,PlayerBoard2);
        }else if(oneOrTwo == 1){
            char[][] computerBoard = Board.createBoard(BOARD_SIZE, SHIP_AMOUNT);
            char[][] playerBoard = PlayerBoard.createBoardPlayer(BOARD_SIZE, SHIP_AMOUNT);

            PlayGameAI.letsPlayAI(computerBoard,playerBoard);


        }


    }

}