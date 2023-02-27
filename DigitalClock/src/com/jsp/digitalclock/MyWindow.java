package com.jsp.digitalclock;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class MyWindow extends JFrame
{
	private JLabel heading;
	private JLabel clockLabel;
	private Font font=new Font("",Font.BOLD, 35);
	public MyWindow() {
		super.setTitle("My Clock");
		super.setSize(400, 400);
		super.setLocation(300, 50);
		this.createGUI();
		this.startclock();
		super.setVisible(true);
	}
	public void createGUI()
	{
		//gui
		heading =new JLabel("My Clock");
		clockLabel=new JLabel("Clock");
		heading.setFont(font);
		clockLabel.setFont(font);
		this.setLayout(new GridLayout(2,1));
		this.add(heading);
		this.add(clockLabel);
	}
	public void startclock()
	{
		
		Thread t=new Thread()
				{
			public void run()
			{
				try {
					
					while(true)
					{
						Date d=new Date();
						SimpleDateFormat sfd=new SimpleDateFormat("hh : mm : ss a");
						String dateTime=sfd.format(d);
						clockLabel.setText(dateTime);
						Thread .currentThread().sleep(1000);
					}
					
				}catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				}
				};
				t.start();
	}
}
		
