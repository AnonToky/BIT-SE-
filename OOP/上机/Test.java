import java.util.ArrayList;
import java.util.Scanner;
//1120230519孙济勋 3.23日作业
public class Test {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<Question> Qlist = new ArrayList<>();
        System.out.println("请输入题目个数");
        int qnum = input.nextInt();
        input.nextLine();
        for(int x = 0;x <qnum; x++){
            System.out.println("请输入题目"+(x+1)+"为单选还是多选，单选为a,多选为b：");
            String s = input.nextLine();
            if(s.equals("a")){
                System.out.println("请输入题目：");
                String text = input.nextLine();

                System.out.println("请输入选项个数：");
                int num = input.nextInt();
                input.nextLine();
                String [] options = new String[num];
                for(int i = 0;i < num; i++){
                    System.out.println("请输入选项"+(i+1)+":");
                    options[i] = input.nextLine();
                }

                System.out.println("请输入答案：");
                char answer =  input.nextLine().charAt(0);

                SingleQuestion singleQuestion = new SingleQuestion(text,options,answer);
                Qlist.add(singleQuestion);
            } else if (s.equals("b")) {
                System.out.println("请输入题目：");
                String text = input.nextLine();

                System.out.println("请输入选项个数：");
                int num = input.nextInt();
                input.nextLine();
                String [] options = new String[num];
                for(int i = 0;i < num; i++){
                    System.out.println("请输入选项"+(i+1)+":");
                    options[i] = input.nextLine();
                }

                System.out.println("请输入答案个数：");
                int num1 = input.nextInt();
                input.nextLine();
                char[] answer = new char[num1];
                for(int i = 0;i < num1; i++){
                    System.out.println("请输入答案"+(i+1)+":");
                    answer[i] = input.nextLine().charAt(0);
                }

                MultiQuestion multiQuestion = new MultiQuestion(text,options,answer);
                Qlist.add(multiQuestion);
            }
        }

        System.out.println("开始测试");
        for(Question Q: Qlist){
            Q.print();
            String Sanswers = input.nextLine();
            char[] answers = Sanswers.toCharArray();
            if(Q.check(answers)){
                System.out.println("答对");
                continue;
            }
            else{
                System.out.println("答错或系统出错");
            }
        }

    }
}
