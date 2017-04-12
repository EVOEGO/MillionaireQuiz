package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by izaac on 30/03/2017.
 * This class handles all the processes in storing and reading in the games highscores
 */
public class highScores
{
    private static final String FILE_NAME = "input/highscores";
    private String input;
    private String line;
    private String[] Split_Line;
    private boolean SORTING_HIGH_SCORES = true;
    private ArrayList<String> HIGH_SCORES = new ArrayList();
    private ArrayList<Integer> SCORE_NUMBER = new ArrayList<Integer>();
    private ArrayList<String> SORTED_SCORES = new ArrayList<String>();

    public highScores()
    {
        this.SORTED_SCORES = new ArrayList<>();
    }

    /*saveHighScore method will write to the highscores file. So that i can keep a running count
    * of the current highscores.*/

    public void saveHighScore(int score, String Username)
    {
        try
        {
            FileWriter file = new FileWriter(FILE_NAME, true);
            BufferedWriter writer = new BufferedWriter(file);
            input = "";
            input = input.concat(Username);
            input = input.concat(":");
            input = input.concat(Integer.toString(score));
            //concatenates the input so its read in together and then split up later on

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
        try //used try catch methods so that i handle the errors instead of ignoring them
        {
            Scanner scan = new Scanner(new File(FILE_NAME));

            while(scan.hasNextLine())
            {
                line = scan.nextLine();
                Split_Line = line.split(":");
                HIGH_SCORES.add(Split_Line[0]);
                HIGH_SCORES.add(Split_Line[1]);
                //separtes the username and the score so i can store it inside another array
                SCORE_NUMBER.add(Integer.parseInt(Split_Line[1]));
                //adds the score to another arraylist which only contains score integers
            }

            HIGH_SCORES.trimToSize(); //trims the arraylist HIGHSCORES down, so that i have no index problems
            SCORE_NUMBER.trimToSize(); //same as above
            Collections.sort(SCORE_NUMBER);  //sorts the arraylist
            Collections.reverse(SCORE_NUMBER); //reverses the order of the arraylist

            while(SORTING_HIGH_SCORES == true) //checks if the loop is still sorting the scores
            {
                for(int i = 0; i < SCORE_NUMBER.size(); i++)
                {
                    for(int x = 0; x < HIGH_SCORES.size(); x++)
                    {
                        if(HIGH_SCORES.get(x).equalsIgnoreCase(Integer.toString(SCORE_NUMBER.get(i))))
                        {
                            SORTED_SCORES.add(HIGH_SCORES.get(x-1));
                            SORTED_SCORES.add(Integer.toString(SCORE_NUMBER.get(i))); //I then add them to a differnt arraylist, that i call in the view
                        }
                    }
                }
                SORTING_HIGH_SCORES = false; //breaks out of the loop as sorting has been completed
            }

        }
        catch (IOException r) //catches the IOException and handles it
        {
            r.printStackTrace();
        }
    }

    /*This method gets the highscores and returns them to the view so that i can use the data
    stored inside the arraylist.*/
    public ArrayList<String> get_SORTED_SCORES()
    {
        return this.SORTED_SCORES;
    }

}
