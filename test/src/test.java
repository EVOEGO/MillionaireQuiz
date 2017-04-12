import java.util.Scanner;

/**
 * Created by izaac on 7/04/2017.
 */
public class test
{
    public static boolean isPrime(double n) {
        int i;
        for (i = 2; i <= n / 2; i++)   {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        double input = 0;
        boolean answer;


        System.out.println("Input: ");
        input = scan.nextInt();

        answer = isPrime(input);
        System.out.println(answer);



    }
}
