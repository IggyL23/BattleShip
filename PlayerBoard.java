import java.util.Random;
import java.util.Scanner;

public class PlayerBoard {

    public static char[][] shipsPlayer(char[][] gameBoard, int SHIP_AMOUNT, char empty, char ship){
        int shipsPlaced = 0;
        int boardSize = gameBoard.length;

        for(int s = 0; s < 5; s++){
            int VOrH = new Scanner(System.in).nextInt();
            int[][] severalLocations = getEntireShipPLayer(boardSize,s,VOrH);
            Piece[] pieceArr = Board.pieceArray();
            int shipLength = pieceArr[s].size;


            if (Board.checkIfEmpty(severalLocations,gameBoard,s)){

                if(VOrH == 0){
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


    public static int[][] getEntireShipPLayer(int boardSize, int type, int vOrH) {
        int[] location = getShipCoordsPlayer(boardSize);
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

    public static int[] getShipCoordsPlayer(int boardSize){

    }

}


