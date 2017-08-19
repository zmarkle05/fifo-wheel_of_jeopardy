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
    
    public Category(String catName)
    {
        categoryName = catName;
        
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
    
    public Queue<Question> retrieveQuestions()
    {
        return catQuestions;
    }
    
    public String retrieveAnswer(String question)
    {
        for (Question quest: catQuestions)
        {
            if (question.equals(quest.getQuestion()))
            {
                return quest.getAnswer();
            }
        }
        
        return "";
    }
}
