# PacMan Project

## Group Members:
1. Ankit Patel
2. Aadil Shekh
3. Roshan Shet
4. Joshua Wyatt

## PacMan Game 
<img width="603" alt="Screen Shot 2022-10-05 at 5 37 46 PM" src="https://user-images.githubusercontent.com/84682338/194168824-c7fd6365-64f0-41ee-b9b9-978a6ac2f07a.png">


## Running the Code
To run the code, make sure you are in the P3 directory only. Then type in the commands below. The first one command will compile all the source files and the second command will run the StartMenu java program which will open up the PacMan games interface.
```
javac -cp "src/" src/*.java
java -cp "src/" StartMenu
```

## Testing the code
Navigate to the following link <https://github.com/junit-team/junit4/wiki/Download-and-Install>.
Download the Junit.jar and the hamcrest.jar, and move both of these files into the "test" directory.

Compile and run the tests with
```
javac -cp "tests/*:src/:tests/" src/*.java tests/your_test.java
java -cp "tests/*:src/:tests/" org.junit.runner.JUnitCore your_test
```

## Functions

### PacMan Class

#### get_valid_moves()
- Created four new locations: UP, DOWN, LEFT, and RIGHT. For each location, checked if the location was empty or contained a cookie or ghost and checked to make sure the location did not contain a wall.
- If the check passed, the location is valid and is added to the list of valid locations that is returned at the end of the function.

#### move()
- Used the `get_valid_moves` function to find all the possible moves for the PacMan and proceeded to chose the first move available. Used a random number generator from zero to the size of moves array returned from `get_valid_moves` to choose a random location to move if there was more than one. Set the PacMans location to the new location chosen. Finally, updated the PacMan's location on the Map with the `move` function and returned true. If no valid moves existed, returned false.
- Tested that the PacMan can move freely without any Ghosts nearby. Then added ghosts around PacMan to move near them as well. Finally, ensured that PacMans current location isn't the same as old location. 

#### is_ghost_in_range()
- Inserted all of the possible movement locations (1 space up, down, left, or right) into an `Arraylist` and went through that list of adjacent locations to see if any contained a Ghost. If any of them did, then return true, otherwise return false.
- To test this I first placed PacMan and the Ghost in specific locations where I knew the ghost was in range. Then I moved PacMan randomly and checked to see if it was still in range of the ghost or not by checking its adjacent spaces. Then I compared that result to the one returned by the `is_ghost_in_range()` function.

#### consume()
- Consume first checks if there is a cookie at Pacman's current location by referencing myMap.getLoc(myLoc). If this location contains a cookie to be consumed, this function calls myMap.eatCookie(pacman_name), and the eaten cookie is returned. If there is no valid cookie at this location, simply return null.
- To test this function, I first placed PacMan in specific locations that already had cookies at them. I next called pacman.consume() and verified that the cookie was 'eaten' and returned to the test. Further testing was also done to test calling pacman.consume at a location without a cookie to ensure that null was being returned correctly.

### Ghost Class

#### get_valid_moves()
- Identical to the function get_valid_moves() for the Pacman class. Each of the four locations are checked.
- If a location is valid, it is added to the list of valid locations returned at the end of the function.

#### move()
-  Used the `get_valid_moves` function to find all the possible moves for the PacMan and proceeded to chose the first move available. Used a random number generator from zero to the size of moves array returned from `get_valid_moves` to choose a random location to move if there was more than one. Set the Ghosts location to the new location chosen. Finally, updated the Ghosts location on the Map with the `move` function and returned true. If no valid moves existed, returned false.
- Ghosts can move anywhere without any restrcitions so just moved the Ghost and checked to ensure its Location is not the same as before calling `move`.

#### is_pacman_in_range()
- Inserted all of the possible movement locations (1 space up, down, left, or right) into an `Arraylist` and went through that list of adjacent locations to see if any contained PacMan. If any of them did, then return true, otherwise return false.
- To test this I first placed PacMan and the Ghost in specific locations where I knew that PacMan was in range. Then I moved the Ghost randomly and checked to see if it was still in range of PacMan or not by checking its adjacent spaces. Then I compared that result to the one returned by the `is_pacman_in_range()` function.

#### attack()
- This function checks if pacman is in range of the ghost by calling the is_pacman_in_range() function. If pacman is in range, we call myMap.attack(ghost_name) and we return true, else we return false. 
- This function was tested by placing pacman one space away from the ghost and executing ghost.attack(). We assert that this returns true, and also assert that the game is now considered over. We also test by placing pacman jsut out of range of the ghost and then calling ghost.attack(), we assert that this returns false.

### Map Class

#### move(String name, Location loc, Type type)
- The function begins by retrieving a hashset of types at the given location using the getLoc() function.
- If the type passed is Pacman and the location contains pacman or a wall, false is returned, because Pacman can't freeze or move through walls.
- If the type passed is Ghost and the location contains a wall, false is returned, because ghosts can't move through walls.
- If false isn't returned, the component's location is updated by calling setLocation() on its component.
- Next, the field hashmap is updated. The type is removed from its old location and placed in its new location.
- Finally, the locations hashmap is updated.

#### getLoc(Location loc)
- Used the field HashMap to get what is at the given location loc. If it returns null, it means that it is out of bounds which would return the wallSet or the other Types.
- Checked if PacMan, Ghost, and Cookie were in their respectable locations after adding them to the frame. Called the function using an out of bounds location to ensure it returns the wall set and had PacMan eat a cookie and then move to another location. Then called getLoc on the old location where the cookie used to exist to ensure that it returns the empty set. 

#### attack(String name)
- Inserted all of the adjacent locations into an Arraylist and passed each element into a helper function `attackHelper (HashSet<Type> direction, Location ghostLoc)`. This helper would then check if any adjacent direction contains PacMan and replaces PacMan with the Ghost at that location and ends the game.
- Tested this by placing PacMan and the Ghost in adjacent locations where I knew the Ghost could attack PacMan. Then I called this `attack()` function and ensured it returned true and also checked to make sure that `gameOver` was set to true.

#### eatCookie(String name)
- eatCookie takes a given name of a pacman object, and handles all of the work associated with removing a cookie from the game. First, this function checks to make sure a cookie exists at the location that pacman is currently at. If a cookie exists here, we remove this cookie object from the Locations HashMap, we grab the JComponent object from the components HashMap, and then remove the cookie from components. Next, the EMPTY enum is added to that location, and the COOKIE enum is removed from that location, and finally the cookie count is incremented. The JComponent Cookie that was grabbed from the components HashMap is then returned.
- This was tested in combination with pacman.consume() since pacman.consume() calls this function to function correctly. First we place pacman at a location where there is a cookie, we have pacman eat the cookie, and then inspect the location. This location should go from [COOKIE PACMAN] to [PACMAN EMPTY]. We also assert that the cookie object was returned correctly, and that cookie count was updated.
