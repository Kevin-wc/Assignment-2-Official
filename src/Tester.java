

import java.util.Random;
public class Tester {
    private double avg;
    private SortingAlgorithm sa;
    public Tester(SortingAlgorithm sa){
        this.sa = sa;
    }
    double singleTest(int size){
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++){
            array[i] = random.nextInt();
        }

        long start = System.nanoTime();
        sa.sorty(array);
        long finish = System.nanoTime();

        return (finish - start) / 1_000_000.0;
    }

    public void test(int iterations, int size) {
        double totalTime = 0;

        for (int i = 0; i < iterations; i++){
            totalTime = totalTime + singleTest(size);
        }

        double averageTime = totalTime/iterations;
        avg = averageTime;
        System.out.println("Normal Sorted " + size + " elements in " + averageTime + " ms (avg)\n");

    }

    public int[] generateKSorted(int[] my_array) {

        int n = my_array.length;
        for(int gap = n / 10; gap > 0; gap = 0) {
            for(int i = gap; i < n; i++) {
                int tmp = my_array[i];
                int j = 0;
                for (j = i; j >= gap && my_array[j - gap] > tmp; j -= gap) {
                    my_array[j] = my_array[j-gap];
                }
                my_array[j] = tmp;
            }
        }
        return my_array;
    }

    double singleTestK(int size){
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        generateKSorted(array);

        long start = System.nanoTime();
        sa.sorty(array);
        long finish = System.nanoTime();

        return (finish - start) / 1_000_000.0;
    }

    public void testK(int iterations, int size){
        double totalTime = 0;

        for (int i = 0; i < iterations; i++){
            totalTime = totalTime + singleTestK(size);
        }

        double averageTime = totalTime/iterations;
        avg = averageTime;
        System.out.println("K Sorted " + size + " elements in " + averageTime + " ms (avg) \n");

    }

    public double getAvg() {
        return avg;
    }
}
