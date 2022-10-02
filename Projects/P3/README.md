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

## Functions

### PacMan Class

#### get_valid_moves()
- 
- 

#### move()
- Used the `get_valid_moves` function to find all the possible moves for the PacMan and proceeded to chose the first move available. Found the difference between the location to move and used the Location classes `shift` or `unshift` methods to change the location of the PacMan. Finally, updated the PacMan's location on the Map with the `move` function and returned true. If no valid moves existed, returned false.
- 

#### is_ghost_in_range()
- 
- 

#### consume()
- 
- 

### Ghost Class

#### get_valid_moves()
- 
- 

#### move()
-  Used the `get_valid_moves` function to find all the possible moves for the Ghost and proceeded to chose the first move available. Found the difference between the location to move and used the Location classes `shift` or `unshift` methods to change the location of the Ghost. Finally, updated the Ghost's location on the Map with the `move` function and returned true. If no valid moves existed, returned false.
- 

#### is_pacman_in_range()
- 
- 

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
- 
- 

#### eatCookie(String name)
- 
- 
