public class SingleQuestion extends Question{
    private char answer;//answer是期待的正确答案
    public SingleQuestion(){}

    public SingleQuestion(String text,String[] options,char answer){
        this.answer = answer;
        this.text = text;
        this.options = options;
    }

    @Override
    public boolean check(char[] answers) {//answers是输入的答案
        if(answers.length == 1 && answers[0] == answer) return true;
        else return false;
    }
}
//1120230519孙济勋 3.23日作业