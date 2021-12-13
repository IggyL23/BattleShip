import java.util.InputMismatchException;
import java.util.Scanner;

//contains methods needed to play against computer
public class PlayGameAI {

    //main method for AI battleship game
    public static void letsPlayAI(char [][] gameBoard1, char[][] gameBoard2){
        boolean[] shipDone = new boolean[5];


        int aliveShips1 = 17;
        int aliveShips2 = 17;

        Piece[] pieceArr = Board.pieceArray();
        while(aliveShips1 > 0 || aliveShips2 > 0){
            //player 1
            int[] guessCoords1;
            char locationView1;
            do{
                //I use the getShipCoordsAI as it randomly gives me a coordinate which is perfect for this application
                guessCoords1 = Board.getShipCoordsAI(8);

                locationView1 = PlayGame.guessAndGet(guessCoords1, gameBoard2,pieceArr);
                if (locationView1 == Board.hit){
                    aliveShips1--;
                }
                gameBoard2 = PlayGame.updateGameBoard(gameBoard2, guessCoords1, locationView1);
                PlayGame.checkIfSunk(gameBoard2,pieceArr,shipDone);
            }while (!checkIfEmptyAI(guessCoords1,gameBoard1));





            //player 2
            System.out.println("Player turn:");
            System.out.println("\nYour board :");
            Board.printBoard(gameBoard2);
            System.out.println("\nEnemy Board: ");
            Board.printBoardHidden(gameBoard1);
            System.out.println();

            int[] guessCoords2 = PlayGame.getUserCoords();
            char locationView2 = PlayGame.guessAndGet(guessCoords2, gameBoard1,pieceArr);
            if (locationView2 == Board.hit){
                aliveShips2--;
            }
            gameBoard1 = PlayGame.updateGameBoard(gameBoard1, guessCoords2, locationView1);
            PlayGame.checkIfSunk(gameBoard1,pieceArr,shipDone);
            System.out.println("\nEnemy Board: ");
            Board.printBoardHidden(gameBoard1);
            Board.pressEnterToContinue();
            Board.clearConsole();


        }
        if(aliveShips1 == 0){
            System.out.println("Computer wins");
        }else if(aliveShips2 == 0){
            System.out.println("Player wins");
        }else{
            System.out.println("Draw?? is that even possible?");
        }



    }

    //checks to make sure that the AI doesn't make the same guess
    public static boolean checkIfEmptyAI(int[] location, char[][] gameBoard) {
        Piece[] pieceArr = Board.pieceArray();
        boolean check = true;

        for (int i = 0; i < 2; i++) {
            if (location[i] > 7) {
                check = false;
                break;
            }
            char possiblePlace = gameBoard[location[0]][location[1]];
            if (possiblePlace != Board.hit || possiblePlace != Board.miss) {
                check = true;
            } else {
                check = false;
                break;
            }


        }
        return check;
    }

}

