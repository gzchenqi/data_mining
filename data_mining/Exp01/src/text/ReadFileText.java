package text;


import Entity.Student;
import org.junit.Test;
import util.ReadFile;

import java.io.IOException;
import java.util.ArrayList;

public class ReadFileText {

    /**
     * 测试函数 测试下读取文件是否可用
     * @throws IOException
     */
    @Test
    public void TextReadTxt() throws IOException {
        //String filePath_csv = "src/Data/data.csv";
        String filePath_txt = "src/Data/data.txt";
        ArrayList<Student> list = ReadFile.ReadCsv(filePath_txt);
        System.out.println(list);
    }

    @Test
    public void TextReadCsv() throws IOException {
        String filePath_csv = "src/Data/data.csv";
        //String filePath_txt = "src/Data/data.txt";
        ArrayList<Student> list = ReadFile.ReadCsv(filePath_csv);
        System.out.println(list);
    }

}
