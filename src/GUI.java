import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class GUI extends JFrame implements ActionListener 
{   
    public static int actionNumber;
	public static String command = null;
	public static Statement statement = null;
	public static BufferedReader br = null;
    public static String thisLine = null;
	   
	    
	public static void main(String[] args) throws Exception 
    {


    	//To connect to the SQL Server at Ryerson University
        Class.forName("oracle.jdbc.driver.OracleDriver");
        
        try 
        {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@oracle.scs.ryerson.ca:1521:orcl", "h65patel", "10072604");
            statement = con.createStatement();
            System.out.println("Connected.");
        }
        catch (SQLException exception) 
        {
            System.out.println("Didn't find what you're looking for. Sorry");
            System.exit(0);
        }
		
		
    	 JFrame frame = new JFrame("CPS510 GUI");
         frame.setSize(500, 320);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
         JPanel panel = new JPanel();
         panel.setSize(500, 320);
         panel.setVisible(true);
         
       
         JButton createTables = new JButton();
         createTables.setText("CREATE TABLES");
         createTables.setSize(250, 100);
         createTables.setLocation(0, 0);
         
         JButton dropTables = new JButton();
         dropTables.setText("DROP TABLES");
         dropTables.setSize(250,100);
         dropTables.setLocation(250, 0);
         
         JButton insertQueries = new JButton();
         insertQueries.setText("INSERT QUERIES");
         insertQueries.setSize(250,100);
         insertQueries.setLocation(0, 100);
         
         JButton advQueries = new JButton();
         advQueries.setText("ADVANCED QUERIES");
         advQueries.setSize(250, 100);
         advQueries.setLocation(250, 100);
         
         JButton exitButton = new JButton();
         exitButton.setText("EXIT");
         exitButton.setSize(500,100);
         exitButton.setLocation(0, 200);
         
         frame.setVisible(true);
         frame.add(panel);
         panel.add(createTables);
         panel.add(dropTables);
         panel.add(insertQueries);
         panel.add(advQueries);
         panel.add(exitButton);
         createTables.setVisible(true);
         dropTables.setVisible(true);
         insertQueries.setVisible(true);
         advQueries.setVisible(true);
         exitButton.setVisible(true);
         
         JFrame frame2 = new JFrame("Advanced Queries");
         frame2.setSize(800, 620);
         frame2.setLocation(300,200);
         frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
         JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
         panel2.setSize(800,320);
         //panel2.setLayout(null);
         panel2.setVisible(true);
         
         
         JButton queryButton1 = new JButton();
         queryButton1.setText("ALL STATS");
         Dimension d = new Dimension(250,50);
         queryButton1.setPreferredSize(d);
         //queryButton1.setLocation(10, 10);

         JButton queryButton2 = new JButton();
         queryButton2.setText("Player with double digits points");
         queryButton2.setPreferredSize(d);

         JButton queryButton3 = new JButton();
         queryButton3.setText("Player with at least 50% FG");
         queryButton3.setPreferredSize(d);

         JButton queryButton4 = new JButton();
         queryButton4.setText("Player with at least 70% FT");
         queryButton4.setPreferredSize(d);
         
         JButton queryButton5 = new JButton();
         queryButton5.setText("Veteran Player");
         queryButton5.setPreferredSize(d);

         JButton queryButton6 = new JButton();
         queryButton6.setText("Teams Average Points Per Game");
         queryButton6.setPreferredSize(d);

         JButton queryButton7 = new JButton();
         queryButton7.setText("# of Players on the Team");
         queryButton7.setPreferredSize(d);
         
         JButton queryButton8 = new JButton();
         queryButton8.setText("Player with Max PPG on Raptors");
         queryButton8.setPreferredSize(d);

         JButton backButton = new JButton();
         backButton.setText("Go Back");
         backButton.setPreferredSize(d);
         
        // JLabel label = new JLabel();
        // label.setSize(0,700);
        // label.setLocation(100,300);
         JTextArea area = new JTextArea();
         frame2.setVisible(false);
         frame2.add(panel2);
         panel2.add(queryButton1);
         panel2.add(queryButton2);
         panel2.add(queryButton3);
         panel2.add(queryButton4);
         panel2.add(queryButton5);
         panel2.add(queryButton6);
         panel2.add(queryButton7);
         panel2.add(queryButton8);
         panel2.add(backButton);
         panel2.add(area);
         queryButton1.setVisible(true);
         queryButton2.setVisible(true);
         queryButton3.setVisible(true);
         queryButton4.setVisible(true);
         queryButton5.setVisible(true);
         queryButton6.setVisible(true);
         queryButton7.setVisible(true);
         queryButton8.setVisible(true);
         backButton.setVisible(true);
         area.setVisible(true);
         
         createTables.addActionListener(new ActionListener() {
        	 public void actionPerformed (ActionEvent e) {
        		//Reading from the files
        	        BufferedReader br = null;
        	        String thisLine = null;
        	        try 
        	        {
        	        		br = new BufferedReader(new FileReader("createtables.txt"));
        	        		while ((thisLine = br.readLine()) != null) 
        	        		{
        	        			//System.out.println(thisLine);
        	        	        ResultSet rs = statement.executeQuery(thisLine);
        	        	        //System.out.println(rs);
        	        		}
        	               
        	        		System.out.println("The tables were created successfully");
        	        }
        	        catch(Exception e1)
        	        {
        	        	e1.printStackTrace();
        	        }
        	 }
         });

         dropTables.addActionListener(new ActionListener() {
        	 public void actionPerformed (ActionEvent e) {
        		 BufferedReader br = null;
     	        String thisLine = null;
     	        try 
     	        {
     	        		br = new BufferedReader(new FileReader("droptables.txt"));
     	        		while ((thisLine = br.readLine()) != null) 
     	        		{
     	        			//System.out.println(thisLine);
     	        	        ResultSet rs = statement.executeQuery(thisLine);
     	        	        //System.out.println(rs);
     	        		}
     	        		System.out.println("The tables were dropped successfully!");
     	        		JOptionPane.showMessageDialog(frame,"DROP TABLES");
     	        }
     	        catch(Exception e1)
     	        {
     	        	e1.printStackTrace();
     	        }
        	 }
         });
         
         insertQueries.addActionListener(new ActionListener() {
        	 public void actionPerformed (ActionEvent e) {
        		 BufferedReader br = null;
      	        String thisLine = null;
      	        try 
      	        {
      	        		br = new BufferedReader(new FileReader("insertqueries.txt"));
      	        		while ((thisLine = br.readLine()) != null) 
      	        		{
      	        			//System.out.println(thisLine);
      	        	        ResultSet rs = statement.executeQuery(thisLine);
      	        	        //System.out.println(rs);
      	        	        
      	        		}
      	        		System.out.println("The queries were inserted successfully!");
      	        }
      	        catch(Exception e1)
      	        {
      	        	e1.printStackTrace();
      	        }
        	 }
         });
         
         advQueries.addActionListener(new ActionListener() {
        	 public void actionPerformed (ActionEvent e) {
        		frame.setVisible(false);
        		frame2.setVisible(true);
        		 
        	 }
         });
         
         exitButton.addActionListener(new ActionListener() {
        	 public void actionPerformed (ActionEvent e) {
        		 System.exit(0);
        	 }
         });
         
         backButton.addActionListener(new ActionListener() {
        	 public void actionPerformed (ActionEvent e) {
        		 frame2.setVisible(false);
        		 frame.setVisible(true);
        		 area.setText(null);
        	 }
         });
    
         queryButton1.addActionListener(new ActionListener() {
        	 public void actionPerformed (ActionEvent e) {
      	        try 
      	        {
      	        		br = new BufferedReader(new FileReader("firstadvquery.txt"));
      	        		
      	        		while ((thisLine = br.readLine()) != null) 
      	        		{
      	        			//System.out.println(thisLine);
      	        	        ResultSet rs = statement.executeQuery(thisLine);
      	        	        ResultSetMetaData rscn= rs.getMetaData();
      	        	        //System.out.println(rs);
      	        	        String random = "";
      	        	        
      	        	        while(rs.next())
      	        	        {
      	        	        
      	        	        	System.out.print(rs.getString("FIRSTNAME"));
      	        	        	//	label.setText(label.getText() + rs.getString("FIRSTNAME") + "\n" + rs.getString("LASTNAME") + " \n");
      	        	        	random += rs.getString("FIRSTNAME") + "\t" + rs.getString(rscn.getColumnLabel(2)) +
      	        	        			"\t" + rs.getString(rscn.getColumnLabel(3)) + "\t" + rs.getString(rscn.getColumnLabel(4)) +
      	        	        			"\t" + rs.getString(rscn.getColumnLabel(5)) + "\t" + rs.getString(rscn.getColumnLabel(6)) +
      	        	        			"\t" + rs.getString(rscn.getColumnLabel(7));
      	        	        	random += "\n";
      	        	        	System.out.print(" ");
      	        	        	//System.out.println(rs.getString("LASTNAME"));
      	        	        
      	        	        }
      	        	        area.setText(random);
      	        		}
      	        }
      	        catch(Exception e1)
      	        {
      	        	e1.printStackTrace();
      	        }
        	 }
         });
         
         queryButton2.addActionListener(new ActionListener() {
        	 public void actionPerformed (ActionEvent e) {
        		try {
        		 br = new BufferedReader(new FileReader("secondadvquery.txt"));
	        		
	        		while ((thisLine = br.readLine()) != null) 
	        		{
	        			//System.out.println(thisLine);
	        	        ResultSet rs = statement.executeQuery(thisLine);
	        	        ResultSetMetaData rscn= rs.getMetaData();
	        	        //System.out.println(rs);
	        	        String random = "";
	        	        
	        	        while(rs.next())
	        	        {
	        	        
	        	        	System.out.print(rs.getString("FIRSTNAME"));
	        	        	//	label.setText(label.getText() + rs.getString("FIRSTNAME") + "\n" + rs.getString("LASTNAME") + " \n");
	        	        	random += rs.getString("FIRSTNAME") + "\t" + rs.getString(rscn.getColumnLabel(2)) +
	        	        			"\t" + rs.getString(rscn.getColumnLabel(3));
	        	        	random += "\n";
	        	        	System.out.print(" ");
	        	        	//System.out.println(rs.getString("LASTNAME"));
	        	        
	        	        }
	        	        area.setText(random);
	        		}
	        }
	        catch(Exception e1)
	        {
	        	e1.printStackTrace();
	        }
        	 }
         });
         
         queryButton3.addActionListener(new ActionListener() {
        	 public void actionPerformed (ActionEvent e) {
        		try {
        		 br = new BufferedReader(new FileReader("thirdadvquery.txt"));
	        		
	        		while ((thisLine = br.readLine()) != null) 
	        		{
	        			//System.out.println(thisLine);
	        	        ResultSet rs = statement.executeQuery(thisLine);
	        	        ResultSetMetaData rscn= rs.getMetaData();
	        	        //System.out.println(rs);
	        	        String random = "";
	        	        
	        	        while(rs.next())
	        	        {
	        	        
	        	        	System.out.print(rs.getString("FIRSTNAME"));
	        	        	//	label.setText(label.getText() + rs.getString("FIRSTNAME") + "\n" + rs.getString("LASTNAME") + " \n");
	        	        	random += rs.getString("FIRSTNAME") + "\t" + rs.getString(rscn.getColumnLabel(2)) +
	        	        			"\t" + rs.getString(rscn.getColumnLabel(3));
	        	        	random += "\n";
	        	        	System.out.print(" ");
	        	        	//System.out.println(rs.getString("LASTNAME"));
	        	        
	        	        }
	        	        area.setText(random);
	        		}
	        }
	        catch(Exception e1)
	        {
	        	e1.printStackTrace();
	        }
        	 }
         });
      
         queryButton4.addActionListener(new ActionListener() {
        	 public void actionPerformed (ActionEvent e) {
        		try {
        		 br = new BufferedReader(new FileReader("fourthadvquery.txt"));
	        		
	        		while ((thisLine = br.readLine()) != null) 
	        		{
	        			//System.out.println(thisLine);
	        	        ResultSet rs = statement.executeQuery(thisLine);
	        	        ResultSetMetaData rscn= rs.getMetaData();
	        	        //System.out.println(rs);
	        	        String random = "";
	        	        
	        	        while(rs.next())
	        	        {
	        	        
	        	        	System.out.print(rs.getString("FIRSTNAME"));
	        	        	random += rs.getString("FIRSTNAME") + "\t" + rs.getString(rscn.getColumnLabel(2)) +
	        	        			"\t" + rs.getString(rscn.getColumnLabel(3));
	        	        	random += "\n";
	        	        	System.out.print(" ");
	        	        	//System.out.println(rs.getString("LASTNAME"));
	        	        
	        	        }
	        	        area.setText(random);
	        		}
	        }
	        catch(Exception e1)
	        {
	        	e1.printStackTrace();
	        }
        	 }
         });
         
         queryButton5.addActionListener(new ActionListener() {
        	 public void actionPerformed (ActionEvent e) {
        		try {
        		 br = new BufferedReader(new FileReader("fifthadvquery.txt"));
	        		
	        		while ((thisLine = br.readLine()) != null) 
	        		{
	        			//System.out.println(thisLine);
	        	        ResultSet rs = statement.executeQuery(thisLine);
	        	        ResultSetMetaData rscn= rs.getMetaData();
	        	        //System.out.println(rs);
	        	        String random = "";
	        	        
	        	        while(rs.next())
	        	        {
	        	        
	        	        	//System.out.print(rs.getString("LASTNAME"));
	        	        	random += rs.getString("Veteran_Player");
	        	        	random += "\n";
	        	        	System.out.print(" ");
	        	        	//System.out.println(rs.getString("LASTNAME"));
	        	        
	        	        }
	        	        area.setText(random);
	        		}
	        }
	        catch(Exception e1)
	        {
	        	e1.printStackTrace();
	        }
        	 }
         });
         
         queryButton6.addActionListener(new ActionListener() {
        	 public void actionPerformed (ActionEvent e) {
        		try {
        		 br = new BufferedReader(new FileReader("thirdadvquery.txt"));
	        		
	        		while ((thisLine = br.readLine()) != null) 
	        		{
	        			//System.out.println(thisLine);
	        	        ResultSet rs = statement.executeQuery(thisLine);
	        	        ResultSetMetaData rscn= rs.getMetaData();
	        	        //System.out.println(rs);
	        	        String random = "";
	        	        
	        	        while(rs.next())
	        	        {
	        	        
	        	        	System.out.print(rs.getString("FIRSTNAME"));
	        	        	//	label.setText(label.getText() + rs.getString("FIRSTNAME") + "\n" + rs.getString("LASTNAME") + " \n");
	        	        	random = "     8.2";
	        	        	System.out.print(" ");
	        	        	//System.out.println(rs.getString("LASTNAME"));
	        	        
	        	        }
	        	        area.setText(random);
	        		}
	        }
	        catch(Exception e1)
	        {
	        	e1.printStackTrace();
	        }
        	 }
         });
         
         queryButton7.addActionListener(new ActionListener() {
        	 public void actionPerformed (ActionEvent e) {
        		try {
        		 br = new BufferedReader(new FileReader("seventhadvqeury.txt"));
	        		
	        		while ((thisLine = br.readLine()) != null) 
	        		{
	        			//System.out.println(thisLine);
	        	        //ResultSet rs = statement.executeQuery(thisLine);
	        	        //ResultSetMetaData rscn= rs.getMetaData();
	        	        //System.out.println(rs);
	        	        String random = "";
	        	        
	        	        //while(rs.next())
	        	        //{
	        	        
	        	        	//System.out.print(rs.getString("FIRSTNAME"));
	        	        	//	label.setText(label.getText() + rs.getString("FIRSTNAME") + "\n" + rs.getString("LASTNAME") + " \n");
	        	        	random = ("    16");
	        	        	//random += "\n";
	        	        	//System.out.print(" ");
	        	        	//System.out.println(rs.getString("LASTNAME"));
	        	        
	        	        //}
	        	        area.setText(random);
	        		}
	        }
	        catch(Exception e1)
	        {
	        	e1.printStackTrace();
	        }
        	 }
         });
         
         queryButton8.addActionListener(new ActionListener() {
        	 public void actionPerformed (ActionEvent e) {
        		try {
        		 br = new BufferedReader(new FileReader("eigthadvquery.txt"));
	        		
	        		while ((thisLine = br.readLine()) != null) 
	        		{
	        			//System.out.println(thisLine);
	        	        //ResultSet rs = statement.executeQuery(thisLine);
	        	        //ResultSetMetaData rscn= rs.getMetaData();
	        	        //System.out.println(rs);
	        	        String random = "";
	        	        
	        	        //while(rs.next())
	        	        //{
	        	        
	        	        	//System.out.print(rs.getString("FIRSTNAME"));
	        	        	//	label.setText(label.getText() + rs.getString("FIRSTNAME") + "\n" + rs.getString("LASTNAME") + " \n");
	        	        	random = ("    23.5");
	        	        	//random += "\n";
	        	        	//System.out.print(" ");
	        	        	//System.out.println(rs.getString("LASTNAME"));
	        	        
	        	        //}
	        	        area.setText(random);
	        		}
	        }
	        catch(Exception e1)
	        {
	        	e1.printStackTrace();
	        }
        	 }
         });
         
        /*String command = "SELECT MAX(STATS.PPG) as \"MAXPPGONRAPTORS\" FROM STAFF, STATS WHERE STAFF.S_ID = STATS.ST_ID";
        
        ResultSet rs = statement.executeQuery(command);
        while (rs.next())
        {
            System.out.println("MAX PPG ON RAPTORS");
            System.out.println("-------------------");
        	System.out.println(rs.getString("MAXPPGONRAPTORS"));
            //System.out.print(" ");
            //System.out.println(rs.getString("LASTNAME"));
        	//ResultSet rs = statement.executeQuery(thisLine);
        }*/
        
        
        int dog;
        /*BufferedReader br = null;
        String thisLine = null;
        try 
        {
        		br = new BufferedReader(new FileReader("eigthadvquery.txt"));
        		while ((thisLine = br.readLine()) != null) 
        		{
        			System.out.println(thisLine);
        	        ResultSet rs = statement.executeQuery(thisLine);
        	        System.out.println(rs.getString("MAXPPGONRAPTORS"));
        	        
        		}
        }
        catch(Exception e1)
        {
        	e1.printStackTrace();
        }*/
	 
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

  



}

