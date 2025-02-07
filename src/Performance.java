

import org.jfree.data.xy.XYSeries;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Performance {
    public static void main(String[] args) throws IOException {
        int[] sizes = {100, 500, 1000, 2000, 5000, 10000, 20000, 75000, 150000};
        int iterations = 20;

        Graph xyChart = new Graph("Sorting Algorithms", "Sorting Runtimes");
        Graph xyChartK = new Graph("Sorting Algorithms (K-Sorted)", "Sorting Runtimes (K-Sorted)");

        try (PrintStream fileOut = new PrintStream(new FileOutputStream("performance_report_K.txt"));
             PrintStream console = System.out) {

            System.setOut(fileOut);


            SortingAlgorithm bubbleSort = new BubbleSort();
            Tester testBubble = new Tester(bubbleSort);
            System.out.println("Sorting algorithm – Bubble sort");

            XYSeries bubbleSeries = new XYSeries("Bubble Sort");
            XYSeries bubbleSeriesK = new XYSeries("Bubble Sort (K-Sorted)");

            for (int size : sizes) {
                testBubble.test(iterations, size);
                bubbleSeries.add(size, testBubble.getAvg());

                testBubble.testK(iterations, size);
                bubbleSeriesK.add(size, testBubble.getAvg());
            }
            xyChart.addToCollection(bubbleSeries);
            xyChartK.addToCollection(bubbleSeriesK);


            SortingAlgorithm insertionSort = new InsertionSort();
            Tester testInsertion = new Tester(insertionSort);
            System.out.println("Sorting algorithm – Insertion sort");

            XYSeries insertionSeries = new XYSeries("Insertion Sort");
            XYSeries insertionSeriesK = new XYSeries("Insertion Sort (K-Sorted)");

            for (int size : sizes) {
                testInsertion.test(iterations, size);
                insertionSeries.add(size, testInsertion.getAvg());

                testInsertion.testK(iterations, size);
                insertionSeriesK.add(size, testInsertion.getAvg());
            }
            xyChart.addToCollection(insertionSeries);
            xyChartK.addToCollection(insertionSeriesK);


            SortingAlgorithm selectionSort = new SelectionSort();
            Tester testSelection = new Tester(selectionSort);
            System.out.println("Sorting algorithm – Selection sort");

            XYSeries selectionSeries = new XYSeries("Selection Sort");
            XYSeries selectionSeriesK = new XYSeries("Selection Sort (K-Sorted)");

            for (int size : sizes) {
                testSelection.test(iterations, size);
                selectionSeries.add(size, testSelection.getAvg());

                testSelection.testK(iterations, size);
                selectionSeriesK.add(size, testSelection.getAvg());
            }
            xyChart.addToCollection(selectionSeries);
            xyChartK.addToCollection(selectionSeriesK);


            SortingAlgorithm shellSort = new ShellSort();
            Tester testShell = new Tester(shellSort);
            System.out.println("Sorting algorithm – Shell sort");

            XYSeries shellSeries = new XYSeries("Shell Sort");
            XYSeries shellSeriesK = new XYSeries("Shell Sort (K-Sorted)");

            for (int size : sizes) {
                testShell.test(iterations, size);
                shellSeries.add(size, testShell.getAvg());

                testShell.testK(iterations, size);
                shellSeriesK.add(size, testShell.getAvg());
            }
            xyChart.addToCollection(shellSeries);
            xyChartK.addToCollection(shellSeriesK);


            SortingAlgorithm quickSort = new QuickSort();
            Tester testQuick = new Tester(quickSort);
            System.out.println("Sorting algorithm – Quick sort");

            XYSeries quickSeries = new XYSeries("Quick Sort");
            XYSeries quickSeriesK = new XYSeries("Quick Sort (K-Sorted)");

            for (int size : sizes) {
                testQuick.test(iterations, size);
                quickSeries.add(size, testQuick.getAvg());

                testQuick.testK(iterations, size);
                quickSeriesK.add(size, testQuick.getAvg());
            }
            xyChart.addToCollection(quickSeries);
            xyChartK.addToCollection(quickSeriesK);


            SortingAlgorithm mergeSort = new MergeSort();
            Tester testMerge = new Tester(mergeSort);
            System.out.println("Sorting algorithm – Merge sort");

            XYSeries mergeSeries = new XYSeries("Merge Sort");
            XYSeries mergeSeriesK = new XYSeries("Merge Sort (K-Sorted)");

            for (int size : sizes) {
                testMerge.test(iterations, size);
                mergeSeries.add(size, testMerge.getAvg());

                testMerge.testK(iterations, size);
                mergeSeriesK.add(size, testMerge.getAvg());
            }
            xyChart.addToCollection(mergeSeries);
            xyChartK.addToCollection(mergeSeriesK);

            System.setOut(console);
        }


        xyChart.pack();
        xyChart.setVisible(true);
        xyChart.saveImage(new java.io.File("Sorting_Runtimes.jpg"));

        xyChartK.pack();
        xyChartK.setVisible(true);
        xyChartK.saveImage(new java.io.File("Sorting_Runtimes_K_Sorted.jpg"));
    }
}
