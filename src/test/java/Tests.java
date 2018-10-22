import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Tests {
    @Test
    public void facTest1() {
        assertEquals(Algorithms.factorial(0), 1);
    }

    @Test
    public void facTest2() {
        assertEquals(Algorithms.factorial(1), 1);
    }

    @Test
    public void facTest3() {
        assertEquals(Algorithms.factorial(5), 120);
    }

    @Test
    public void facTest4() {
        assertEquals(Algorithms.factorial(12), 479001600);
    }

    @Test
    public void sumArrayTest1() {
        assertEquals(Algorithms.sumArray(new int [] {1,2,3}, 0), 6);
    }

    @Test
    public void sumArrayTest2() {
        assertEquals(Algorithms.sumArray(new int [] {1,2,3}, 1), 5);
    }

    @Test
    public void sumArrayTest3() {
        assertEquals(Algorithms.sumArray(new int [] {1,2,3}, 2), 3);
    }

    @Test
    public void sumArrayTest4() {
        assertEquals(Algorithms.sumArray(new int [] {1,2,3,-1,-2,-3,10,20,15,-5,2}, 0), 42);
    }

    @Test
    public void fibonacciTest1() {
        assertEquals(Algorithms.fibonacci(0), 0);
    }

    @Test
    public void fibonacciTest2() {
        assertEquals(Algorithms.fibonacci(1), 1);
    }

    @Test
    public void fibonacciTest3() {
        assertEquals(Algorithms.fibonacci(10), 55);
    }

    @Test
    public void fibonacciTest4() {
        assertEquals(Algorithms.fibonacci(42), 267914296);
    }

    @Test
    public void racamanTest2() {
        int[] array = new int[] {0, 1, 3, 6, 2, 7, 13, 20};
        List<Integer> expected =  Arrays.stream(array).boxed().collect(Collectors.toList());
        List<Integer> result = Algorithms.racaman(8);
        assertEquals(expected, result);
    }

    @Test
    public void racamanTest1() {
        int[] array = new int[] {0};
        List<Integer> expected =  Arrays.stream(array).boxed().collect(Collectors.toList());
        List<Integer> result = Algorithms.racaman(1);
        assertEquals(expected, result);
    }

    @Test
    public void racamanTest3() {
        int[] array = new int[] {0, 1};
        List<Integer> expected =  Arrays.stream(array).boxed().collect(Collectors.toList());
        List<Integer> result = Algorithms.racaman(2);
        assertEquals(expected, result);
    }

    @Test
    public void racamanTest4() {
        int[] array = new int[] {0, 1, 3, 6, 2, 7, 13, 20, 12, 21, 11, 22, 10, 23, 9, 24, 8,
                25, 43, 62, 42, 63, 41, 18, 42, 17, 43, 16, 44, 15, 45, 14, 46, 79, 113, 78,
                114, 77, 39, 78, 38, 79, 37, 80, 36, 81, 35, 82, 34, 83, 33, 84, 32, 85, 31,
                86, 30, 87, 29, 88, 28, 89, 27, 90, 26, 91, 157, 224, 156, 225, 155};
        List<Integer> expected =  Arrays.stream(array).boxed().collect(Collectors.toList());
        List<Integer> result = Algorithms.racaman(71);
        assertEquals(expected, result);
    }

    @Test
    public void mc91Test1() {
        assertEquals(Algorithms.mccarthy91(99), 91);
    }

    @Test
    public void mc91Test2() {
        assertEquals(Algorithms.mccarthy91(87), 91);
    }

    @Test
    public void mc91Test3() {
        assertEquals(Algorithms.mccarthy91(24), 91);
    }

    @Test
    public void mc91Test4() {
        assertEquals(Algorithms.mccarthy91(120), 110);
    }

    @Test
    public void lbTest1() {
        assertTrue(Algorithms.canLoadBalance(40, 40, 40));
    }

    @Test
    public void lbTest2() {
        assertTrue(Algorithms.canLoadBalance(15, 30, 45));
    }

    @Test
    public void lbTest3() {
        assertTrue(Algorithms.canLoadBalance(225, 500, 475));
    }

    @Test
    public void lbTest4() {
        assertTrue(!Algorithms.canLoadBalance(40, 80, 0));
    }

    @Test
    public void lbTest5() {
        assertTrue(Algorithms.canLoadBalance(10, 15, 35));
    }
}

