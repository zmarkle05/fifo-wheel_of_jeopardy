/*
 * 
 */
package wheelofjeopardy.UserInterface;

import java.util.ArrayList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import wheelofjeopardy.Database.Database;
import wheelofjeopardy.Database.Question;
import wheelofjeopardy.GameEngine.GameEngine;

/**
 *
 * @author adam
 */
public class UserInterface {
    
    private static Wheel wheel;
    private static GameBoard board;
    private static InformationDisplay infoDisplay;
    private Button submitBtn;
    private Button spinBtn;
    private GameEngine gameEngine;
    private Text questionText;
    private Text answerText;
    private Display display;
    private Database database;
    public UserInterface(Database db)
    {
        gameEngine = new GameEngine(db, this);
        
       database = db;
        display = new Display();
        Shell shell = new Shell(display);
        shell.setMaximized(true);
        FillLayout fillLayout = new FillLayout();
        fillLayout.marginHeight = 5;
        fillLayout.marginWidth = 5;
        shell.setLayout( fillLayout );

        Composite outer = new Composite( shell, SWT.BORDER );
        outer.setBackground( new Color( null, 207, 255, 206 ) ); // Green

        FormLayout formLayout = new FormLayout();
        formLayout.marginHeight = 5;
        formLayout.marginWidth = 5;
        formLayout.spacing = 5;
        outer.setLayout( formLayout );
        // CONTROLS 
        Composite innerLeftTop = new Composite( outer, SWT.BORDER );
        innerLeftTop.setLayout( new GridLayout(2, false) );
        innerLeftTop.setBackground( new Color( null, 232, 223, 255 ) ); // Blue
        FormData fData = new FormData();
        fData.top = new FormAttachment( 0 );
        fData.left = new FormAttachment( 0 );
        fData.right = new FormAttachment( 50 ); // Locks on 10% of the view
        fData.bottom = new FormAttachment( 18 );
        innerLeftTop.setLayoutData( fData );
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true,true);
       
        Label questionLabel = new Label(innerLeftTop, SWT.NONE);
        questionLabel.setText("Question:");
        questionLabel.setLayoutData(gd);
        questionLabel.setAlignment(SWT.CENTER);
        questionText = new Text(innerLeftTop, SWT.NONE);
        questionText.setEnabled(false);
        questionText.setLayoutData(gd);
        
        Label answerLabel = new Label(innerLeftTop, SWT.NONE);
        answerLabel.setText("Answer:");
        answerLabel.setAlignment(SWT.CENTER);

        answerLabel.setLayoutData(gd);
        answerText = new Text(innerLeftTop, SWT.NONE);
        answerText.setEnabled(true);
        answerText.setLayoutData(gd);
        
        submitBtn = new Button(innerLeftTop, SWT.NONE);
        submitBtn.setText("SUBMIT");
        submitBtn.setLayoutData(gd);
        spinBtn = new Button(innerLeftTop, SWT.NONE);
        spinBtn.setText("SPIN");
        spinBtn.setLayoutData(gd);
        
        // SPIN WHEEL AREA
        Composite innerLeftBottom = new Composite( outer, SWT.BORDER );
        innerLeftBottom.setLayout( fillLayout );
        innerLeftBottom.setBackground( new Color( null, 232, 223, 255 ) ); // Blue
        fData = new FormData();
        fData.top = new FormAttachment( innerLeftTop );
        fData.left = new FormAttachment( 0 );
        fData.right = new FormAttachment( 50 ); // Locks on 10% of the view
        fData.bottom = new FormAttachment( 100 );
        innerLeftBottom.setLayoutData( fData );
        
        // GAME BOARD VISUAL AREA
        Composite innerRight = new Composite( outer, SWT.BORDER );
        innerRight.setLayout( fillLayout );
        innerRight.setBackground( new Color( null, 255, 235, 223 ) ); // Orange
        fData = new FormData();
        fData.top = new FormAttachment( 0 );
        fData.left = new FormAttachment( innerLeftTop );
        fData.right = new FormAttachment( 100 );
        fData.bottom = new FormAttachment( 100 );
        innerRight.setLayoutData( fData );
        
        wheel = new Wheel(this,db.getCategories(), innerLeftBottom, SWT.NONE);
        board = new GameBoard(db);
        infoDisplay = new InformationDisplay();
        
        setListeners();
        
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        
        display.dispose();
    }
    
    public Sector.SectorType spinWheel()
    {
        wheel.spin();
        return wheel.getCurrentSector().getType();
    }
    
    public String retrieveSectorName()
    {
        return wheel.getCurrSectorName();
    }
    
    private void setListeners() {
        Listener listener = new Listener() {
            @Override
            public void handleEvent(Event event) {
                if (event.widget == submitBtn) {
                    gameEngine.compareAnswer(answerText.getText());
                } else if (event.widget == spinBtn) {
                    wheel.spin();
                    gameEngine.playGame(wheel.getCurrentSector());                   
                }
            }
        };
        spinBtn.addListener(SWT.Selection,listener);
        submitBtn.addListener(SWT.Selection, listener);
    }
    
    public void updateQuestion(Question question) {
        gameEngine.setCurrentQuestion(question);
        questionText.setText(question.getQuestion()); 
    }
    
    public Database getDb(){
        return database;
    }
    
    
}
