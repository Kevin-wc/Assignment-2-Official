

public class SelectionSort implements SortingAlgorithm {
    @Override
    public int[] sorty(int[] input) {
        int indexSmallest;
        int temp;
        for (int i = 0; i < input.length - 1; ++i) {
            indexSmallest = i;
            for (int j = i + 1; j < input.length; ++j) {
                if ( input[j] < input[indexSmallest] ) {
                    indexSmallest = j;
                }
            }
            temp = input[i];
            input[i] = input[indexSmallest];
            input[indexSmallest] = temp;
        }
    return input;
    }
}
