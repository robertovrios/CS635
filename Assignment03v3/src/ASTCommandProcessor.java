
// this class executes all the  nodes of the AST
public class ASTCommandProcessor implements Visitor{

	private TurtleProgram turtle;
	
	public ASTCommandProcessor(TurtleProgram turtle){
		this.turtle=turtle;
	}
	
	// visits the assignment class and runs the execute method
	@Override
	public void visit(Assignment assignment) {
		assignment.execute(turtle);
		
	}

	// visits the Move class and runs the execute method
	@Override
	public void visit(Move move) {
		move.execute(turtle);
		
	}

	// visits the Turn class and runs the execute method
	@Override
	public void visit(Turn turn) {
		turn.execute(turtle);
		
	}

	// visits the Repeat class and runs the execute method
	@Override
	public void visit(Repeat repeat) {
		repeat.execute(turtle);
		
	}

	// visits the End class and runs the execute method
	@Override
	public void visit(End end) {
		end.execute(turtle);
		
	}

	// visits the TurtleProgram class and runs the execute method
	@Override
	public void visit(TurtleProgram turtle) {
		turtle.execute(turtle);
		
	}

}
