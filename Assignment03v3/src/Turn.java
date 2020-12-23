import java.util.Hashtable;

public class Turn extends ASTCommand {

	private int degrees;
	
	public Turn(int degrees) {
		this.degrees=degrees;
	}

	public Turn() {

	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}

	@Override
	public void execute(TurtleProgram turtle) {
		turtle.turn(this.degrees);
		
	}
	
	public String toString() {
		return "turn";
	}

	@Override
	
	// interpret the expression if it contains a variable or a constant value and return an instantiation
	public ASTCommand evaluate(String expression, Hashtable<String, Integer> variables) {
		// it's a variable then it needs to be found in the variable list
		if (expression.contains("#")) {
			degrees=variables.get(expression.split(" ")[1]);
		} else {
			degrees = Integer.parseInt(expression.split(" ")[1]);

		}
		return new Turn(degrees);
	}
	
	

}
