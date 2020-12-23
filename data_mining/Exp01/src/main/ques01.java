package main;

import Entity.Student;
import util.DataProcess;
import util.FilePath;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ques01 {
    /**
     * 此实验1有参考-贾剑超小组的代码 但大部分代码均为本人所敲且对部分代码有所改进
     * 实验2是自己所写
     * 学生中家乡在Beijing的所有课程的平均成绩
     **/
    public static void main(String[] args) throws IOException {

        FilePath filepath=new FilePath();
        String filePath_csv = filepath.filePath_csv;
        String filePath_txt = filepath.filePath_txt;

        //传入文件路径，直接读取合并后的文件
        ArrayList<Student> list_students = DataProcess.MergeDuplicateRemoval_CsvAndTxt(filePath_csv,filePath_txt);
        ArrayList<Student> arr = new ArrayList<Student>();
        HashMap<String, Double> map = new HashMap<>();  //创建hashMap，key为学生姓名，value为学生的平均成绩
        for (int i = 0; i < list_students.size(); i++) {   //将地址为北京的放入列表arr
            if (list_students.get(i).getCity().equals("Beijing")) {
                arr.add(list_students.get(i));   //向北京的人的列表中添加
            }
        }
        for (int j = 0; j < arr.size(); j++) {  //遍历arr，将Average、ZScore等放入map
            Student t = list_students.get(j);  //t保存j对应序号的Student

            ArrayList<Double> arr_grades = new ArrayList<>();  //用于存放学生的每门成绩
            arr_grades.add((double) t.getC1());  //读取课程1的成绩
            arr_grades.add((double) t.getC2());  //读取课程2的趁机
            arr_grades.add((double) t.getC3());  //读取课程3的成绩
            arr_grades.add((double) t.getC4());  //读取课程4的成绩
            arr_grades.add((double) t.getC5());  //读取课程5的成绩
            arr_grades.add((double) t.getC6()*10);  //十分制转换为百分制
            arr_grades.add((double) t.getC7()*10);  //十分制转换为百分制
            arr_grades.add((double) t.getC8()*10);  //十分制转换为百分制
            arr_grades.add((double) t.getC9()*10);  //十分制转换为百分制
            arr_grades.add((double) t.getC10()*10);  //十分制转换为百分制
            arr_grades.add(DataProcess.TransformConstitution(t.getConstitution()));  //四段制转换成百分制
            //System.out.println(dataProcessing.TransformConstitution(t.getConstitution()));

            double avg = DataProcess.GetAverage(arr_grades);  //求出平均值，加入map
            map.put(t.getName(), avg);   //key->value:name->average
        }


        System.out.println(map.size());
        for (String key :       //遍历key，打印average信息
                map.keySet()) {
            System.out.println("average" + "-" + key + "-" + map.get(key));
        }
    }

}
