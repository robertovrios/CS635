import java.util.Hashtable;

// this class assigns a value to a specific variable 
public class Assignment extends ASTCommand {
	private String varName;
	private int varValue;

	public Assignment(String name, int value) {
		this.varName = name;
		this.varValue = value;
	}

	public Assignment() {
	}

	@Override
	public String toString() {
		return "assignment";
	}


	@Override
	public void execute(TurtleProgram turtle) {

	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	// evaluate the received expression and create a new assignment with the expression values
	@Override
	public ASTCommand evaluate(String expression, Hashtable<String, Integer> variables) {
		varName=expression.split(" ")[0];
		varValue=Integer.parseInt(expression.split(" ")[2]);

		return new Assignment(varName,varValue);
	}
}
