package marlabsassignment;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
public class Calendarjavaswing {
	
	public JFrame frame;
	public JLabel title;
	public JLabel month;
	public JButton nextmonth;
	public JButton previousmonth;
	public JTable calendartable;
	public JSeparator border;
	public JScrollPane pane;
	public JComboBox<String> combo;
	public String year;
	public Calendar c;
	public int month1;
	public int year1;
	
	public Calendarjavaswing()
	{
		gui();
	}
	
	public void calendar(int mon,int yea)
	{
		//clearing the contents of a JTable first
		for(int i1=1;i1<7;i1++)
		{
			for(int j1=0;j1<7;j1++)
			{
				calendartable.setValueAt("", i1, j1);
			}
		}
		
		//loading new calendar
		c=Calendar.getInstance();
		c.set(yea, mon-1, 1);
		int maxdays=c.getActualMaximum(Calendar.DATE);
		int dayofweek=c.get(Calendar.DAY_OF_WEEK);
		Boolean b=false;
		int day=1;
		for(int i=1;i<7;i++)
		{
			for(int j=dayofweek-1;j<=maxdays&&j<7;j++)
			{
				calendartable.setValueAt(" "+day, i, j);
				day++;
				
				if(day>maxdays)
				{
					b=true;
			        break;
				}
			}
			dayofweek=1;
			if(b==true)
			{
				break;
			}
		}	
	}
	
