package problems;

import java.util.ArrayList;
import java.util.List;

import algorithms.ILBFSNode;

public class CustomILBFSProblemNode implements ILBFSNode{
	
	private String name;
	private boolean isGoal;
	private List<ILBFSNode> children;
	private double f;
	private double F;
	private double h;
	private ILBFSNode parent;
	
	public CustomILBFSProblemNode(String name, boolean isGoal, double f, double F) {
		super();
		this.name = name;
		this.isGoal = isGoal;
		this.children = new ArrayList<ILBFSNode>();
		this.f = f;
		this.F = F;
		this.parent = null;
	}
	
	public void addChild(ILBFSNode child) {
		this.children.add(child);
	}
	
	public void setParent(ILBFSNode parent) {
		this.parent = parent;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public boolean isGoal() {
		return this.isGoal;
	}

	@Override
	public List<ILBFSNode> getChildren() {
		return this.children;
	}

	@Override
	public double getf() {
		return this.f;
	}

	@Override
	public double getF() {
		return this.F;
	}
	
	@Override
	public double geth() {
		return this.h;
	}
	
	@Override
	public void setf(double f) {
		this.f = f;
	}

	@Override
	public void setF(double F) {
		this.F = F;
	}

	@Override
	public ILBFSNode getParent() {
		return this.parent;
	}

}
