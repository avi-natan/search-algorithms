package algorithms;

public class IDAStarSuccessor {

	private double cost;
	private IDAStarNode node;
	
	public IDAStarSuccessor(double cost, IDAStarNode node) {
		this.cost = cost;
		this.node = node;
	}
	
	public double getCost() {
		return this.cost;
	}
	
	public IDAStarNode getNode() {
		return this.node;
	}
	
}
