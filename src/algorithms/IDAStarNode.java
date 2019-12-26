package algorithms;

import java.util.List;

public interface IDAStarNode {
	
	public String getName();
	public boolean isGoal();
	public List<IDAStarSuccessor> getSuccessors();
	public double getHeuristic();
	public void drawState();

}
