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
	
	// Clones the m1 maze into m4
	Maze m4 = new Maze(new String[] {
            "#___",
            "__F_",
            "S##_",
            "____"
        });
	
	Maze m2 = new Maze(new String[] {"S"});
	
	String[] queueSol = {"#___", "**F_", "S##_", "____"};
	String[] stackSol = {"#___", "__F*", "S##*", "****"};
	
	String[] m2Sol = {};

	/**
	 * Tests maze given in the writeup
	 */
	@Test
	public void testGivenMaze() {
		QueueWorklist q = new QueueWorklist();
		StackWorklist s = new StackWorklist();
		checkMaze(q, m1, queueSol);
		checkMaze(s, m4, stackSol);
	}
	
	/**
	 * Tests if a maze with no solution will return a null value
	 */
	@Test
	public void testBadMaze() {
		QueueWorklist q = new QueueWorklist();
		StackWorklist s = new StackWorklist();
		checkMaze(q, m2, null);
	}
	
	//Helper method to extract solution for mazes
	public String solveMaze(SearchWorklist wl, Maze startMaze) {
		Square s = MazeSolver.solve(startMaze, wl);	
		ArrayList<Square> sp = startMaze.storePath();
		return formatMaze(startMaze.showSolution(sp));
	}
	
	/**
	 * Tests if maze solvers have same output every time
	 */
	@Test
	public void testSameSolution() {	
		StackWorklist s = new StackWorklist();
		String solvedStack1 = solveMaze(s, m1);
		String solvedStack2 = solveMaze(s, m1);
		assertEquals(solvedStack1, solvedStack2);
	}
}



