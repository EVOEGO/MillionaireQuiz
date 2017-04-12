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
    private int FIFTYFIFTY;
    private String a;
    private String b;
    private String c;
    private String d;
    private boolean used50;
    private boolean usedAudience;
    private boolean usedPhone;
    private boolean FIFTY_FIFTY_ACTIVE;
    private ArrayList<Integer> chances = new ArrayList<>();
    private AttributeDataBase finalGame = new AttributeDataBase();
    private ArrayList<String> questionLetters = new ArrayList<>();
    private ArrayList<String> friendNames = new ArrayList<>();
    private boolean isAnswer = false;
    private boolean isIncorrect1;
    private boolean isIncorrect2;
    private boolean isIncorrect3;

    public ArrayList<Integer> totalChances(int chance, int incorrect, int position)
    {
        Random random = new Random();
        int incorrectChances = incorrect;
        int ichance = incorrectChances / 2;
        int number1 = 0;
        int number2 = 0;

        number1 = random.nextInt((ichance - 10) + 1) + 10;
        incorrectChances = incorrectChances - number1;

        number2 = random.nextInt((ichance - 10) + 1) + 10;
        incorrectChances = incorrectChances - number2;

        if(position == 0)
        {
            chances.add(0, chance);
            chances.add(1, number1);
            chances.add(2, number2);
            chances.add(3, incorrectChances);
        }
        else if(position == 1)
        {
            chances.add(0,number1);
            chances.add(position, chance);
            chances.add(2, number2);
            chances.add(3, incorrectChances);
        }
        else if(position == 2)
        {
            chances.add(0, number1);
            chances.add(1, number2);
            chances.add(position, chance);
            chances.add(3, incorrectChances);
        }
        else if(position == 3)
        {
            chances.add(0, number1);
            chances.add(1, number2);
            chances.add(2, incorrectChances);
            chances.add(position, chance);
        }

        chances.trimToSize();
        return chances;
    }
    public Integer friendIsCorrect()
    {
        int randomNumber = 0;
        Random rand = new Random();

        randomNumber = rand.nextInt((100 - 1) + 1) + 1;


        return randomNumber;
    }
    public Integer randomNumber()
    {
        int number = 0;
        Random rand = new Random();

        number = rand.nextInt((4 - 1) + 1) + 1;

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
        System.out.print("Quesiton " + (i + 1) + ": ");
        System.out.println(finalGame.getQuestions().get(i).getQuestion());
        System.out.println("-------------------------------------------------------------");

        for(int q = 0; q < quizAnswers.size(); q++)
        {
            if(q == 0)
            {
                System.out.println("A. " + quizAnswers.get(q));
                a = quizAnswers.get(q);
                questionLetters.add(a);
            }
            else if(q == 1)
            {
                System.out.println("B. " + quizAnswers.get(q));
                b = quizAnswers.get(q);
                questionLetters.add(b);
            }
            if(q == 2)
            {
                System.out.println("C. " + quizAnswers.get(q));
                c = quizAnswers.get(q);
                questionLetters.add(c);
            }
            else if(q == 3)
            {
                System.out.println("D. " + quizAnswers.get(q));
                d = quizAnswers.get(q);
                questionLetters.add(d);

            }
        }
        questionLetters.trimToSize();
        System.out.println("-------------------------------------------------------------");
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
                FIFTYFIFTY = 1;
                printFiftyFifty(FIFTYFIFTY, i);
                used50 = true;
                break;
            }
            else if(finalGame.getQuestion(i).getAnswer().equalsIgnoreCase(c) || finalGame.getQuestion(i).getAnswer().equalsIgnoreCase(d))
            {
                FIFTYFIFTY = 2;
                printFiftyFifty(FIFTYFIFTY, i);
                used50 = true;
                break;
            }
        }

        return used50 = true;
    }

    public void printFiftyFifty(int number, int i)
    {
        if(number == 1)
        {
            System.out.println(finalGame.getQuestions().get(i).getQuestion());
            System.out.println("A. " + a);
            System.out.println("B. " + b);
        }
        else if(number == 2)
        {
            System.out.println(finalGame.getQuestions().get(i).getQuestion());
            System.out.println("C. " + c);
            System.out.println("D. " + d);
        }
    }

    public void checkQuestionType(String question, int i)
    {
        if(finalGame.getQuestion(i).getAnswer().equalsIgnoreCase(question))
        {
            isAnswer = true;
        }
        else if(finalGame.getQuestion(i).getIncorrect1().equalsIgnoreCase(question))
        {
            isIncorrect1 = true;
        }
        if(finalGame.getQuestion(i).getIncorrect2().equalsIgnoreCase(question))
        {
            isIncorrect2 = true;
        }
        else if(finalGame.getQuestion(i).getIncorrect3().equalsIgnoreCase(question))
        {
            isIncorrect3 =true;
        }
    }

    public void askTheAudience(Integer round) {
        //ask the audience
        int i = round;

        for (int w = 0; w < 4; w++) {
            if (finalGame.getQuestion(i).getAnswer().equalsIgnoreCase(questionLetters.get(w))) {
                if (finalGame.getQuestion(i).getDifficulty().equalsIgnoreCase("1")) {
                    usedAudience = true;
                    int chance = 45;
                    int incorrect = 55;
                    int position = w;
                    totalChances(chance, incorrect, position);
                    print();
                    break;

                } else if (finalGame.getQuestion(i).getDifficulty().equalsIgnoreCase("2")) {
                    usedAudience = true;
                    int chance = 55;
                    int incorrect = 45;
                    int position = w;
                    totalChances(chance, incorrect, position);
                    print();
                    break;
                } else if (finalGame.getQuestion(i).getDifficulty().equalsIgnoreCase("3")) {
                    usedAudience = true;
                    int chance = 65;
                    int incorrect = 35;
                    int position = w;
                    totalChances(chance, incorrect, position);
                    print();
                    break;
                }

            }
        }
    }

    public void phoneAFriend(String name, int round)
    {
        //phone a friend
        int friendIsIncorrect = 40;
        int i = round;
        String username = name;
        create(i);

        if(friendIsCorrect() > friendIsIncorrect)
        {
            for(int y = 1; y < questionLetters.size(); y++)
            {
                if(finalGame.getQuestion(i).getAnswer().equalsIgnoreCase(questionLetters.get(y)))
                {
                    usedPhone = true;
                    System.out.println("=============================================================================================================================================");
                    System.out.println("Hello " + username + " its your mate " + friendNames.get(getFriendName()) +" here, i looked at the question");
                    System.out.println("and i believe that |" + questionLetters.get(y) + "| is the correct one. ");
                    System.out.println("Goodluck!!!!! catch you later.");
                    System.out.println("=============================================================================================================================================");
                    System.out.println("\n");
                }
            }
        }
        else
        {
            usedPhone = true;
            System.out.println("=============================================================================================================================================");
            System.out.println("Hello " + username + " its your friend " + friendNames.get(getFriendName()) +" here, i took a look at the question ");
            System.out.println("your stuck on, and i think the answer is |" + questionLetters.get(randomNumber()) + "| Hope that helps! later man!");
            System.out.println("=============================================================================================================================================");
            System.out.println("\n");

        }
    }

    public Integer getFriendName()
    {
        int number = 0;
        Random rand = new Random();

        friendNames.add("Joe");
        friendNames.add("Mike");
        friendNames.add("Jarad");
        friendNames.add("Tj");
        friendNames.add("Isabella");
        friendNames.add("Tina");
        friendNames.add("Grace");
        friendNames.trimToSize();

        number = rand.nextInt((6 - 1) + 1) + 1;

        return number;
    }

    public void printQuestions()
    {
        for(int i = 0; i < questionLetters.size(); i++)
        {
            if(i == 0)
            {
                System.out.println("A. " + questionLetters.get(i));
            }
            else if(i == 1)
            {
                System.out.println("B. " + questionLetters.get(i));
            }
            else if(i == 2)
            {
                System.out.println("C. " + questionLetters.get(i));
            }
            else if(i == 3)
            {
                System.out.println("D. " + questionLetters.get(i));
            }
        }
        //System.out.println("\n");
    }

    public boolean checkFiftyFifty(boolean active)
    {
        FIFTY_FIFTY_ACTIVE = active;
        return FIFTY_FIFTY_ACTIVE;
    }

    public Integer confirmFiftyFifty()
    {
        return FIFTYFIFTY;
    }
    /*Moved my print statements to a method instead to save space in my code*/

    public void print()
    {
        System.out.println("A. " + chances.get(0) + "%");
        System.out.println("B. " + chances.get(1) + "%");
        System.out.println("C. " + chances.get(2) + "%");
        System.out.println("D. " + chances.get(3) + "%");
    }

    /*I created the getUsed methods, so that i could check to see if the lifelines had been used
    I found these really helpful, in my main LOGIN_VIEW as i was able to check on the fly if each lifeline
    had been used or not.*/

    public boolean getUsed1()
    {
        return used50;
    }
    public boolean getUsed2()
    {
        return usedAudience;
    }
    public boolean getUsed3()
    {
        return usedPhone;
    }
}

