# PacMan Project

## Group Members:
1. Ankit Patel
2. Aadil Shekh
3. Roshan Shet
4. Joshua Wyatt

## PacMan Game (Image)


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
- 
- 

#### move()
- Used the `get_valid_moves` function to find all the possible moves for the PacMan and proceeded to chose the first move available. Found the difference between the location to move and used the Location classes `shift` or `unshift` methods to change the location of the PacMan. Finally, updated the PacMan's location on the Map with the `move` function and returned true. If no valid moves existed, returned false.
- 

#### is_ghost_in_range()
- Inserted all of the possible movement locations (1 space up, down, left, or right) into an `Arraylist` and went through that list of adjacent locations to see if any contained a Ghost. If any of them did, then return true, otherwise return false.
- To test this I first placed PacMan and the Ghost in specific locations where I knew the ghost was in range. Then I moved PacMan randomly and checked to see if it was still in range of the ghost or not by checking its adjacent spaces. Then I compared that result to the one returned by the `is_ghost_in_range()` function.

#### consume()
- Consume first checks if there is a cookie at Pacman's current location by referencing myMap.getLoc(myLoc). If this location contains a cookie to be consumed, this function calls myMap.eatCookie(pacman_name), and the eaten cookie is returned. If there is no valid cookie at this location, simply return null.
- To test this function, I first placed PacMan in specific locations that already had cookies at them. I next called pacman.consume() and verified that the cookie was 'eaten' and returned to the test. Further testing was also done to test calling pacman.consume at a location without a cookie to ensure that null was being returned correctly.

### Ghost Class

#### get_valid_moves()
- 
- 

#### move()
-  Used the `get_valid_moves` function to find all the possible moves for the Ghost and proceeded to chose the first move available. Found the difference between the location to move and used the Location classes `shift` or `unshift` methods to change the location of the Ghost. Finally, updated the Ghost's location on the Map with the `move` function and returned true. If no valid moves existed, returned false.
- 

#### is_pacman_in_range()
- Inserted all of the possible movement locations (1 space up, down, left, or right) into an `Arraylist` and went through that list of adjacent locations to see if any contained PacMan. If any of them did, then return true, otherwise return false.
- To test this I first placed PacMan and the Ghost in specific locations where I knew that PacMan was in range. Then I moved the Ghost randomly and checked to see if it was still in range of PacMan or not by checking its adjacent spaces. Then I compared that result to the one returned by the `is_pacman_in_range()` function.

#### attack()
- 
- 

### Map Class

#### move(String name, Location loc, Type type)
- 
- 

#### getLoc(Location loc)
- Used the field HashMap to get what is at the given location loc. If it returns null, it means that it is out of bounds which would return the wallSet or the other Types.
- 

#### attack(String name)
- Inserted all of the adjacent locations into an Arraylist and passed each element into a helper function `attackHelper (HashSet<Type> direction, Location ghostLoc)`. This helper would then check if any adjacent direction contains PacMan and replaces PacMan with the Ghost at that location and ends the game.
- 

#### eatCookie(String name)
- 
- 
