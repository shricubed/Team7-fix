import java.io.*;
import java.util.HashSet;

import javax.swing.JComponent;

import junit.framework.*;
import java.awt.Color;



public class TestMapEatCookie extends TestCase {

  public static void testConsume() throws FileNotFoundException {
    System.out.println("Testing MapEatCookie");
    //Creating A Map
    //MainFrame frame = new MainFrame(); //Creates A New Map With Walls and Tokens Initialized
    NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

    //Ghost ghost = frame.addGhost(new Location(1, 1), "name", Color.red); //Creates a red ghost named "name" at location x,y
    PacMan pacman = frame.addPacMan(new Location(2, 3)); //Creates PacMan at location x, y 2,3 is a cookie so is 2,3
    
    HashSet<Map.Type> loc_items = frame.getMap().getLoc(new Location(2, 3));
    HashSet<Map.Type> expected = new HashSet<Map.Type>();
    expected.add(Map.Type.COOKIE);
    expected.add(Map.Type.PACMAN);
    System.out.println("Asserting that pacman and cookie are present at location");
    assertEquals(loc_items, expected);
    JComponent temp = frame.getMap().eatCookie(pacman.myName);
    System.out.println("Asserting that cookie was consumed");
    assertNotNull(temp); //temp should be a consumed cookie
    System.out.println("Asserting that cookies count is updated");
    assertEquals(frame.getMap().getCookies(), 1);
    HashSet<Map.Type> after_consume = frame.getMap().getLoc(new Location(2, 3));
    expected = new HashSet<Map.Type>();
    expected.add(Map.Type.PACMAN);
    System.out.println("Asserting that old cookie was removed from the current location");
    assertEquals(after_consume, expected);

    //alternatively if you don't need the PacMan or Ghost objects in your tests
    //frame.initPlayers(); //Creates all of the players

    //Start The Game
    //frame.startGame();
  }

}
