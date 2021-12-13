import java.util.InputMismatchException;
import java.util.Scanner;
public class PlayGame {

    public static void letsPlay2Player(char [][] gameBoard1, char [][] gameBoard2){
        boolean[] shipDone = new boolean[5];


        int aliveShips1 = 17;
        int aliveShips2 = 17;

        Piece[] pieceArr = Board.pieceArray();
        while(aliveShips1 > 0 || aliveShips2 > 0){
            //player 1
            System.out.println("Player 1 turn:");
            System.out.println("\nYour board :");
            Board.printBoard(gameBoard1);
            System.out.println("\nEnemy Board: ");
            Board.printBoardHidden(gameBoard2);
            System.out.println();

            int[] guessCoords1 = getUserCoords();
            char locationView1 = guessAndGet(guessCoords1, gameBoard2,pieceArr);
            if (locationView1 == Board.hit){
                aliveShips1--;
            }
            gameBoard2 = updateGameBoard(gameBoard2, guessCoords1, locationView1);
            checkIfSunk(gameBoard2,pieceArr,shipDone);
            System.out.println("\nEnemy Board: ");
            Board.printBoardHidden(gameBoard2);
            Board.pressEnterToContinue();
            Board.clearConsole();

            //player 2
            System.out.println("Player 2 turn:");
            System.out.println("\nYour board :");
            Board.printBoard(gameBoard2);
            System.out.println("\nEnemy Board: ");
            Board.printBoardHidden(gameBoard1);
            System.out.println();

            int[] guessCoords2 = getUserCoords();
            char locationView2 = guessAndGet(guessCoords2, gameBoard1,pieceArr);
            if (locationView2 == Board.hit){
                aliveShips2--;
            }
            gameBoard1 = updateGameBoard(gameBoard1, guessCoords2, locationView1);
            checkIfSunk(gameBoard1,pieceArr,shipDone);
            System.out.println("\nEnemy Board: ");
            Board.printBoardHidden(gameBoard1);
            Board.pressEnterToContinue();
            Board.clearConsole();


        }
        if(aliveShips1 == 0){
            System.out.println("Player1 wins");
        }else if(aliveShips2 == 0){
            System.out.println("Player2 wins");
        }else{
            System.out.println("Draw?? is that even possible?");
        }



    }

    public static char[][] updateGameBoard(char[][] gameBoard, int[] guessCoords, char locationView) {
        int row = guessCoords[0];
        int col = guessCoords[1];
        gameBoard[row][col] = locationView;

        return gameBoard;
    }

    public static char guessAndGet(int[] guessCoords, char [][] gameBoard,Piece[] pieceArr) {
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


