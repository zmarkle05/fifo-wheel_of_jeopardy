/*
 * 
 */
package wheelofjeopardy.Database;

/**
 *
 * @author adam
 */
public class Question 
{
    
    private String question;
    private String answer;
    private int pointValue;
    private boolean answered;
    
    public Question(String quest,
                    String answ,
                    int    value)
    {
        question   = quest;
        answer     = answ;
        pointValue = value;
        answered   = false;
    }
    
    public String getAnswer()
    {
        return answer;
    }
    
    public String getQuestion()
    {
        return question;
    }
    
    public int getPointValue()
    {
        return pointValue;
    }
    
    public boolean isAnswered()
    {
        return answered;
    }
}
