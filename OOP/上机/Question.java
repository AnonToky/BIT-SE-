import java.util.List;

public class Question {
    private String title;
    private List<String> options;
    private String answer;

    public Question() {
    }

    public Question(String title, List<String> options, String answer) {
        this.title = title;
        this.options = options;
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void showQuestion() {
        System.out.println(title);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }
}
