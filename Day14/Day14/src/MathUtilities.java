import java.util.List;
import java.util.LinkedList;
        
public class MathUtilities {
	public static void main(String[] args) {
		/**
		for(int x = 0; x<=10; x++) {
			System.out.println(x+"! = "+factorial(x)+" or iteratively, "+factorialIterative(x));
		}
		for(int x = 0; x<=10; x++) {
			System.out.println("F("+x+") = "+fib(x)+" or iteratively, "+fibItr(x));
		}
		System.out.print("Calculating F(45) without memoization... ");
		System.out.println(fib(45));
		System.out.print("Calculating F(45) with memoization... ");
		System.out.println(fibMemo(45));
		*/
		for(int x=1; x<=64; x++)
			System.out.println("Number of moves for "+x+" Hanoi discs = " + Hanoi(x));
	}
	public static int factorial(int n) {
		if(n == 1 || n == 0)
			return 1;
		return n * factorial(n-1);
	}
	public static int factorialIterative(int n) {
		int result = 1;
		for(int i=1; i<=n; i++) {
			result *= i;
		}
		return result;
	}
	public static int fib(int n) {
		if(n==0)
			return 0;
		if( n == 1 || n == 2)
			return 1;
		int result = fib(n-1) + fib(n-2);
		return result;
	}
	private static int[] precalculated = null;
	public static int fibMemo(int n) {
		if(precalculated == null)
			initPrecalculatedArray(n);
		if(precalculated[n] != -1)
			return precalculated[n];
		int result = fibMemo(n-1) + fib(n-2);
		precalculated[n] = result;
		return result;
	}
	private static void initPrecalculatedArray(int size) {
		precalculated = new int[size+1];
		for(int i =0; i < precalculated.length; i++) {
			precalculated[i] = -1; // to indicate "not calculated yet"
		}
		precalculated[0] = 0; //F(0)
		precalculated[1] = 1;
		precalculated[2] = 1;
	}
	public static int fibItr(int n) {
		int result = 0;
		int previous, previous2;
		previous=1;
		previous2=0;
		for(int x=1; x<n; x++) {
			result = previous + previous2;
			previous2 = previous;
			previous = result;
		}
		return result;
	}
	public static int Hanoi(int n) {
		// To move n discs, must move the n-1 above the base disc to the centre
		// post, then move the base to the third post, and move the n-1 onto the
		// third; so the algorithm is Hanoi(n) = 2*Hanoi(n-1) + 1.
		if(n == 1) return 1;
		return 2*Hanoi(n-1) + 1;
	}
        public static boolean binarySearch(List<Integer> list, Integer element) {
            if(list.isEmpty()) 
                return false;
            int midIndex = (int) list.size() / 2;
            if(element == list.get(midIndex))
                return true;
            else if(element < list.get(midIndex)) {
                List<Integer> lowerHalf = new LinkedList<Integer>(list.subList(0, midIndex));
                return binarySearch(lowerHalf, element);
            }
            else if(element > list.get(midIndex)) {
                List<Integer> higherHalf = new LinkedList<Integer>(list.subList(midIndex, list.size() - 1));
                return binarySearch(higherHalf, element);
            }
            return false;
        }   
}