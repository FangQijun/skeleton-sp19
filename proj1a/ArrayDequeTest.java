import java.util.Arrays;

/** Performs some basic array list tests. */
public class ArrayDequeTest {

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

    public static void addTest() {
        System.out.println("\n > > > > > Running add test.");

        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        boolean passed = checkEmpty(true, ad1.isEmpty());
        printTestStatus(passed);

        for (int num = 10; num < 210; num += 10) {
            ad1.addFirst(num);
            ad1.printDeque();
//            System.out.print("nextFirst = " + ad1.nextFirst + " | nextLast = " + ad1.nextLast + "\n");
//            System.out.print("head = " + ad1.head + " | tail = " + ad1.tail + "\n");
//            System.out.println(Arrays.toString(ad1.items));
            System.out.println("-----");
        }
        System.out.println("Size of ad1 is: " + ad1.size());
        System.out.println("===========================================================================\n");

        ArrayDeque<Integer> ad2 = new ArrayDeque<Integer>();
        boolean passed2 = checkEmpty(true, ad2.isEmpty());
        printTestStatus(passed2);

        for (int num = 10; num < 210; num += 10) {
            ad2.addLast(num);
            ad2.printDeque();
//            System.out.print("nextFirst = " + ad2.nextFirst + " | nextLast = " + ad2.nextLast + "\n");
//            System.out.print("head = " + ad2.head + " | tail = " + ad2.tail + "\n");
//            System.out.println(Arrays.toString(ad2.items));
//            System.out.println("-----");
        }
        System.out.println("Size of ad2 is: " + ad2.size());
        System.out.println("===========================================================================\n");

        ArrayDeque<Integer> ad3 = new ArrayDeque<Integer>();
        boolean passed3 = checkEmpty(true, ad3.isEmpty());
        printTestStatus(passed3);
        for (int num = 10; num < 210; num += 10) {
            ad3.addLast(num);
            ad3.addFirst(num);
            ad3.printDeque();
//            System.out.print("nextFirst = " + ad3.nextFirst + " | nextLast = " + ad3.nextLast + "\n");
//            System.out.print("head = " + ad3.head + " | tail = " + ad3.tail + "\n");
//            System.out.println(Arrays.toString(ad3.items));
//            System.out.println("-----");
        }
        System.out.println("Size of ad3 is: " + ad3.size());
        System.out.println("===========================================================================\n");

        ArrayDeque<Integer> ad4 = new ArrayDeque<Integer>(ad3);
        System.out.println("Size of ad4 is: " + ad4.size());
    }

    public static void removeTest() {
        System.out.println("\n > > > > > Running remove test.");

        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        boolean passed = checkEmpty(true, ad1.isEmpty());
        printTestStatus(passed);

        for (int num = 10; num < 200; num += 10) {
            ad1.addFirst(num);
            ad1.printDeque();
//            System.out.print("nextFirst = " + ad1.nextFirst + " | nextLast = " + ad1.nextLast + "\n");
//            System.out.print("head = " + ad1.head + " | tail = " + ad1.tail + "\n");
//            System.out.println(Arrays.toString(ad1.items));
//            System.out.println("-----");
        }
        System.out.println("================================");
        for (int num = 10; num < 200; num += 10) {
            Integer i = ad1.removeFirst();
            ad1.printDeque();
//            System.out.println("nextFirst = " + ad1.nextFirst + " | nextLast = " + ad1.nextLast);
//            System.out.println("head = " + ad1.head + " | tail = " + ad1.tail);
//            System.out.println("value deleted: " + i + " | size = " + ad1.size);
//            System.out.println(Arrays.toString(ad1.items));
            System.out.println("-----");
        }
        System.out.println("Size of ad1 is: " + ad1.size());
        System.out.println("===========================================================================\n");

        ArrayDeque<Integer> ad2 = new ArrayDeque<Integer>();
        boolean passed2 = checkEmpty(true, ad2.isEmpty());
        printTestStatus(passed2);

        for (int num = 10; num < 200; num += 10) {
            ad2.addLast(num);
            ad2.printDeque();
//            System.out.print("nextFirst = " + ad1.nextFirst + " | nextLast = " + ad1.nextLast + "\n");
//            System.out.print("head = " + ad1.head + " | tail = " + ad1.tail + "\n");
//            System.out.println(Arrays.toString(ad1.items));
//            System.out.println("-----");
        }
        System.out.println("================================");
        for (int num = 10; num < 200; num += 10) {
            Integer i = ad2.removeLast();
            ad2.printDeque();
//            System.out.println("nextFirst = " + ad2.nextFirst + " | nextLast = " + ad2.nextLast);
//            System.out.println("head = " + ad2.head + " | tail = " + ad2.tail);
//            System.out.println("value deleted: " + i + " | size = " + ad2.size);
//            System.out.println(Arrays.toString(ad2.items));
            System.out.println("-----");
        }
        System.out.println("Size of ad2 is: " + ad2.size());
        System.out.println("===========================================================================\n");
    }

