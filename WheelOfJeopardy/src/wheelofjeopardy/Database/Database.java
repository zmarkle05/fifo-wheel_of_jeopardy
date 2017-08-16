/*
 *
 */
package wheelofjeopardy.Database;

import java.util.*;

import wheelofjeopardy.Database.Category;

/**
 *
 * @author adam
 */
public class Database 
{
    // TODO figure out how to deal with both rounds of questions
    private Category[] categories = new Category[12];
    
    public Database(String csv)
    {
        readCSV(csv);
    }
    
    public void addQuestionAnswer()
    {
        //TODO if time for addtional functionality
    }
    
    public Question getQuestion(String category)
    {
        Question question = null;
        for (Category cat: categories)
        {
            if (category.equals(cat.getCatName()))
            {
                question = cat.removeQuestion();
            }
        }
        
        return question;
    } 
    public String[] getCategories(int round)
    {
        String[] catNames = new String[6];
        
        int index = 0;
        for (Category cat: categories)
        {
            if (round == cat.getRound())
            {
                catNames[index] = cat.getCatName();
                round++;
            }
        }
        
        return catNames;        
    }
    
    public void readCSV(String csvPath)
    {
 
        
    }
    
    public void writeCSV()
    {
        //TODO if time for additional functionality
    }
}
