import java.util.Scanner;
import java.math.BigDecimal;
import java.math.BigInteger;
//老师，这道题要干什么我没看懂，我按照自己的理解写的但感觉不太对(太简陋了)，要是需要改还麻烦您邮箱告诉我2457495959@qq.com
public class T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float a = scanner.nextFloat();
        float b = scanner.nextFloat();
;
        System.out.println("int 加法: " + ((int)a + (int)b));
        System.out.println("int 减法: " + ((int)a - (int)b));
        System.out.println("int 乘法: " + ((int)a * (int)b));
        System.out.println("int 除法: " + ((int)a / (int)b));

        System.out.println("\nfloat 加法: " + (a+ b));
        System.out.println("float 减法: " + (a- b));
        System.out.println("float 乘法: " + (a* b));
        System.out.println("float 除法: " + (a/ b));

        BigInteger e = BigInteger.valueOf((int)a);
        BigInteger f = BigInteger.valueOf((int)b);
        System.out.println("\nBigInteger 加法: " + e.add(f));
        System.out.println("BigInteger 减法: " + e.subtract(f));
        System.out.println("BigInteger 乘法: " + e.multiply(f));
        System.out.println("BigInteger 除法: " + e.divide(f));

        BigDecimal g = BigDecimal.valueOf(a);
        BigDecimal h = BigDecimal.valueOf(b);
        System.out.println("\nBigDecimal 加法: " + g.add(h));
        System.out.println("BigDecimal 减法: " + g.subtract(h));
        System.out.println("BigDecimal 乘法: " + g.multiply(h));
        System.out.println("BigDecimal 除法: " + g.divide(h, 10, BigDecimal.ROUND_HALF_UP)); // 保留10位+四舍五入

    }

}