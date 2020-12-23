import java.util.Hashtable;

public class End extends ASTCommand {

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}

	@Override
	public void execute(TurtleProgram turtle) {
		
	}
	
	public String toString() {
		return "end";
	}

	@Override
	public ASTCommand evaluate(String expression,Hashtable<String,Integer> variables) {
		if (expression.contains("end")) 
			return new End();
		return new End();
		
	}

}
