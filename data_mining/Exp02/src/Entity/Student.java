package Entity;

/**
 * 数据库表：ID (int),  姓名(string),
 * 家乡(string:限定为Beijing / Guangzhou / Shenzhen / Shanghai),
 * 性别（string:boy/girl）、身高（float:单位是cm)）、
 * 课程1成绩（float）、课程2成绩（float）、...、课程10成绩(float)、
 * 体能测试成绩（string：bad/general/good/excellent）；
 */
public class Student {
    int id;
    String studentId;
    String Name;
    String City;
    String gender;
    float Height;
    float C1;
    float C2;
    float C3;
    float C4;
    float C5;
    float C6;
    float C7;
    float C8;
    float C9;
    float C10;
    String Constitution;

    public Student(int id, String studentId, String name, String city, String gender, float height, float c1, float c2, float c3, float c4, float c5, float c6, float c7, float c8, float c9, float c10, String constitution) {
        this.id = id;
        this.studentId = studentId;
        Name = name;
        City = city;
        this.gender = gender;
        Height = height;
        C1 = c1;
        C2 = c2;
        C3 = c3;
        C4 = c4;
        C5 = c5;
        C6 = c6;
        C7 = c7;
        C8 = c8;
        C9 = c9;
        C10 = c10;
        Constitution = constitution;
    }
    public Student(){
        this.C1 = 0;
        this.C2 = 0;
        this.C3 = 0;
        this.C4 = 0;
        this.C5 = 0;
        this.C6 = 0;
        this.C7 = 0;
        this.C8 = 0;
        this.C9 = 0;
        this.C10 = 0;
        this.id = 0;
        this.studentId = "0";
        this.gender = "0";
        this.Name = "0";
        this.City = "0";
        this.Constitution = "0";

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getHeight() {
        return Height;
    }

    public void setHeight(float height) {
        Height = height;
    }

    public float getC1() {
        return C1;
    }

    public void setC1(float c1) {
        C1 = c1;
    }

    public float getC2() {
        return C2;
    }

    public void setC2(float c2) {
        C2 = c2;
    }

    public float getC3() {
        return C3;
    }

    public void setC3(float c3) {
        C3 = c3;
    }

    public float getC4() {
        return C4;
    }

    public void setC4(float c4) {
        C4 = c4;
    }

    public float getC5() {
        return C5;
    }

    public void setC5(float c5) {
        C5 = c5;
    }

    public float getC6() {
        return C6;
    }

    public void setC6(float c6) {
        C6 = c6;
    }

    public float getC7() {
        return C7;
    }

    public void setC7(float c7) {
        C7 = c7;
    }

    public float getC8() {
        return C8;
    }

    public void setC8(float c8) {
        C8 = c8;
    }

    public float getC9() {
        return C9;
    }

    public void setC9(float c9) {
        C9 = c9;
    }

    public float getC10() {
        return C10;
    }

    public void setC10(float c10) {
        C10 = c10;
    }

    public String getConstitution() {
        return Constitution;
    }

    public void setConstitution(String constitution) {
        Constitution = constitution;
    }
}
