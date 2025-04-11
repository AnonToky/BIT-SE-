import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class TestExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("学生姓名：");
        String studentName = scanner.nextLine();
        Student student = new Student(studentName);

        System.out.println("题目数量：");
        int questionCount = scanner.nextInt();
        scanner.nextLine();

        Exam exam = new Exam(student);

        List<Question> questionList = new ArrayList<>();
        for (int i = 1; i <= questionCount; i++) {
            System.out.println("请输入题目" + i);

            System.out.println("请输入题目名称：");
            String title = scanner.nextLine();

            List<String> options = new ArrayList<>();
            System.out.println("输入选项 (用英文逗号分隔 e.g., A, B, C):");
            String optionsLine = scanner.nextLine();
            String[] optionsArray = optionsLine.split(",");
            for (String option : optionsArray) {
                options.add(option.trim());
            }

            System.out.println("输入正确选项 (A, B, C, etc.):");
            String answer = scanner.nextLine().toUpperCase();

            Question question = new Question(title, options, answer);
            questionList.add(question);
        }

        System.out.println(studentName+"开始做答");
        exam.createPaper(questionList);

        exam.answerQuestions();

        exam.showScoreOfPaper();

        scanner.close();
    }
}
