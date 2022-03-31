package intlist;

/**
 * This class is designed to implement and test Linked Lists.
 * 
 * @author Jon Steele
 * @email jonwhsteele@gmail.com
 *
 */
public class Lab3Tester {

	public static void main(String[] args) {
		
		
		LinkedIntegerList test1 = new LinkedIntegerList();
		test1.add(12);
		test1.add(4);
		test1.add(2);
		test1.add(99);
		System.out.println(test1.toString());

		test1.set(0, 0);
		test1.set(1, 1);
		test1.set(2, 2);

		System.out.println(test1.toString());
		
		test1.remove(12);
		test1.remove(99);
		test1.remove(2);
		System.out.println(test1.toString());
		
		test1.add(100);
		test1.add(400);
		test1.add(22);
		test1.add(123);
		System.out.println(test1.toString());
		
		test1.removeAt(0);
		test1.removeAt(3);
		test1.remove(1239);
		test1.removeAt(3);
		
		System.out.println(test1.toString());
		
		System.out.println(test1.indexOf(400));
		
		test1.clear();

	}

}
