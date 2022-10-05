import java.awt.Color;
import java.io.*;
import junit.framework.*;
import java.util.*;

public class TestGhostInRange extends TestCase {

  public void testGhostInRange() throws FileNotFoundException {
    System.out.println("Testing pacman isGhostInRange()");
    NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

    Ghost ghost = frame.addGhost(new Location(1, 1), "name", Color.RED); //Creates a red ghost named "name" at location x,y
    PacMan pacman = frame.addPacMan(new Location(2, 1)); //Creates PacMan at location x, y

    System.out.println("Asserting that ghost is in range when locations are set and is known to be in range");
    Boolean result = pacman.is_ghost_in_range();
    assertEquals(result, true);

    Map map = frame.getMap();
    ArrayList<Location> validMoves = pacman.get_valid_moves();
    Random random = new Random();
    int r = random.nextInt(validMoves.size());
    map.move(pacman.myName, validMoves.get(r), Map.Type.PACMAN);

    Boolean result2 = pacman.is_ghost_in_range();
    Boolean actualGhost = false;
    ArrayList<Location> checkAround = new ArrayList<>();

    checkAround.add(new Location(pacman.myLoc.x+1, pacman.myLoc.y));
    checkAround.add(new Location(pacman.myLoc.x-1, pacman.myLoc.y));
    checkAround.add(new Location(pacman.myLoc.x, pacman.myLoc.y+1));
    checkAround.add(new Location(pacman.myLoc.x, pacman.myLoc.y-1));

    for(Location loc : checkAround){
      if (pacman.myMap.getField().get(loc).contains(Map.Type.GHOST)){
        actualGhost = true;
      };
    }
    assertEquals(result, actualGhost);
  }
}
