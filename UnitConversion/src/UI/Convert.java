package UI;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

public class Convert extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Convert();
	}
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	private JTextField number;
	//to know when to convert
	private int click = 0;
	//to store the value of what needs to be converted.
	private float factor = 0;
	//implement the buttons
	public static final Font BTN_FONT = new Font(Font.SANS_SERIF,Font.BOLD,40);
	public Convert() 
	{
		this.setSize(450,600);
		this.setLocationRelativeTo(null);
		this.setTitle("Unit Converter Program");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel text = new JPanel();
		text.setLayout(new BorderLayout(5,5));
		text.setBorder(new EmptyBorder(4,4,4,4));
		number = new JTextField(15);
		number.setFont(BTN_FONT.deriveFont(Font.PLAIN));
		text.add(number,BorderLayout.NORTH);
		
		this.setContentPane(text);
		JPanel panel = new JPanel(new GridLayout(4,2,4,10));
		JButton mmbutton = new JButton("mm");
		mmbutton.setFont(BTN_FONT);
		mmbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(mmbutton.isEnabled())
				{
					click++;
					mmbutton.setEnabled(false);
					unit("mm");
					
				}
				else
					JOptionPane.showMessageDialog(Convert.this,"Unit already in desired unit.","I think you misclicked.",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		buttons.add(mmbutton);
		
		JButton cmbutton = new JButton("cm");
		cmbutton.setFont(BTN_FONT);
		cmbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(cmbutton.isEnabled())
				{
					click++;
					cmbutton.setEnabled(false);
					unit("cm");
				}
				else
					JOptionPane.showMessageDialog(Convert.this,"Unit already in desired unit.","I think you misclicked.",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		buttons.add(cmbutton);
		
		JButton meterbutton = new JButton("meter");
		meterbutton.setFont(BTN_FONT);
		meterbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(meterbutton.isEnabled())
				{
					click++;
					meterbutton.setEnabled(false);
					unit("meter");	
				}
			}
		});
		buttons.add(meterbutton);
		
		JButton kilobutton = new JButton("kilometer");
		kilobutton.setFont(BTN_FONT);
		kilobutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(kilobutton.isEnabled())
				{
					click++;
					kilobutton.setEnabled(false);
					unit("kilometer");	
				}
			}
		});
		buttons.add(kilobutton);
		
		JButton inbutton = new JButton("inch");
		inbutton.setFont(BTN_FONT);
		inbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(inbutton.isEnabled())
				{
					click++;
					inbutton.setEnabled(false);
					unit("inch");	
				}
			}
		});
		buttons.add(inbutton);
		
		JButton ftbutton = new JButton("feet");
		ftbutton.setFont(BTN_FONT);
		ftbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(ftbutton.isEnabled())
				{
					click++;
					ftbutton.setEnabled(false);
					unit("ft");	
				}
			}
		});
		buttons.add(ftbutton);
		
		JButton yardbutton = new JButton("yards");
		yardbutton.setFont(BTN_FONT);
		yardbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(yardbutton.isEnabled())
				{
					click++;
					yardbutton.setEnabled(false);
					unit("yard");	
				}
			}
		});
		buttons.add(yardbutton);
		
		JButton milebutton = new JButton("miles");
		milebutton.setFont(BTN_FONT);
		milebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(milebutton.isEnabled())
				{
					click++;
					milebutton.setEnabled(false);
					unit("miles");
				}
			}
		});
		buttons.add(milebutton);
		
		panel.add(inbutton);
		panel.add(mmbutton);
		panel.add(ftbutton);
		panel.add(cmbutton);
		panel.add(yardbutton);
		panel.add(meterbutton);
		panel.add(milebutton);
		panel.add(kilobutton);
		this.add(panel);
		JOptionPane.showMessageDialog(panel, "Enter value to convert,then click the unit it is to then click the unit you want it to be.","Instruction Message",JOptionPane.INFORMATION_MESSAGE);
		//this.pack();
		this.setVisible(true);
	}
	//Convert everything to meters first, to then convert to desired unit
	public void unit(String value)
	{
		try {
			
		if(value == "mm" && click == 1) factor = Float.parseFloat(number.getText())/1000;
		if(value == "cm" && click == 1) factor = Float.parseFloat(number.getText())/100;
		if(value == "meter" && click == 1) factor = Float.parseFloat(number.getText());
		if(value == "kilometer" && click == 1) factor = Float.parseFloat(number.getText())*1000;
		if(value == "inch" && click == 1) factor = (float) (Float.parseFloat(number.getText()) * .0254);
		if(value ==  "ft" && click == 1) factor = (float) (Float.parseFloat(number.getText()) * .3048);
		if(value == "yard" && click == 1) factor = (float)(Float.parseFloat(number.getText()) * .9144);
		if(value == "miles" && click == 1) factor = (float)(Float.parseFloat(number.getText()) * 1609.344);
		
		if(value == "mm" && click == 2) 
		{
			factor = factor*1000;
			click = 0;
			JOptionPane.showMessageDialog(Convert.this,factor+" mm","converted value is "+factor+" mm",JOptionPane.INFORMATION_MESSAGE);
			for(JButton b :buttons)
				b.setEnabled(true);
		}
		
		if(value == "cm" && click == 2) 
		{
			factor = factor*100;
			click = 0;
			JOptionPane.showMessageDialog(Convert.this,factor+" cm","converted value is "+factor+" cm",JOptionPane.INFORMATION_MESSAGE);
			for(JButton b :buttons)
				b.setEnabled(true);
		}
		
		if(value == "meter" && click == 2) 
		{
			click = 0;
			JOptionPane.showMessageDialog(Convert.this,factor+" meter","converted value is "+factor+" meter",JOptionPane.INFORMATION_MESSAGE);
			for(JButton b :buttons)
				b.setEnabled(true);
		}
		if(value == "kilometer" && click == 2) 
		{
			factor = factor/1000;
			click = 0;
			JOptionPane.showMessageDialog(Convert.this,factor+" kilometer","converted value is "+factor+" kilometer",JOptionPane.INFORMATION_MESSAGE);
			for(JButton b :buttons)
				b.setEnabled(true);
		}
		if(value == "inch" && click == 2)
		{
			factor = (float) (factor/.0254);
			click = 0;
			JOptionPane.showMessageDialog(Convert.this,factor+" inches","converted value is "+factor+" inches",JOptionPane.INFORMATION_MESSAGE);
			for(JButton b :buttons)
				b.setEnabled(true);
			
		}
		if(value == "ft" && click == 2)
		{
			factor = (float) (factor/.3048);
			click = 0;
			JOptionPane.showMessageDialog(Convert.this,factor+" ft","converted value is "+factor+" ft",JOptionPane.INFORMATION_MESSAGE);
			for(JButton b :buttons)
				b.setEnabled(true);
			
		}
		if(value == "yard" && click == 2)
		{
			factor = (float) (factor/.9144);
			click = 0;
			JOptionPane.showMessageDialog(Convert.this,factor+" yards","converted value is "+factor+" yards",JOptionPane.INFORMATION_MESSAGE);
			for(JButton b :buttons)
				b.setEnabled(true);
			
		}
		if(value == "miles" && click == 2)
		{
			factor = (float)(factor/1609.344);
			click = 0;
			JOptionPane.showMessageDialog(Convert.this,factor+" miles","converted value is "+factor+" miles",JOptionPane.INFORMATION_MESSAGE);
			for(JButton b :buttons)
				b.setEnabled(true);
		}
		
		}
		catch(Exception e) 
		{
			JOptionPane.showMessageDialog(Convert.this,"Please make sure you are entering a real number and not gibberish","Oh no, something went wrong.",JOptionPane.INFORMATION_MESSAGE);
			for(JButton b :buttons)
				b.setEnabled(true);
		}
		
	}

}
