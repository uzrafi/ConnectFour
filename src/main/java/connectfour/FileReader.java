package connectfour;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.StringTokenizer;

/**
 * @author Uzair Rafi
 * Description: Class that reads a file and puts file content into a board
 */

public class FileReader {

    private Path path;

    public FileReader(String fileName) {
        path = FileSystems.getDefault().getPath("assets", fileName);
    }

    /**
     * method to read lines of a file
     * @return line
     */

    public String readLines() {
        String line = null; // set line to null
        try {
            line = Files.readString(path); // read string at file
        } catch (IOException e) {
            // do something to handle exception
            System.out.println("Error reading lines in file!"); // print error for file reading
        }
        return line; // return line
    }

    /**
     * method to read a file and tokenize the contents to put them into a board
     * @return boardToRead
     * @throws Exception
     */

    public Board readBoard() throws Exception {

        Board boardToRead = new Board();
        String fileContent = readLines();
        StringTokenizer tokens = new StringTokenizer(fileContent, ",\n"); // tokenize by comma and new line delimmiter

        int boardSpace = 0;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                boardSpace = 0;
                String token = tokens.nextToken().strip(); // create tokenizer, and strip whitespace
                try {
                    boardSpace = Integer.parseInt(token); // parse tokens, and set them to boardSpace
                } catch (NumberFormatException e) { // invalid number in file
                    throw new Exception("Invalid number: " + token);
                }

                if (boardSpace == 1) {
                    boardToRead.setBoard(i, j, 82); // if 1, set board to ASCII of R
                    boardToRead.setTurn();  // add to turn
                } else if (boardSpace == 2) {
                    boardToRead.setBoard(i, j, 66); // else if 2, set board to ASCII of B
                    boardToRead.setTurn(); // add to turn
                } else if (boardSpace == 0) {
                    boardToRead.setBoard(i, j, boardSpace); // else if 0, set board to boardSpace
                } else {
                    throw new Exception("Invalid value in board!"); // else, invalid value in board
                }

            }
        }

        if (tokens.hasMoreTokens()) { // if there are too many tokens
            throw new Exception("Too many values in the board!"); // throw exception
        }

        return boardToRead; // return board to read

    }

}