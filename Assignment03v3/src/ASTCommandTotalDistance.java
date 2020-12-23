
// class to calculate the total distance made by the pointer
public class ASTCommandTotalDistance implements Visitor{

	private TurtleProgram turtle;
	private int distance;
	
	// declare distance to 0
	public ASTCommandTotalDistance(TurtleProgram turtle){
		this.turtle=turtle;
		this.distance=0;
	}
	
	public int getDistance() {
		return distance;
	}
	
	@Override
	public void visit(TurtleProgram turtle) {
		turtle.execute(turtle);
		
	}

	@Override
	public void visit(Assignment assignment) {
		assignment.execute(turtle);
		
	}

	// accumulate the distance every time that the object is visited
	@Override
	public void visit(Move move) {
		move.execute(turtle);
		distance += move.getDistance();
	}


	@Override
	public void visit(Turn turn) {
		turn.execute(turtle);
		
	}

	@Override
	public void visit(Repeat repeat) {
		repeat.execute(turtle);
		
	}

	@Override
	public void visit(End end) {
		end.execute(turtle);
		
	}

	

}
