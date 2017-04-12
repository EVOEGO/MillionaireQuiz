/**
 * Created by izaac on 4/04/2017.
 */
public class printStar implements Runnable
{
    private int rowNumber;
    private int number_Of_Stars;

    public printStar(int rowNumber, int number_Of_Stars)
    {
        this.rowNumber = rowNumber;
        this.number_Of_Stars = number_Of_Stars;
    }

    public void run()
    {
        printStar(rowNumber, number_Of_Stars);
    }


    private void printStar(int rowNumber, int number_Of_Stars) {
        while (rowNumber > 1) {
            for (int i = 1; i <= rowNumber; i++) {
                System.out.print(" ");

                if (i == rowNumber) {
                    for (int x = 1; x <= number_Of_Stars; x++) {
                        System.out.print("*");

                    }
                }
            }
            number_Of_Stars = number_Of_Stars + 2;
            --rowNumber;
            System.out.println("");
        }
    }

}
