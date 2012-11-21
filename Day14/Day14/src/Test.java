/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sward09
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        //t.launch10();
        //t.launch100();
        //t.launch1000();
        t.testPoly();
    }
    public void testPoly() {
        System.out.println("Testing class Polynomial:\n\tLet's see if we can find roots in two polys,");
        System.out.println("\tone which I know has roots between -1000 and +1000,");
        System.out.println("\tand one which I know doesn't...");
        
        System.out.println("\nFirst poly to test is 6 - 5x + x^2");
        Polynomial p1 = new Polynomial();
        double[] c1 = {6, -5, 1};
        p1.setCoefficients(c1);
        if(p1.root())
            System.out.println("Found a root in poly1!");
        else
            System.out.println("Unable to find a root in poly1... :(");
    }
    public void launch10() {
        MyList lst = new MyList();
        System.out.println("Filling MyList with 10 random integers from 0 - 10...");
        for(int i=1; i<=10; i++) {
            int rnd = (int) Math.abs(11 * Math.random());
            lst.add(rnd);
        }
        System.out.println("Sorting MyList with Quicksort...");
        lst = lst.quicksort();
        
        System.out.println("Searching for all possible numbers...");
        for(int x=0; x<=10; x++) {
            if(lst.binarySearch(x))
                System.out.println("Found " + x + "!");
        }
    }
    public void launch100() {
        MyList lst = new MyList();
        System.out.println("Filling MyList with 100 random integers from 0 - 100...");
        for(int i=1; i<=100; i++) {
            int rnd = (int) Math.abs(101 * Math.random());
            lst.add(rnd);
        }
        System.out.println("Sorting MyList with Quicksort...");
        lst = lst.quicksort();
        
        System.out.println("Searching for all possible numbers...");
        for(int x=0; x<=100; x++) {
            if(lst.binarySearch(x))
                System.out.println("Found " + x + "!");
        }
    }
    public void launch1000() {
        MyList lst = new MyList();
        System.out.println("Filling MyList with 1000 random integers from 0 - 1000...");
        for(int i=1; i<=1000; i++) {
            int rnd = (int) Math.abs(1001 * Math.random());
            lst.add(rnd);
        }
        System.out.println("Sorting MyList with Quicksort...");
        lst = lst.quicksort();
        
        System.out.println("Searching for all possible numbers...");
        for(int x=0; x<=1000; x++) {
            if(lst.binarySearch(x))
                System.out.println("Found " + x + "!");
        }
    }
}
