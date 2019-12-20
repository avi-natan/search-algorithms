package algorithms;

import java.util.List;

public interface Node {
	
	public String getName();
	public boolean isGoal();
	public List<Neighbor> getSuccessors();
	public Neighbor getParent();
	public double getHeuristic();

}
