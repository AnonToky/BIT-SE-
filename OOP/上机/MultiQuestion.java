public class MultiQuestion extends Question{
    private char[] answer;//answer是期待的正确答案
    public MultiQuestion(){}

    public MultiQuestion(String text,String[] options,char[]answer){
        this.answer = answer;
        this.text = text;
        this.options = options;
    }

    @Override
    public boolean check(char[] answers) {//answers是输入的答案
        if(answers.length != answer.length) return false;
        for(int i=0; i<answers.length; i++){
            boolean found = false;
            for(int j=0; j< answers.length; j++){
                if(answers[i] == answer[j]){
                    found = true;
                    break;
                }
                if(j == answers.length-1 && !found){
                    return false;
                }
            }
        }
        return true;
    }
}
//1120230519孙济勋 3.23日作业