

public class BubbleSort implements SortingAlgorithm {
    @Override
    public int[] sorty(int[] input){

        int n = input.length;
        int tmp;
        for (int i = 0; i < n-1; i++){
            for(int j = 0; j < n-1-i; j++){
                if (input[j] > input[j+1]){
                    tmp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = tmp;
                }
            }
        }
        return input;
    }
}
