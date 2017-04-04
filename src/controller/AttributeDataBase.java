package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.management.Attribute;

public class AttributeDataBase
{
    private int question;
    private int questionOption;
    private int numberOfQuestions;
    private int difficulty1;
    private int difficulty2;
    private int difficulty3;
    private int randDiff;
    private String line;
    private String[] splitLine;

    ArrayList<Attributes> attributes = new ArrayList<Attributes>();
    ArrayList<Attributes> finalGame = new ArrayList<Attributes>();

    public AttributeDataBase()
    {
        this.attributes = new ArrayList<Attributes>();
        this.finalGame = new ArrayList<Attributes>();
        this.initaliseQuestionDataBase();
        //this populates the array with all the questions and answers from the file
    }

    public static int randomDifficulty()
    {
        Random randomDifficulty = new Random();

        int randomNumber = randomDifficulty.nextInt((3 - 1) + 1) + 1;

        return randomNumber;
    }

    public ArrayList<Attributes> initaliseQuestionDataBase()
    {
        try {

            Scanner fileScan = new Scanner(new File("Input/questionInformation")); //used a scanner to read in the file

            while (fileScan.hasNextLine()) //while loop to loop over the file as long as it has a next line
            {
                line = fileScan.nextLine();
                splitLine = line.split("%");

                Attributes attribute = new Attributes();
                Attributes finalAttributes = new Attributes();

                randDiff = randomDifficulty();  //helps choose a random difficulty rating, so that the questions are choosen at random

                attribute.setDifficulty(splitLine[0]);
                attribute.setQuestion(splitLine[1]);  //i did this so that all the attributes are set up as the lines are split
                attribute.setAnswer(splitLine[2]);
                attribute.setIncorrect1(splitLine[3]);
                attribute.setIncorrect2(splitLine[4]);
                attribute.setIncorrect3(splitLine[5]);

                for(int i = 0; i < attributes.size(); i++) //these nested if statements setup the final game arraylist.
                {
                    if(randDiff == Integer.parseInt(attribute.getDifficulty()))
                    {
                        if(attribute.getDifficulty().equalsIgnoreCase("1"))
                        {
                            difficulty1++; //a counter system to make sure that i don't get more than 5 of one difficulty.

                            if(difficulty1 <= 5)
                            {
                                if(numberOfQuestions <= 15)
                                {
                                    finalGame.add(attribute);  //adds this difficulty rating attribute to the final game
                                    numberOfQuestions++;
                                    break;
                                }
                            }
                            else
                            {
                                break;
                            }
                        }

                        else if(attribute.getDifficulty().equalsIgnoreCase("2"))
                        {
                            difficulty2++;

                            if(difficulty2 <= 5)
                            {
                                if(numberOfQuestions <= 15)
                                {
                                    finalGame.add(attribute);
                                    numberOfQuestions++;
                                    break;
                                }
                            }
                            else
                            {
                                break;
                            }
                        }

                        if(attribute.getDifficulty().equalsIgnoreCase("3"))
                        {
                            difficulty3++;

                            if(difficulty3 <= 5)
                            {
                                if(numberOfQuestions <= 15)
                                {
                                    finalGame.add(attribute);
                                    attributes.add(attribute);
                                    numberOfQuestions++;
                                    break;
                                }
                            }
                            else
                            {
                                break;
                            }
                        }

                        else if(numberOfQuestions > 15)
                        {
                            break;
                        }
                    }
                    else
                    {
                        break;
                    }
                }



                attributes.add(attribute);

            }

            fileScan.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return finalGame;

    }

    public Attributes getQuestion(int index)
    {
        if(index  >= 0 && index <  this.finalGame.size())
        {
            return this.finalGame.get(index);
        }
        return null;
    }

    public void remove(int id)
    {
        int question = id;

        finalGame.remove(question);
    }

    public ArrayList<Attributes> getQuestions()
    {
        return this.finalGame;
    }
}
