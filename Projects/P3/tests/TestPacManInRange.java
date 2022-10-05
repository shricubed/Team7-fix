import java.awt.Color;
import java.io.*;
import junit.framework.*;
import java.util.*;

public class TestPacManInRange extends TestCase {

  public void testPacManInRange() throws FileNotFoundException {
    System.out.println("Testing ghost isPacManInRange()");
    NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

    Ghost ghost = frame.addGhost(new Location(2, 1), "name", Color.RED); //Creates a red ghost named "name" at location x,y
    PacMan pacman = frame.addPacMan(new Location(1, 1)); //Creates PacMan at location x, y

    System.out.println("Asserting that pacman is in range when locations are set and is known to be in range");
    boolean result = ghost.is_pacman_in_range();
    assertEquals(result, true);

    Map map = frame.getMap();
    ArrayList<Location> validMoves = ghost.get_valid_moves();
    Random random = new Random();
    int r = random.nextInt(validMoves.size());
    map.move(ghost.myName, validMoves.get(r), Map.Type.GHOST);

    boolean result2 = ghost.is_pacman_in_range();
    boolean actualPacMan = false;
    ArrayList<Location> checkAround = new ArrayList<>();

    checkAround.add(new Location(ghost.myLoc.x+1, ghost.myLoc.y));
    checkAround.add(new Location(ghost.myLoc.x-1, ghost.myLoc.y));
    checkAround.add(new Location(ghost.myLoc.x, ghost.myLoc.y+1));
    checkAround.add(new Location(ghost.myLoc.x, ghost.myLoc.y-1));

    for(Location loc : checkAround){
      if (pacman.myMap.getField().get(loc).contains(Map.Type.PACMAN)){
        actualPacMan = true;
      };
    }
    assertEquals(result, actualPacMan);
  }
}
