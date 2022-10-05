import java.io.*;

import static org.junit.Assert.assertNotEquals;

import java.awt.Color;
import junit.framework.*;

public class TestPacManMove extends TestCase {

  public void testPacManMove() throws FileNotFoundException {
    System.out.println("Testing Pacman move(): ");
    NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

    // PacMan moves freely
    System.out.println("Asserting Pacman Moves");
    PacMan pacman = frame.addPacMan(new Location(2, 1));
    Location oldLoc = pacman.myLoc;
    pacman.move();
    Location newLoc = pacman.myLoc;
    assertTrue(oldLoc.x != newLoc.x || oldLoc.y != newLoc.y);
    oldLoc = pacman.myLoc;
    // PacMan can still move
    System.out.println("Asserting PacMan can move");
    Ghost test1 = frame.addGhost(new Location(1, 1), "test1", Color.red);
    Ghost test2 = frame.addGhost(new Location(3, 1), "test2", Color.blue);
    Ghost test3 = frame.addGhost(new Location(2, 2), "test3", Color.yellow);
    assertTrue(pacman.move());
    System.out.println("Asserting that location changed");
    assertNotEquals(oldLoc, pacman.myLoc);
  }
}
