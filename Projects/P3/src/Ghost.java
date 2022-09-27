import java.util.ArrayList;
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
      }
      else { // Move down
        shiftX = this.myLoc.x - moves.get(0).x;
        shiftY = this.myLoc.y - moves.get(0).y;
        Location other = new Location(shiftX, shiftY);
        this.myLoc = other.unshift(this.myLoc);
      }

      return true;
    }
    
    return false;
  }

  public boolean is_pacman_in_range() {
    return false;
  }

  public boolean attack() {
    return false;
  }
}
