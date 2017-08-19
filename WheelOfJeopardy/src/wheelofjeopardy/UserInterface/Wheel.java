/*
 *
 */
package wheelofjeopardy.UserInterface;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import wheelofjeopardy.UserInterface.Sector.SectorType;
/**
 *
 * @author adam
 */
public class Wheel 
{
    private int currentSector;
    List<Sector> gameSectors = new ArrayList<>();
    private Image image;
    private static int imageNumber;
    private static boolean spinning;
    private static Canvas canvas;
    private static Display display;
    private static ImageLoader loader;
    private static GC gc;
    private UserInterface ui;
    
    
    public Wheel(UserInterface ui, String [] catNames, Composite composite, int style) 
    {
        spinning = false;
        this.ui = ui;
        //create sectors in order of wheel picture.
        gameSectors.add(new Sector(Sector.SectorType.CATEGORY, catNames[0]));
        gameSectors.add(new Sector(Sector.SectorType.CATEGORY, catNames[2]));
        gameSectors.add(new Sector(Sector.SectorType.CATEGORY, catNames[1]));
        gameSectors.add(new Sector(Sector.SectorType.BANKRUPT,      "BANKRUPT"));        
        gameSectors.add(new Sector(Sector.SectorType.CATEGORY, catNames[3]));
        gameSectors.add(new Sector(Sector.SectorType.CATEGORY, catNames[4]));
        gameSectors.add(new Sector(Sector.SectorType.SPIN_AGAIN,    "SPIN AGAIN"));
        gameSectors.add(new Sector(Sector.SectorType.CATEGORY, catNames[5]));
        gameSectors.add(new Sector(Sector.SectorType.CATEGORY, catNames[0]));
        gameSectors.add(new Sector(Sector.SectorType.CATEGORY, catNames[1]));
        gameSectors.add(new Sector(Sector.SectorType.PLAYER_CHOICE, "PLAYER'S CHOICE" ));
        gameSectors.add(new Sector(Sector.SectorType.CATEGORY, catNames[2]));
        gameSectors.add(new Sector(Sector.SectorType.CATEGORY, catNames[3]));
        gameSectors.add(new Sector(Sector.SectorType.CATEGORY, catNames[4]));
        gameSectors.add(new Sector(Sector.SectorType.CATEGORY, catNames[5]));
        gameSectors.add(new Sector(Sector.SectorType.LOSE_TURN,     "LOSE TURN"));
        gameSectors.add(new Sector(Sector.SectorType.CATEGORY, catNames[0]));
        gameSectors.add(new Sector(Sector.SectorType.CATEGORY, catNames[1]));
        gameSectors.add(new Sector(Sector.SectorType.FREE_TURN,     "FREE TURN"));
        gameSectors.add(new Sector(Sector.SectorType.CATEGORY, catNames[2]));
        gameSectors.add(new Sector(Sector.SectorType.CATEGORY, catNames[3]));
        gameSectors.add(new Sector(Sector.SectorType.CATEGORY, catNames[4]));
        gameSectors.add(new Sector(Sector.SectorType.OPP_CHOICE,    "OPPONENT'S CHOICE"));
        gameSectors.add(new Sector(Sector.SectorType.CATEGORY, catNames[5]));
        
        // randomize order of Sectors
        loader = new ImageLoader();
        loader.load("./wheel.gif");
        display = composite.getDisplay();
        canvas = new Canvas(composite,SWT.DOUBLE_BUFFERED);
        canvas.setBackground(new Color(null, 255, 255, 255));
        image = new Image(composite.getDisplay(),loader.data[0]);
        imageNumber = 0;
        gc = new GC(image);
        canvas.addPaintListener(new PaintListener(){
            @Override
            public void paintControl(PaintEvent e) {
                e.gc.drawImage(image,0,0);
            }
        });
       
    }
    
    public Sector getCurrentSector()
    {
        return gameSectors.get(currentSector);
    }
    
    public String getCurrSectorName()
    {
        return gameSectors.get(currentSector).getName();
    }
    
    public void spin()
    {
        final int num = (int) ((Math.random() * 24) + 1); 
        
        currentSector = imageNumber + num;
        if (currentSector > 23) {
            currentSector = currentSector - 24;
        }
        ui.enableSpin(false);
        ui.enableSubmit(false);
        Thread thread = new Thread() {
            public void run() {
                spinning = true;
                for (int i = 0; i < num + 47; i++) {
 
                    long currentTime = System.currentTimeMillis();
                    int delayTime = loader.data[imageNumber].delayTime;                    
                    while(currentTime + (delayTime*6) > System.currentTimeMillis()) {
                        // Wait till the delay time has passed
                    }
                    display.asyncExec(new Runnable() {
                        public void run() {
                            // Increase the variable holding the frame number
                            imageNumber = imageNumber == loader.data.length - 1 ? 0 : imageNumber + 1;
                            // Draw the new data onto the image
                            ImageData nextFrameData = loader.data[imageNumber];
                            Image frameImage = new Image(display,nextFrameData);
                            gc.drawImage(frameImage,nextFrameData.x,nextFrameData.y);
                            frameImage.dispose();
                            canvas.redraw();
                        }
                    });
                }
                
                display.asyncExec(new Runnable() {
                        public void run() {
                           if (getCurrentSector().getType() == SectorType.LOSE_TURN) {
                                ui.enableSubmit(false);
                                ui.enableSpin(true);
                                ui.loseTurn();
                           } else if (getCurrentSector().getType() == SectorType.BANKRUPT) {
                                ui.enableSubmit(false);
                                ui.enableSpin(true);
                                ui.bankrupt();
                           } else if (getCurrentSector().getType() == SectorType.FREE_TURN) {
                                ui.enableSubmit(false);  
                                ui.enableSpin(true);
                           } else if (getCurrentSector().getType() == SectorType.OPP_CHOICE) {
                                ui.enableSubmit(true);
                                ui.enableSpin(false);
                                ui.chooseCategory();
                           } else if (getCurrentSector().getType() == SectorType.PLAYER_CHOICE) {
                                ui.enableSubmit(true);
                                ui.enableSpin(false);
                                ui.chooseCategory();
                           } else if (getCurrentSector().getType() == SectorType.SPIN_AGAIN) {
                                ui.enableSubmit(false);
                                ui.enableSpin(true);
                           } else {
                                ui.enableSubmit(true);
                                ui.enableSpin(false);
                           }
                           ui.updateQuestion(ui.getDb().getQuestion(getCurrentSector().getName()));
                           ui.updateInfo();
                           ui.startTimer();
                           
                        }
                    });
                spinning = false;
            }
        };
        thread.start();
    
    }
    
    public void setSpinning(boolean s) {
        spinning = s;
    }
    
    public boolean isSpinning() {
        return spinning;
    }
}
