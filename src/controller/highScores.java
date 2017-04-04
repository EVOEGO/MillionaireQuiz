package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by izaac on 30/03/2017.
 */
public class highScores
{
    private String fileName = "input/highscores.txt";

    public void saveHighScore()
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            String score = "";

            writer.write(score);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void initaliseHighScores()
    {

    }


}
