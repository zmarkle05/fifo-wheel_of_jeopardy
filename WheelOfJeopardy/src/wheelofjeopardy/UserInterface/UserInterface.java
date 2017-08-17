/*
 * 
 */
package wheelofjeopardy.UserInterface;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import wheelofjeopardy.Database.Database;

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
    private Button cat1Button;
    private Button cat2Button;
    private Button cat3Button;
    private Button cat4Button;
    private Button cat5Button;
    private Button cat6Button;
    private Button[][] squares;
    private Display display;
    
    public UserInterface(Database   db)
    {
        
        wheel = new Wheel(db.getCategories());
        board = new GameBoard(db);
        infoDisplay = new InformationDisplay();
        
        squares = new Button[5][6];
        
        display = new Display();
        Shell shell = new Shell(display);
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
        fData.bottom = new FormAttachment( 50 );
        innerLeftTop.setLayoutData( fData );
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true,true);
       
        Label questionLabel = new Label(innerLeftTop, SWT.NONE);
        questionLabel.setText("Question:");
        questionLabel.setLayoutData(gd);
        questionLabel.setAlignment(SWT.CENTER);
        Text questionText = new Text(innerLeftTop, SWT.NONE);
        questionText.setEnabled(false);
        questionText.setLayoutData(gd);
        
        Label answerLabel = new Label(innerLeftTop, SWT.NONE);
        answerLabel.setText("Answer:");
        answerLabel.setAlignment(SWT.CENTER);

        answerLabel.setLayoutData(gd);
        Text answerText = new Text(innerLeftTop, SWT.NONE);
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
        innerLeftTop.setLayout( new GridLayout() );
        innerLeftTop.setBackground( new Color( null, 232, 223, 255 ) ); // Blue
        fData = new FormData();
        fData.top = new FormAttachment( innerLeftTop );
        fData.left = new FormAttachment( 0 );
        fData.right = new FormAttachment( 50 ); // Locks on 10% of the view
        fData.bottom = new FormAttachment( 100 );
        innerLeftBottom.setLayoutData( fData );
        
        // GAME BOARD VISUAL AREA
        Composite innerRight = new Composite( outer, SWT.BORDER );
        FillLayout rowLayout = new FillLayout(SWT.HORIZONTAL);
        //rowLayout.pack = true;
        //rowLayout.justify = true;
        innerRight.setLayout( rowLayout );
        innerRight.setBackground( new Color( null, 255, 235, 223 ) ); // Orange
        fData = new FormData();
        fData.top = new FormAttachment( 0 );
        fData.left = new FormAttachment( innerLeftTop );
        fData.right = new FormAttachment( 100 );
        fData.bottom = new FormAttachment( 100 );
        innerRight.setLayoutData( fData );       

        Composite category1Buttons = new Composite (innerRight, SWT.BORDER);
        category1Buttons.setLayout(new FillLayout(SWT.VERTICAL));
        cat1Button = new Button(category1Buttons, SWT.None);
        cat1Button.setText(db.getCategories()[0]);
        cat1Button.setEnabled(false);
        Button cat1100 = new Button(category1Buttons, SWT.None);
        cat1100.setEnabled(false);
        cat1100.setText("100");
        Button cat1200 = new Button(category1Buttons, SWT.None);
        cat1200.setText("200");
        Button cat1300 = new Button(category1Buttons, SWT.None);
        cat1300.setText("300");
        Button cat1400 = new Button(category1Buttons, SWT.None);
        cat1400.setText("400");
        Button cat1500 = new Button(category1Buttons, SWT.None);
        cat1500.setText("500");
        
        Composite category2Buttons = new Composite (innerRight, SWT.BORDER);
        category2Buttons.setLayout(new FillLayout(SWT.VERTICAL));
        cat2Button = new Button(category2Buttons, SWT.None);
        cat2Button.setText(db.getCategories()[1]);
        cat2Button.setEnabled(false);
        Button cat2100 = new Button(category2Buttons, SWT.None);
        cat2100.setText("100");
        Button cat2200 = new Button(category2Buttons, SWT.None);
        cat2200.setText("200");
        Button cat2300 = new Button(category2Buttons, SWT.None);
        cat2300.setText("300");
        Button cat2400 = new Button(category2Buttons, SWT.None);
        cat2400.setText("400");
        Button cat2500 = new Button(category2Buttons, SWT.None);
        cat2500.setText("500");
        
        Composite category3Buttons = new Composite (innerRight, SWT.BORDER);
        category3Buttons.setLayout(new FillLayout(SWT.VERTICAL));
        cat3Button = new Button(category3Buttons, SWT.None);
        cat3Button.setText(db.getCategories()[2]);
        cat3Button.setEnabled(false);
        Button cat3100 = new Button(category3Buttons, SWT.None);
        cat3100.setText("100");
        Button cat3200 = new Button(category3Buttons, SWT.None);
        cat3200.setText("200");
        Button cat3300 = new Button(category3Buttons, SWT.None);
        cat3300.setText("300");
        Button cat3400 = new Button(category3Buttons, SWT.None);
        cat3400.setText("400");
        Button cat3500 = new Button(category3Buttons, SWT.None);
        cat3500.setText("500");
        
        Composite category4Buttons = new Composite (innerRight, SWT.BORDER);
        category4Buttons.setLayout(new FillLayout(SWT.VERTICAL));
        cat4Button = new Button(category4Buttons, SWT.None);
        cat4Button.setText(db.getCategories()[3]);
        cat4Button.setEnabled(false);
        Button cat4100 = new Button(category4Buttons, SWT.None);
        cat4100.setText("100");
        Button cat4200 = new Button(category4Buttons, SWT.None);
        cat4200.setText("200");
        Button cat4300 = new Button(category4Buttons, SWT.None);
        cat4300.setText("300");
        Button cat4400 = new Button(category4Buttons, SWT.None);
        cat4400.setText("400");
        Button cat4500 = new Button(category4Buttons, SWT.None);
        cat4500.setText("500");
        
        Composite category5Buttons = new Composite (innerRight, SWT.BORDER);
        category5Buttons.setLayout(new FillLayout(SWT.VERTICAL));
        cat5Button = new Button(category5Buttons, SWT.None);
        cat5Button.setText(db.getCategories()[4]);
        cat5Button.setEnabled(false);
        Button cat5100 = new Button(category5Buttons, SWT.None);
        cat5100.setText("100");
        Button cat5200 = new Button(category5Buttons, SWT.None);
        cat5200.setText("200");
        Button cat5300 = new Button(category5Buttons, SWT.None);
        cat5300.setText("300");
        Button cat5400 = new Button(category5Buttons, SWT.None);
        cat5400.setText("400");
        Button cat5500 = new Button(category5Buttons, SWT.None);
        cat5500.setText("500");
        
        Composite category6Buttons = new Composite (innerRight, SWT.BORDER);
        category6Buttons.setLayout(new FillLayout(SWT.VERTICAL));
        cat6Button = new Button(category6Buttons, SWT.None);
        cat6Button.setText(db.getCategories()[5]);     
        cat6Button.setEnabled(false);
        Button cat6100 = new Button(category6Buttons, SWT.None);
        cat6100.setText("100");
        Button cat6200 = new Button(category6Buttons, SWT.None);
        cat6200.setText("200");
        Button cat6300 = new Button(category6Buttons, SWT.None);
        cat6300.setText("300");
        Button cat6400 = new Button(category6Buttons, SWT.None);
        cat6400.setText("400");
        Button cat6500 = new Button(category6Buttons, SWT.None);
        cat6500.setText("500");
        
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        
        display.dispose();
      
    }

    public Sector.SectorType retrieveCurrentSector()
    {        
        return wheel.getCurrentSector().getType();
    }
    
    public String retrieveSectorName()
    {
        return wheel.getCurrSectorName();
    }
    
//    public String getCurrentCategory()
//    {
//        
//    }
    
    private void setListeners() {
        Listener listener = new Listener() {
            @Override
            public void handleEvent(Event event) {
                if (event.widget == submitBtn) {
                    
                } else if (event.widget == spinBtn) {;
                    wheel.spin();
                } else if (event.widget == cat1Button){
                    
                } else if (event.widget == cat2Button) {
                
                } else if (event.widget == cat3Button) {
                    
                } else if (event.widget == cat4Button) {
                    
                } else if (event.widget == cat5Button) {
                    
                } else if (event.widget == cat6Button) {
                    
                }
            }
            
        };
    }
}
