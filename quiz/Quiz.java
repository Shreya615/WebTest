package quiz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;

public class Quiz extends JFrame {
	JLabel lblNewLabel_1,lblNewLabel_2;
	JRadioButton rdbtnNewRadioButton,rdbtnNewRadioButton_1,rdbtnNewRadioButton_2,rdbtnNewRadioButton_3;
	JButton btnNewButton, btnNewButton_1, btnNewButton_2;
	ButtonGroup groupoptions;
	int secondsPassed=0;
	public static int timer=10;
	public static int ans_given=0;
	public static int count=0;
	public static int score =0;
	static String username;
	String questions[][] = new String[10][5];
	String answers[][] = new String[10][2];
	String useranswers[][] = new String[10][1];

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quiz frame = new Quiz(username);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */String name;
		public Quiz(String name){
		this.name = name;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 585);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\divya\\Downloads\\j4.png"));
		lblNewLabel.setBounds(0, -13, 724, 312);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(53, 312, 623, 20);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setBounds(99, 310, 615, 22);
		contentPane.add(lblNewLabel_2);
		
		questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";


        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";
		
		rdbtnNewRadioButton = new JRadioButton();
		rdbtnNewRadioButton.setBackground(Color.LIGHT_GRAY);
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnNewRadioButton.setBounds(100, 358, 319, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton();
		rdbtnNewRadioButton_1.setBackground(Color.LIGHT_GRAY);
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnNewRadioButton_1.setBounds(99, 403, 320, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton();
		rdbtnNewRadioButton_2.setBackground(Color.LIGHT_GRAY);
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnNewRadioButton_2.setBounds(99, 450, 333, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		rdbtnNewRadioButton_3 = new JRadioButton();
		rdbtnNewRadioButton_3.setBackground(Color.LIGHT_GRAY);
		buttonGroup.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnNewRadioButton_3.setBounds(100, 497, 342, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		groupoptions = new ButtonGroup();
		groupoptions.add(rdbtnNewRadioButton);
		groupoptions.add(rdbtnNewRadioButton_1);
		groupoptions.add(rdbtnNewRadioButton_2);
		groupoptions.add(rdbtnNewRadioButton_3);
		
		btnNewButton = new JButton("Next");
		btnNewButton.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == btnNewButton)
				{
					repaint();
					rdbtnNewRadioButton.setEnabled(true);
		    		rdbtnNewRadioButton_1.setEnabled(true);
		    		rdbtnNewRadioButton_2.setEnabled(true);
		    		rdbtnNewRadioButton_3.setEnabled(true);
					ans_given=1;
					if(groupoptions.getSelection() == null) {
		    			useranswers[count][0] = "";
		    		}
					else {
		    			useranswers[count][0] = groupoptions.getSelection().getActionCommand();
		    		}
					if (count ==8)
					{
						btnNewButton.setEnabled(false);
						btnNewButton_2.setEnabled(true);
					}

					count++;
					start(count);
				}
				
				
			}
		});
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBounds(479, 380, 131, 44);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("50-50 Lifeline");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnNewButton_1)
				{
					if(count == 2 || count == 4 || count == 6 || count == 8 || count == 9)
					{
						rdbtnNewRadioButton_1.setEnabled(false);
						rdbtnNewRadioButton_2.setEnabled(false);
					}
					else
					{
						rdbtnNewRadioButton.setEnabled(false);
						rdbtnNewRadioButton_3.setEnabled(false);
					}
					btnNewButton_1.setEnabled(false);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		btnNewButton_1.setForeground(new Color(0, 0, 255));
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setBounds(479, 435, 131, 44);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Submit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ans_given=1;
				if(groupoptions.getSelection() == null) {
	    			useranswers[count][0] = "";
	    		}
	    		else {
	    			useranswers[count][0] = groupoptions.getSelection().getActionCommand();
	    		}
    			for(int i=0;i<useranswers.length;i++)
    			{
    				if(useranswers[i][0].equals(answers[i][1]))
    				{
    					score += 10;
    				}
    				else {
    					score += 0;
    				}
    			}
    			setVisible(false);
    			Score s=new Score(name, score);
    			s.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		btnNewButton_2.setForeground(new Color(0, 0, 255));
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setBounds(479, 497, 131, 38);
		btnNewButton_2.setEnabled(false);
		contentPane.add(btnNewButton_2);
		
		start(count);
		
			
		}

		public void paint(Graphics g)
	    {
	    	super.paint(g);
	    	String time = "Time left " + timer + " seconds";
	    	g.setColor(Color.RED);
	    	g.setFont(new Font("Tahoma", Font.BOLD,16));
	    	if (timer > 0)
	    	{
	    		g.drawString(time, 480, 385);
	    	}
	    	else {
	    		g.drawString("Times up!!", 480, 385);
	    	}
	    	timer--;
	    	try {
	    		Thread.sleep(1000);
	    		repaint();
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    	if(ans_given == 1) {
	    		ans_given=0;
	    		timer=10;
	    	}
	    	else if(timer < 0){
	    		timer=10;
	    		rdbtnNewRadioButton.setEnabled(true);
	    		rdbtnNewRadioButton_1.setEnabled(true);
	    		rdbtnNewRadioButton_2.setEnabled(true);
	    		rdbtnNewRadioButton_3.setEnabled(true);
	    		if (count == 8)
				{
					btnNewButton.setEnabled(false);
					btnNewButton_2.setEnabled(true);
				}
	    		if(count == 9) {
	    			if(groupoptions.getSelection() == null) {
		    			useranswers[count][0] = "";
		    		}
		    		else {
		    			useranswers[count][0] = groupoptions.getSelection().getActionCommand();
		    		}
	    			for(int i=0;i<useranswers.length;i++)
	    			{
	    				if(useranswers[i][0].equals(answers[i][1]))
	    				{
	    					score += 10;
	    				}
	    				else {
	    					score += 0;
	    				}
	    			}
	    			setVisible(false);
	    			new Score(name, score);
	    		}
	    		else {
	    			
	    		if(groupoptions.getSelection() == null) {
	    			useranswers[count][0] = "";
	    		}
	    		else {
	    			useranswers[count][0] = groupoptions.getSelection().getActionCommand();
	    		}
	    		count++;
	    		start(count);
	    		}
	    	}
	    }
	    public void start(int count) {
		lblNewLabel_1.setText("" +(count + 1) + ".");
		lblNewLabel_2.setText(questions[count][0]);
		rdbtnNewRadioButton.setText(questions[count][1]);
		rdbtnNewRadioButton.setActionCommand(questions[count][1]);
		rdbtnNewRadioButton_1.setText(questions[count][2]);
		rdbtnNewRadioButton_1.setActionCommand(questions[count][2]);
		rdbtnNewRadioButton_2.setText(questions[count][3]);
		rdbtnNewRadioButton_2.setActionCommand(questions[count][3]);
		rdbtnNewRadioButton_3.setText(questions[count][4]);
		rdbtnNewRadioButton_3.setActionCommand(questions[count][4]);
		
		groupoptions.clearSelection();
        
	}
}
