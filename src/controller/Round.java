package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by izaac on 22/03/2017.
 */
public class Round
{
    public static ArrayList<String> create(Attributes attributes)
    {
        ArrayList<String> quizAnswers = new ArrayList<String>();
        AttributeDataBase finalGame = new AttributeDataBase();

        String correctAnswer = " "; // rst

        quizAnswers.add(attributes.getAnswer());
        quizAnswers.add(attributes.getIncorrect1());
        quizAnswers.add(attributes.getIncorrect2());
        quizAnswers.add(attributes.getIncorrect3());
        Collections.shuffle(quizAnswers);

        for(int i = 0; i < finalGame.getQuestions().size(); i++)
        {
            if(finalGame.getQuestion(i).getAnswer().toString().equalsIgnoreCase(quizAnswers.get(i)))
            {
                quizAnswers.add(attributes.getAnswer());
                correctAnswer = Integer.toString(i);
                quizAnswers.add(correctAnswer);
                break;
            }
        }

        return quizAnswers;
    }

}
