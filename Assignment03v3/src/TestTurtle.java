import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

public class TestTurtle {

	Turtle turtle =new Turtle();
	
	@Before
	public void setup() {

	}
	
	@Test
	public void testMoveHorizontally() {
		Point correctAnswer=new Point(5,0);
		
		// move horizontally 5 
		turtle.move(5);

		assertEquals(correctAnswer, turtle.location());		
	
	}
	
	@Test
	public void testMoveVertically() {
	Point correctAnswer=new Point(0,5);
	
	// move vertically 5 
	turtle.turn(90);
	turtle.move(5);

	assertEquals(correctAnswer, turtle.location());
	}
	
	@Test
	public void testMoveBothWithAngle() {
	Point correctAnswer=new Point(3,4);
	
	// move vertically and horizontally 5 with angle 53
	turtle.turn(53);
	turtle.move(5);

	assertEquals(correctAnswer, turtle.location());
	}
	
	@Test
	public void testMoveBothWithNegativeAngle() {
	Point correctAnswer=new Point(3,-4);
	
	// move vertically and horizontally 5 with angle 53
	turtle.turn(-53);
	turtle.move(5);

	assertEquals(correctAnswer, turtle.location());
	}
	
	/*
	
	#s = 15
	move #s
	turn 90
	move #s
	turn 90
	move #s
	turn 90
	move #s

	OUTPUT: point(0,0)... it's a square
	*/
	
	@Test
	public void testTurtleProgramMakeAnSquare() {
		TurtleProgram turtle = new TurtleProgram("square.txt");
		turtle.accept(new ASTCommandProcessor(turtle));
		
		Point correctAnswer=new Point(0,0);
		
		assertEquals(correctAnswer, turtle.location());	
		
	}
	
	/* Same square using repeat command
	#s = 10
	repeat 4
	move #s
	turn 90
	end
	
	*/
	
	@Test
	public void testTurtleProgramRepeat() {
		TurtleProgram turtle = new TurtleProgram("repeat.txt");
		turtle.accept(new ASTCommandProcessor(turtle));
		
		Point correctAnswer=new Point(0,0);
		
		assertEquals(correctAnswer, turtle.location());	
		
	}
	
	
	
	/* 
	
	move 10
	turn 180
	move 10
	*/
	
	// test the ASTCommandTotalDistance class to calculate the total movement of the pointer
	@Test
	public void testTurtleProgramTotalDistance() {
		
		TurtleProgram turtle = new TurtleProgram("testDistance.txt");

		ASTCommandTotalDistance a = new ASTCommandTotalDistance(turtle);
		turtle.accept(a);
		int correctAnswer=50;
		
		assertEquals(correctAnswer, a.getDistance());
	
	}
	
	
	
	//MORE TESTS
	// Test a file with 3 variables #a, #b and #c. And Test move and turn function
	/*
	#a = 5
	#b = 90
	move 15
	move #a
	turn #b
	move #a
	#c = 0
	turn #c
	move #a
	
	 
	 */
	
	
	@Test
	public void testTurtleProgramVariablesTurnAndMove() {
		TurtleProgram turtle = new TurtleProgram("testFile1.txt");
		turtle.accept(new ASTCommandProcessor(turtle));
		
		Point correctAnswer=new Point(20,10);
		
		assertEquals(correctAnswer, turtle.location());	
		
	}
	
	
	// Test a file with 2 negative variables #a and #b. And Test move and turn function
	/*
	 
	#a = -10
	#b = -90
	move #a
	turn #b
	move #a
	turn 90
	move #a
	turn 90
	move #a
	 
	 
	 */
	
	@Test
	public void testTurtleProgramNegativeVariablesTurnAndMove() {
		TurtleProgram turtle = new TurtleProgram("testFile2.txt");
		turtle.accept(new ASTCommandProcessor(turtle));
		
		Point correctAnswer=new Point(-20,0);
		
		assertEquals(correctAnswer, turtle.location());	
	
		
	}
	
	//test 2 repeat commands, move, turn and variables
	
	/*
	#a = 10
	#b = 2
	repeat 2
	move #a
	turn 90
	end
	move 10
	repeat #b
	move #a
	end
			
		*/
	
	@Test
	public void testTurtleProgramRepeatCommand() {
		TurtleProgram turtle = new TurtleProgram("testFile3.txt");
		turtle.accept(new ASTCommandProcessor(turtle));
		
		Point correctAnswer=new Point(-20,10);
		
		assertEquals(correctAnswer, turtle.location());
	
	}
	
	
	
	/*
	 #a = 10
	#b = 2
	repeat 2
	move #a
	turn 90
	end
	move 10
	repeat #b
	move #a
	end
	 
	 */
	// test the ASTCommandTotalDistance class to calculate the total movement of the pointer
	@Test
	public void testTurtleProgramTotalDistanceAnotherTest() {
		
		TurtleProgram turtle = new TurtleProgram("testFile3.txt");

		ASTCommandTotalDistance a = new ASTCommandTotalDistance(turtle);
		turtle.accept(a);
		int correctAnswer=50;
		
		assertEquals(correctAnswer, a.getDistance());
	
	}
	
	
	
	
	// test the following commands:
	/*
	 move 10
	 turn 90
	 move 20
	 turn -60
	 move 15
	 	 
	 */
	// final point (23,28)
	
	@Test
	public void testTurtleProgramRepeatCommandXXX() {
		TurtleProgram turtle = new TurtleProgram("testFile4.txt");
		turtle.accept(new ASTCommandProcessor(turtle));
		
		Point correctAnswer=new Point(23,28);
		
		assertEquals(correctAnswer, turtle.location());
	
	}
}
