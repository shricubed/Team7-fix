import java.io.*;
import java.util.HashSet;
import java.awt.Color;
import junit.framework.*;

public class TestMapGetLoc extends TestCase {

  public void testMapGetLoc() throws FileNotFoundException {
    System.out.println("Testing Map getLoc(): ");
    HashSet<Map.Type> emptySet = new HashSet<Map.Type>();
    HashSet<Map.Type> wallSet = new HashSet<Map.Type>();

    NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display
    emptySet.add(Map.Type.EMPTY);
    wallSet.add(Map.Type.WALL);

    PacMan pacman = frame.addPacMan(new Location(2, 1));
    Ghost ghost = frame.addGhost(new Location(1, 1), "test1", Color.red);

    HashSet<Map.Type> moves1 = pacman.myMap.getLoc(pacman.myLoc);
    HashSet<Map.Type> moves2 = ghost.myMap.getLoc(ghost.myLoc);
    HashSet<Map.Type> moves3 = frame.getMap().getLoc(new Location(3, 1));
    HashSet<Map.Type> moves4 = frame.getMap().getLoc(new Location(-1, -1));
    
    System.out.print("Checks if PacMan is there: ");
    assertTrue(moves1.contains(Map.Type.PACMAN));
    System.out.print("Checks if Ghost is there: ");
    assertTrue(moves2.contains(Map.Type.GHOST));
    System.out.print("Checks if a Cookie is there: ");
    assertTrue(moves3.contains(Map.Type.COOKIE));
    System.out.print("Checks if it is a Wall: ");
    assertTrue(moves4.contains(Map.Type.WALL));

    pacman.myMap.move(pacman.myName, new Location(3, 1), Map.Type.PACMAN);
    assertNotNull(pacman.myMap.eatCookie(pacman.myName));
    pacman.myMap.move(pacman.myName, new Location(4, 1), Map.Type.PACMAN);
    HashSet<Map.Type> moves5 = frame.getMap().getLoc(new Location(3, 1));
    System.out.print("Checks if it is Empty: ");
    assertTrue(moves5.contains(Map.Type.EMPTY));

  }
}
