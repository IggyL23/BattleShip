import java.util.Arrays;
import java.util.Scanner;

public class PlayerBoard {


    public static char[][] createBoardPlayer(int BOARD_SIZE, int SHIP_AMOUNT){

        char[][] gameBoard = new char [BOARD_SIZE][BOARD_SIZE];
        for (char[] row : gameBoard){
            Arrays.fill(row, Board.empty);

        }


        return shipsPlayer(gameBoard, SHIP_AMOUNT, Board.empty, Board.ship);
    }

    public static char[][] shipsPlayer(char[][] gameBoard, int SHIP_AMOUNT, char empty, char ship){
        int shipsPlaced = 0;
        Piece[] pieceArr = Board.pieceArray();
        int boardSize = gameBoard.length;
        Board.printBoard(gameBoard);
        for(int s = 0; s < 5; s++){
            System.out.println(pieceArr[s].name + ", size: " + pieceArr[s].size + ", symbol: " +"'" +pieceArr[s].charName + "'");
            System.out.println("Press 0 for horizontal, or 1 for vertical");
            int VOrH = new Scanner(System.in).nextInt();
            int[][] severalLocations = getEntireShipPLayer(boardSize,s,VOrH, gameBoard);
            int shipLength = pieceArr[s].size;


            if (Board.checkIfEmpty(severalLocations,gameBoard,s)){

                if(VOrH == 0){
                    for(int i = 0; i < shipLength; i++){
                        gameBoard[severalLocations[i][0]][severalLocations[i][1]]=pieceArr[s].charName;


                    }
                    Board.printBoard(gameBoard);

                }else{
                    for(int i = 0; i < shipLength; i++){
                        gameBoard[severalLocations[i][0]][severalLocations[i][1]]=pieceArr[s].charName;


                    }
                    Board.printBoard(gameBoard);
                }


                shipsPlaced++;


            }else{
                s--;
                System.out.println("A ship is already there");
            }
        }
        return gameBoard;
    }


    public static int[][] getEntireShipPLayer(int boardSize, int type, int vOrH, char[][] gameBoard) {
        int[] location = getShipCoordsPlayer(boardSize, gameBoard,type);
        Piece[] pieceArr = Board.pieceArray();
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

    public static int[] getShipCoordsPlayer(int boardSize,char[][] gameBoard,int type){
        Piece[] pieceArr = Board.pieceArray();
        System.out.println("Select location for your " + pieceArr[type].name + "(size: " + pieceArr[type].size + ")");
        int[] coords = PlayGame.getUserCoords();


        /*int[] coords = new int [2];
        System.out.println("Pick X coordinates");
        int xCoord = new Scanner(System.in).nextInt();
        coords[0] = xCoord;


        System.out.println("Pick Y coordinates");
        int yCoord = new Scanner(System.in).nextInt();
        coords[1] = yCoord;*/





        return coords;
    }

}


