import	  java.sql.*;
import  java, swing.*;
import  java.awt.event.*;
import  java, awt.*;
class Address_Book extends JFrame implements ActionListener
(
	JLabel 11,12,12;
	JButton b1,b2,b3,b4,b5,b6;
	JTextField tf1,tf2,tf3;
	Static Connection con ;
	Static PreparedStatement pst = null;
	Static Statement st = null;
	JTextArea tal;
	
	Address_Book ()
		tal = new JTextArea(20,20);
		11 = new JLabel (”Roll”);
		12 = new JLabel (“Name”);
		13 = new JLabel (College”);
	tf1 = new JTextField (20);
	tf2 = new JTextField (20);
	tf3 = new JTextField (20);
	b1 = new JButton (“INSERT”);
	b2 = new JButton (“UPDATE”);
	b3 = new JButton (“DELETE”);
	b4 = new JButton (“MODIFY”);
	b5 = new JButton (“CLEAR”);
	b6 = new JButton ((“SHOW”);
	
	setLayout (null);
	setVisible (true);
	setSize (300,300);
	setTitle(“Address Book ”);
	this . setDefaultCloseOperation (EXIT_ON_CLOSE);
	
	11 . setBounds (30,30,50,20);
	12 . setBounds (30,60,50,20);
	13 . setBounds (30,90,50,20);

	tf1 . setBounds (90,30,100,20);
	tf2 . setBounds (90,60,100,20);
	tf3 . setBounds (90,90,100,20);

	b1. setBounds (30,120,90,20);
	b2 . setBounds (125,120,90,20);
	b3 . setBounds (30,150,90,20);
	b4 . setBounds (125,150,90,20);
	b5 . setBounds(220,30,300,200);
	b6 . setBounds(125,180,90,20);
	tal  .setBounds(220,30,300,200);

	add(11);		add(12); 	add913);
	add(tf1);		add(tf2);	add(tf3);
	add(b1);		add(b2);	add(b3);
	add(b4);	     add(b5);   add(b3);
	add(tal);

	b1  .  addActionListener(this);
	b2  .  addActionListener(this);
	b3  .  addActionListener(this);
	b4  .  addActionListener(this);
	b5  .  addActionListener(this);
	b6  .  addActionListener(this);
)
public void actionPerformed(ActionEvent  ae)
( 
      try
      (
	Con = getMyConnection  ();
	If (con == null)
	(
			System.out.printin (“Not connection)
			with DB server”);
			System.exit (0);
	)
	if  (ae  .  getSource   ()  == b1)
	(
			String query = “Insert into student
			Values (?,?,?)”;
			In toll = Integer    .parseInt (tf1) .
			getText() );
			String name = tf2 . getText();
			String college = tf3 . getText ();
			pst = con  . prepareStatement(query);
			pst  . setInt (1,roll);
			pst  . setString(2,name);
			pst  . setString(3,college);
			pst  .executeUpdate();

	if  (ae  .  getSource  ()  == b2)
	(
			String query = “update student set
			name=?, College=?
			where roll=?;”;
			int roll = Integer  .parseInt (tf1.getText () );
			String name =  tf2  .getText ();
			String College = tf3  .getText ();
			pst  = con   .   prepareStatement (query);
			pst   .  setInt (3,roll);
			pst   .  setString(1, name);
			pst   .  setString(2, college);
			pst   .  executeUpdate();

	)
	if  (ae   .   getSource  ()  == b3)
	(
			String query =  “delete from student
			where roll =?;”;
			int roll =  Integer   .parseInt (tf1).
			get Text () );
			pst  = con  .  prepareStatement (query);
			pst  .  setInt (1,roll);
			pst  .  executeUpdate ();
	)
	if  (ae  .   getSource   ()  ==b4)
	(
			String query = “alter table student modify
			(name varchar2 (30) );”;
			st   =  con.createStatement ();
			st   .   executeUpdate (query);
	)
	If   (ae   .   getSource  ()  ==b6
	(
			String query =  “select   *  from student  “;
			pst   =  con   .  prepareStatement (query);
			ResultSet  rs  = pst   .executeQuery  ();
			tal   .   append
			(“Roll\tNAME\Tcollege\n - - - - - - - - - - - - - - - - -\n”);
			while  (rs  .next ();
			(
				int roll =  rs.getInt(1);
				String name = rs   .   getString(2);
				String college =  rs   . getSring (3);
				tal   .   append(roll+”\t”+name+”\
				t”+college+”\n””);
			)
	      )
	)
	catch   (Exception  e  )
	(
		    e.printStackTrace ();
	(
		    try

		    (
			con   . close();
		    )
		    catch   (Exception  e)
		    (
			e.printStackTrace ();
		    )
            )
 )
public  static Connection getMyConnection ()
(
     	try 
	(
		Class.forName(“oracle.jdbc.OracleDriver”);
		Con  =  DriverManager.getConnection
		(“jdbc:oracle:thin:@localhost:1521:
		xe”, “system”, “1it”);
	)
	Catch  (Exception  e)
	(
		e.printStackTrace ();
	)
	finally
	(
		teturn  con;
	)
)
public  static void main (string[ ] agrs) throws Exception
(
		new Address_Book ();
     	)
)
