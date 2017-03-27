package view;

import controller.AttributeDataBase;
import controller.Attributes;
import controller.Round;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class MillionaireQuiz
{
    private AttributeDataBase quizQuestions;

    public static Integer score(Integer round)
    {
        Integer prizeMoney = 0;

        ArrayList<Integer> values = new ArrayList<>();
        values.add(500);
        values.add(1000);
        values.add(2000);
        values.add(3000);
        values.add(5000);
        values.add(7000);
        values.add(10000);
        values.add(20000);
        values.add(300000);
        values.add(50000);
        values.add(100000);
        values.add(250000);
        values.add(500000);
        values.add(1000000);

        prizeMoney = values.get(round);

        return prizeMoney;
    }

    public static void view() throws IOException, InterruptedException
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("                                                      | WHO WANTS TO BE A MILLIONAIRE |");
        System.out.println("=============================================================================================================================================");
        System.out.println("               ");
        System.out.print("                                                  Username: ");
        String username = scan.nextLine();
        System.out.println("               ");
        System.out.println("               ");
        System.out.println("=============================================================================================================================================");
        System.out.println("                                           Welcome " + username + " to the who wanted to be a millionaire quiz");
        System.out.println("=============================================================================================================================================");
        System.out.println("\n");

    }

    public static void game() throws IOException, InterruptedException
    {
            for(int i = 0; i < 15; i++)
            {
                Scanner scanInput = new Scanner(System.in);
                Round round = new Round();
                Integer roundNumber = i;
                System.out.println("\n");

                System.out.println("This question is worth: $" + score(roundNumber));

                String answer = "";
                //System.out.println("");

                round.create(i);

                System.out.print("Answer: ");
                answer = scanInput.nextLine();

               if(round.quieryAnswer(answer) == true)
                {
                    System.out.println("Correct!");

                }
                else if(round.quieryAnswer(answer) == false)
                {
                    System.out.println("incorrect");
                    System.exit(0);

                }
            }


    }
    public static void main(String[] args) throws IOException, InterruptedException
    {
        boolean power = true;
        view();
        game();


    }

}