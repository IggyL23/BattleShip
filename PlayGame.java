import java.util.InputMismatchException;
import java.util.Scanner;
public class PlayGame {

    public static void letsPlay(char [][] gameBoard){
        boolean[] shipDone = new boolean[5];


        int undetectedShipNum = 17;
        Piece[] pieceArr = Board.pieceArray();
        while(undetectedShipNum > 0){
            int[] guessCoords = getUserCoords();
            char locationView = guessAndGet(guessCoords, gameBoard,pieceArr);
            if (locationView == Board.hit){
                undetectedShipNum--;
            }
            gameBoard = updateGameBoard(gameBoard, guessCoords, locationView);
            checkIfSunk(gameBoard,pieceArr,shipDone);
            Board.printBoard(gameBoard);


        }
        System.out.println("Player wins");
    }

    public static char[][] updateGameBoard(char[][] gameBoard, int[] guessCoords, char locationView) {
        int row = guessCoords[0];
        int col = guessCoords[1];
        gameBoard[row][col] = locationView;

        return gameBoard;
    }

    private static char guessAndGet(int[] guessCoords, char [][] gameBoard,Piece[] pieceArr) {
        String message = null;
        int row = guessCoords[0];
        int col = guessCoords[1];
        char target = gameBoard[row][col];

        for(int i = 0; i < 5; i++){
            if(target == pieceArr[i].charName) {
                message = "Hit!";
                target = Board.hit;
                pieceArr[i].hits = pieceArr[i].hits + 1;
                break;
            }else{
                message = "Already hit!";
            }
        }
        if(target == Board.empty){
            message = "Miss!";
            target = Board.miss;
        }


        System.out.println(message);
        return target;
    }

    public static void checkIfSunk(char[][] gameBoard,Piece[] pieceArr,boolean[] shipDone){


        if(pieceArr[0].hits >= pieceArr[0].size && !shipDone[0]){
            System.out.println("You sunk my destroyer");
            shipDone[0] = true;
        }
        if(pieceArr[1].hits >= pieceArr[1].size && !shipDone[1]){
            System.out.println("You sunk my submarine");
            shipDone[1] = true;
        }
        if(pieceArr[2].hits >= pieceArr[2].size && !shipDone[2]){
            System.out.println("You sunk my cruiser");
            shipDone[3] = true;
        }
        if(pieceArr[3].hits >= pieceArr[3].size && !shipDone[3]){
            System.out.println("You sunk my battleship");
            shipDone[3] = true;
        }
        if(pieceArr[4].hits >= pieceArr[4].size && !shipDone[4]){
            System.out.println("You sunk my carrier");
            shipDone[4] = true;
        }







    }

    public static int[] getUserCoords(){
        int row = 0;
        int col;
        char charCol;
        do {
            System.out.print("Row: ");
            charCol = new Scanner(System.in).next().charAt(0);
            charCol = Character.toUpperCase(charCol);
            col = charCol-64;
            //col = new Scanner(System.in).nextInt();
        }while (col < 0 || col > MainRunner.BOARD_SIZE + 1);

        do{
            System.out.print("Column: ");
            Scanner sc = new Scanner(System.in);

            try{
                row = sc.nextInt();
            }catch (InputMismatchException e) {
                System.out.println("Not an int, not valid");
                row = 10;
            }

        }while(row < 0 || row > MainRunner.BOARD_SIZE + 1);

        return new int[]{col-1, row - 1};
    }


}

