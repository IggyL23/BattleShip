public class MainRunner {
    static int SHIP_AMOUNT = 5;
    static int BOARD_SIZE = 8;
    public static void main(String[] args){






        char[][] AIBoard = Board.createBoard(BOARD_SIZE, SHIP_AMOUNT);
        Board.printBoard(AIBoard);
        PlayGame.letsPlay(AIBoard);



    }
}
