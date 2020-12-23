package util;

import Entity.Student;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExportFile {
    public static void Export(ArrayList<Student> students) throws IOException {
        String content = "ID,Name,City,Gender,Hight,C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,Constitution\n";
        for (int i=0;i<students.size();i++){
            //System.out.println(students.get(i).getId()+" "+students.get(i).getStudentId());
            content += students.get(i).getStudentId() + ",";
            content += students.get(i).getName() + ",";
            content += students.get(i).getCity() + ",";
            content += students.get(i).getGender() + ",";
            content += students.get(i).getHeight() + ",";
            content += students.get(i).getC1() + ",";
            content += students.get(i).getC2() + ",";
            content += students.get(i).getC3() + ",";
            content += students.get(i).getC4() + ",";
            content += students.get(i).getC5() + ",";
            content += students.get(i).getC6() + ",";
            content += students.get(i).getC7() + ",";
            content += students.get(i).getC8() + ",";
            content += students.get(i).getC9() + ",";
            content += students.get(i).getC10() + ",";
            content += students.get(i).getConstitution() + "\n";
        }
        FileOutputStream out = new FileOutputStream("datax.csv");
        byte[] bytes = content.getBytes();
        for (int i = 0;i<bytes.length;i++){
            out.write(bytes[i]);
        }

        out.close();
        System.out.println("Done");
    }

    public static void ExportByFormat(ArrayList<Student> students) throws IOException {
        String content = "ID,Name,City,Gender,Hight,C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,Constitution\n";
        for (int i=0;i<students.size();i++){
            //System.out.println(students.get(i).getId()+" "+students.get(i).getStudentId());
            content += students.get(i).getStudentId() + ",";
            content += students.get(i).getName() + ",";
            content += students.get(i).getCity() + ",";
            content += students.get(i).getGender() + ",";
            content += students.get(i).getHeight() + ",";
            content += students.get(i).getC1() + ",";
            content += students.get(i).getC2() + ",";
            content += students.get(i).getC3() + ",";
            content += students.get(i).getC4() + ",";
            content += students.get(i).getC5() + ",";
            content += students.get(i).getC6()*10 + ",";
            content += students.get(i).getC7()*10 + ",";
            content += students.get(i).getC8()*10 + ",";
            content += students.get(i).getC9()*10 + ",";
            content += students.get(i).getC10()*10 + ",";
            content += DataProcess.TransformConstitution(students.get(i).getConstitution()) + "\n";
        }
        FileOutputStream out = new FileOutputStream("datafy.csv");
        byte[] bytes = content.getBytes();
        for (int i = 0;i<bytes.length;i++){
            out.write(bytes[i]);
        }
        out.close();
        System.out.println("Done");
    }

}
