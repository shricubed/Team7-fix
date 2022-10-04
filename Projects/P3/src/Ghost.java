import java.util.ArrayList;
import java.util.HashSet;

//This is a test comment
public class Ghost {
  String myName;
  Location myLoc;
  Map myMap;

  public Ghost(String name, Location loc, Map map) {
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
		  if ((myMap.getLoc(loc).contains(Map.Type.EMPTY)
				  || myMap.getLoc(loc).contains(Map.Type.COOKIE)
				  || myMap.getLoc(loc).contains(Map.Type.PACMAN)
				  || myMap.getLoc(loc).contains(Map.Type.GHOST)) &&
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
        this.myMap.move(this.myName, this.myLoc, Map.Type.GHOST);
        return true;
      }
      else { // Move down
        shiftX = this.myLoc.x - moves.get(0).x;
        shiftY = this.myLoc.y - moves.get(0).y;
        Location other = new Location(shiftX, shiftY);
        this.myLoc = other.unshift(this.myLoc);
      }
      this.myMap.move(this.myName, this.myLoc, Map.Type.GHOST);
      return true;
    }
    
    return false;
  }

  public boolean is_pacman_in_range() {
    HashSet<Map.Type> type;
    ArrayList<Location> checkAround = new ArrayList<>();

    checkAround.add(new Location(myLoc.x+1, myLoc.y));
    checkAround.add(new Location(myLoc.x-1, myLoc.y));
    checkAround.add(new Location(myLoc.x, myLoc.y+1));
    checkAround.add(new Location(myLoc.x, myLoc.y-1));

    for(Location loc : checkAround){
      type = myMap.getField().get(loc);
      if (type == null) {
        return false;
      }
      if (type.contains(Map.Type.PACMAN)){
        return true;
      }
    }
    return false;
  }

  public boolean attack() {
    /* check if pacman is in range of ghost with the is_pacman_in_range function
     * if so, call the map attack method on pacman and return true
     * else return false
     */

     //myMap.attack expects the name of a ghost, and returns true if successful
    if(is_pacman_in_range()){
      return myMap.attack(myName);
    }else{
      return false;
    }
  }
}
