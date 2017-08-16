/*
 *
 */
package wheelofjeopardy.Database;

import java.io.BufferedReader;
import java.io.FileReader;
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
        try {
            BufferedReader br = null;
            br = new BufferedReader(new FileReader(csvPath));
            String line = "";
            String delimiter = ",";
            
            line = br.readLine();
            String[] categories = line.split(delimiter);
            
            category1 = new Category(categories[0]);
            category2 = new Category(categories[1]);
            category3 = new Category(categories[2]);
            category4 = new Category(categories[3]);
            category5 = new Category(categories[4]);
            category6 = new Category(categories[5]);
            while ((line = br.readLine()) != null) {
                String[] questionAnswer = line.split(delimiter);
                for (int i = 0; i < questionAnswer.length; i++) {
                    String[] qa = questionAnswer[i].split(";");
                    if (i == 0) {
                        category1.addQuestion(qa[0], qa[1]);
                    } else if (i == 1) {
                        category2.addQuestion(qa[0], qa[1]);
                    } else if (i == 2) {
                        category3.addQuestion(qa[0], qa[1]);
                    } else if (i == 3) {
                        category4.addQuestion(qa[0], qa[1]);
                    } else if (i == 4) {
                        category5.addQuestion(qa[0], qa[1]);
                    } else {
                        category6.addQuestion(qa[0], qa[1]);
                    }
                }
            }
           
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }
    
    public void writeCSV()
    {
        //TODO if time for additional functionality
    }
}
