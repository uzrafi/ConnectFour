package connectfour;

import java.util.Scanner;

/**
 * @author Uzair Rafi
 * Description: Class that has the main method and takes user input,
 * while also printing every message in the program and the board's
 * string representation
 */

public class TextUI {
    private Scanner input = new Scanner(System.in);
    private Scanner s = new Scanner(System.in);

    /**
     * method to print the string representation of the board
     * @param b
     */

    public void printBoard(Board b) {
        System.out.println(b.toString());
    }

    /**
     * method that gets the user input and catches exception
     * @return inp
     */

    public int getUserInput() {
        int inp = 0; // declare and initialize input variable

        try {
            inp = input.nextInt(); // set input to input from next line
        } catch (Exception e) { // catch invalid input
            printInputError(); // print input error, and move on to next input
            input.next();
        }

        return inp; // return inp
    }

    /**
     * method to get the name of the file
     * @return fName
     */

    public String getFileName() {
        String fName = "";

        System.out.println("Enter the name of the file:"); // prompt user for file name
        fName = s.next(); // file name is next string input

        return fName; // return file name
    }

    /**
     * toString method that returns a string representation
     * of the game's intro message
     * @return message
     */

    @Override
    public String toString() {

        String message = "";

        message += "\nWelcome to Connect Four! R will move first.\n";
        message += "Enter 1 to start a new game, or 2 to load an existing game from a file\n";

        return message;
    }

    /**
     * method to print the game start
     * @param text
     */

    public void printGameStart(TextUI text) {

        System.out.println(text.toString()); // print toString method
    }

    /**
     * method to print which players turns it is, and what
     * inputs can be given for the columns or saving to a file
     * @param player
     */

    public void printMove(ConnectFour player) {
        System.out.println("Enter a column between 0 and 6, "
                + "or enter 7 to save the game to a file. (Turn = " + player.getPlayerMove() + ")");
    }

    /**
     * method to print invalid move
     */

    public void printInvalidMove() {
        System.out.println("Column is full! Try again.");
    }

    /**
     * method to print match end based on game state
     * @param player
     */

    public void printMatchEnd(ConnectFour player) {
        player.setPlayerTurn(player.getPlayerMove()); // set the current players turn
                                                      // to player who made winning move

        if (player.getGameState() == 1) { // if win
            System.out.println("The winner is " + player.getPlayerMove() + "!"); // print winner
        } else if (player.getGameState() == 2) { // if draw
            System.out.println("The game is a tie!"); // print tie
        }

    }

    /**
     * method to print incorrect column input
     */

    public void printColError() {
        System.out.println("Error - Invalid input! Only enter an integer between 0 and 7.");
    }

    /**
     * method to print incorrect input
     */

    public void printInputError(){
        System.out.println("Error - Invalid input!\nA new game will now begin instead!");
    }

    /**
     * method that loops the game until a win or a draw
     * @param newBoard
     * @param newGame
     * @param newOutput
     */

    public void gameLoop(Board newBoard, ConnectFour newGame, TextUI newOutput) {
        int column = 0; // declare and initialize variables for column and file name
        String fileName = "";

        newGame.toString(); // set default move
        newOutput.printBoard(newBoard); // print board

        while (newGame.getGameState() == 0) { // loop until win or draw
            newOutput.printMove(newGame); // print move
            column = newOutput.getUserInput(); // get user input for column

            if (column > 7 || column < 0) { // if incorrect column input
                newOutput.printColError(); // print error message
            } else if (column == 7) { // if column is 7
                fileName = newOutput.getFileName(); // get file name
                FileWriter fw = new FileWriter(fileName); // create file writer
                fw.writeLinesToFile(newBoard); // write to file
            } else {
                if (!newBoard.validMove(column)) { // else, if invalid move
                    newOutput.printInvalidMove(); // print invalid move message
                }
                newBoard.makePlayerMove(column, newGame); // make the player move
            }

            newOutput.printBoard(newBoard); // print updated board
            newGame.setGameState(newBoard); // set the game state if there has been a win or draw

            if (newGame.getGameState() != 0) { 
                newOutput.printMatchEnd(newGame); // print match end for win or draw
            }
        }
    }

    /**
     * main method for the program
     * @param args
     */

    public static void main(String[] args) {

        Board board = new Board(); // create new board, connectfour game, and textui output
        ConnectFour game = new ConnectFour();
        TextUI output = new TextUI();

        int input = 0; // declare and initialize variables for input and file name
        String fileName = "";

        output.printGameStart(output); // print game start
        input = output.getUserInput(); // get user input

        if (input == 2) { // if input is 2
            fileName = output.getFileName(); // get file name
            FileReader fr = new FileReader(fileName); // create file reader

            try {
                board = fr.readBoard(); // read the board 
            } catch (Exception e) { // throw exception for incorrect file reading
                output.printInputError(); // print error message
                board = new Board();  // create new empty board for error case
            }
            output.gameLoop(board, game, output); // initiate game loop
        } else if (input == 1) { // else, if input is 1
            output.gameLoop(board, game, output); // loop through a new game
        } else {
            output.printInputError(); // else, print invalid input
            output.gameLoop(board, game, output); // initiate game loop
        }

    }
}