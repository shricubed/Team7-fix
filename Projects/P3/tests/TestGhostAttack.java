import java.io.*;
import java.util.HashSet;

import javax.swing.JComponent;
import java.awt.Color;

import junit.framework.*;

public class TestGhostAttack extends TestCase {

  public void testAttack() throws FileNotFoundException {
    NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

    //Ghost ghost = frame.addGhost(new Location(1, 1), "name", Color.red); //Creates a red ghost named "name" at location x,y
    PacMan pacman = frame.addPacMan(new Location(2, 3)); //Creates PacMan at location x, y 2,3 is a cookie so is 2,3
    Ghost test = frame.addGhost(new Location(2, 3), "test", Color.red);
    HashSet<Map.Type> loc_items = frame.getMap().getLoc(new Location(2, 3));
    HashSet<Map.Type> expected = new HashSet<Map.Type>();
    expected.add(Map.Type.COOKIE);
    expected.add(Map.Type.PACMAN);
    //expected.add(Map.Type.GHOST);
    System.out.println("Asserting that pacman and cookie and ghost are present at location");
    assertEquals(loc_items, expected);
    JComponent temp = pacman.consume();
    System.out.println("Asserting that cookie was consumed");
    assertNotNull(temp); //temp should be a consumed cookie
    System.out.println("Asserting that cookies count is updated");
    assertEquals(frame.getMap().getCookies(), 1);
    boolean result = test.attack();
    System.out.println("Asserting that pacman was attacked by the ghost");
    assertTrue(result);
    HashSet<Map.Type> after_consume = frame.getMap().getLoc(new Location(2, 3));
    expected = new HashSet<Map.Type>();
    expected.add(Map.Type.PACMAN);
    System.out.println("Asserting that old cookie was removed from the current location");
    assertEquals(after_consume, expected);
    System.out.println(frame.getMap().isGameOver());
  }
}
