package controller;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by izaac on 22/03/2017.
 */
public class Round
{
    public String a;
    public String b;
    public String c;
    public String d;
    private  AttributeDataBase finalGame = new AttributeDataBase();

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

    public boolean quieryAnswer(String input)
    {
        int correctAnswer = 0;
        boolean answer = true;

        for(int i = 0; i < finalGame.getQuestions().size(); i++)
        {
            if(input.equalsIgnoreCase("a"))
            {
                if(finalGame.getQuestion(i).getAnswer().equalsIgnoreCase(a))
                {
                    answer = true;
                    break;
                }

            }
            else if(input.equalsIgnoreCase("b"))
            {
                if(finalGame.getQuestion(i).getAnswer().equalsIgnoreCase(b))
                {
                    answer = true;
                    break;
                }
            }
            if(input.equalsIgnoreCase("c"))
            {
                if(finalGame.getQuestion(i).getAnswer().equalsIgnoreCase(c))
                {
                    answer = true;
                    break;
                }
            }
            else if(input.equalsIgnoreCase("d"))
            {
                if(finalGame.getQuestion(i).getAnswer().equalsIgnoreCase(d))
                {
                    answer = true;
                    break;
                }
            }
            else
            {
                answer = false;
                break;
            }

        }

        return answer;
    }
}
