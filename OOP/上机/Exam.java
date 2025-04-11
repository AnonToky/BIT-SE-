import java.util.*;

public class Exam {
    private Student student;
    private Paper paper;
    private AnswerSheet answerSheet;

    public Exam() {
    }

    public Exam(Student student) {
        this.student = student;
        this.paper = new Paper();
        this.answerSheet = new AnswerSheet();
    }

    public Student getStudent() {
        return student;
    }

    public Paper getPaper() {
        return paper;
    }

    public AnswerSheet getAnswerSheet() {
        return answerSheet;
    }

    public void createPaper(List<Question> questionList) {//这里您是不是ppt上标错了，createPaper应该得告诉题是啥吧
        for (int i = 0; i < questionList.size(); i++) {
            paper.addQuestion(i + 1, questionList.get(i));
        }
    }

    public void answerQuestions() {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, Question> questions = paper.getQuestions();
        for (Map.Entry<Integer, Question> entry : questions.entrySet()) {
            int questionNumber = entry.getKey();
            Question question = entry.getValue();
            System.out.println("题目" + questionNumber + ":");
            question.showQuestion();

            System.out.println("输入答案(A, B, C, etc.):");
            String answer = scanner.nextLine();
            answerSheet.addAnswer(questionNumber, answer);
        }
    }

    public void showScoreOfPaper() {
        Map<Integer, Question> questions = paper.getQuestions();
        Map<Integer, String> answers = answerSheet.getAnswers();
        int correctCount = 0;

        System.out.println("Student: " + student.getName());
        for (Map.Entry<Integer, Question> entry : questions.entrySet()) {
            int questionNumber = entry.getKey();
            Question question = entry.getValue();
            String studentAnswer = answers.get(questionNumber);
            String correctAnswer = question.getAnswer();
            boolean correct = false;

            if (studentAnswer != null && studentAnswer.equalsIgnoreCase(correctAnswer)) {
                correct = true;
                correctCount++;
            }

            System.out.println("题目 " + questionNumber + ": 你的回答: " + studentAnswer +
                    ", 正确回答为: " + correctAnswer + ", 回答结果: " + correct);
        }

        System.out.println("总分: " + correctCount + " / " + paper.getCount());
    }

}

class AnswerSheet {
    private Map<Integer, String> answers = new HashMap<>();


    public void addAnswer(int key, String answer) {
        this.answers.put(key, answer);
    }

    public AnswerSheet() {
    }

    public Map<Integer, String> getAnswers() {
        return answers;
    }
}

class Student {
    private String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
