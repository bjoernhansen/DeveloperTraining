package training.algorithms.acceleration;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class Simulation extends JPanel implements Runnable, ActionListener, ChangeListener
{
	private static final long serialVersionUID = 4301592417000711331L;
	static final boolean START_AS_APP = true;
	
	public static final Dimension
		DIM = new Dimension(1000, 1000);
	
	static boolean loop = false;
	
	private final Thread animator;
	
	private static final Image offImage = new BufferedImage(DIM.width, DIM.height, BufferedImage.TYPE_INT_RGB);
    private static final Graphics2D offGraphics = getGraphics(offImage);
	
    private final JButton start_stop_button;
	private final JButton restart_button;
	private final JSpinner spinner_1;
	private final JSpinner spinner_2;
	
	static Ball ball = new Ball();

	Simulation()
	{			
		this.setLayout(null);		
		this.start_stop_button = new JButton("Starten");
		JLabel label_1 = new JLabel("label 1");
		JLabel number_of_sim_label = new JLabel("number of simulations");
		this.restart_button = new JButton("Neustart");
		this.spinner_1             = new JSpinner(new SpinnerNumberModel(0.0, Float.MIN_VALUE/2, Float.MAX_VALUE/2, 0.01));
		this.spinner_2 = new JSpinner(new SpinnerNumberModel(0.0, Float.MIN_VALUE/2, Float.MAX_VALUE/2, 0.01));
		this.spinner_1.addChangeListener(this); 
		this.spinner_2.addChangeListener(this);
		JPanel main_panel = new JPanel(new GridLayout(3, 2));
		main_panel.setBounds(1400, 25, 300, 120);
		main_panel.setBorder(BorderFactory.createEtchedBorder());
		this.start_stop_button.addActionListener(this);
		this.restart_button.addActionListener(this);		
		this.add(main_panel);
		main_panel.add(this.start_stop_button);
		main_panel.add(this.restart_button);
		main_panel.add(label_1);
		main_panel.add(this.spinner_1);
		main_panel.add(number_of_sim_label);
		main_panel.add(this.spinner_2);
		
		this.animator = new Thread(this);		
		this.animator.start();
		
		this.restart_app();
	}
	
	public static void start_sim()
	{					
		restart();		
		while(true)
		{
			calculate_sim();		
			//printResults();
		}		
	}
	
	void restart_app()
	{
		restart();
		this.start_stop_button.setText("Starten");
	}
	
	static void restart()
	{
		ball.reset();
	}	
		
	// @Override: Überschreibt die run-Methode im Interface Runnable
	@Override
	public void run()
	{
		while (Thread.currentThread() == this.animator)
		{			
			try{Thread.sleep(0);}
			catch (InterruptedException e)
			{
				e.printStackTrace();
				break;
			}
			repaint();
		}
	}		
	
	private static void calculate_sim()
	{
		ball.update();
	}	
	
	static void drawOffImage()
	{		
		// wei�er Hintergrund		
		offGraphics.setColor(Color.white);
		offGraphics.fillRect(0, 0, DIM.width, DIM.height);	
		
		
		ball.paint(offGraphics);
		//offGraphics.setColor(Color.red);
		//offGraphics.fillOval(counter, 10, 20, 20);
						
		// Schwarzer Rahmen
		offGraphics.setColor(Color.BLACK);
		offGraphics.drawRect(0, 0, DIM.width-1, DIM.height-1);
	}	
		
	@Override
	public void paintComponent(Graphics g)
	{
		if(loop)
		{
			calculate_sim();		
			//printResults();
		}
		paintSim(g);
	}
			
	private void paintSim(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g.create();		
		drawOffImage();				
		super.paintComponent(g);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);  
    	g2.drawImage(offImage, 25, 25, null);	
		g2.dispose();		
	}
	
	/**
	 *  technical methods 
	 */
	
	private static Graphics2D getGraphics(Image Image)
	{
		Graphics2D graphics2D = (Graphics2D) Image.getGraphics();
		graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		return graphics2D;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object o = e.getSource();
		
		if (o == this.start_stop_button)
		{
			if(loop)
			{
				this.start_stop_button.setText("Starten");
			}
			else
			{
				this.start_stop_button.setText("Anhalten");
			}
			loop = !loop;
		} 
		else if(o == this.restart_button)
		{
			
			this.restart_app();
			loop = false;
		}
	}
		
	@Override
	public void stateChanged(ChangeEvent e)
    {
        Object o = e.getSource();           
        if(o==this.spinner_1)
        {            
            ball.a.setLocation(Double.parseDouble((this.spinner_1).getValue()
																  .toString()), ball.a.getY());
        }
        if(o==this.spinner_2)
        {            
            ball.a.setLocation(ball.a.getX(), Double.parseDouble((this.spinner_2).getValue()
																				 .toString()));
        }
    }
}
