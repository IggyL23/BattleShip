import java.util.Arrays;
import java.util.Random;

public class Board {
    static char empty = '-';
    static char ship = 's';
    static char hit = 'X';
    static char miss = 'O';
    static int REDIX = 18;





    public static Piece[] pieceArray(){
        Piece[] PieceArr = new Piece[5];
        for(int i = 0; i < 5; i++){
            PieceArr[i] = new Piece(i);
        }
        return PieceArr;
    }

    public static char[][] createBoard(int BOARD_SIZE, int SHIP_AMOUNT){

        char[][] gameBoard = new char [BOARD_SIZE][BOARD_SIZE];
        for (char[] row : gameBoard){
            Arrays.fill(row, empty);
        }
        return shipsAI(gameBoard, SHIP_AMOUNT, empty, ship);
    }

    public static char[][] shipsAI(char[][] gameBoard, int SHIP_AMOUNT, char empty, char ship){
        int shipsPlaced = 0;
        int boardSize = gameBoard.length;

        for(int s = 0; s < 5; s++){
            int randoVOrH = new Random().nextInt(2);
            int[][] severalLocations = getEntireShipAI(boardSize,s,randoVOrH);
            Piece[] pieceArr = pieceArray();
            int shipLength = pieceArr[s].size;


            if (checkIfEmpty(severalLocations,gameBoard,s)){

                if(randoVOrH == 0){
                    for(int i = 0; i < shipLength; i++){
                        gameBoard[severalLocations[i][0]][severalLocations[i][1]]=pieceArr[s].charName;


                    }
                }else{
                    for(int i = 0; i < shipLength; i++){
                        gameBoard[severalLocations[i][0]][severalLocations[i][1]]=pieceArr[s].charName;


                    }
                }


                shipsPlaced++;


            }else{
                s--;
            }
        }
        return gameBoard;
    }

    public static int[] getShipCoordsAI(int boardSize){
        int[] coords = new int [2];
        for(int i = 0; i < coords.length; i++){
            coords[i] = new Random().nextInt(boardSize);
        }


        return coords;
    }

    public static int[][] getEntireShipAI(int boardSize, int type, int vOrH) {
        int[] location = getShipCoordsAI(boardSize);
        Piece[] pieceArr = pieceArray();
        int shipLength = pieceArr[type].size;
        int[][] severalCoords = new int[shipLength][2];
        if(vOrH == 0){
            for (int i = 0; i < shipLength; i++) {

                severalCoords[i][0] = location[0];
                severalCoords[i][1] = location[1]+i;

            }
        }else{
            for (int i = 0; i < shipLength; i++) {

                severalCoords[i][0] = location[0]+i;
                severalCoords[i][1] = location[1];

            }
        }

        return severalCoords;
    }

    public static boolean checkIfEmpty(int[][] location, char[][] gameBoard,int s){
        Piece[] pieceArr = pieceArray();
        int shipLength = pieceArr[s].size;
        boolean check = true;

        for (int i =0; i < shipLength; i++){
            if(location[i][1]>7 || location[i][0]>7){
                check = false;
                break;
            }
            char possiblePlace = gameBoard[location[i][0]][location[i][1]];
            if(possiblePlace == empty){
                check = true;
            }else{
                check = false;
                break;
            }


        }
        return check;
    }

    public static void printBoard ( char[][] gameBoard){
        Piece[] pieceArr = pieceArray();
        int boardSize = gameBoard.length;
        System.out.print("  ");
        for (int i = 0; i < boardSize; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        for (int row = 0; row < boardSize; row++) {
            System.out.print(Character.toUpperCase((Character.forDigit((row + 10), REDIX))) + " ");
            for (int col = 0; col < boardSize; col++) {
                char position = gameBoard[row][col];
                if (position == pieceArr[0].charName || position == pieceArr[1].charName || position == pieceArr[2].charName || position == pieceArr[3].charName || position == pieceArr[4].charName) {
                    System.out.print(empty + " ");
                } else {
                    System.out.print(position + " ");
                }
            }
            System.out.println();
        }
    }

}
