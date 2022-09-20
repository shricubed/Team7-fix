import java.util.ArrayList;
import javax.swing.JComponent;
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
    return null;
  }

  public boolean move() {
    return false;
  }

  public boolean is_ghost_in_range() {
    HashMap<String, Location> h = myMap.getLocations();
    for (String str : h.keySet()){
      if(str == "ghost") {
        Location ghostLoc = h.get(str);
        if(ghostLoc.x == myLoc.x && ghostLoc.y == myLoc.y+1){
          return true;
        }
        if(ghostLoc.x == myLoc.x && ghostLoc.y == myLoc.y-1){
          return true;
        }
        if(ghostLoc.x == myLoc.x+1 && ghostLoc.y == myLoc.y){
          return true;
        }
        if(ghostLoc.x == myLoc.x-1 && ghostLoc.y == myLoc.y){
          return true;
        }
      }
    }
    return false;
  }

  public JComponent consume() {
    return null;
  }
}
