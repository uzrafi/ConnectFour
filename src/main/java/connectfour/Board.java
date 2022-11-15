package connectfour;

/**
 * @author Uzair Rafi
 *         Description: Board class to maintain board, make win conditions,
 *         and provide a string representation of the board
 */

public class Board {

    private int[][] board = new int[6][7]; // declare and initialize variable for the board and turn
    private int turn = 0;

    /**
     * setter for turn variable
     */

    public void setTurn() {
        turn += 1; // add to turn
    }

    /**
     * getter for turn variable
     * 
     * @return turn
     */

    public int getTurn() {
        return turn; // return turn
    }

    /**
     * setter for board
     * 
     * @param row
     * @param column
     * @param element
     */

    public void setBoard(int row, int column, int element) {
        board[row][column] = element; // set board at row and column to element
    }

    /**
     * getter for board
     * 
     * @return board
     */

    public int[][] getBoard() {
        return board; // return board
    }

    /**
     * method that puts both the default board and altered board
     * into a string and returns that string
     * 
     * @return boardString
     */

    @Override
    public String toString() {

        String boardString = ""; // declare and initialize string to return

        // default board
        if (getTurn() == 0) { // if the turn count is 0
            for (int i = 0; i < 6; i++) { // loop through board
                for (int j = 0; j < 7; j++) {

                    setBoard(i, j, 0); // set contents of board to 0
                    boardString += board[i][j]; // add board contents to board string

                    if (j < 6) { // print boarders between numbers after 1st column till 6th column
                        boardString += "|";
                    }
                }
                if (i < 5) { // print borders between each row after 1st row till 5th row
                    boardString += "\n-+-+-+-+-+-+-\n";
                } else {
                    boardString += "\n"; // else add new line to string
                }
            }
        } else { // else turn count is not 0
            // altered board
            for (int i = 0; i < 6; i++) { // loop through board
                for (int j = 0; j < 7; j++) {

                    if (board[i][j] == 82 || board[i][j] == 66) { // if board contains either 82 or 66
                        boardString += (char) board[i][j]; // print char of converted ASCII value
                    } else {
                        boardString += board[i][j]; // else, print board
                    }

                    if (j < 6) { // print boarders between numbers after 1st till 6th column
                        boardString += "|";
                    }

                }
                if (i < 5) { // print borders between each row after 1st till 5th row
                    boardString += "\n-+-+-+-+-+-+-\n";
                } else {
                    boardString += "\n"; // else print new line
                }
            }
        }

        return boardString; // return the board string
    }

    /**
     * method to put the player move on the board at the first empty space
     * of a column from the bottom, using column and Player object as parameters
     * 
     * @param column
     * @param user
     */

    public void makePlayerMove(int column, ConnectFour user) {

        int counter = 5; // set counter to 5

        char move = user.getPlayerMove(); // declare move character and initialize to player move
        user.setPlayerTurn(move); // call setPlayerTurn method to set move to next turn

        for (int i = 0; i < 6; i++) { // loop through board
            if (board[counter][column] == 0) { // if board at counter and column is 0
                setBoard(counter, column, move); // place the move
                setTurn(); // add to turn count
                break; // break from loop
            }
            counter--; // decrease counter by 1
        }
    }

    /**
     * method with Boolean return value that checks if a column is full
     * using the column as a parameter
     * 
     * @param column
     * @return true, false
     */

    public Boolean validMove(int column) {

        int fullSpaceCount = 0; // declare and initalize count for full spaces

        for (int i = 5; i >= 0; i--) { // loop from bottom of a column
            if (board[i][column] != 0) { // if board space is not empty
                fullSpaceCount++; // add to full space count
            }
        }

        if (fullSpaceCount == 6) { // if full space count is true
            return false; // return false for an invalid move
        }

        return true; // else, return true

    }

    /**
     * method with Boolean return value to check right diagonal wins
     * 
     * @return true, false
     */

