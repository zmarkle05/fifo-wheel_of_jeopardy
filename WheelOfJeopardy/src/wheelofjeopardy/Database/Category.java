/*
 * 
 */
package wheelofjeopardy.Database;

import wheelofjeopardy.Database.Question;
import java.util.*;

/**
 *
 * @author Adam
 */
public class Category 
{
    private String categoryName;
    private Queue<Question> catQuestions;
    private int round;
    
    public Category(String catName, int roundNum)
    {
        categoryName = catName;
        round        = roundNum;
        
        catQuestions = new LinkedList<Question>();
    }
    
    public String getCatName()
    {
        return categoryName;
    }
    
    public boolean outOfQuestions()
    {
        return catQuestions.isEmpty();
    }
    
    public void addQuestion(String question,
                            String answer)
    {
        catQuestions.add(new Question(question, answer, 0));
    }
    
    public Question removeQuestion()
    {
        return catQuestions.poll();
    }
    
    public Question retrieveQuestion()
    {
        return catQuestions.peek();
    }
    
    public int getRound()
    {
        return round;
    }
}
