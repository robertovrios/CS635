import java.util.Hashtable;

//This class helps to evaluate the AST 
public class ASTContext {
	
	private String expression;
	private ASTCommand cmd;
	
	public ASTContext(String expression) {
		this.expression=expression;
	}

	// check the first string in the expression to evaluate the correct class instantiation  
	// Ex. if the expression begins with #, we instantiate the class Assignment and add it to the list of variables
	// Returns a command
	public ASTCommand setValue(Hashtable<String, Integer> variables) {
		String firstToken= expression.split(" ")[0];

		if(firstToken.contains("#")) {		
			cmd = new Assignment().evaluate(expression, variables);
			variables.put(expression.split(" ")[0],Integer.parseInt(expression.split(" ")[2]));
		}
		else if(firstToken.contains("move"))
			cmd = new Move().evaluate(expression, variables);
		else if(firstToken.contains("turn"))
			cmd = new Turn().evaluate(expression, variables);
		else if(firstToken.contains("repeat"))
			cmd = new Repeat().evaluate(expression, variables);
		else if(firstToken.contains("end"))
			cmd= new End();

		return cmd;
	}


}
