package algorithms;

import java.util.List;

public interface ILBFSNode {
	
	public String getName();
	public boolean isGoal();
	public List<ILBFSNode> getChildren();
	public double getf();
	public double getF();
	public void setF(double F);
	public ILBFSNode getParent();

}
