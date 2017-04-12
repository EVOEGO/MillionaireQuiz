/**
 * Created by izaac on 3/04/2017.
 */
public class Counter
{
    public static void main(String[] args)
    {
       OddNEven odd = new OddNEven(1, 1000);
       OddNEven even = new OddNEven(0, 1000);
       Thread oddNumber = new Thread(odd);
       Thread evenNumber = new Thread(even);

        oddNumber.start();
        evenNumber.start();

    }

}



