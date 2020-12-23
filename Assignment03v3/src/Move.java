import java.util.Hashtable;

// 
public class Move extends ASTCommand {
	
	private int distance;


	public Move() {
		
	}
	
	public int getDistance() {
		return distance;
	}
	
	public Move(int distance) {
		this.distance = distance;
	}

	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}

	@Override
	public void execute(TurtleProgram turtle) {
		turtle.move(this.distance);
		
	}
	
	public String toString() {
		return "move";
	}

	// interpret the expression if it contains a variable or a constant value and return an instantiation
	@Override
	public ASTCommand evaluate(String expression, Hashtable<String, Integer> variables) {
		if (expression.contains("#")) {
			// it's a variable then it needs to be found in the variable list
			distance=variables.get(expression.split(" ")[1]);
		} else {
			// it's a constant value
			distance = Integer.parseInt(expression.split(" ")[1]);

		}
		return new Move(distance);
	}

}
