package print;

import Entity.Student;
import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;
import util.DataProcess;
import util.FilePath;

import java.io.IOException;
import java.util.ArrayList;

import static java.lang.StrictMath.sqrt;

public class ques03 {
    /**
     * 对每门成绩进行z-score归一化，得到归一化的数据矩阵。
     */
     public static void main(String[] args) throws IOException {

        FilePath filepath = new FilePath();
        String filePath_csv = filepath.filePath_csv;
        String filePath_txt = filepath.filePath_txt;

        ArrayList<Student> student_list = DataProcess.MergeDuplicateRemoval_CsvAndTxt(filePath_csv, filePath_txt);

        ArrayList<ArrayList<Double>> student_Matrix = new ArrayList<>();
        ArrayList<Double> student_c1 = new ArrayList<>();
        ArrayList<Double> student_c2 = new ArrayList<>();
        ArrayList<Double> student_c3 = new ArrayList<>();
        ArrayList<Double> student_c4 = new ArrayList<>();
        ArrayList<Double> student_c5 = new ArrayList<>();
        ArrayList<Double> student_c6 = new ArrayList<>();
        ArrayList<Double> student_c7 = new ArrayList<>();
        ArrayList<Double> student_c8 = new ArrayList<>();
        ArrayList<Double> student_c9 = new ArrayList<>();
        ArrayList<Double> student_c10 = new ArrayList<>();
        ArrayList<Double> student_c11 = new ArrayList<>();

        //对数据进行处理
        for (int i = 0; i < student_list.size(); i++) {
            student_c1.add((double) student_list.get(i).getC1());
            student_c2.add((double) student_list.get(i).getC2());
            student_c3.add((double) student_list.get(i).getC3());
            student_c4.add((double) student_list.get(i).getC4());
            student_c5.add((double) student_list.get(i).getC5());
            student_c6.add((double) student_list.get(i).getC6());
            student_c7.add((double) student_list.get(i).getC7());
            student_c8.add((double) student_list.get(i).getC8());
            student_c9.add((double) student_list.get(i).getC9());
            student_c10.add((double) student_list.get(i).getC10());
            student_c11.add(DataProcess.TransformConstitution(student_list.get(i).getConstitution()));
        }
        student_Matrix.add(student_c1);
        student_Matrix.add(student_c2);
        student_Matrix.add(student_c3);
        student_Matrix.add(student_c4);
        student_Matrix.add(student_c5);
        student_Matrix.add(student_c6);
        student_Matrix.add(student_c7);
        student_Matrix.add(student_c8);
        student_Matrix.add(student_c9);
        student_Matrix.add(student_c10);
        student_Matrix.add(student_c11);

        //创建一个新数组 保存ZScore化后的数据
        ArrayList<ArrayList<Double>> student_newMatrix = new ArrayList<>();
        for (int i = 0; i < student_Matrix.size(); i++) {
            student_newMatrix.add(GetZScore(student_Matrix.get(i)));
        }

        //把数据添加进矩阵
        Matrix dense = DenseMatrix.Factory.zeros(student_newMatrix.size(), student_newMatrix.get(1).size());
         for (int i = 0; i < student_newMatrix.size(); i++) {
             for (int j = 0; j < student_newMatrix.get(i).size(); j++) {
                 dense.setAsDouble(student_newMatrix.get(i).get(j), i, j);
             }
         }

         //输出矩阵
         System.out.println(dense);
    }

    //求均值
    public static double GetAverage(ArrayList<Double> list) {
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum / list.size();
    }

    //求方差
    public static double GetCovariance(ArrayList<Double> list) {
        double x1 = GetAverage(list);
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += (list.get(i) - x1) * (list.get(i) - x1);
        }
        return sum / (list.size() - 1);
    }

    //ZScore化
    public static ArrayList<Double> GetZScore(ArrayList<Double> list) {
        double avg = GetAverage(list);
        double s = sqrt(GetCovariance(list));
        ArrayList<Double> ret = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (s != 0) {
                ret.add((list.get(i) - avg) / s);
            }
        }
        return ret;
    }
}

