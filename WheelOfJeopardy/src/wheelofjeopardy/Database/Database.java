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
    
    public Question getQuestion(String category)
    {
        Question question = null;
        
        if (category.equals(category1.getCatName()))
        {
            question = category1.removeQuestion();
        }
        else if (category.equals(category2.getCatName()))
        {
            question = category2.removeQuestion();
        }
        else if (category.equals(category3.getCatName()))
        {
            question = category3.removeQuestion();
        }
        else if (category.equals(category4.getCatName()))
        {
            question = category4.removeQuestion();
        }
        else if (category.equals(category5.getCatName()))
        {
            question = category5.removeQuestion();
        }
        else if (category.equals(category6.getCatName()))
        {
            question = category6.removeQuestion();    
        }
        else
        {
            //shouldn't happen
        }
        
        return question;
    } 
    public String[] getCategories()
    {
        String[] catNames = new String[6];
        
        catNames[0] = category1.getCatName();
        catNames[1] = category2.getCatName();
        catNames[2] = category3.getCatName();
        catNames[3] = category4.getCatName();
        catNames[4] = category5.getCatName();
        catNames[5] = category6.getCatName();
        
        return catNames;
                
    }
    
    public void readCSV(String csvPath)
    {
        //TODO populate 6 category objects from CSV
        // For round 1
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
