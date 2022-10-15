import java.io.*;
import java.awt.Color;
import junit.framework.*;

public class TestMapMove extends TestCase {

  public void testGhostMove() throws FileNotFoundException {
    System.out.println("Testing TestMapMove");
    
    NoFrame frame = new NoFrame();

    frame.addGhost(new Location(1, 1), "ghost", Color.GREEN);
    
    assertTrue(frame.getMap().move("ghost", new Location(2,1), Map.Type.GHOST) == true);
  }
}
