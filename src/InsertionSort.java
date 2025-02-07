
public class InsertionSort implements SortingAlgorithm {
    @Override
    public int[] sorty(int[] input) {
        int i = 0;
        int j = 0;
        int tmp = 0;

        for (i = 1; i < input.length; i++) {
            j = 1;

            while (j > 0 && input[j] < input[j - 1]) {
                tmp = input[j];
                input[j] = input[j - 1];
                input[j - 1] = tmp;
                --j;
            }
        }
        return input;
    }
}
