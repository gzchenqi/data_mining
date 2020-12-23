package print;

import Entity.Student;
import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;
import util.DataProcess;
import util.FilePath;

import java.io.IOException;
import java.util.ArrayList;

import static java.lang.StrictMath.sqrt;

public class ques04 {
    /**
     * 计算协相关矩阵，并画出混淆矩阵。
     */
    public static void main(String[] args) throws IOException {

        FilePath filepath = new FilePath();
        String filePath_csv = filepath.filePath_csv;
        String filePath_txt = filepath.filePath_txt;

        ArrayList<Student> student_list = DataProcess.MergeDuplicateRemoval_CsvAndTxt(filePath_csv, filePath_txt);
        ArrayList<ArrayList<Double>> student_Matrix = new ArrayList<>();

        //对数据进行处理
        for (int i = 0; i < student_list.size(); i++) {
            ArrayList<Double> student_c = new ArrayList<>();
            student_c.add((double) student_list.get(i).getC1());
            student_c.add((double) student_list.get(i).getC2());
            student_c.add((double) student_list.get(i).getC3());
            student_c.add((double) student_list.get(i).getC4());
            student_c.add((double) student_list.get(i).getC5());
            student_c.add((double) student_list.get(i).getC6());
            student_c.add((double) student_list.get(i).getC7());
            student_c.add((double) student_list.get(i).getC8());
            student_c.add((double) student_list.get(i).getC9());
            student_c.add((double) student_list.get(i).getC10());
            student_c.add(DataProcess.TransformConstitution(student_list.get(i).getConstitution()));
            student_Matrix.add(student_c);
        }

        //把计算后的数据添加进新的列表
        ArrayList<ArrayList<Double>> student_newMatrix = new ArrayList<>();
        for (int i = 0; i < student_Matrix.size(); i++) {
            ArrayList<Double> ret=new ArrayList<>();
            for (int j = 0; j < student_Matrix.size(); j++) {
                ret.add(GetCorrelation(student_Matrix.get(i),student_Matrix.get(j)));
            }
            student_newMatrix.add(ret);
        }

        //把数据添加进矩阵
        Matrix dense = DenseMatrix.Factory.zeros(student_newMatrix.size(), student_newMatrix.get(1).size());
        for (int i = 0; i < student_newMatrix.size(); i++) {
            for (int j = 0; j < student_newMatrix.get(i).size(); j++) {
                dense.setAsDouble(student_newMatrix.get(i).get(j), i, j);
            }
        }

        //输出结果
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
    public static double GetCorrelation(ArrayList<Double> listx,ArrayList<Double> listy){
        ArrayList<Double> listA = GetZScore(listx);
        ArrayList<Double> listB = GetZScore(listy);
        double sum=0;
        for (int i = 0; i < listA.size()&&i<listB.size(); i++) {
            sum += listA.get(i) * listB.get(i);
        }
        return sum;
    }
}
