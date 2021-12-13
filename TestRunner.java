//class used to test code throughout, can be ignored


public class TestRunner {
    static int SHIP_AMOUNT = 5;
    static int BOARD_SIZE = 8;
    public static void main(String[] args){






        //char[][] PlayerBoard1 = PlayerBoard.createBoardPlayer(BOARD_SIZE, SHIP_AMOUNT);
        //char[][] PlayerBoard2 = PlayerBoard.createBoardPlayer(BOARD_SIZE, SHIP_AMOUNT);

        char[][] PlayerBoard1 = Board.createBoard(BOARD_SIZE, SHIP_AMOUNT);
        char[][] PlayerBoard2 = Board.createBoard(BOARD_SIZE, SHIP_AMOUNT);

        Board.printBoard(PlayerBoard1);
        Board.printBoard(PlayerBoard2);

        PlayGame.letsPlay2Player(PlayerBoard1,PlayerBoard2);



    }
}

