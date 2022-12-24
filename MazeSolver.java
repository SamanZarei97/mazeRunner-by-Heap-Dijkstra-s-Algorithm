/**
 * The purpose of this file is to find a path from start 
 * to end so that, the path minimizes the cost from start to end.
 * This implementation will happen by dijkstra's algorithm
 */
import java.util.ArrayList;

/**
 * This class has designed to find the path in dijkstra's algorithm
 * from start to end so that the path we try find, minimizes the cost from
 * start to end by checking the available neighbors and compare their cost 
 * with what we already have. 
 * @author saman
 *
 */
public abstract class MazeSolver {
	
	/**
	 * This is the helper method that returns true if the neighbor we are 
	 * looking for is in the valid bound, not visited yet and is not wall.
	 * It returns false otherwise.
	 * @param maze
	 * @param rowOffset
	 * @param colOffset
	 * @return
	 */
    private static boolean available(Maze maze, int rowOffset, int colOffset) {
     
    	if((rowOffset >= 0 && rowOffset < maze.rows) &&
                (colOffset >= 0 && colOffset < maze.cols)) {
    		
    		if(!maze.contents[rowOffset][colOffset].getIsWall() &&
    				!maze.contents[rowOffset][colOffset].isVisited()) {
    			
    			return true;
    		}
    	}
    	
    	return false; 	
    }
    
    /**
     * This method tries to find the path from start to end so that the 
     * path we are talking about minimizes the cost. So because of this,
     * we will check all the paths and neighbors in North,South, West and East
     * to find a path from start to end with the minimum cost.
     * @param maze
     * @param pq
     * @return
     */
	public static Square solve(Maze maze, PriorityQueue<Integer,Square> pq) {
		
		pq.add(maze.start.getCost(), maze.start);
		
		while(pq.isEmpty() == false) {
			
			Entry<Integer, Square> currently = pq.poll();
			Square currentlySQ = currently.value;
			currentlySQ.isVisited();
			
			if(currentlySQ.equals(maze.finish)) {
				
				return currentlySQ;
			}
			
			else {
				
				// North
				if(available(maze, currentlySQ.getRow() - 1, currentlySQ.getCol())) {
					
					Square north = maze.contents[currentlySQ.getRow() - 1][currentlySQ.getCol()];
					
					int currentCost = currently.key + north.getCost();
					
					if(currentCost < north.getRunningCost()) {
						
						north.setPrevious(currentlySQ);
						north.setRunningCost(currentCost);
						pq.add(currentCost, north);
					}
				}
				
				//West
				if(available(maze, currentlySQ.getRow(), currentlySQ.getCol() - 1)) {
					
					Square west = maze.contents[currentlySQ.getRow()][currentlySQ.getCol() - 1];
					int currentCost = currently.key + west.getCost();
					
					if(currentCost < west.getRunningCost()) {
						
						west.setPrevious(currentlySQ);
						west.setRunningCost(currentCost);
						pq.add(currentCost, west);
					}
				}
				
				//South
				if(available(maze, currentlySQ.getRow() + 1, currentlySQ.getCol())) {
					
					Square south = maze.contents[currentlySQ.getRow() + 1][currentlySQ.getCol()];
					int currentCost = currently.key + south.getCost();
					
					if(currentCost < south.getRunningCost()) {
						
						south.setPrevious(currentlySQ);
						south.setRunningCost(currentCost);
						pq.add(currentCost, south);
					}
				}
				
				//East
				if(available(maze, currentlySQ.getRow(), currentlySQ.getCol() + 1)) {
					
					Square east = maze.contents[currentlySQ.getRow()][currentlySQ.getCol() + 1];
					int currentCost = currently.key + east.getCost();
					
					if(currentCost < east.getRunningCost()) {
						
						east.setPrevious(currentlySQ);
						east.setRunningCost(currentCost);
						pq.add(currentCost, east);
					}
				}
			}
		}
		
		return null;
	}
}
	
