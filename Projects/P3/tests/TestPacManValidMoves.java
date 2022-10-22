import java.io.*;
import java.util.ArrayList;
import java.awt.Color;
import junit.framework.*;

public class TestPacManValidMoves extends TestCase {

  public void testGhostMove() throws FileNotFoundException {
    System.out.println("Testing TestPacManValidMoves");
    
    NoFrame frame = new NoFrame();

    PacMan pacman = frame.addPacMan(new Location(1, 1));
    Ghost ghost = frame.addGhost(new Location(2, 1), "ghost", Color.GREEN);
    
    ArrayList<Location> valid_moves = new ArrayList<>();
    valid_moves.add(new Location(2,1));
    valid_moves.add(new Location(1,2));
    
    ArrayList<Location> pacman_valid_moves = pacman.get_valid_moves();
    
    assertTrue(valid_moves.size() == pacman_valid_moves.size());
    
    if (valid_moves.size() == pacman_valid_moves.size()) {
    	assertTrue(valid_moves.get(0).x == pacman_valid_moves.get(0).x);
    	assertTrue(valid_moves.get(0).y == pacman_valid_moves.get(0).y);
    	assertTrue(valid_moves.get(1).x == pacman_valid_moves.get(1).x);
    	assertTrue(valid_moves.get(1).y == pacman_valid_moves.get(1).y);
  }
}
