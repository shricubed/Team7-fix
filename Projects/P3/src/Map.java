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
	  
	HashSet<Type> types = getLoc(loc);

	if (type == Map.Type.PACMAN) {
		if (types.contains(Map.Type.PACMAN) || types.contains(Map.Type.WALL))
			return false;
		
		PacManComponent pacman = (PacManComponent) components.get(name);
		pacman.setLocation(loc.x, loc.y);
	} else if (type == Map.Type.GHOST) {
		if (types.contains(Map.Type.WALL))
			return false;
		
		GhostComponent ghost = (GhostComponent) components.get(name);
		ghost.setLocation(loc.x, loc.y);
	}

  field.get(locations.get(name)).remove(type); //removing type from old position
	locations.remove(name);
	locations.put(name, loc);
  field.get(loc).add(type);//updating field with type
	//types.add(type);
  
	
    return true;
  }

  public HashSet<Type> getLoc(Location loc) {
    // wallSet and emptySet will help you write this method
    HashSet<Type> move = field.get(loc);
    if (move == null || move.contains(Map.Type.WALL)) { // Out of bounds case
      return wallSet;
    }
    else if (move.contains(Map.Type.EMPTY)) { // Empty case
      return emptySet;
    }
    else {
      return move;
    }
  }

  public boolean attackHelper (HashSet<Type> direction, Location ghostLoc) {
    if(direction.contains(Type.PACMAN)){
      field.get(ghostLoc).remove(Type.GHOST);
      direction.remove(Type.PACMAN);
      direction.add(Type.GHOST);
      return true;
    }
    return false;
  }

  public boolean attack(String Name) {
    // update gameOver
    Location ghostLoc = locations.get(Name);
    
    HashSet<Type> up = field.get(new Location(ghostLoc.x, ghostLoc.y+1));
    HashSet<Type> down = field.get(new Location(ghostLoc.x, ghostLoc.y-1));
    HashSet<Type> left = field.get(new Location(ghostLoc.x-1, ghostLoc.y));
    HashSet<Type> right = field.get(new Location(ghostLoc.x+1, ghostLoc.y));

    if(attackHelper(up, ghostLoc) || attackHelper(down, ghostLoc) || attackHelper(left, ghostLoc) || attackHelper(right, ghostLoc)) {
      return true;
    }
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
      //incrementing cookies eaten
      cookies += 1;
      //simply return the cookie now
      return eaten_cookie;
    }else{
      //no cookie here
      return null;
    }
  }

  public HashMap<Location, HashSet<Type>> getField(){
    return field;
  }
}
 