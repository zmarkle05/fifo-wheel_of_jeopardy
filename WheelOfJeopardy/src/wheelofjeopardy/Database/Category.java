/*
 * 
 */
package wheelofjeopardy.Database;

import wheelofjeopardy.Database.Question;

/**
 *
 * @author Adam
 */
public class Category 
{
    private String categoryName;
    private Question[] catQuestions;
    
    public Category(String catName)
    {
        categoryName = catName;
        catQuestions = new Question[5];
    }
    
    public String getCatName()
    {
        return categoryName;
    }
    
    public boolean outOfQuestions()
    {
        return false;
    }
}