    public Boolean winRightDiag() {

        int matchCount = 0; // declare and initialize variables for match count,
        int colCount = 0; // column count, and origin
        int origin = 0;

        for (int i = 3; i <= 5; i++) { // loop through the rows that can have diagonal wins
            for (int j = 0; j < 4; j++) { // loop through each win for each row
                origin = board[i][colCount]; // set origin to board at i and column count
                matchCount = 0; // set matchCount back to 0 for new win possibility
                for (int k = 0; k < 4; k++) { // loop through diagonal
                    if (origin == 0 || board[i - k][colCount + k] != origin) { // if origin is an empty space or
                                                                               // not equal to the diagonal space
                        break; // break out of diagonal
                    } else {
                        matchCount++; // else, add to match count
                    }
                }
                colCount++; // add to colCount for next win

                if (matchCount == 4) { // if matchCount is 4, return true
                    return true;
                }
            }
            colCount = 0; // set colCount to 0 for next row
        }

        return false; // return false
    }

    /**
     * method with Boolean return value to check left diagonal wins
     * 
     * @return true, false
     */

    public Boolean winLeftDiag() {

        int matchCount = 0; // declare and initialize variables for match count,
        int colCount = 6; // column count, and origin
        int origin = 0;

        for (int i = 3; i <= 5; i++) { // loop through the rows that can have diagonal wins
            for (int j = 0; j < 4; j++) { // loop through each win for each row
                origin = board[i][colCount]; // set origin to board at i and column count
                matchCount = 0; // set matchCount back to 0 for new win possibility
                for (int k = 0; k < 4; k++) { // loop through diagonal
                    if (origin == 0 || board[i - k][colCount - k] != origin) { // if origin is an empty space or
                                                                            // not equal to the diagonal space
                        break; // break out of diagonal
                    } else {
                        matchCount++; // else, add to match count
                    }
                }
                colCount--; // subtract from colCount for next win

                if (matchCount == 4) { // if matchCount is 4, return true
                    return true;
                }
            }
            colCount = 6; // set colCount to 6 for next row
        }

        return false; // return false
    }

    /**
     * method with Boolean return value to check row wins
     * 
     * @return true, false
     */

    public Boolean winRows() {

        int colCount = 0; // declare and initialize variables for match count,
        int origin = 0;  // column count, and origin
        int matchCount = 0;

        for (int i = 5; i >= 0; i--) { // loop through rows
            for (int j = 0; j < 4; j++) { // loop through win posibilities
                origin = board[i][colCount]; // set origin to board at i and column count
                matchCount = 0; // set match count back to 0 for next win possibility
                for (int k = 0; k < 4; k++) { // loop through row
                    if (origin == 0 || board[i][colCount + k] != origin) { // if origin is empty space or
                                                                        // not equal to the row space
                        break; // break from win
                    } else {
                        matchCount++; // else, add to match count
                    }
                }
                colCount++; // add to column count for next win

                if (matchCount == 4) { // if match count is 4, return true
                    return true;
                }
            }
            colCount = 0; // set column count to 0 for next row
        }

        return false; // return false

    }

    /**
     * method with Boolean return value to check column wins
     * using a transposed board
     * @return true, false
     */

    public boolean winCol() {
        int matchCount = 0; // declare and initialize variables for match count,
        int[][] transposedBoard = new int[7][6]; // transposed board, and origin
        int origin = 0;
        int colCount = 0;

        // transpose matrix
        for (int i = 0; i < 6; i++) { // loop through board
            for (int j = 0; j < 7; j++) {
                transposedBoard[j][i] = board[i][j]; // set transposed board elements to boards columns as rows
            }
        }

        for (int i = 6; i >= 0; i--) { // loop through rows
            for (int j = 0; j < 3; j++) { // loop through each win possibility
                origin = transposedBoard[i][colCount]; // set origin to transposed board at i and col count
                matchCount = 0; // set match count back to 0 for next win possibility
                for (int k = 0; k < 4; k++) { // loop through row
                    if (origin == 0 || transposedBoard[i][colCount + k] != origin) { // if origin is empty space or
                                                                                     // not equal to the row space
                        break; // break from win
                    } else {
                        matchCount++; // else, add to match count
                    }
                }
                colCount++; // add to colCount for next win

                if (matchCount == 4) { // if match count is 4, return true
                    return true;
                }
            }
            colCount = 0; // set colCount back to 0 for next row
        }

        return false; // return false

    }

    /**
     * method with Boolean return value to determine if a tie takes place
     * 
     * @return true, false
     */

    public Boolean isTie() {
        if (!winCol() && !winLeftDiag() && !winRightDiag() && !winCol() && turn == 42) {
            // if a win condition hasnt been met,
            // and turn count is 42
            return true; // return true
        }

        return false; // return false
    }

}