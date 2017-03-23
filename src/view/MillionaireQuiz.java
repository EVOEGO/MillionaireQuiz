package view;

import controller.AttributeDataBase;

import java.io.IOException;
import java.util.Scanner;


public class MillionaireQuiz
{
    private AttributeDataBase quizQuestions;

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

    public static void game(boolean power) throws IOException, InterruptedException
    {
        while(power == true)
        {
            Scanner scanInput = new Scanner(System.in);

            String answer = "";
            AttributeDataBase attributeDatabase = new AttributeDataBase();
            attributeDatabase.initaliseQuestionDataBase();

            System.out.println(attributeDatabase.getQuestion(1).toString());
            //System.out.println(attributeDatabase.getIncorrect1(1).toString());
            System.out.print("Answer: ");
            answer = scanInput.nextLine();


        }
    }
    public static void main(String[] args) throws IOException, InterruptedException
    {
        boolean power;
        view();
        power = true;
        game(power);








    }

}