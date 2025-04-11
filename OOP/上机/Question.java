public class Question {
    protected String text;
    protected String[] options;

    public Question(){}

    public Question(String text,String[] options){
        this.text = text;
        this.options = options;
    }

    public boolean check(char[] answers){
        return false;
    }

    public void print(){
        System.out.println(text);
        for(String s : options) {
            System.out.println(s );
        }
        System.out.println("请选择：");
    }
}
//1120230519孙济勋 3.23日作业