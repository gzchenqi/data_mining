package main;

import Entity.Student;
import util.DataProcess;
import util.FilePath;

import java.io.IOException;
import java.util.ArrayList;

public class ques02 {
    /**
     * 此实验1有参考-贾剑超小组的代码 但大部分代码均为本人所敲且对部分代码有所改进
     * 实验2是自己所写
     * 学生中家乡在广州，课程1在80分以上，且课程10在9分以上的男同学的数量。
     **/
    public static void main(String[] args) throws IOException {

        FilePath filepath=new FilePath();
        String filePath_csv = filepath.filePath_csv;
        String filePath_txt = filepath.filePath_txt;

        //传入文件路径，直接读取合并后的文件
        ArrayList<Student> list_students = DataProcess.MergeDuplicateRemoval_CsvAndTxt(filePath_csv,filePath_txt);

        ArrayList<Student> arr = new ArrayList<Student>();  //存放符合条件的学生列表
        System.out.println(list_students.size());
        for (int i = 0; i < list_students.size(); i++) {
            //System.out.println(list_students.get(i).getName()+ "-" + list_students.get(i).getCity()+"-"+ list_students.get(i).getGender() + "-" + list_students.get(i).getC1()+ "-" +list_students.get(i).getC9());
            if (list_students.get(i).getCity().equals("Guangzhou")
                    &&list_students.get(i).getC1()>=80.0
                    &&list_students.get(i).getC9()>=9.0
                    &&(list_students.get(i).getGender().equals("boy")||list_students.get(i).getGender().equals("male"))
            ) {
                arr.add(list_students.get(i));  //如果符合条件，加入学生列表
            }
        }

        System.out.println(arr.size());    //打印数组的长度，即符合条件的人数
    }


}
