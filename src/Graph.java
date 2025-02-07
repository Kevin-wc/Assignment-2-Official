

import java.awt.*;
import java.io.File;
import java.io.IOException;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.ui.RefineryUtilities;

public class Graph extends ApplicationFrame {

    private XYSeriesCollection data = new XYSeriesCollection();
    private JFreeChart graph;

    public Graph(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        this.graph = ChartFactory.createXYLineChart(
                chartTitle,
                "Inputs",
                "Sorting Time Avg (ms)",
                data,
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(graph);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        XYPlot plot = graph.getXYPlot();
        renderChart(plot);
        setContentPane(chartPanel);
    }

    private void renderChart(XYPlot plot) {
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        Color[] colors = {Color.RED, Color.BLUE, Color.YELLOW, Color.ORANGE, Color.MAGENTA, Color.GREEN};

        for (int i = 0; i < colors.length; i++) {
            renderer.setSeriesPaint(i, colors[i]);
            renderer.setSeriesStroke(i, new BasicStroke(2.0f));
        }
        plot.setRenderer(renderer);
    }

    public void addToCollection(XYSeries sortingAlgorithm) {
        data.addSeries(sortingAlgorithm);
    }

    public void saveImage(File file) throws IOException {
        ChartUtilities.saveChartAsJPEG(file, graph, 1200, 600);
    }
}
