/*
 *
 */
package wheelofjeopardy.Database;

import java.util.*;

import wheelofjeopardy.Database.Question;

/**
 *
 * @author adam
 */
public class Database 
{
    private static HashMap<Integer, Question> questions;
    
    public Database()
    {
        questions = new HashMap<Integer, Question>();
    }
    
    public static void addQuestionAnswer()
    {
        
    }
    
    public static HashMap<Integer, Question> getQuestions()
    {
        return questions;
    }
    
    public static void readCSV()
    {
        
    }
    
    public static void writeCSV()
    {
        
    }
    
}
