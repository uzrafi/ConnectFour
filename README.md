# Project Title

Two-player ConnectFour Game

## Description

The program functions as a two-player Connect Four game, with Red and Blue pieces being represented as 'R' and 'B' on the board, and empty spaces being represented with a '0'. The program utilizes 5 classes: Board, ConnectFour, FileReader, FileWriter, and TextUI. Board contains the altering of the board itself and handles where each piece is placed. It also contains the various win conditions and tie condition, and has a string representation of the board in a toString method as well. The ConnectFour class handles which players turn it is, and tells TextUI what to print based on updating a game state variable. The game state is changed based on if a tie or win is found on the board. The FileReader and FileWriter classes handle file reading and writing respectively, and can save a boards contents to a file, or read a board from a file. TextUI contains every print statement of the game, and prints the string representation of the board. It handles the gameplay loop and contains the main method, which allows the game to be played from scratch, or from a preexisting game that can be loaded from a file.

## Getting Started

### Dependencies

* No dependencies


### Executing program

* How to build and run the program
* Step-by-step bullets:

1. cd to the A2 directory
```
cd A2
```

2. build the program
```
gradle build
```

3. run the program
```
gradle run
```

4. execute the program 
```
java -cp build/classes/java/main connectfour.TextUI
```
* expected output:

```
Welcome to Connect Four! R will move first.
Enter 1 to start a new game, or 2 to load an existing game from a file

1
```

```
0|0|0|0|0|0|0
-+-+-+-+-+-+-
0|0|0|0|0|0|0
-+-+-+-+-+-+-
0|0|0|0|0|0|0
-+-+-+-+-+-+-
0|0|0|0|0|0|0
-+-+-+-+-+-+-
0|0|0|0|0|0|0
-+-+-+-+-+-+-
0|0|0|0|0|0|0

Enter a column between 0 and 6, or enter 7 to save the game to a file. (Turn = R)
```

## Limitations

No functionalities of the program are incomplete or cause errors. 

## Author Information

Name: Uzair Rafi

Email: urafi@uoguelph.ca

## Development History

* 0.1
    * Initial Release

## Acknowledgments

Inspiration, code snippets, etc.
* [awesome-readme](https://github.com/matiassingers/awesome-readme)
* [simple-readme] (https://gist.githubusercontent.com/DomPizzie/7a5ff55ffa9081f2de27c315f5018afc/raw/d59043abbb123089ad6602aba571121b71d91d7f/README-Template.md)



