package print;

import Entity.Student;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import util.DataProcess;
import util.FilePath;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class ques02 {
    /**
     * 以5分为间隔，画出课程1的成绩直方图。
     */
    public static void main(String[] args) throws IOException {

        FilePath filepath=new FilePath();
        String filePath_csv = filepath.filePath_csv;
        String filePath_txt = filepath.filePath_txt;

        ArrayList<Student> student_list= DataProcess.MergeDuplicateRemoval_CsvAndTxt(filePath_csv,filePath_txt);
        ArrayList<Integer> C1=new ArrayList<Integer>();

        //处理数据 计算属于同一分数区域的数量
        for (int i = 0; i < 20; i++) {
            int num=0;
            for (int j = 0; j < student_list.size(); j++) {
                if (student_list.get(j).getC1()==0&&i==0){
                    num++;
                }
                if (student_list.get(j).getC1()>(5*i)&&student_list.get(j).getC1()<=5*(i+1)){
                    num++;
                }
            }
            C1.add(num);
        }

        //设置直方图
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < C1.size(); i++) {
            int a=i*5;
            int b=(i+1)*5;
            String label=a+"+"+b;
            dataset.addValue(C1.get(i), "Row 1", Integer.toString(i*5));
        }

        //以5分为间隔，画出课程1的成绩直方图。
        JFreeChart chart = ChartFactory.createBarChart("课程1成绩直方图", // chart title
                "成绩", // domain axis label
                "数量", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // 图标方向
                true, // 是否显示legend
                true, // 是否显示tooltips
                false // 是否显示URLs
        );

        //以面板显示
        ChartPanel chartPanel=new ChartPanel(chart );
        chartPanel.setPreferredSize(new java.awt.Dimension(560,400));

        //创建一个主窗口来显示面板
        JFrame frame=new JFrame("饼图");
        frame.setLocation(500,400);
        frame.setSize(600,500);

        //将主窗口的内容面板设置为图表面板
        frame.setContentPane(chartPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
