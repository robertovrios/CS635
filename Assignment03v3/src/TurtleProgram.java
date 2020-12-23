import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

// the client program that reads a file and creates 2 lists: commands and variables.
// evaluate each command element and execute it 
public class TurtleProgram extends Turtle implements ASTExpression {

	private ArrayList<ASTExpression> commands;
	private Hashtable<String, Integer> variables;

	public ArrayList<ASTExpression> getCommands() {
		return commands;
	}

	public void addCommands(ASTExpression expression) {
		this.commands.add(expression);
	}

	public Hashtable<String, Integer> getVariables() {
		return variables;
	}

// the constructor read a file and call the method that evaluate its content
	public TurtleProgram(String fileName) {

		commands= new ArrayList<ASTExpression>();
		variables = new Hashtable<String, Integer>();
		File dir = new File(".");
		try {
			File file = new File(dir.getCanonicalPath() + File.separator
					+ fileName);
			evaluateFileContents(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// this method interpret each line of the input file. 
	// Call the interpreter in order to get the correct commands and add them to the command list
	private void evaluateFileContents(File file) throws IOException {
		FileInputStream input = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(input));
		String line = null;
		
		while ((line = br.readLine()) != null) {		
			ASTContext values= new ASTContext(line);
				commands.add(values.setValue(variables));
		}
		br.close();
	}

	public void execute() {
		execute(this);
	}

	@Override
	public void execute(TurtleProgram turtle) {
		
	}
	
	// execute all commands in the command list. 
	@Override
	public void accept(Visitor visitor) {
		int counter=0;
		Iterator<ASTExpression> itr = commands.iterator();
		while (itr.hasNext()) {
			ASTExpression cmd = itr.next();
			
		// create a list of the repeat commands in order to execute the same commands a specific number 
		//times until "end" is found
			if(cmd.toString().equals("repeat")) {
				
				counter=((Repeat) cmd).getCounter();
				ArrayList<ASTExpression> repeatedCommands= new ArrayList<ASTExpression>();
				while(itr.hasNext()) {
					ASTExpression nextCmd=itr.next();
				
					if(!nextCmd.toString().equals("end")) 
						repeatedCommands.add(nextCmd);
					else
						break;
					
				}
				while(counter>0) {
					for(ASTExpression repeatCmd:repeatedCommands) {
						repeatCmd.accept(visitor);
					}
					counter--;
				}
				
			}
			cmd.accept(visitor);
		}
		visitor.visit(this);
	}

	
	@Override
	public String toString() {
		return "Turtle";
	}

	@Override
	public ASTCommand evaluate(String expression, Hashtable<String, Integer> variables) {

		return null;
	}




}
