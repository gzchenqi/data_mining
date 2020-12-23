package main;

import Entity.Student;
import util.DataProcess;
import util.FilePath;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class ques04 {
    /**
     * 学习成绩和体能测试成绩，两者的相关性是多少？
     **/
    public static void main(String[] args)throws IOException {

        FilePath filepath=new FilePath();
        String filePath_csv = filepath.filePath_csv;
        String filePath_txt = filepath.filePath_txt;

        //传入文件路径，直接读取合并后的文件
        ArrayList<Student> list_students = DataProcess.MergeDuplicateRemoval_CsvAndTxt(filePath_csv, filePath_txt);

        ArrayList<Double> arr1 = new ArrayList<>();
        ArrayList<Double> arr2 = new ArrayList<>();
        ArrayList<Double> arr3 = new ArrayList<>();
        ArrayList<Double> arr4 = new ArrayList<>();
        ArrayList<Double> arr5 = new ArrayList<>();
        ArrayList<Double> arr6 = new ArrayList<>();
        ArrayList<Double> arr7 = new ArrayList<>();
        ArrayList<Double> arr8 = new ArrayList<>();
        ArrayList<Double> arr9 = new ArrayList<>();
        ArrayList<Double> arr10 = new ArrayList<>();
        ArrayList<Double> arr11 = new ArrayList<>();

        for (int i = 0; i < list_students.size(); i++) {
            arr1.add((double) list_students.get(i).getC1());
            arr2.add((double) list_students.get(i).getC2());
            arr3.add((double) list_students.get(i).getC3());
            arr4.add((double) list_students.get(i).getC4());
            arr5.add((double) list_students.get(i).getC5());
            arr6.add((double) list_students.get(i).getC6());
            arr7.add((double) list_students.get(i).getC7());
            arr8.add((double) list_students.get(i).getC8());
            arr9.add((double) list_students.get(i).getC9());
            arr10.add((double) list_students.get(i).getC10());
            arr11.add(DataProcess.TransformConstitution(list_students.get(i).getConstitution()));
        }

        System.out.println(DataProcess.GetCorrelation(arr1, arr11)); //打印相关系数
        System.out.println(DataProcess.GetCorrelation(arr2, arr11)); //打印相关系数
        System.out.println(DataProcess.GetCorrelation(arr3, arr11)); //打印相关系数
        System.out.println(DataProcess.GetCorrelation(arr4, arr11)); //打印相关系数
        System.out.println(DataProcess.GetCorrelation(arr5, arr11)); //打印相关系数
        System.out.println(DataProcess.GetCorrelation(arr6, arr11)); //打印相关系数
        System.out.println(DataProcess.GetCorrelation(arr7, arr11)); //打印相关系数
        System.out.println(DataProcess.GetCorrelation(arr8, arr11)); //打印相关系数
        System.out.println(DataProcess.GetCorrelation(arr9, arr11)); //打印相关系数
        //System.out.println(dataProcessing.GetCorrelation(arr10,arr11));
    }
}
