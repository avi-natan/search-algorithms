package problems;

import java.util.ArrayList;
import java.util.List;

import algorithms.Neighbor;
import algorithms.Node;

public class CustomProblemNode implements Node {
	
	private String name;
	private double heuristic;
	private boolean isGoal;
	private Neighbor parent;
	private List<Neighbor> successors;
	
	public CustomProblemNode(String name, double heuristic, boolean isGoal) {
		this.name = name;
		this.heuristic = heuristic;
		this.isGoal = isGoal;
		this.successors = new ArrayList<Neighbor>();
	}
	
	public void addParent(double cost, Node node) {
		this.parent = new Neighbor(cost, node);
	}
	
	public void addSuccessor(double cost, Node node) {
		this.successors.add(new Neighbor(cost, node));
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
	public List<Neighbor> getSuccessors() {
		return this.successors;
	}

	@Override
	public double getHeuristic() {
		return this.heuristic;
	}

	@Override
	public Neighbor getParent() {
		return this.parent;
	}

}
