import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    private String courseName;
    private int credit;

    public Course(String courseName, int credit) {
        this.courseName = courseName;
        this.credit = credit;
    }

    // Getter 和 Setter
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public int getCredit() {
        return credit;
    }
    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return courseName + " (" + credit + "学分)";
    }
}

class Stu {
    private String name;
    private String grade;
    private List<Course> courses; // 存储学生选课

    public Stu(String name, String grade) {
        this.name = name;
        this.grade = grade;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }

    public List<Course> getCourses() {
        return courses;
    }
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    // 添加一门课程
    public void addCourse(Course course) {
        courses.add(course);
    }

    public int getHours() {
        int totalCredits = 0;
        for (Course course : courses) {
            totalCredits += course.getCredit();
        }
        return totalCredits;
    }

    public void showMessage() {
        System.out.println("学生姓名：" + name);
        System.out.println("年级：" + grade);
        System.out.println("所选课程：");
        if(courses.isEmpty()){
            System.out.println("  暂无课程信息");
        } else {
            for (Course course : courses) {
                System.out.println("  " + course.getCourseName() + " - " + course.getCredit() + "学分");
            }
        }
        System.out.println("总学分：" + getHours());
        System.out.println("----------------------------");
    }
}

public class TestStudentCourse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入课程信息
        System.out.print("请输入课程门数：");
        int courseCount = scanner.nextInt();
        scanner.nextLine();

        List<Course> courseList = new ArrayList<>();
        for (int i = 0; i < courseCount; i++) {
            System.out.println("请输入第 " + (i + 1) + " 门课程名称：");
            String courseName = scanner.nextLine();
            System.out.println("请输入课程学分：");
            int credit = scanner.nextInt();
            scanner.nextLine();
            Course course = new Course(courseName, credit);
            courseList.add(course);
        }

        // 输入学生信息
        System.out.print("请输入学生人数：");
        int studentCount = scanner.nextInt();
        scanner.nextLine(); // 吸收换行符

        List<Stu> studentList = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            System.out.println("请输入第 " + (i + 1) + " 个学生的姓名：");
            String name = scanner.nextLine();
            System.out.println("请输入学生年级：");
            String grade = scanner.nextLine();
            Stu student = new Stu(name, grade);

            // 输入该学生所选课程数
            System.out.print("请输入该学生选课门数：");
            int selectedCourseCount = scanner.nextInt();
            scanner.nextLine();
            for (int j = 0; j < selectedCourseCount; j++) {
                System.out.println("请输入第 " + (j + 1) + " 门选课名称：");
                String selectedCourseName = scanner.nextLine();
                // 在课程列表中查找是否存在该课程
                boolean found = false;
                for (Course course : courseList) {
                    if(course.getCourseName().equalsIgnoreCase(selectedCourseName)){
                        student.addCourse(course);
                        found = true;
                        break;
                    }
                }
                if(!found){
                    System.out.println("没有找到课程[" + selectedCourseName + "]，请确保输入正确的课程名称！");
                }
            }
            studentList.add(student);
        }

        // 输出所有学生的选课信息
        System.out.println("\n所有学生选课信息如下：");
        for (Stu student : studentList) {
            student.showMessage();
        }

        scanner.close();
    }
}
