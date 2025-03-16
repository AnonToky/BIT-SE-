import java.util.*;

//1120230519孙济勋 作业2025.3.16
class Student {
    private int id;
    private String name;
    private int age;
    private String gender;
    public static int total;

    public Student(int id, String name, int age, String gender) {//set
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Getter方法
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public int getTotal(){
        return total;
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + age + "\t" + gender + "\t";
    }
}

public class StudentInf {
    public static void main(String[] args) {
        // 初始化数据集合
        ArrayList<Student> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入学生总数：");
        int n = scanner.nextInt();

        for(int i = 0;i < n;i++){
            System.out.println("输入第"+(i+1)+"名学生的id");
            int id = scanner.nextInt();
            scanner.nextLine();//清除换行符，否则后续读取会出错
            System.out.println("输入第"+(i+1)+"名学生的姓名");
            String name = scanner.nextLine();
            System.out.println("输入第"+(i+1)+"名学生的年龄");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.println("输入第"+(i+1)+"名学生的性别");
            String gender = scanner.nextLine();
            System.out.println("--------------------------");
            Student stu = new Student(id,name,age,gender);
            list.add(stu);
            Student.total++;
        }

        System.out.println("\n");
        printList(list);
    }

    private static void printList(ArrayList<Student> list){
        for (Student s : list) {
            System.out.println(s);

        }
    }
}

