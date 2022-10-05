
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JComponent;

import junit.framework.*;
import java.awt.Color;

public class TestValidMove extends TestCase {

    public static void testMove() throws FileNotFoundException {

    System.out.println("Testing valid move");
    //MainFrame frame = new MainFrame(); //Creates A New Map With Walls and Tokens Initialized
    NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

    //Ghost ghost = frame.addGhost(new Location(-1, -1), "name", Color.red); //Creates a red ghost named "name" at location x,y
    System.out.println("What is at 1,13: "+ frame.getMap().getField().get(new Location(1, 13)));
    System.out.println("What is at 1,12: "+ frame.getMap().getField().get(new Location(1, 12)));
    PacMan pacman = frame.addPacMan(new Location(1, 14)); //Creates PacMan at location x, y 2,3 is a cookie so is 2,3
    //maybe top left?

    //HashSet<Map.Type> loc_items = frame.getMap().getLoc(new Location(2, 1));
    //
    pacman.consume(); //removes cookie at 2,1, updates score
    //now move pacman to 1,1 and eat cookie again
    System.out.println("Asserting that cookies eaten should have been 1");
    assertEquals(frame.getMap().getCookies(), 1);
    frame.getMap().move(pacman.myName, new Location(1,13), Map.Type.PACMAN);
    //why isn't this setting pacmans location correctly? cause pacman.move does it, and I'm subverting that for now
    pacman.myLoc = new Location(1, 13);
    pacman.consume();
    //pacman should now be at 1,1 score of 2, and have no cookies around him
    System.out.println("Asserting that cookies eaten should have been 2");
    assertEquals(frame.getMap().getCookies(), 2);
    //frame.getMap().getField().get(new Location(1, 1)).remove(Map.Type.COOKIE);
    //HashSet<Map.Type> expected = new HashSet<Map.Type>();
    ArrayList<Location> possible_moves = pacman.get_valid_moves();
    for (Location loc : possible_moves){
        System.out.println("possible location coordinates: " + loc.x + "," + loc.y);
    }
    System.out.println("Alleged pacman current location = "+frame.getMap().getField().get(new Location(1, 13)));
    System.out.println("Where pacman wants to go = " + frame.getMap().getField().get(new Location(1, 14)));
    System.out.println("Asserting that possible move is equal to 1,14");
    assertEquals(possible_moves.get(0), new Location(1,14));
    pacman.move();
    System.out.println("Asserting that pacman moved to 1,14");
    assertEquals(pacman.myLoc, new Location(1,14));
    System.out.println("Asserting that pacman type is at 1,14");
    System.out.println(frame.getMap().getField().get(new Location(1, 14)));

    //System.out.println(pacman.get_valid_moves());
    /* 
    expected.add(Map.Type.COOKIE);
    expected.add(Map.Type.PACMAN);
    System.out.println("Asserting that pacman and cookie are present at location");
    assertEquals(loc_items, expected);
    JComponent temp = pacman.consume();
    System.out.println("Asserting that cookie was consumed");
    assertNotNull(temp); //temp should be a consumed cookie
    System.out.println("Asserting that cookies count is updated");
    assertEquals(frame.getMap().getCookies(), 1);
    HashSet<Map.Type> after_consume = frame.getMap().getLoc(new Location(2, 3));
    expected = new HashSet<Map.Type>();
    expected.add(Map.Type.PACMAN);
    System.out.println("Asserting that old cookie was removed from the current location");
    assertEquals(after_consume, expected); */

    //alternatively if you don't need the PacMan or Ghost objects in your tests
    //frame.initPlayers(); //Creates all of the players

    //Start The Game
    //frame.startGame();


    }
    
}
