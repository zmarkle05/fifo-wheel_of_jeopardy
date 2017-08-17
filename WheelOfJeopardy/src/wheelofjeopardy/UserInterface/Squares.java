/*
 *
 */
package wheelofjeopardy.UserInterface;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
/**
 *
 * @author adam
 */
public class Squares {

    
    public Squares(Composite composite, 
                   String label){
        
        Button square = new Button(composite, SWT.NONE);
        square.setText(label);   
        square.setEnabled(false);
    }
}
