/* Class to implement a Maze solver */

public abstract class MazeSolver {
	
	public static Square solve(Maze maze, SearchWorklist wl) {
		String[] cardinalD = {"n", "s", "e", "w"};
		wl.add(maze.start);
		while(!wl.isEmpty()) {
			Square current = wl.remove();
			current.visit();
			if (current.equals(maze.finish)) {
				return current;
			} else {
				for(String direction: cardinalD) {
					int posX = current.getCol();
					int posY = current.getRow();
					Sqaure target;
					switch(direction) {
						case "n":
							if (posY - 1 >= 0) {
								target = maze.contents[posX][posY - 1];
							}
							break;
						case "s":
							if (posY + 1 < maze.rows) {
								target = maze.contents[posX][posY + 1];
							}
							break;
						case "e":
							if (posX + 1 < maze.cols) {
								target = maze.contents[posX + 1][posY];
							}
							break;
						case "w":
							if (posX - 1 >= 0) {
								target = maze.contents[posX - 1][posY];
							}
							break;

						default:
							break;
						}
					if (!target.getIsWall() && target != null  && !target.isVisited()) {
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
