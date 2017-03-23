package controller;

import java.util.ArrayList;
import java.util.List;

public class Attributes
{
    private String question;
    private String answer;
    private String incorrect1;
    private String incorrect2;
    private String incorrect3;
    private String difficulty;
    private ArrayList<String> quiz;
    //the file varaibles that i will use when reading in the file


    public Attributes(String difficulty, String question, String answer, String incorrect1, String incorrect2, String incorrect3) {
        super();
        this.difficulty = difficulty;
        this.question = question;
        this.answer = answer;
        this.incorrect1 = incorrect1;
        this.incorrect2 = incorrect2;
        this.incorrect3 = incorrect3;
    }


    public Attributes(){};

    //this method then under is all the getters and setter methods

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getIncorrect1() {
        return incorrect1;
    }

    public String getIncorrect2() {
        return incorrect2;
    }

    public String getIncorrect3() {
        return incorrect3;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setIncorrect1(String incorrect1) {
        this.incorrect1 = incorrect1;
    }

    public void setIncorrect2(String incorrect2) {
        this.incorrect2 = incorrect2;
    }

    public void setIncorrect3(String incorrect3) {
        this.incorrect3 = incorrect3;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Object[] toTableRow()
    {
        return new Object[]
                {
                        this.question,
                        this.answer,
                        this.incorrect1,
                        this.incorrect2,
                        this.incorrect3,
                        this.difficulty
                };
    }

    public String toString()
    {
        return this.question+"\n"+this.answer+"\n"+this.incorrect1+"\n"+this.incorrect2+"\n"+this.incorrect3+"\n";
    }


    //this is my toString method

}