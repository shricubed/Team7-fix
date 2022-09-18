import java.util.ArrayList;
import javax.swing.JComponent;
import java.util.HashSet;

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
