import java.util.ArrayList;
import javax.swing.JComponent;

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
    return false;
  }

  public boolean is_ghost_in_range() {
    return false;
  }

  public JComponent consume() {
    return null;
  }
}
