package problems;

import java.util.ArrayList;
import java.util.List;

import algorithms.ILBFSNode;

public class FifteenPuzzleILBFSNode implements ILBFSNode {
	
	private static long ID = 0;
	
	private static final int[][] GOAL_STATE =
		{
				{0, 1, 2, 3},
				{4, 5, 6, 7},
				{8, 9, 10, 11},
				{12, 13, 14, 15}
		};
	
	private int[][] state;
	private FifteenPuzzleILBFSNode parent;
	private long id;

	private double g;
	private double h;
	private double f;
	private double F;
	
	public FifteenPuzzleILBFSNode(int[][] state, FifteenPuzzleILBFSNode parent, double g) {
		this.state = state;
		this.parent = parent;
		this.id = ID;
		ID++;
		
		this.g = g;
		this.h = calculate_h();
		this.f = this.g + this.h;
		this.F = Double.MAX_VALUE;
	}
	
	@Override
	public long getId() {
		return this.id;
	}

	@Override
	public String getName() {
		String st = "";
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				st += this.state[i][j] + ",";
			}
			st += this.state[i][3] + "|";
		}
		for(int j = 0; j < 3; j++) {
			st += this.state[3][j] + ",";
		}
		st += this.state[3][3];
		return "state" + st;
	}

	@Override
	public boolean isGoal() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(this.state[i][j] != GOAL_STATE[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public List<ILBFSNode> getChildren() {
		int blankI = -1;
		int blankJ = -1;
		
		// finding the coordinates of the blank (0 is blank)
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(state[i][j] == 0) {
					blankI = i;
					blankJ = j;
				}
			}
		}
		
		if(blankI == -1 || blankJ == -1) {
			System.out.println("blank index error");
		}
		
		// initiating list of children
		List<ILBFSNode> children = new ArrayList<ILBFSNode>();
		
		// can swipe blank to top
		if(blankI > 0) {
			int[][] new_state = new int[4][4];
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					new_state[i][j] = this.state[i][j];
				}
			}
			new_state[blankI][blankJ] = this.state[blankI-1][blankJ];
			new_state[blankI-1][blankJ] = 0;
			ILBFSNode child = new FifteenPuzzleILBFSNode(new_state, this, this.g+1);
			children.add(child);
		}
		
		// can swipe blank to bottom
		if(blankI < 3) {
			int[][] new_state = new int[4][4];
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					new_state[i][j] = this.state[i][j];
				}
			}
			new_state[blankI][blankJ] = this.state[blankI+1][blankJ];
			new_state[blankI+1][blankJ] = 0;
			ILBFSNode child = new FifteenPuzzleILBFSNode(new_state, this, this.g+1);
			children.add(child);
		}
		
		// can swipe blank to left
		if(blankJ > 0) {
			int[][] new_state = new int[4][4];
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					new_state[i][j] = this.state[i][j];
				}
			}
			new_state[blankI][blankJ] = this.state[blankI][blankJ-1];
			new_state[blankI][blankJ-1] = 0;
			ILBFSNode child = new FifteenPuzzleILBFSNode(new_state, this, this.g+1);
			children.add(child);
		}
		
		// can swipe blank to right
		if(blankJ < 3) {
			int[][] new_state = new int[4][4];
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					new_state[i][j] = this.state[i][j];
				}
			}
			new_state[blankI][blankJ] = this.state[blankI][blankJ+1];
			new_state[blankI][blankJ+1] = 0;
			ILBFSNode child = new FifteenPuzzleILBFSNode(new_state, this, this.g+1);
			children.add(child);
		}
		
		return children;
	}
	
	@Override
	public double getg() {
		return this.g;
	}
	
	@Override
	public double geth() {
		return this.h;
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
	
	private double calculate_h() {
		double h = 0;
		
		// for each tile in the state
		for(int state_i = 0; state_i < 4; state_i++) {
			for(int state_j = 0; state_j < 4; state_j++) {
				// ... except the blank
				if(this.state[state_i][state_j] != 0) {
					// find its coordinates in the goal
					for(int goal_i = 0; goal_i < 4; goal_i++) {
						for(int goal_j = 0; goal_j < 4; goal_j++) {
							if(this.state[state_i][state_j] == GOAL_STATE[goal_i][goal_j]) {
								h += Math.abs(goal_i - state_i) + Math.abs(goal_j - state_j);
							}
						}
					}
				}
			}
		}
		
		return h;
	}
	
	@Override
	public void drawState() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				String prefix = this.state[i][j] < 10 ? "0" : "";
				System.out.print(prefix + this.state[i][j] + ",");
			}
			String prefix = this.state[i][3] < 10 ? "0" : "";
			System.out.println(prefix + this.state[i][3]);
		}
		for(int j = 0; j < 3; j++) {
			String prefix = this.state[3][j] < 10 ? "0" : "";
			System.out.print(prefix + this.state[3][j] + ",");
		}
		String prefix = this.state[3][3] < 10 ? "0" : "";
		System.out.println(prefix + this.state[3][3]);
		System.out.println("");
	}

}