	public void gui()
	{
		frame=new JFrame("Calendar");
		frame.setSize(390, 290);
		frame.setLayout(null);
		frame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      });
	    	
		title=new JLabel("Year");
		title.setSize(100, 50);
		title.setBounds(115, -5, 100, 50);
		
		String[] years={"2016","2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000","1999","1998","1997","1996","1995","1994","1993","1992","1991","1990","1989","1988","1987","1986","1985","1984","1983","1982","1981","1980","1979","1978","1977","1976","1975","1974","1973","1972","1971","1970"};
		combo=new JComboBox<String>(years);
		combo.setSelectedIndex(1);
		combo.setBounds(150, 12, 70, 20);
		combo.addActionListener(new comboactionlistener());
		
		previousmonth=new JButton("<<");
		previousmonth.setSize(100, 30);
		previousmonth.setBounds(15, 40, 50, 20);
		previousmonth.addActionListener(new previousmonthActionListener());	
		Border border3=BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
		previousmonth.setBorder(border3);
		
		month=new JLabel("December");
		month.setBounds(155, 40, 70, 20);
		
		nextmonth=new JButton(">>");
		nextmonth.setBounds(320, 40, 50, 20);
		nextmonth.addActionListener(new nextmonthActionListener());
		Border border2=BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
		nextmonth.setBorder(border2);
		
		border=new JSeparator(JSeparator.HORIZONTAL);
		border.setBounds(0, 70, 390, 25);
		border.setBackground(Color.DARK_GRAY);
		 
		calendartable=new JTable(7,7);
		
		String[] months={"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
		
		for(int i=0;i<7;i++)
		{
			calendartable.setValueAt("     "+months[i], 0, i);
			
		}
		
		calendartable.setBounds(0, 80, 385, 430);
		calendartable.setRowHeight(26);
		calendartable.setBackground(Color.cyan);
		calendartable.setGridColor(Color.DARK_GRAY);
		Border border4=BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
		calendartable.setBorder(border4);
		
		frame.add(title);
		frame.add(nextmonth);
		frame.add(month);
		frame.add(previousmonth);
		frame.add(border);
		frame.add(calendartable);
		frame.add(combo);
		frame.setVisible(true);
		frame.setResizable(false);
		
		
		if(month.getText()=="January")
		{
			month1=1;
		}
		
		else if(month.getText()=="February")
		{
			month1=2;
		}
		
		else if(month.getText()=="March")
		{
			month1=3;
		}
		
		else if(month.getText()=="April")
		{
			month1=4;
		}
		
		else if(month.getText()=="May")
		{
			month1=5;
		}
		
		else if(month.getText()=="June")
		{
			month1=6;
		}
		
		else if(month.getText()=="July")
		{
			month1=7;
		}
		
		else if(month.getText()=="August")
		{
			month1=8;
		}
		
		else if(month.getText()=="September")
		{
			month1=9;
		}
		
		else if(month.getText()=="October")
		{
			month1=10;
		}
		
		else if(month.getText()=="November")
		{
			month1=11;
		}
		
		else if(month.getText()=="December")
		{
			month1=12;
		}
		
		year1=2015;
		this.calendar(month1, year1);
		
	}
	
	class previousmonthActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String mon=month.getText();
			switch(mon)
			{
			case "January":
			{
				month.setText("December");
				month1=12;
				calendar(month1, year1);
				break;
			}
			
			case "February":
			{
				month.setText("January");
				month1=1;
				calendar(month1, year1);
				break;
			}
			
			case "March":
			{
				month.setText("February");
				month1=2;
				calendar(month1, year1);
				break;
			}
			
			case "April":
			{
				month.setText("March");
				month1=3;
				calendar(month1, year1);
				break;
			}
			
			case "May":
			{
				month.setText("April");
				month1=4;
				calendar(month1, year1);
				break;
			}
			
			case "June":
			{
				month.setText("May");
				month1=5;
				calendar(month1, year1);
				break;
			}
			
			case "July":
			{
				month.setText("June");
				month1=6;
				calendar(month1, year1);
				break;
			}
			
			case "August":
			{
				month.setText("July");
				month1=7;
				calendar(month1, year1);
				break;
			}
			
			case "September":
			{
				month.setText("August");
				month1=8;
				calendar(month1, year1);
				break;
			}
			
			case "October":
			{
				month.setText("September");
				month1=9;
				calendar(month1, year1);
				break;
			}
			
			case "November":
			{
				month.setText("October");
				month1=10;
				calendar(month1, year1);
				break;
			}
			
			case "December":
			{
				month.setText("November");
				month1=11;
				calendar(month1, year1);
				break;
			}
			
			}
				
		}	
	}
	class nextmonthActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String mon=month.getText();
			switch(mon)
			{
			case "January":
			{
				month.setText("February");
				month1=2;
				calendar(month1, year1);
				break;
			}
			
			case "February":
			{
				month.setText("March");
				month1=3;
				calendar(month1, year1);
				break;
			}
			
			case "March":
			{
				month.setText("April");
				month1=4;
				calendar(month1, year1);
				break;
			}
			
			case "April":
			{
				month.setText("May");
				month1=5;
				calendar(month1, year1);
				break;
			}
			
			case "May":
			{
				month.setText("June");
				month1=6;
				calendar(month1, year1);
				break;
			}
			
			case "June":
			{
				month.setText("July");
				month1=7;
				calendar(month1, year1);
				break;
			}
			
			case "July":
			{
				month.setText("August");
				month1=8;
				calendar(month1, year1);
				break;
			}
			
			case "August":
			{
				month.setText("September");
				month1=9;
				calendar(month1, year1);
				break;
			}
			
			case "September":
			{
				month.setText("October");
				month1=10;
				calendar(month1, year1);
				break;
			}
			
			case "October":
			{
				month.setText("November");
				month1=11;
				calendar(month1, year1);
				break;
			}
			
			case "November":
			{
				month.setText("December");
				month1=12;
				calendar(month1, year1);
				break;
			}
			
			case "December":
			{
				month.setText("January");
				month1=1;
				calendar(month1, year1);
				break;
			}
			
			}
		}
	}
	
	class comboactionlistener implements ActionListener
	{

		@SuppressWarnings("rawtypes")
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			JComboBox c=(JComboBox) arg0.getSource();
			year=(String) c.getSelectedItem();
		    year1=Integer.parseInt(year);
		    calendar(month1,year1);	
		}
		
	}
	
	public static void main(String [] args)
	{
		Calendarjavaswing s=new Calendarjavaswing();
	}
}
