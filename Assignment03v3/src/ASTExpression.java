import java.util.Hashtable;

// interpret or evaluate the received expression 
public interface ASTExpression {

	public void accept(Visitor visitor);
	public ASTCommand evaluate(String expression,Hashtable<String,Integer> variables);
	public void execute(TurtleProgram turtle);
	public String toString();
}
