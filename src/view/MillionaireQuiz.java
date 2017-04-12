package view;

import com.sun.org.apache.xpath.internal.SourceTree;
import controller.AttributeDataBase;
import controller.Attributes;
import controller.Round;
import controller.highScores;

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

    public static void printMENU()
    {
        System.out.println("                                                      | WHO WANTS TO BE A MILLIONAIRE |");
        System.out.println("=============================================================================================================================================");
        System.out.println("                                                            (1) Start New Game");
        System.out.println("                                                            (2) HighScores ");
        System.out.println("                                                            (3) Exit");
        System.out.println("");
        System.out.print("                                                                 Input: ");
    }


    public static void MENU()
    {
        Scanner scan = new Scanner(System.in);
        String userChoice = "";
        boolean correctInput = false;
        highScores score = new highScores();

        printMENU();
        //I added this method so that i didn't have to have big blocks of system.out. It made my code alot easier to work with

        userChoice = scan.nextLine();

       while(correctInput == false)
       {
           if(userChoice.equalsIgnoreCase("1"))
           {
                correctInput = true;
           }
           else if(userChoice.equalsIgnoreCase("2"))
           {
               score.initaliseHighScores();
               //Initalises the highscores, by reading them in
               System.out.println("");
               System.out.println("                                                                | HIGHSCORES |");
               System.out.println("=============================================================================================================================================");

               for(int x = 0; x < score.get_SORTED_SCORES().size(); x++)
               {
                   System.out.print("                                                     " + score.get_SORTED_SCORES().get(x) + " : " + "");
                   x++;
                   System.out.println(score.get_SORTED_SCORES().get(x));
                   //prints out the highscores
               }

               System.out.println("=============================================================================================================================================");
               System.out.println("");
               printMENU();
               System.out.print("                                                     Input: ");
               userChoice = scan.nextLine();

           }
           else if(userChoice.equalsIgnoreCase("3"))
           {
               System.out.println("                                                     What was the point in opening the program.................");

               try
               {
                   Thread.sleep(1000);
               }
               catch (InterruptedException e)
               {
                   e.printStackTrace();
               }
                /*Try catch loops so that i handle the error instead of ignoring them*/

               System.exit(0);
           }
           else
           {
               System.out.println("                                                       Incorrect input, try again");
               userChoice = "";
               System.out.print("                                                                 Input: ");
               userChoice = scan.nextLine();
               //error message, to make sure the user enters in the correct input
           }
       }

    }

    public static String view()
    {
        Scanner scan = new Scanner(System.in);
        boolean checker = false;
        highScores score = new highScores();

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

        return username;
    }

    private static void rules()
    {
        System.out.println("                                                                      Rules ");
        System.out.println("=============================================================================================================================================");
        System.out.println("                              For General GamePlay You Will Need To Select One Of The Following Answers Given, In Order");
        System.out.println("                                                       To Advance To The Next Question.");
        System.out.println("=============================================================================================================================================");
        System.out.println("                                           In Order To Access Lifelines You Will Need To Do The Following");
        System.out.println("                                                         Input The Number: 1 - 50/50");
        System.out.println("                                                         Input The Number: 2 - Ask The Audience");
        System.out.println("                                                         Input The Number: 3 - Phone A Friend");
        System.out.println("=============================================================================================================================================");
        System.out.println("                                                 If You Want To Take The Money At Any Stage Of The Game");
        System.out.println("                                                                 Input - Run");
        System.out.println("=============================================================================================================================================");

        /*try {
            Thread.sleep(5000);
        }catch (InterruptedException e)
        {
            System.err.println("InterruptedException: " + e.getMessage());
        }*/

    }

    public static void game(String name)
    {
        Scanner scanInput = new Scanner(System.in);
        Round round = new Round();
        Integer roundNumber;
        String username;
        Boolean correctInput;
        String answer;
        Integer prize;

        /*I put these outside the for loop so that each time the for loop, looped over itself
        * it wont create a new round each time, as my variables would chance and return to default
        * and wouldn't store any data.*/

            for(int i = 0; i < 15; i++)
            {
                roundNumber = i;
                username = name;
                correctInput = false;
                /*keeps track of the roundnumber so that i can use it for some of my variables*/
                answer = "";

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
               // System.out.print("Answer: ");
                //answer = scanInput.nextLine();

                while(correctInput == false)
                {
                    System.out.print("Available Lifelines: ");

                   if(round.getUsed1() == false)
                   {
                       System.out.print("50/50");
                       System.out.print(" | ");
                   }
                   if(round.getUsed2() == false)
                   {
                       System.out.print("Ask the Audience");
                       System.out.print(" | ");
                   }
                   if(round.getUsed3() == false)
                   {
                       System.out.print("Phone A Friend");
                       System.out.print(" | ");;
                   }
                   else
                   {
                       System.out.println("None");
                   }

                    System.out.print("\n");

                    System.out.print("Answer: ");
                    answer = scanInput.nextLine();


                /*These blocks of if statemnets, i put there to check if a lifeline has been used or not,
                * if it has been used them it wont be displayhed to the screen, else if it hasn't been
                * used it will be displayed to the screen and still will be able to be used*/


                    if(answer.equalsIgnoreCase("1") && round.getUsed1() == false)
                    {
                        System.out.println("Lifeline chosen - 50/50");
                        System.out.println("\n");
                        round.fiftyFifty(roundNumber);

                    }
                    else if(answer.equalsIgnoreCase("1") && round.getUsed1() == true) {
                        System.out.println("LifeLine has been used.");
                        round.create(i);
                    }
                    if(answer.equalsIgnoreCase("2") && round.getUsed2() == false)
                    {
                        System.out.println("LifeLine chosen - Ask the Audience");
                        round.askTheAudience(roundNumber);

                    }
                    else if(answer.equalsIgnoreCase("2") && round.getUsed2() == true)
                    {
                        System.out.println("LifeLine has been used.");
                        round.create(i);
                        System.out.println("\n");

                    }
                    else if(answer.equalsIgnoreCase("3") && round.getUsed3() == false)
                    {
                        System.out.println("LifeLine chosen - Phone A Friend");
                        System.out.println("\n");
                        round.phoneAFriend(username, roundNumber);


                    }
                    else if(answer.equalsIgnoreCase("3") && round.getUsed3() == true)
                    {
                        System.out.println("LifeLine has been used.");
                        round.create(i);

                    }
                    else if(answer.equalsIgnoreCase("help"))
                    {
                        rules();
                        round.create(i);
                    }
                    else if(answer.equalsIgnoreCase("run"))
                    {
                        System.out.println("Congratulations you took the money and ended up with " + score(roundNumber));
                        System.out.println("Goodluck and thank for you for playing ");
                        System.out.println("WHO WANTS TO BE A MILLIONAIRE!!!!");
                        highScores score = new highScores();
                        prize = score(roundNumber);
                        score.saveHighScore(prize, username);
                        System.exit(0);
                    }

                    if(answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("b"))
                    {
                        correctInput = true;

                    }
                    else if(answer.equalsIgnoreCase("c") || answer.equalsIgnoreCase("d"))
                    {
                        correctInput = true;

                    }

                }
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
                        try {
                            Thread.sleep(1000);
                        }catch (InterruptedException e)
                        {
                            System.err.println("InterruptedException: " + e.getMessage());
                        }
                        System.out.println("YOU HAVE WON A MILLION DOLLARS!!!!!!");
                        System.out.println("Congratulations!!!!");
                        System.out.println("$" + score(roundNumber));

                    }

                }
                else if(round.quieryAnswer(answer, roundNumber) == false)
                {
                    highScores score = new highScores();
                    prize = score(roundNumber);
                    score.saveHighScore(prize, username);
                    System.out.println("incorrect");
                    System.out.println("You lost " + score(roundNumber));
                    System.out.println("Thank you for playing Who Wants To Be A Millionaire Quiz");
                    System.exit(0);
                }

                /*These if statements quiery the answer from the user to make sure if is correct, i did this so that
                * the program can make sure that the user has inputted the correct answer.*/
            }


    }
    public static void main(String[] args) throws IOException, InterruptedException
    {
        boolean power = true;
        //view();
        MENU();
        String name = view();
        rules();
        game(name);


    }

}