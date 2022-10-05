import java.io.*;
import java.awt.Color;
import junit.framework.*;

public class TestGhostMove extends TestCase {

  public void testGhostMove() throws FileNotFoundException {
    System.out.println("Testing Ghost move(): ");
    NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

    // Ghost moves freely
    System.out.println("Asserting Ghost Moves");
    Ghost test1 = frame.addGhost(new Location(1, 1), "test1", Color.red);
    Location oldLoc = test1.myLoc;
    test1.move();
    Location newLoc = test1.myLoc;
    assertTrue(oldLoc.x != newLoc.x || oldLoc.y != newLoc.y);
  }
}
