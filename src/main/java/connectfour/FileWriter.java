package connectfour;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Uzair Rafi
 * Description: Class that writes board contents to a file
 */

public class FileWriter {
    private Path path;

    /**
     * method to set path to assets folder
     * @param fileName
     */

    public FileWriter(String fileName) {
        path = FileSystems.getDefault().getPath("assets", fileName);
    }

    /**
     * method to write board contents to a file
     * @param b
     */

    public void writeLinesToFile(Board b) {

        int[][] boardToSave = new int[6][7]; // create new 2d array for board to save

        boardToSave = b.getBoard(); // get board and store it to the board to save

        String boardString = "";

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {

                if (boardToSave[i][j] == 82) { // if board at i and j contains 82
                    boardString += "1"; // set boardString to 1
                } else if (boardToSave[i][j] == 66) { // else if board contains 66
                    boardString += "2"; // set boardString to 2
                } else {
                    boardString += boardToSave[i][j]; // else, set board string to the element
                }

                if (j < 6) { // print commas between numbers after 1st column till 6th column
                    boardString += ",";
                }
            }

            if (i < 5) { // print borders between each row after 1st till 5th row
                boardString += "\n";
            }
        }

        try {
            Files.writeString(path, boardString); // write the board string to the file at path
        } catch (IOException e) { // catch IOException
            System.out.println("Error writing board to the file!"); // print error message
        }
    }

}
