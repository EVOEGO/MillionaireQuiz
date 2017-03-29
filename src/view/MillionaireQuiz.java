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
       /*This class stores the prize money arraylist, so i can print the amount each question is worth*/

        Integer prizeMoney = 0;

        ArrayList<Integer> values = new ArrayList<>();
        values.add(500);
        values.add(1000);
        values.add(2000);
        values.add(3000);
        values.add(5000);
        values.add(7500);
        values.add(10000);
        values.add(12500);
        values.add(15000);
        values.add(25000);
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
        /*I put these outside the for loop so that each time the for loop, looped over itself
        * it wont create a new round each time, as my variables would chance and return to default
        * and wouldn't store any data.*/

            for(int i = 0; i < 15; i++)
            {
                Integer roundNumber = i;
                /*keeps track of the roundnumber so that i can use it for some of my variables*/
                String answer = "";

                if(roundNumber == 4)
                {
                    System.out.println("Congratulations on making to the first checkpoint!");
                }
                else if(roundNumber == 9)
                {
                    System.out.println("Congratulations on making to the second checkpoint!");
                }
                else if(roundNumber == 14)
                {
                    System.out.println("CONGRATULATIONS YOUR ON THE LAST QUESTION!!!!!! GOOD LUCK");
                }

                System.out.println("\n");
                System.out.println("This question is worth: $" + score(roundNumber));

                round.create(i);

                if(round.getUsed1() == true && round.getUsed2() == true)
                {
                    System.out.println("\n");
                    System.out.println("Available LifeLines: None");
                }
                else if(round.getUsed1() == false && round.getUsed2() == true)
                {
                    System.out.println("\n");
                    System.out.println("Available LifeLines: 50/50");
                }
                else if(round.getUsed1() == true && round.getUsed2() == false)
                {
                    System.out.println("\n");
                    System.out.println("Available LifeLines: Ask the Audience");
                }
                else if(round.getUsed1() == false && round.getUsed2() == false)
                {
                    System.out.println("\n");
                    System.out.println("Available LifeLines: 50/50 | Ask the Audience");
                }

                /*These blocks of if statemnets, i put there to check if a lifeline has been used or not,
                * if it has been used them it wont be displayhed to the screen, else if it hasn't been
                * used it will be displayed to the screen and still will be able to be used*/

                System.out.print("Answer: ");
                answer = scanInput.nextLine();

                if(answer.equalsIgnoreCase("1") && round.getUsed1() == false)
                {
                    System.out.println("Lifeline chosen - 50/50");
                    round.fiftyFifty(roundNumber);
                    System.out.print("Answer: ");
                    answer = scanInput.nextLine();
                }
                else if(answer.equalsIgnoreCase("1") && round.getUsed1() == true)
                {
                    System.out.println("LifeLine has been used.");
                    round.create(i);
                    System.out.print("Answer: ");
                    answer = scanInput.nextLine();
                }
                if(answer.equalsIgnoreCase("2") && round.getUsed2() == false)
                {
                    System.out.println("LifeLine chosen - Ask the Audience");
                    round.askTheAudience(roundNumber);
                    System.out.println("Answer: ");
                    answer = scanInput.nextLine();
                }
                else if(answer.equalsIgnoreCase("2") && round.getUsed2() == true)
                {
                    System.out.println("LifeLine has been used.");
                    round.create(i);
                    System.out.println("Answer: ");
                    answer = scanInput.nextLine();
                }
                /*else
                {
                    System.out.println("Invalid answer, Try Again...");
                    round.create(i);
                    System.out.print("Answer: ");
                    answer = scanInput.nextLine();
                }*/
                /*If statements above i put there to check to see if the life line has been used before allowing
                * the user to use it, if the life line has been used it will issue a print statement and disallow them
                * the life line. Otherwise if the life line hasn't been used it will display the lifeline and continue
                * to run.*/

                if(round.quieryAnswer(answer, roundNumber) == true)
                {
                   // Thread.sleep(1000);
                    System.out.println("Correct! for $" + score(roundNumber));

                    if(roundNumber == 14)
                    {
                        Thread.sleep(1000);
                        System.out.println("YOU HAVE WON A MILLION DOLLARS!!!!!!");
                        System.out.println("Congratulations!!!!");
                        System.out.println("$" + score(roundNumber));

                    }

                }
                else if(round.quieryAnswer(answer, roundNumber) == false)
                {
                    System.out.println("incorrect");
                    System.out.println("You lost " + score(roundNumber));
                    System.exit(0);
                }

                /*These if statements quiery the answer from the user to make sure if is correct, i did this so that
                * the program can make sure that the user has inputted the correct answer.*/
            }


    }
    public static void main(String[] args) throws IOException, InterruptedException
    {
        boolean power = true;
        view();
        game();


    }

}