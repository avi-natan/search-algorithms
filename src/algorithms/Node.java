package algorithms;

import java.util.List;

public interface Node {
	
	public String getName();
	public boolean isGoal();
	public List<Successor> getSuccessors();
	public double getHeuristic();

}
