import java.util.ArrayList;

/*
 * Write your JUnit tests here
 * Use the formatMaze() method to get nicer JUnit output
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSolvers {

	/* Helper method to compare two mazes */
	public void checkMaze(SearchWorklist wl, Maze startMaze, String[] expected) {
		Square s = MazeSolver.solve(startMaze, wl);
		if(expected == null) { assertNull(s); }
		else {
			ArrayList<Square> sp = startMaze.storePath();
			System.out.println(sp);
			assertEquals(s, startMaze.finish);
			String actualStr = formatMaze(startMaze.showSolution(sp));
			String expectedStr = formatMaze(expected);
			assertEquals(expectedStr, actualStr);
		}
	}	

	/* Helper method to format String[] output as String */
	public String formatMaze(String[] arr) {
		String result = "";
		for (String s: arr)
			result += "\n"+s;
		return (result+"\n");
	}

	/* Add your own Worklist tests below */

	/* ************** HINT ******************** 
	 * Use the helper methods to create simple
	 * tests that are easier to debug. 
	 */
	
	Maze m1 = new Maze(new String[] {
            "#___",
            "__F_",
            "S##_",
            "____"
        });
	
	Maze m3 = new Maze(new String[] {
            "_#F",
            "___",
            "S__"
        });
	
	Maze m2 = new Maze(new String[] {"S"});
	String[] m2Solution = {"S"};
	
	String[] queueSol = {"#___", "**F_", "S##_", "____"};
	String[] stackSol = {"#___", "__F*", "S##*", "****"};
	@Test
	public void dummyTest() {
		QueueWorklist q = new QueueWorklist();
		StackWorklist s = new StackWorklist();
		checkMaze(q, m1, queueSol);
		
	}
	@Test
	public void test2() {
		QueueWorklist q = new QueueWorklist();
		StackWorklist s = new StackWorklist();
		checkMaze(q, m2, null);
		
	}
	@Test
	public void test3() {
		
	}
}



