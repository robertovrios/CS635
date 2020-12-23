
import java.util.Iterator;

// decorator class uses to return only odd values from a heap
public class OddHeapDecorator<T> extends AbstractDecorator<T> {

	public OddHeapDecorator(Heap<T> heap) {
		super(heap);

	}

	// Filter odd values of the heap and return them into a list of strings
	@Override
	public String toString() {

		Iterator<T> iter = decorated.iterator();

		String heapContents = "[";
		while (iter.hasNext()) {
			T element = iter.next();
			if ((int) element % 2 != 0) {
				String nodeValue = element.toString();
				if (iter.hasNext())
					heapContents += nodeValue.toString() + ",";
				else
					heapContents += nodeValue.toString();
			}else if(!iter.hasNext()){
				heapContents = heapContents.substring(0,heapContents.length()-1);
			}
		}
		heapContents += "]";
		return heapContents;

	}

	// create an array since the list of strings created by toString method.
	// Removing the commas,
	// and the first and the last elements

	@Override
	public Object[] toArray() {

		String nodeValueStrings = this.toString();
		Object[] arrayOfNodeValues = nodeValueStrings.substring(1, nodeValueStrings.length() - 1).split(",");

		return arrayOfNodeValues;

	}



	@Override
	public Iterator<T> iterator() {

		return null;
	}

}
