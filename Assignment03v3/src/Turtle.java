import java.awt.Point;

public class Turtle {
	
	private final double RADIAN= 180.0;
	private float currentDirection;
	private Point currentLocation;
	private boolean penUp;

	
	public Turtle() {
		this.currentDirection=0;
		this.currentLocation =new Point();
		this.penUp = false;

	}
	public float getCurrentDirection() {
		return currentDirection;
	}
	public void setCurrentDirection(float currentDirection) {
		this.currentDirection = currentDirection;
	}
	public Point getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(Point currentLocation) {
		this.currentLocation = currentLocation;
	}
	
	
	public void penUp()
	{
		penUp = true;
	}
	
	public void penDown()
	{
		penUp = false;
	}
	public void move(int distance) {
		if (penUp==false) {

			double Xdelta=distance*Math.cos(currentDirection*Math.PI/RADIAN);
			double Ydelta=distance*Math.sin(currentDirection*Math.PI/RADIAN);
			
			currentLocation.setLocation(currentLocation.getX()+Xdelta,currentLocation.getY()+Ydelta);
		}
	}
	
	public void turn(int degrees) {
		currentDirection+=degrees;
	}
	
	public float direction() {
		return this.currentDirection;
		
	}
	

	
	public Point location() {
		return this.currentLocation;
		
	}

	
	
	public float distanceTo(Point point) {
		return (float) currentLocation.distance(point);
		
	}
	
	public float bearingTo(Point point) {
		return (float) Math.atan((currentLocation.getY()-point.getY())/(currentLocation.getX()-point.getX()));
		
	}
}
