import java.util.ArrayList;

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
	  ArrayList<Location> list = new ArrayList<Location>();
	  for (int i = -1; i < 2; i++) {
		  for (int j = -1; j < 2; j++) {
			  Location loc = new Location(myLoc.x + i, myLoc.y + j);
			  if ((i != 0 || j != 0) && 
					  (myMap.getLoc(loc).contains(Map.Type.EMPTY) ||
					  myMap.getLoc(loc).contains(Map.Type.GHOST) ||
					  myMap.getLoc(loc).contains(Map.Type.PACMAN))) {
				  list.add(loc);
			  }
		  }
	  }
	  return list;
  }

  public boolean move() {
    return false;
  }

  public boolean is_pacman_in_range() {
    return false;
  }

  public boolean attack() {
    return false;
  }
}
