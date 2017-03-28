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
        boolean checker = false;

        System.out.println("                                                      | WHO WANTS TO BE A MILLIONAIRE |");
        System.out.println("=============================================================================================================================================");
        System.out.println("               ");
        System.out.print("                                                                 Username: ");
        String username = scan.nextLine();

        while(checker == false)
        {
            if(username.equalsIgnoreCase(""))
            {
                System.out.println("                                                          Invalid, try again. ");
                System.out.print("                                                                 Username: ");
                username = "";
                username = scan.nextLine();
            }
            else
            {
                checker = true;
            }
        }

        System.out.println("               ");
        System.out.println("               ");
        System.out.println("=============================================================================================================================================");
        System.out.println("                                           Welcome " + username + " to the who wanted to be a millionaire quiz");
        System.out.println("=============================================================================================================================================");
        System.out.println("\n");

    }

    public static void game() throws IOException, InterruptedException
    {
        Scanner scanInput = new Scanner(System.in);
        Round round = new Round();

            for(int i = 0; i < 15; i++)
            {
                Integer roundNumber = i;
                String answer = "";

                System.out.println("\n");
                System.out.println("This question is worth: $" + score(roundNumber));

                round.create(i);

                if(round.getUsedLifeline1() == true)
                {
                    System.out.println("\n");
                    System.out.println("Available LifeLines: ");
                }
                else if(round.getUsedLifeline1() == false)
                {
                    System.out.println("\n");
                    System.out.println("Available LifeLines: 50/50");
                }

                System.out.print("Answer: ");
                answer = scanInput.nextLine();

                if(answer.equalsIgnoreCase("1") && round.getUsedLifeline1() == false)
                {
                    System.out.println("Lifeline chosen - 50/50");
                    round.fiftyFifty(roundNumber);
                    System.out.print("Answer: ");
                    answer = scanInput.nextLine();
                }
                else if(answer.equalsIgnoreCase("1") && round.getUsedLifeline1() == true)
                {
                    System.out.println("LifeLine has been used.");
                    round.create(i);
                    System.out.print("Answer: ");
                    answer = scanInput.nextLine();
                }

                if(round.quieryAnswer(answer, roundNumber) == true)
                {
                    System.out.println("Correct! for $" + score(roundNumber));

                }
                else if(round.quieryAnswer(answer, roundNumber) == false)
                {
                    System.out.println("incorrect");
                    System.out.println("You lost " + score(roundNumber));
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