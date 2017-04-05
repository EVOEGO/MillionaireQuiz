package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by izaac on 30/03/2017.
 */
public class highScores
{
    private static final String FILE_NAME = "input/highscores.txt";
    private String input;
    private String line;
    private String[] Split_Line;
    private ArrayList<String> HIGH_SCORES = new ArrayList();

    public highScores()
    {
        this.HIGH_SCORES = new ArrayList<>();
    }

    public void saveHighScore(int score, String Username)
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            input = "";
            input = input.concat(Username);
            input = input.concat(":");
            input = input.concat(Integer.toString(score));

            writer.write(input);
            writer.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void initaliseHighScores()
    {
        try
        {
            Scanner scan = new Scanner(new File(FILE_NAME));

            while(scan.hasNextLine())
            {
                line = scan.nextLine();
                Split_Line = line.split(":");

                for(int i = 0; i < 2; i++)
                {
                    HIGH_SCORES.add(Split_Line[i]);
                }

            }
        }
        catch (IOException r)
        {
            r.printStackTrace();
        }
    }


    public ArrayList<String> getHighScores()
    {
        return this.HIGH_SCORES;
    }


}
