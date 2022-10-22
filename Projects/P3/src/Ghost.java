import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

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
      // the only restriction on the ghost's movement is a wall
		  if (!myMap.getLoc(loc).contains(Map.Type.WALL)) {
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
