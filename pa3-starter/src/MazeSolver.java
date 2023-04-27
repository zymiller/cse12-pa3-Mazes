/* Class to implement a Maze solver */

public abstract class MazeSolver {
	
	public static Square solve(Maze maze, SearchWorklist wl) {
		while(!wl.isEmpty()) {
			wl.remove();
		}
		String[] cardinalD = {"n", "s", "e", "w"};
		wl.add(maze.start);
		maze.start.visit();
		while(!wl.isEmpty()) {
			Square current = wl.remove();
			if (current.equals(maze.finish)) {
				return current;
			} else {
				// Takes every direction in NSEW
				for(String direction: cardinalD) {
					// Stores position of current square
					int posX = current.getCol();
					int posY = current.getRow();
					// Target square is the neighboring square
					Square target = null;
					// If checks if neighbor in in bounds
					switch(direction) {
						case "n":
							if (posY - 1 >= 0) {
								target = maze.contents[posY - 1][posX];
							}
							break;
						case "s":
							if (posY + 1 < maze.rows) {
								target = maze.contents[posY + 1][posX];
							}
							break;
						case "e":
							if (posX + 1 < maze.cols) {
								target = maze.contents[posY][posX + 1];
							}
							break;
						case "w":
							if (posX - 1 >= 0) {
								target = maze.contents[posY][posX - 1];
							}
							break;

						default:
							break;
						}
					// Checks if it is an open unvisited space
					if (!(target == null || target.getIsWall() || target.isVisited())) {
						target.visit();
						target.setPrevious(current);
						wl.add(target);
					}
				}
			}
		}
		return null;
	}

	/* Add any helper methods you want */
}