    public static void addRemoveGetTest() {
        System.out.println("\n > > > > > Running add/remove test.");

        ArrayDeque<String> ad1 = new ArrayDeque<String>();
        boolean passed = checkEmpty(true, ad1.isEmpty());
        printTestStatus(passed);

        ad1.addLast("XV");
        ad1.printDeque();

        String value = ad1.removeLast();
        System.out.println("value deleted: " + value);
        ad1.printDeque();
        ad1.addLast("XV");
        ad1.printDeque();

        System.out.println("The 0th item of ad1 is: " + ad1.get(0));
        System.out.println("The 1st item of ad1 is: " + ad1.get(1));
        System.out.println("The 2nd item of ad1 is: " + ad1.get(2));

        ad1.addFirst("XIV");
        ad1.printDeque();

        value = ad1.removeFirst();
        System.out.println("value deleted: " + value);
        ad1.printDeque();
        ad1.addFirst("XIV");
        ad1.printDeque();

        ad1.addFirst("XIII");
        ad1.printDeque();

        System.out.println("The 0th item of ad1 is: " + ad1.get(0));
        System.out.println("The 1st item of ad1 is: " + ad1.get(1));
        System.out.println("The 2nd item of ad1 is: " + ad1.get(2));
        System.out.println("The 3rd item of ad1 is: " + ad1.get(3));

        ad1.addLast("XVI");
        ad1.printDeque();

        ad1.addLast("XVII");
        ad1.printDeque();

        ad1.addLast("XVIII");
        ad1.printDeque();

        ad1.addFirst("XII");
        ad1.printDeque();

        value = ad1.removeFirst();
        System.out.println("value deleted: " + value);
        ad1.printDeque();
        ad1.addFirst("XII");
        ad1.printDeque();

        ad1.addLast("XIX");
        ad1.printDeque();

        ad1.addLast("XX");
        ad1.printDeque();

        ad1.addFirst("XI");
        ad1.printDeque();

        ad1.addFirst("X");
        ad1.printDeque();

        ad1.addLast("XXI");
        ad1.printDeque();

        ad1.addFirst("IX");
        ad1.printDeque();

        ad1.addFirst("VIII");
        ad1.printDeque();

        ad1.addLast("XXII");
        ad1.printDeque();

        ad1.addLast("XXIII");
        ad1.printDeque();

        value = ad1.removeLast();
        System.out.println("value deleted: " + value);
        ad1.printDeque();
        ad1.addLast("XXIII");
        ad1.printDeque();

        ad1.addLast("XXIV");
        ad1.printDeque();

        ad1.addLast("XXV");
        ad1.printDeque();

        ad1.addFirst("VII");
        ad1.printDeque();

        ad1.addFirst("VI");
        ad1.printDeque();

        ad1.addFirst("V");
        ad1.printDeque();

        ad1.addLast("XXVI");
        ad1.printDeque();

        value = ad1.removeLast();
        System.out.println("value deleted: " + value);
        ad1.printDeque();
        ad1.addLast("XXVI");
        ad1.printDeque();

        ad1.addLast("XXVII");
        ad1.printDeque();

        ad1.addLast("XXVIII");
        ad1.printDeque();

        ad1.addLast("XXIX");
        ad1.printDeque();

        ad1.addFirst("IV");
        ad1.printDeque();

        value = ad1.removeFirst();
        System.out.println("value deleted: " + value);
        ad1.printDeque();
        ad1.addFirst("IV");
        ad1.printDeque();

        ad1.addLast("XXX");
        ad1.printDeque();

        ad1.addLast("XXXI");
        ad1.printDeque();

        ad1.addFirst("III");
        ad1.printDeque();

        ad1.addFirst("II");
        ad1.printDeque();

        ad1.addFirst("I");
        ad1.printDeque();

        value = ad1.removeFirst();
        System.out.println("value deleted: " + value);
        ad1.printDeque();
        ad1.addFirst("I");
        ad1.printDeque();

        ad1.addLast("XXXII");
        ad1.printDeque();

        ad1.addLast("XXXIII");
        ad1.printDeque();

        ad1.addLast("XXXIV");
        ad1.printDeque();

        value = ad1.removeLast();
        System.out.println("value deleted: " + value);
        ad1.printDeque();

        ad1.addLast("XXXIV");
        ad1.printDeque();
        System.out.println("The 33rd item of ad1 is: " + ad1.get(33));

        value = ad1.removeLast();
        System.out.println("value deleted: " + value);
        ad1.printDeque();
//        System.out.println(Arrays.toString(ad1.items));

        value = ad1.removeLast();
        System.out.println("value deleted: " + value);
        ad1.printDeque();
//        System.out.println(Arrays.toString(ad1.items));

        value = ad1.removeLast();
        System.out.println("value deleted: " + value);
        ad1.printDeque();
//        System.out.println(Arrays.toString(ad1.items));

        value = ad1.removeLast();
        System.out.println("value deleted: " + value);
        ad1.printDeque();
//        System.out.println(Arrays.toString(ad1.items));

        System.out.println("===========================================================================\n");
    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
//        addTest();
//        removeTest();
        addRemoveGetTest();
    }
}