import java.util.ArrayList;
import javax.swing.JComponent;

import java.util.HashSet;
import java.util.Random;

public class PacMan {
  String myName;
  Location myLoc;
  Map myMap;
  Location shift;

  public PacMan(String name, Location loc, Map map) {
    this.myLoc = loc;
    this.myName = name;
    this.myMap = map;
  }

  public ArrayList<Location> get_valid_moves() {
	  ArrayList<Location> moves = new ArrayList<Location>();
	  moves.add(new Location(myLoc.x, myLoc.y + 1)); //UP
	  moves.add(new Location(myLoc.x, myLoc.y - 1)); //DOWN
	  moves.add(new Location(myLoc.x - 1, myLoc.y)); //LEFT
	  moves.add(new Location(myLoc.x + 1, myLoc.y)); //RIGHT

	  ArrayList<Location> valid_moves = new ArrayList<Location>();
	  for (Location loc : moves) {
		  if (((myMap.getLoc(loc).contains(Map.Type.EMPTY)|| 
				  myMap.getLoc(loc).contains(Map.Type.COOKIE) ||
				  myMap.getLoc(loc).contains(Map.Type.GHOST)) &&
				  !myMap.getLoc(loc).contains(Map.Type.WALL)) || 
          myMap.getLoc(loc).size() == 1 && myMap.getLoc(loc).contains(Map.Type.PACMAN)) {
			  valid_moves.add(loc);
		  }
	  }
	  
	  return valid_moves;
  }

  public boolean move() {
    // Randomly selects a move from the valid moves and executes them
    int randomNum; 
    Random rand = new Random();
    ArrayList<Location> moves = get_valid_moves();

    if (!moves.isEmpty()) {
        int size = moves.size();
        if (size != 1) {
          randomNum = rand.nextInt(size);
        }
        else {
          randomNum = 0;
        }
        this.myLoc = moves.get(randomNum);
        this.myMap.move(this.myName, this.myLoc, Map.Type.PACMAN);
        return true;
    }

    return false;
  }

  public boolean is_ghost_in_range() {
    ArrayList<Location> checkAround = new ArrayList<>();

    checkAround.add(new Location(myLoc.x+1, myLoc.y));
    checkAround.add(new Location(myLoc.x-1, myLoc.y));
    checkAround.add(new Location(myLoc.x, myLoc.y+1));
    checkAround.add(new Location(myLoc.x, myLoc.y-1));

    for(Location loc : checkAround){
      if (myMap.getField().get(loc).contains(Map.Type.GHOST)){
        return true;
      };
    }
    return false;
  }

  public JComponent consume() {

    /*Check if there is a cookie at pacman's location
     * if there is, call Map.eatCookie and return the result
     * getLoc() can get us the elements at our location.
     */
    //set of other components at pacmans location
    HashSet<Map.Type> other_comp = myMap.getLoc(myLoc);
    if(other_comp.contains(Map.Type.COOKIE)){
      //checking to make sure a cookie is at the current location
      return myMap.eatCookie(myName);
    }else{
      return null;
    }
  }
}
