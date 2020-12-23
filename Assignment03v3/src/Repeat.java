
import java.util.Hashtable;


public class Repeat extends ASTCommand{
	
	private int counter;
	
	public Repeat(int counter) {
		this.counter=counter;
	}
	
	public Repeat() {

	}

	public int getCounter() {
		return counter;
	}

	
	public String toString() {
		return "repeat";
	}

	// interpret the expression if it contains a variable or a constant value and return an instantiation
	@Override
	public ASTCommand evaluate(String expression, Hashtable<String, Integer> variables) {
		if (expression.contains("#")) {
			// it's a variable then it needs to be found in the variable list
			counter=variables.get(expression.split(" ")[1]);
		} else {
			counter= Integer.parseInt(expression.split(" ")[1]);

		}
		return new Repeat(counter);
		
	}

	@Override
	public void accept(Visitor visitor) {
		
		
	}

	@Override
	public void execute(TurtleProgram turtle) {
		
		
	}




}
