

public class ShellSort implements SortingAlgorithm {
    @Override
    public int[] sorty(int[] input){
        int n = input.length;
        for(int gap = n / 2; gap > 0; gap /= 2) {
            for(int i = gap; i < n; i++) {
                int tmp = input[i];
                int j = 0;
                for (j = i; j >= gap && input[j - gap] > tmp; j -= gap) {
                    input[j] = input[j-gap];
                }
                input[j] = tmp;
            }
        }
        return input;
    }
}
