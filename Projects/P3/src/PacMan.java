import java.util.ArrayList;
import javax.swing.JComponent;
import java.util.Random;


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
         this.myMap.move(this.myName, this.myLoc, Map.Type.PACMAN);
         return true;
     }
 
     return false;
  }

  public boolean is_ghost_in_range() {
    return false;
  }

  public JComponent consume() {
    return null;
  }
}
