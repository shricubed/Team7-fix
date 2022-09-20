import java.util.ArrayList;
import java.util.HashMap;

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
    return null;
  }

  public boolean move() {
    return false;
  }

  public boolean is_pacman_in_range() {
    HashMap<String, Location> h = myMap.getLocations();
    for (String str : h.keySet()){
      if(str == "pacman") {
        Location pacmanLoc = h.get(str);
        if(pacmanLoc.x == myLoc.x && pacmanLoc.y == myLoc.y+1){
          return true;
        }
        if(pacmanLoc.x == myLoc.x && pacmanLoc.y == myLoc.y-1){
          return true;
        }
        if(pacmanLoc.x == myLoc.x+1 && pacmanLoc.y == myLoc.y){
          return true;
        }
        if(pacmanLoc.x == myLoc.x-1 && pacmanLoc.y == myLoc.y){
          return true;
        }
      }
    }
    return false;
  }

  public boolean attack() {
    return false;
  }
}
