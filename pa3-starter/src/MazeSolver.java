/* Class to implement a Maze solver */

public abstract class MazeSolver {
	
	public static Square solve(Maze maze, SearchWorklist wl) {
		String[] cardinalD = {"n", "s", "e", "w"};
		wl.add(maze.start);
		maze.start.visit();
		while(!wl.isEmpty()) {
			Square current = wl.remove();
			if (current.equals(maze.finish)) {
				return current;
			} else {
				for(String direction: cardinalD) {
					int posX = current.getCol();
					int posY = current.getRow();
					Square target = null;
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
