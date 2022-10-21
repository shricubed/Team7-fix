import java.io.*;
import java.util.ArrayList;
import java.awt.Color;
import junit.framework.*;

public class TestGhostValidMoves extends TestCase {

  public void testGhostMove() throws FileNotFoundException {
    System.out.println("Testing TestGhostValidMoves");
        
    NoFrame frame = new NoFrame();

    Ghost ghost = frame.addGhost(new Location(1, 1), "ghost", Color.GREEN);
    
    ArrayList<Location> valid_moves = new ArrayList<>();
    valid_moves.add(new Location(2,1));
    valid_moves.add(new Location(1,2));
    
    ArrayList<Location> ghost_valid_moves = ghost.get_valid_moves();
    
    assertTrue(valid_moves.size() == ghost_valid_moves.size());
    
    if (valid_moves.size() == ghost_valid_moves.size()) {
    	assertTrue(valid_moves.get(0).equals(ghost_valid_moves.get(0)));
    	assertTrue(valid_moves.get(1).equals(ghost_valid_moves.get(1)));
    }
  }
}