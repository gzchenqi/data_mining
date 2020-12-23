package print;

import Entity.Student;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import util.DataProcess;
import util.FilePath;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class ques01 {
    /**
     * 以课程1成绩为x轴，体能成绩为y轴，画出散点图。
     */
    public static void main(String[] args) throws IOException {

        FilePath filepath=new FilePath();
        String filePath_csv = filepath.filePath_csv;
        String filePath_txt = filepath.filePath_txt;

        ArrayList<Student> student_list= DataProcess.MergeDuplicateRemoval_CsvAndTxt(filePath_csv,filePath_txt);
        //设置散点图数据集
        XYSeries xy=new XYSeries("xy");

        //以课程1成绩为x轴，体能成绩为y轴，画出散点图。
        for (int i = 0; i < student_list.size(); i++) {
            xy.add(student_list.get(i).getC1(), DataProcess.TransformConstitution(student_list.get(i).getConstitution()));
        }

        //添加到数据集
        XYSeriesCollection dataset=new XYSeriesCollection();
        dataset.addSeries(xy);

        //实现简单的散点图，设置基本的数据 无连线的散点图
        JFreeChart chart = ChartFactory.createScatterPlot(
                "成绩-体能",
                "X-C1成绩",
                "Y-体能",
                dataset,
                PlotOrientation.VERTICAL,
                true,//是否显示图例
                true,//是否显示提示
                false//是否生成URL连接
        );

        //以面板显示
        ChartPanel chartPanel=new ChartPanel(chart );
        chartPanel.setPreferredSize(new java.awt.Dimension(560,400));

        //创建一个主窗口来显示面板
        JFrame frame=new JFrame("散点图");
        frame.setLocation(500,400);
        frame.setSize(600,500);

        //将主窗口的内容面板设置为图表面板
        frame.setContentPane(chartPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}