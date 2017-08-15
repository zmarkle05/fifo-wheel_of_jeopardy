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
    private Category category1;
    private Category category2;
    private Category category3;
    private Category category4;
    private Category category5;
    private Category category6;
    
    public Database(String csv)
    {
        readCSV(csv);
    }
    
    public void addQuestionAnswer()
    {
        //TODO if time for addtional functionality
    }
    
    public Category getQuestion(String category)
    {
        //return question;
        if (category.equals(category1.getCatName()))
        {
            //should use QUE
        }
        else
        {
            
        }
        else
        
        return null;
    }
    
    public void readCSV(String csvPath)
    {
        //TODO populate 6 category objects from CSV
        category1 = new Category("BLANK");
        category2 = new Category("BLANK");
        category3 = new Category("BLANK");
        category4 = new Category("BLANK");
        category5 = new Category("BLANK");
        category6 = new Category("BLANK");
        
    }
    
    public void writeCSV()
    {
        //TODO if time for additional functionality
    }
    
    
    
}
