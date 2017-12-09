# Find The Pairs

**Authors:** Lisa Huang (rhuang2), Huihan Li (hli3) and Tina Zhang (yzhang16)

**Date:** 11/20/2017

## Description

**Find The Pairs** is a memory game that requires users to flip the cards with pictures underneath and find pairs of identical pictures within as few clicks as possible. Each flip will last a couple of seconds and then flip back.

## User's Manual
There are **three** levels of difficulty, with **8-pairs, 12-pairs, and 16-pairs** to delete. In each game, you need to select difficulty first in a combo box, and press “Start” button to start the game. At the start of the game, the user has 3 seconds to memorize the location of the pairs. Afterwards, the pictures will turn around. When the user clicks on two pictures, they must form a pair to disappear. Otherwise, the pictures remain.

There is also a counter that keeps track of how many tries the user made and how many pairs he/she has deleted.

When all pairs are deleted, we give a message that congratulates the user for being smart.

If the user wants to play another game, he/she needs to choose the level and press “Start”.

## Technical Report
### ADTs
We have one **array** that stores all the **Picture** objects that we might use in the game.

We also use a **two-dimension array** (Picture[] []) to store the Picture objects in one game panel. Because the panel is of fixed size and layout, it is very efficient to point to one object in an array.

### Classes
Each picture is a unique **Picture** object, with an image of certain size and an index (ID).

We have a **Game** class, which stores the array of Picture objects and the two-d array of game board. It also  keeps track of the moves that the person has taken and how many pairs he/she found. It Implements the game of “find the pairs”. Just the functionality. It is meant to work together with a GUI program.

**GamePanel** class:  Sets up the Panel that contains the  game. Use the grid layout. It communicates with the Game.java class where the functionality of the game resides.

**FindthePairsPanel**  class:  Contains the GamePanel class. Use the box layout. Create the label and counter on the left of the panel. 

**FindthePairsGUI** Class:  Sets up the GUI for the FindthePairs game. Contains main method.


### Main Actions
**Game.Constructor**: randomly arranges the Picture objects in two-d array.

**Game.selectOnePair()**: the user clicks on two Picture objects and the deletes them if they are the same

**Game.countTries()**: Increases when the user makes one try.

**Game.countSuccess()**: Increase when the user successfully deletes one pair and check if the game is over. 

**Game.setDifficulty()**: Determines how many pairs the user needs to delete and change the layout of the game board.

## Example
![](https://lh6.googleusercontent.com/6AImMOjhpRHI_QFKr2T7w0LW0X5J5a213Ba7vzLefgeosJ5sgbC1aTva-40kMBlStpMouBlJt_P1GkIcRqCX6cr_D6g86fCj6xMJvmOZV9HX128OzupSRfmda78-IPg-w57AOcA)
![](https://lh3.googleusercontent.com/5h67xOXFuu9VE_IIh6eaVnOnL7XPnFN8UQLkqoGrh_Vp_WL9kI4enf9KJLjOnPhNeDs8P5wO98LaXoQuLFjfrDjoHB4U3RglVvCR87P5xSWPZHhkkllDlxnFAQHW6VZVC18en3w)
![](https://lh6.googleusercontent.com/plYYm211wlq5pFUm_Mopv-_cuyjKylT0m7m4ca8tx2Ets5XnjmU2Ir5TEuFK-nOUWpAjGXkx0L7yeKqTvFo-YEaldjApFA8moRS9wP7eU8UOxejgjvRaw1mms0Ed3ZODlFNUdkM)