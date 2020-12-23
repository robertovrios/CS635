import java.util.Iterator;

// OddFilter class that returns all odd values
public class OddFilter<T> {

	Iterator<T> elements;

	T element;

	OddFilter(Iterator<T> input) {
		this.elements = input;

	}

	T toPrint() {
		return element;
	}

	// checks if the next value of the heap is odd
	boolean hasNext() {

		while (elements.hasNext()) {
			element = elements.next();
			if (isOdd(element))
				return true;
		}
		return false;
	}

	// returns the next odd value in the heap
	T next() {
		if (this.hasNext())
			return element;
		else
			return null;
	}

	public boolean isOdd(T number) {
		if ((int) number % 2 != 0)
			return true;
		else
			return false;
	}
}
