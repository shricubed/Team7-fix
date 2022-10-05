import java.io.*;
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

    // PacMan cannot move
    System.out.println("Asserting PacMan cannot move");
    Ghost test1 = frame.addGhost(new Location(1, 1), "test1", Color.red);
    Ghost test2 = frame.addGhost(new Location(3, 1), "test2", Color.blue);
    Ghost test3 = frame.addGhost(new Location(2, 2), "test3", Color.yellow);
    assertFalse(pacman.move());
  }
}
