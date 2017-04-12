/**
 * Created by izaac on 4/04/2017.
 */
public class Star
{
    public static void main(String[] args)
    {
        int max=9;
        int number_Of_Stars = 1;
        //System.out.println("Figure:");
      //  aStar.printStar(max, number_Of_Stars);

        printStar star = new printStar(max, number_Of_Stars);
        Thread newStar = new Thread(star);
        newStar.start();

    }

}


