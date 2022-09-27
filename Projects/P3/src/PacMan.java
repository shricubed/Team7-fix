import java.util.ArrayList;
import javax.swing.JComponent;

import java.util.HashSet;
import java.util.HashMap;



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
		  if (myMap.getLoc(loc).contains(Map.Type.EMPTY) &&
				  !myMap.getLoc(loc).contains(Map.Type.WALL)) {
			  valid_moves.add(loc);
		  }
	  }
	  
	  return valid_moves;
  }

  public boolean move() {
    int shiftX, shiftY; // Represents amount of shift 
    ArrayList<Location> moves = get_valid_moves();

    if (!moves.isEmpty()) {
      if (moves.get(0).x >= this.myLoc.x) { // Move up
        if (moves.get(0).x == this.myLoc.x && moves.get(0).y < this.myLoc.y) { // Turn left
          shiftX = 0;
          shiftY = this.myLoc.y - moves.get(0).y;
          Location other = new Location(shiftX, shiftY);
          this.myLoc = other.unshift(this.myLoc);
        }
        else { // Go up or turn right
          shiftX = moves.get(0).x - this.myLoc.x;
          shiftY = moves.get(0).y - this.myLoc.y;
          this.myLoc = this.myLoc.shift(shiftX, shiftY);
        }
      }
      else { // Move down
        shiftX = this.myLoc.x - moves.get(0).x;
        shiftY = this.myLoc.y - moves.get(0).y;
        Location other = new Location(shiftX, shiftY);
        this.myLoc = other.unshift(this.myLoc);
      }

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
