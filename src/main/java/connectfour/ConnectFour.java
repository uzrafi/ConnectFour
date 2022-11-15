package connectfour;


/**
 * @author Uzair Rafi
 * Description: Player class that contains getters and setters for the players move, 
 * and tells TextUI what to print
*/ 
 
public class ConnectFour {

    private int gameState = 0; // declare private variable for move and game state
    private char move; 

    /**
     * method to set the game state to either 1 if there is a win,
     * or 2 if the game is a tie
     * @param b
     */

    public void setGameState(Board b) {
        if (b.winRows() || b.winCol() || b.winRightDiag() || b.winLeftDiag()) {
            gameState = 1; // if win, set to 1
        } else if (b.isTie()) {
            gameState = 2; // else tie, set to 2
        }
    }

    /**
     * getter for gameState
     * @return gameState
     */

    public int getGameState() {
        return gameState;
    }

    /**
     * toString method that sets the default move as a string and returns it
     * @return defaultMove
     */

    @Override
    public String toString() {

        String defaultMove = "";
        move = 'R'; // default move is R

        defaultMove = Character.toString(move); // set default move to move

        return defaultMove; // return defaultMove
    }

    /**
     * setter method that changes the player turn to either R or B, 
     * based on turn parameter
     * @param turn
     */

    public void setPlayerTurn(char turn) { 

        if (turn == 'R') { // if current turn is R, change to B
            turn = 'B';
        } else { // else, turn is B
            turn = 'R';
        }
        move = turn; // set move to the updated turn
    }

    /**
     * getter method for player move
     * @return move
     */

    public char getPlayerMove() {
        return move; // return move
    }

}