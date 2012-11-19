/**
	Exercise 1.(a):
	
	when calling printNumbers(6),
	output:	6
			4
			2
			2
			1
			1
			4
			3
			1
			1
			3
			6
*/
puclic class Exercise1 {
	public static void printNumbers(int n) {
		if (n <= 0) {
			return;
		}
		System.out.println(n);
		printNumbers(n-2);
		printNumbers(n-3);
		System.out.println(n);
	}
}