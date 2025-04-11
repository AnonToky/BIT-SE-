import java.util.HashMap;
import java.util.Map;

public class Paper {
    private Map<Integer, Question> questions = new HashMap<>();
    private int count;

    public Paper() {
    }

    public Paper(int count) {
        this.count = count;
    }

    public void addQuestion(int index, Question question) {//老师，您这里是否在ppt的图中少写了形参question
        this.questions.put(index, question);
    }

    public Map<Integer, Question> getQuestions() {
        return questions;
    }

    public int getCount() {
        return count;
    }

    public void showPaper() {
        for (Map.Entry<Integer, Question> entry : questions.entrySet()) {
            System.out.println("Question " + entry.getKey() + ":");
            entry.getValue().showQuestion();
            System.out.println("\n");
        }
    }
}

