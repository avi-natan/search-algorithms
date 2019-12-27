package algorithms;

import java.util.List;

public interface ILBFSNode {
	
	public long getId();
	public String getName();
	public boolean isGoal();
	public List<ILBFSNode> getChildren();
	public double getg();
	public double geth();
	public double getf();
	public double getF();
	public void setf(double f);
	public void setF(double F);
	public ILBFSNode getParent();
	public void drawState();

}
