package connectfour;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Uzair Rafi
 *         Description: Unit testing of all the methods present within the board
 *         class
 */

public class BoardTest {
    private Board tester;

    @Before
    public void setup() {
        // set up for the test
        tester = new Board();

    }

    /**
     * tester for toString method
     */

    @Test
    public void toStringTest() {
        Assert.assertNotNull(tester.toString());
    }

    /**
     * tester for getBoard and getTurn
     */

    @Test
    public void getters() {
        Assert.assertNotNull(tester.getBoard());
        Assert.assertEquals(tester.getTurn(), 0);
    }

    /**
     * tester for setBoard
     */

    @Test
    public void settersA() {
        Board newBoard = new Board();
        newBoard.setBoard(0, 0, 1);
        tester.setBoard(0, 0, 1);
        Assert.assertArrayEquals(tester.getBoard(), newBoard.getBoard());
    }

    /**
     * tester for setTurn
     */

    @Test
    public void settersB() {
        tester.setTurn();
        Assert.assertEquals(tester.getTurn(), 1);
    }

    /**
     * tester for makePlayerMove
     */

    @Test
    public void playerMoveTest() {
        ConnectFour player = new ConnectFour();
        int[][] board = new int[6][7];

        player.toString();
        tester.makePlayerMove(0, player);
        board = tester.getBoard();

        Assert.assertEquals(board[5][0], 82);
    }

    /**
     * tester for validMove false condiion
     */

    @Test
    public void validMoveTestA() {

        for (int i = 5; i >= 0; i--) {
            tester.setBoard(i, 0, 82);
        }

        Assert.assertEquals(tester.validMove(0), false);
    }

    /**
     * tester for validMove true condition
     */

    @Test
    public void validMoveTestB() {

        tester.setBoard(5, 0, 82);

        Assert.assertEquals(tester.validMove(0), true);
    }

    /**
     * tester for rightDiagWin true condition
     */

    @Test
    public void rightDiagWinTestA() {

        tester.setBoard(5, 0, 82);
        tester.setBoard(4, 1, 82);
        tester.setBoard(3, 2, 82);
        tester.setBoard(2, 3, 82);

        Assert.assertEquals(tester.winRightDiag(), true);
    }

    /**
     * tester for rightDiagWin false condition
     */

    @Test
    public void rightDiagWinTestB() {

        tester.setBoard(4, 0, 82);
        tester.setBoard(1, 1, 82);
        tester.setBoard(2, 2, 82);
        tester.setBoard(1, 3, 82);

        Assert.assertEquals(tester.winRightDiag(), false);
    }

    /**
     * tester for leftDiagWin true condition
     */

    @Test
    public void leftDiagWinTestA() {

        tester.setBoard(5, 6, 82);
        tester.setBoard(4, 5, 82);
        tester.setBoard(3, 4, 82);
        tester.setBoard(2, 3, 82);

        Assert.assertEquals(tester.winLeftDiag(), true);
    }

    /**
     * tester for leftDiagWin false condition
     */

    @Test
    public void leftDiagWinTestB() {

        tester.setBoard(5, 6, 82);
        tester.setBoard(4, 4, 82);
        tester.setBoard(3, 4, 82);
        tester.setBoard(2, 3, 82);

        Assert.assertEquals(tester.winLeftDiag(), false);
    }

    /**
     * tester for winRows true condition
     */

    @Test
    public void winRowsTestA() {

        tester.setBoard(0, 0, 82);
        tester.setBoard(0, 1, 82);
        tester.setBoard(0, 2, 82);
        tester.setBoard(0, 3, 82);

        Assert.assertEquals(tester.winRows(), true);
    }

    /**
     * tester for winRows false condition
     */

    @Test
    public void winsRowsTestB() {

        tester.setBoard(0, 0, 82);
        tester.setBoard(0, 1, 82);
        tester.setBoard(0, 2, 82);
        tester.setBoard(0, 4, 82);

        Assert.assertEquals(tester.winRows(), false);
    }

    /**
     * tester for winCols true condition
     */

    @Test
    public void winColTestA() {

        tester.setBoard(0, 0, 82);
        tester.setBoard(1, 0, 82);
        tester.setBoard(2, 0, 82);
        tester.setBoard(3, 0, 82);

        Assert.assertEquals(tester.winCol(), true);
    }

    /**
     * tester for winCols false condition
     */

    @Test
    public void winColTestB() {

        tester.setBoard(0, 0, 82);
        tester.setBoard(1, 0, 82);
        tester.setBoard(2, 0, 82);
        tester.setBoard(2, 1, 82);

        Assert.assertEquals(tester.winCol(), false);
    }

    /**
     * tester for isTie true condition
     */

    @Test
    public void isTieA() {

        for (int i = 0; i < 42; i++) {
            tester.setTurn();
        }

        Assert.assertEquals(tester.isTie(), true);
    }

    /**
     * tester for isTie false condition
     */

    @Test
    public void isTieB() {

        for (int i = 0; i < 42; i++) {
            tester.setTurn();
        }

        tester.setBoard(0, 0, 82);
        tester.setBoard(1, 0, 82);
        tester.setBoard(2, 0, 82);
        tester.setBoard(3, 0, 82);

        Assert.assertEquals(tester.isTie(), false);
    }

}