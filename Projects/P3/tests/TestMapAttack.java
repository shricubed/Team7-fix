import javax.accessibility.AccessibleAttributeSequence;

import java.awt.Color;
import java.io.*;

import junit.framework.*;
import java.util.*;

public class TestMapAttack extends TestCase {

  public void testMapAttack() throws FileNotFoundException {
    System.out.println("Testing map attack()");
    NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

    Ghost ghost = frame.addGhost(new Location(2, 1), "name", Color.RED); //Creates a red ghost named "name" at location x,y
    PacMan pacman = frame.addPacMan(new Location(1, 1)); //Creates PacMan at location x, y

    Map map = frame.getMap();
    boolean result = map.attack(ghost.myName);
    assertEquals(result, true);
    assertEquals(map.isGameOver(), true);
  }
}
