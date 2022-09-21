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
    return null;
  }

  public boolean move() {
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
    return null;
  }
}
