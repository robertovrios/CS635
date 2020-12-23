

// abstract class used to create a concrete decorator class
public abstract class AbstractDecorator<T> extends Heap<T>{

	protected Heap<T> decorated;

	public AbstractDecorator(Heap<T> heap) {
		this.decorated = heap;
	}
	
	@Override
	public boolean add(T nodeValue) {
		decorated.add(nodeValue);
		return true;
	}
	


}
