package controller;

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by izaac on 22/03/2017.
 */
public class Round
{
    public String a;
    public String b;
    public String c;
    public String d;
    boolean used50;
    //private boolean used50;
    private  AttributeDataBase finalGame = new AttributeDataBase();

    public Integer randomNumber(int chance)
    {
        int number = 0;

        Random random = new Random();

        number  = random.nextInt((chance - 35) + 1) + 35;


        return number;
    }

    public void create(int i)
    {
        ArrayList<String> quizAnswers = new ArrayList<String>();

        String correctAnswer = " ";
        a = "";
        b = "";
        c = "";
        d = "";

        quizAnswers.add(finalGame.getQuestions().get(i).getAnswer());
        quizAnswers.add(finalGame.getQuestions().get(i).getIncorrect1());
        quizAnswers.add(finalGame.getQuestions().get(i).getIncorrect2());
        quizAnswers.add(finalGame.getQuestions().get(i).getIncorrect3());
        Collections.shuffle(quizAnswers);
        System.out.println(finalGame.getQuestions().get(i).getQuestion());

        for(int q = 0; q < quizAnswers.size(); q++)
        {
            if(q == 0)
            {
                System.out.println("A. " + quizAnswers.get(q));
                a = quizAnswers.get(q);

            }
            else if(q == 1)
            {
                System.out.println("B. " + quizAnswers.get(q));
                b = quizAnswers.get(q);
            }
            if(q == 2)
            {
                System.out.println("C. " + quizAnswers.get(q));
                c = quizAnswers.get(q);
            }
            else if(q == 3)
            {
                System.out.println("D. " + quizAnswers.get(q));
                d = quizAnswers.get(q);

            }

        }

    }

    public boolean quieryAnswer(String input, Integer round)
    {
        int i = round;
        boolean answer = false;

        if(input.equalsIgnoreCase("a"))
        {
            if(finalGame.getQuestion(i).getAnswer().equalsIgnoreCase(a))
            {
                answer = true;
            }

        }
        else if(input.equalsIgnoreCase("b"))
        {
            if(finalGame.getQuestion(i).getAnswer().equalsIgnoreCase(b))
            {
                answer = true;
            }
        }
        if(input.equalsIgnoreCase("c"))
        {
            if(finalGame.getQuestion(i).getAnswer().equalsIgnoreCase(c))
            {
                answer = true;
            }
        }
        else if(input.equalsIgnoreCase("d"))
        {
            if(finalGame.getQuestion(i).getAnswer().equalsIgnoreCase(d))
            {
                answer = true;
            }
        }

        return answer;
    }

    public boolean fiftyFifty(Integer round)
    {
        //fifty fitfy
        int i = round;
        boolean active = true;

        while(active == true)
        {
            if(finalGame.getQuestion(i).getAnswer().equalsIgnoreCase(a) || finalGame.getQuestion(i).getAnswer().equalsIgnoreCase(b))
            {
                System.out.println("\n");
                System.out.println("\n");
                System.out.println(finalGame.getQuestions().get(i).getQuestion());
                System.out.println("A. " + a);
                System.out.println("B. " + b);
                used50 = true;
                break;
            }
            else if(finalGame.getQuestion(i).getAnswer().equalsIgnoreCase(c) || finalGame.getQuestion(i).getAnswer().equalsIgnoreCase(d))
            {
                System.out.println("\n");
                System.out.println("\n");
                System.out.println(finalGame.getQuestions().get(i).getQuestion());
                System.out.println("C. " + c);
                System.out.println("D. " + d);
                used50 = true;
                break;
            }
        }

        return used50 = true;
    }

    public void lifeLine2(Integer round)
    {
        //ask the audience
        int i = round;
        boolean answer = false;

        if(finalGame.getQuestion(i).getAnswer().equalsIgnoreCase(a))
        {
            if(finalGame.getQuestion(i).getDifficulty().equalsIgnoreCase("1"))
            {

            }

        }
        else if(finalGame.getQuestion(i).getAnswer().equalsIgnoreCase(b))
        {
            answer = true;
        }
        if(finalGame.getQuestion(i).getAnswer().equalsIgnoreCase(c))
        {
            answer = true;
        }
        else if(finalGame.getQuestion(i).getAnswer().equalsIgnoreCase(d))
        {
            answer = true;
        }


    }
    public void lifeLine3()
    {
        //switch question
    }

    public boolean getUsedLifeline1()
    {
        return used50;
    }
}

