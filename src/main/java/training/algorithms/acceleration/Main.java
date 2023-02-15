package training.algorithms.acceleration;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
 
public class Main extends JFrame
{
	private static final long serialVersionUID = 2638500843910810227L;

	Main(Simulation anim)
    {
    	super("Prototype Application");
    	setSize(1920, 1100);
    	addWindowListener(new DemoAdapter());    	
    	this.add(anim);        
    }
    
    public static void main( String argv[] ) 
    {    	
    	if(Simulation.START_AS_APP)
        {        	
    		Simulation anim = new Simulation();
        	JFrame f = new Main(anim);
        	f.setVisible(true);
        }
    	else
    	{
    		Simulation.loop = true;
    		Simulation.start_sim();
        }    	
    }
        
    static class DemoAdapter extends WindowAdapter
    {
        @Override
		public void windowClosing (WindowEvent e){System.exit(0);}
    }    
}