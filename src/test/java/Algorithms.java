import java.util.ArrayList;
import java.util.List;

public class Algorithms {

    /**
     * Calculate factorial using recursion; i >= 0
     * @param i
     * @return i!
     */
    public static int factorial(int i){
        if (i <= 1)
            return 1;
        return  i * factorial(i - 1);
    }

    /**
     * Sum array using recursion (to show all loops could be recursive calls)
     * startingOIndex < length of the array
     * @param array, array of ints
     * @param startingIndex, index we want to start the sum at
     * @return
     */
    public static  int sumArray(int [] array, int startingIndex){
        if (startingIndex >= array.length)
            return 0;
        return array[startingIndex] + sumArray(array, startingIndex + 1);
    }

    /**
     * find the nth fibonacci number using the mathematical definition of fibonacci
     * (not a vary good implementation - bad for large n, iteration is likely better)
     * @param n
     * @return nth fib number
     */
    public static int fibonacci(int n)  {
        if(n <= 0)
            return 0;
        if(n == 1)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * Now a more interesting problem:
     * 	Recamán's sequence (or Recaman's sequence):
     * 	a(0) = 0;
     * 	for n > 0, a(n) = a(n-1) - n if positive and not already in the sequence
     * 	otherwise a(n) = a(n-1) + n
     *
     * 	This recursive function prints the n first numbers in the Recamán's sequence
     * @param n
     * @return list of first n numbers in Recamán's sequence
     * */
    public static List<Integer> racaman(int n){
        List<Integer> list = new ArrayList<Integer>();
        if ( n <= 0 )
            return new ArrayList<Integer>();

        racamanHelper(list, n-1);
        return list;
    }

    /**
     * Helper method (common pattern among recursive functions)
     */
    private static int racamanHelper(List<Integer> list, int n){
        if ( n <= 0 ) {
            if(!list.contains(0))
                list.add(0);
            return 0;
        }
        int nextNum = racamanHelper(list, n - 1 );
        if( nextNum - n > 0 && !list.contains(nextNum - n)){
            list.add(nextNum - n);
            return nextNum - n;
        }
        list.add(nextNum + n);
        return nextNum + n;
    }

    /**
     * The McCarthy 91 function
     * M(n) = n - 10 for n > 100
     * and M(n) = M(M(n + 11)) for n <= 100
     * Interesting about m(n) for all n <= 100 ... implement to find out! (hint: look at the name)
     * Write a recursive algorithm to calculate M(n)
     *
     * @param  n
     * @return M(n)
     */

    public static int mccarthy91(int n){
        if ( n > 100 )
            return n - 10;
        return mccarthy91(mccarthy91(n + 11));
    }

    /* EXAMPLE SOLUTION FOR EX10 (recursion) */
    /**
     * Given loads a, b, and c, at three power stations, is it possible to
     * balance the load using the permitted operation?
     *
     * @param a
     *            the load at Power Station A, a >= 0
     * @param b
     *            the load at Power Station B, b >= 0
     * @param c
     *            the load at Power Station C, c >= 0
     * @return true if load balancing is possible and false otherwise
     */
    public static boolean canLoadBalance(int a, int b, int c) {
        // TODO: implement this method
        List<int[]> list =  new ArrayList<int[]>();
        return canBalance(a,b,c,list);
    }

    private static boolean canBalance(int a, int b, int c, List<int[]> list) {
        if ((a + b + c) % 3 != 0)
            return false;
        if (a == b && b == c && a == c)
            return true;
        if (a < 0 || b < 0 || c < 0)
            return false;

        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        int other = a + b + c - min - max;
        int triple[] = {min, other, max};

        if (holds(list, triple))
            return false;

        list.add(triple);

        return canBalance(min*2, max - min, other,list) || canBalance(min*2, other - min, max,list);
    }

    private static boolean holds(List<int[]> list, int[] arr){
        for(int[] some : list){
            boolean equals = true;
            for(int i=0; i<arr.length; i++)
                equals = equals && some[i] == arr[i];
            if(equals)
                return true;
        }

        return false;
    }
}
