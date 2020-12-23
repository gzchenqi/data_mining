package util;

import Entity.Student;

import java.io.*;
import java.util.ArrayList;

public class ReadFile {
    public static ArrayList<Student> ReadTxt(String filePath) throws IOException {
        ArrayList<Student> studentList=new ArrayList<>();
        File file=new File(filePath);
        InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
        BufferedReader bufferedReader=new BufferedReader(reader);

        //读一行
        bufferedReader.readLine();
        String line="";
        while((line=bufferedReader.readLine())!=null){
            Object[] arr=line.split(",",15);
            Student student=new Student();
            if (arr[0].toString().isEmpty()==false) {
                student.setStudentId(arr[0].toString());
            }
            if (arr[1].toString().isEmpty()==false) {
                student.setName((String) arr[1]);
            }
            if (arr[2].toString().isEmpty()==false) {
                student.setCity((String) arr[2]);
            }
            if (arr[3].toString().isEmpty()==false) {
                student.setGender((String) arr[3]);
            }
            if (arr[4].toString().isEmpty()==false) {
                student.setHeight(Float.parseFloat(arr[4].toString()));
            }
            if (arr[5].toString().isEmpty()==false) {
                student.setC1(Float.parseFloat(arr[5].toString()));
            }
            if (arr[6].toString().isEmpty()==false) {
                student.setC2(Float.parseFloat(arr[6].toString()));
            }
            if (arr[7].toString().isEmpty()==false) {
                student.setC3(Float.parseFloat(arr[7].toString()));
            }
            if (arr[8].toString().isEmpty()==false) {
                student.setC4(Float.parseFloat(arr[8].toString()));
            }
            if (arr[9].toString().isEmpty()==false) {
                student.setC5(Float.parseFloat(arr[9].toString()));
            }
            if (arr[10].toString().isEmpty()==false) {
                student.setC6(Float.parseFloat(arr[10].toString()));
            }
            if (arr[11].toString().isEmpty()==false) {
                student.setC7(Float.parseFloat(arr[11].toString()));
            }
            if (arr[12].toString().isEmpty()==false) {
                student.setC8(Float.parseFloat(arr[12].toString()));
            }
            if (arr[13].toString().isEmpty()==false) {
                student.setC9(Float.parseFloat(arr[13].toString()));
            }
            if (arr[14].toString().isEmpty()==false) {
                student.setC10(Float.parseFloat(arr[14].toString()));
            }
            if (arr[15].toString().isEmpty()==false) {
                student.setConstitution((String) arr[15]);
            }else {
                student.setConstitution("0");
            }
            studentList.add(student);
        }
        return studentList;
    }

    public static ArrayList<Student> ReadCsv(String filePath) throws IOException {
        ArrayList<Student> studentList=new ArrayList<>();
        File file =new File(filePath);
        InputStreamReader reader=null;
        reader=new InputStreamReader(new FileInputStream(file),"utf-8");
        BufferedReader bufferedReader = new BufferedReader(reader);

        bufferedReader.readLine();   //读取头部，不要保存
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            //System.out.println(line);
            Object[] arr = line.split(",",16);  //利用","进行分割，且限制长度为16避免出现null无法读取
            Student student = new Student();
            if (arr[0].toString().isEmpty()==false) {
                student.setStudentId(arr[0].toString());
            }
            if (arr[1].toString().isEmpty()==false) {
                student.setName((String) arr[1]);
            }
            if (arr[2].toString().isEmpty()==false) {
                student.setCity((String) arr[2]);
            }
            if (arr[3].toString().isEmpty()==false) {
                student.setGender((String) arr[3]);
            }
            if (arr[4].toString().isEmpty()==false) {
                student.setHeight(Float.parseFloat(arr[4].toString()));
            }
            if (arr[5].toString().isEmpty()==false) {
                student.setC1(Float.parseFloat(arr[5].toString()));
            }
            if (arr[6].toString().isEmpty()==false) {
                student.setC2(Float.parseFloat(arr[6].toString()));
            }
            if (arr[7].toString().isEmpty()==false) {
                student.setC3(Float.parseFloat(arr[7].toString()));
            }
            if (arr[8].toString().isEmpty()==false) {
                student.setC4(Float.parseFloat(arr[8].toString()));
            }
            if (arr[9].toString().isEmpty()==false) {
                student.setC5(Float.parseFloat(arr[9].toString()));
            }
            if (arr[10].toString().isEmpty()==false) {
                student.setC6(Float.parseFloat(arr[10].toString()));
            }
            if (arr[11].toString().isEmpty()==false) {
                student.setC7(Float.parseFloat(arr[11].toString()));
            }
            if (arr[12].toString().isEmpty()==false) {
                student.setC8(Float.parseFloat(arr[12].toString()));
            }
            if (arr[13].toString().isEmpty()==false) {
                student.setC9(Float.parseFloat(arr[13].toString()));
            }
            if (arr[14].toString().isEmpty()==false) {
                student.setC10(Float.parseFloat(arr[14].toString()));
            }
            if (arr[15].toString().isEmpty()==false) {
                student.setConstitution((String) arr[15]);
            }else {
                student.setConstitution("0");
            }
            studentList.add(student);
        }
        return studentList;
    }

}
