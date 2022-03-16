/** Performs some basic linked list tests. */
public class LinkedListDequeTest {
	
	/* Utility method for printing out empty checks. */
	public static boolean checkEmpty(boolean expected, boolean actual) {
		if (expected != actual) {
			System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Utility method for printing out empty checks. */
	public static boolean checkSize(int expected, int actual) {
		if (expected != actual) {
			System.out.println("size() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Prints a nice message based on whether a test passed. 
	 * The \n means newline. */
	public static void printTestStatus(boolean passed) {
		if (passed) {
			System.out.println("Test passed!\n");
		} else {
			System.out.println("Test failed!\n");
		}
	}

	/** Adds a few things to the list, checking isEmpty() and size() are correct, 
	  * finally printing the results. 
	  *
	  * && is the "and" operation. */
	public static void addIsEmptySizeTest() {
		System.out.println("\n > > > > > Running add/isEmpty/Size test.");
//		System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

		LinkedListDeque<String> lld1 = new LinkedListDeque<String>();
		lld1.printDeque();
		boolean passed = checkEmpty(true, lld1.isEmpty());

		LinkedListDeque<String> lld2 = new LinkedListDeque<String>("hi");
		System.out.println("Size of lld2 is: " + lld2.size());
		lld2.printDeque();

		lld1.addFirst("front");
		
		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
		passed = checkSize(1, lld1.size()) && passed;
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addLast("middle");
		passed = checkSize(2, lld1.size()) && passed;

		lld1.addLast("back");
		passed = checkSize(3, lld1.size()) && passed;

		System.out.println("Printing out deque: ");
		lld1.printDeque();

		printTestStatus(passed);
	}

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
	public static void addRemoveTest() {

		System.out.println("\n > > > > > Running add/remove test.");

//		System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty 
		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst(10);
		lld1.addFirst(89);
		lld1.printDeque();
		System.out.println("Size of lld1 is: " + lld1.size());
		// should not be empty 
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		Integer valRemoved = lld1.removeFirst();
		lld1.printDeque();
		System.out.println("Size of lld1 is: " + lld1.size() + ". Removed item is: " + valRemoved);
		valRemoved = lld1.removeFirst();
		lld1.printDeque();
		System.out.println("Size of lld1 is: " + lld1.size() + ". Removed item is: " + valRemoved);


		LinkedListDeque<Double> lld2 = new LinkedListDeque<Double>();
		lld2.addLast(3.1415926);
		lld2.addLast(0.0625);
		lld2.addLast(2.71828);
		lld2.printDeque();
		System.out.println("Size of lld2 is: " + lld2.size());
		System.out.println("The 0th item of lld2 is: " + lld2.get(0));
		System.out.println("The 1st item of lld2 is: " + lld2.get(1));
		System.out.println("The 2nd item of lld2 is: " + lld2.get(2));
		System.out.println("The 3rd item of lld2 is: " + lld2.get(3));

		Double valRemoved2 = lld2.removeLast();
		lld2.printDeque();
		System.out.println("Size of lld2 is: " + lld2.size() + ". Removed item is: " + valRemoved2);
		valRemoved2 = lld2.removeFirst();
		lld2.printDeque();
		System.out.println("Size of lld2 is: " + lld2.size() + ". Removed item is: " + valRemoved2);
		valRemoved2 = lld2.removeLast();
		lld2.printDeque();
		System.out.println("Size of lld2 is: " + lld2.size() + ". Removed item is: " + valRemoved2);
		System.out.println("The 0th item of lld2 is: " + lld2.get(0));
		// should be empty 
		passed = checkEmpty(true, lld2.isEmpty()) && passed;

		printTestStatus(passed);

		LinkedListDeque<String> lld3 = new LinkedListDeque<String>();
		lld3.addFirst("ichi");
		lld3.addFirst("zero");
		lld3.addLast("ni");
		lld3.addLast("san");
		lld3.printDeque();
		System.out.println("Size of lld3 is: " + lld3.size());
		System.out.println("The 0th item of lld3 is: " + lld3.get(0));
		System.out.println("The 1st item of lld3 is: " + lld3.get(1));
		System.out.println("The 2nd item of lld3 is: " + lld3.get(2));
		System.out.println("The 3rd item of lld3 is: " + lld3.get(3));
		System.out.println("The 4th item of lld3 is: " + lld3.get(4));
		String valRemoved3 = lld3.removeLast();
		lld3.printDeque();
		System.out.println("Size of lld3 is: " + lld3.size() + ". Removed item is: " + valRemoved3);
		valRemoved3 = lld3.removeFirst();
		lld3.printDeque();
		System.out.println("Size of lld3 is: " + lld3.size() + ". Removed item is: " + valRemoved3);
	}

	public static void main(String[] args) {
		System.out.println("Running tests.\n");
		addIsEmptySizeTest();
		addRemoveTest();
	}
} 