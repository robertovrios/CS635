
// this visitor pattern visits all nodes in the AST

public interface Visitor {
	
	public void visit(TurtleProgram turtle);
	public void visit(Assignment assignment);
	public void visit(Move move);
	public void visit(Turn turn);
	public void visit(Repeat repeat);
	public void visit(End end);

}
