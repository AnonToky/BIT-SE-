import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//第二题
class Student {
    private int id;
    private String name;
    private int age;
    private int grade;

    public Student(int id, String name, int age, int grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
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

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + age + "\t" + grade;
    }
}

public class StudentSortTest {
    public static void main(String[] args) {
        // 初始化数据集合
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "ZhangSan", 28, 98));
        list.add(new Student(2, "LiSi", 21, 100));
        list.add(new Student(3, "KangKang", 27, 89));
        list.add(new Student(4, "LiMing", 19, 92));
        list.add(new Student(5, "WangGang", 22, 66));
        list.add(new Student(6, "ZhaoXin", 24, 85));
        list.add(new Student(7, "LiuWei", 20, 78));
        list.add(new Student(8, "BaiZhanTang", 16, 99));

        // 按Name排序
        List<Student> nameSortedList = new ArrayList<>(list);
        Collections.sort(nameSortedList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });
        System.out.println("按Name排序：");
        printList(nameSortedList);

        // 按Age排序（倒序）
        List<Student> ageSortedList = new ArrayList<>(list);
        Collections.sort(ageSortedList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s2.getAge() - s1.getAge();//用减法，下同
            }
        });
        System.out.println("\n按Age倒序排序：");
        printList(ageSortedList);

        // 按Grade排序
        List<Student> gradeSortedList = new ArrayList<>(list);
        Collections.sort(gradeSortedList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getGrade() - s2.getGrade();//同上
            }
        });
        System.out.println("\n按Grade排序：");
        printList(gradeSortedList);
    }

    private static void printList(List<Student> list) {
        System.out.println("ID\tName\t\tAge\tGrade");
        for (Student s : list) {
            System.out.println(s);
        }
    }
}

