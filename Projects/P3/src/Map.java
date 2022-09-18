import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JComponent;

public class Map {

  public enum Type {
    EMPTY,
    PACMAN,
    GHOST,
    WALL,
    COOKIE
  }

  private HashMap<Location, HashSet<Type>> field;
  private boolean gameOver;
  private int dim;

  private HashMap<String, Location> locations;
  private HashMap<String, JComponent> components;
  private HashSet<Type> emptySet;
  private HashSet<Type> wallSet;

  private int cookies = 0;

  public Map(int dim) {
    gameOver = false;
    locations = new HashMap<String, Location>();
    components = new HashMap<String, JComponent>();
    field = new HashMap<Location, HashSet<Type>>();

    emptySet = new HashSet<Type>();
    wallSet = new HashSet<Type>();
    emptySet.add(Type.EMPTY);
    wallSet.add(Type.WALL);
    this.dim = dim;
  }

  public void add(String name, Location loc, JComponent comp, Type type) {
    locations.put(name, loc);
    components.put(name, comp);
    if (!field.containsKey(loc)) field.put(loc, new HashSet<Type>());
    field.get(loc).add(type);
  }

  public int getCookies() {
    return cookies;
  }

  public boolean isGameOver() {
    return gameOver;
  }

  public boolean move(String name, Location loc, Type type) {
    // update locations, components, and field
    // use the setLocation method for the component to move it to the new location
    return false;
  }

  public HashSet<Type> getLoc(Location loc) {
    // wallSet and emptySet will help you write this method
    return null;
  }

  public boolean attack(String Name) {
    // update gameOver
    return false;
  }

  public JComponent eatCookie(String name) {
    // update locations, components, field, and cookies
    // the id for a cookie at (10, 1) is tok_x10_y1, id is a string

    /* grabs pacmans current location by referencing name from locations hashmap
     * checks if there is also a cookie at that location, by using the location grabbed
     * and checking the fields hashmap, one coordinate could lead to multiple types
     * ex, field.get(Loc(10, 4)) could return {PACMAN, COOKIE, GHOST} 
     * if a cookie exists here, remove it from that field
     * and return the cookie that was eaten
     * also update display?
     * 
     */
    
    //pacman location
    Location pac_man_loc = locations.get(name);
    //getting other components at that locations
    HashSet<Type> other_comp = field.get(pac_man_loc);

    if(other_comp.contains(Type.COOKIE) && other_comp.contains(Type.PACMAN)){
      //making sure there is a cookie, and pacman at this location
      String cookie_name = "tok_x" + pac_man_loc.x + "_y" + pac_man_loc.y;
      //removing the cookie from locations
      locations.remove(cookie_name);
      //storing return value of cookie eaten
      JComponent eaten_cookie =  components.get(cookie_name);
      //removing cookie from components
      components.remove(cookie_name);
      //removing cookie enum from field
      field.get(pac_man_loc).remove(Type.COOKIE);
      //incrementing cookies eaten
      cookies += 1;
      //simply return the cookie now
      return eaten_cookie;
    }else{
      //no cookie here
      return null;
    }
  }
}
