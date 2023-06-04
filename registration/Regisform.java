package registration;

import java.awt.EventQueue;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import admin.Admin;
import feedback.ViewFb;
import home.Home;
import login.LoginForm;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.Color;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Regisform extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textEmail;
	private JTextField textContact;
	private JTextArea textAddress;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rbMale;
	private JRadioButton rbFemale;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	private JComboBox textNation,textQual;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JPasswordField passwordField;
	//protected JLabel rbFemale;
	//protected AbstractButton rbMale;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Regisform frame = new Regisform();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public class EmailValid {
		public static boolean isValid(String email)
		  {
		    String emailformate="^[a-zA-Z0-9_+&*-]+(?:\\."+
		                                       "[a-zA-Z0-9_+&*-]+) *@" +
		                                       "(?:[a-zA-Z0-9-]-\\.)+[a-z" +
		                                       "A-Z]{2,7}$";
		   Pattern p=Pattern.compile(emailformate);
		   if(email==null)
		      return false;
		   return p.matcher(email).matches();
		 }
		}
	public Regisform() {
		setForeground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\divya\\Downloads\\j1.png"));
		setTitle("Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 646);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NAME");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(157, 236, 113, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(157, 267, 113, 14);
		contentPane.add(lblEmail);
		
		JLabel lblContactNo = new JLabel("CONTACT NO.");
		lblContactNo.setForeground(Color.WHITE);
		lblContactNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContactNo.setBounds(157, 298, 113, 14);
		contentPane.add(lblContactNo);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddress.setBounds(157, 336, 107, 14);
		contentPane.add(lblAddress);
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGender.setBounds(157, 399, 113, 14);
		contentPane.add(lblGender);
		
		JLabel lblQualification = new JLabel("QUALIFICATION");
		lblQualification.setForeground(Color.WHITE);
		lblQualification.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQualification.setBounds(157, 433, 133, 14);
		contentPane.add(lblQualification);
		
		JLabel lblNationality = new JLabel("NATIONALITY");
		lblNationality.setForeground(Color.WHITE);
		lblNationality.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNationality.setBounds(157, 464, 113, 14);
		contentPane.add(lblNationality);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(157, 496, 113, 14);
		contentPane.add(lblPassword);
		
		JLabel lblUserRegistration = new JLabel("ENTER YOUR DETAILS");
		lblUserRegistration.setForeground(Color.YELLOW);
		lblUserRegistration.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		lblUserRegistration.setBounds(244, 157, 282, 44);
		contentPane.add(lblUserRegistration);
		
		
		
		JButton btnValidate = new JButton("Register");
		btnValidate.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
		
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
					String query="insert into user_Tb values(?,?,?,?,?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setInt(1, Integer.parseInt(textField.getText()));
					ps.setString(2, textName.getText());
					ps.setString(3, textEmail.getText());
					ps.setInt(4, Integer.parseInt(textContact.getText()));
					ps.setString(5, textAddress.getText());
					if(rbMale.isSelected())
						ps.setString(6, rbMale.getText());
					else
						ps.setString(6, rbFemale.getText());
					String value1=textQual.getSelectedItem().toString();
					ps.setString(7, value1);
					String value=textNation.getSelectedItem().toString();
					ps.setString(8, value);
					//ps.setString(9, textPass.getText());
					ps.setString(9,passwordField.getText());
					int i=ps.executeUpdate();
					JOptionPane.showMessageDialog(btnValidate, i+ " Registration Successfully done!");
					
					
					
				    ps.close();
					con.close();
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnValidate.setForeground(Color.BLACK);
		btnValidate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnValidate.setBounds(282, 561, 89, 23);
		contentPane.add(btnValidate);
		
		textName = new JTextField();
		textName.setForeground(Color.BLACK);
		textName.setBounds(305, 235, 276, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setForeground(Color.BLACK);
		textEmail.setColumns(10);
		textEmail.setBounds(305, 266, 276, 20);
		contentPane.add(textEmail);
		
		textContact = new JTextField();
		textContact.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String phno=textContact.getText();
				int length=phno.length();
				char c=e.getKeyChar();
				if(e.getKeyChar()>='0' && e.getKeyChar()<='9')
				{
					if(length<10)
					{
						textContact.setEditable(true);
					}
					else
					{
						textContact.setEditable(false);
					}
				}
				else
				{
					if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode()==KeyEvent.VK_DELETE )
					{
						textContact.setEditable(true);
					}
					else
					{
						textContact.setEditable(false);
					}
				}
			}
		});
		textContact.setForeground(Color.BLACK);
		textContact.setColumns(10);
		textContact.setBounds(305, 297, 276, 20);
		contentPane.add(textContact);
		
		textAddress = new JTextArea();
		textAddress.setForeground(Color.BLACK);
		textAddress.setBounds(305, 333, 276, 56);
		contentPane.add(textAddress);
		
		rbMale = new JRadioButton("Male");
		buttonGroup_1.add(rbMale);
		rbMale.setBackground(Color.GRAY);
		rbMale.setForeground(Color.BLACK);
		rbMale.setFont(new Font("Tahoma", Font.BOLD, 13));
		rbMale.setBounds(331, 396, 109, 23);
		contentPane.add(rbMale);
		
		JLabel lblUserId = new JLabel("USER ID");
		lblUserId.setForeground(Color.WHITE);
		lblUserId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUserId.setBounds(157, 211, 113, 14);
		contentPane.add(lblUserId);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setColumns(10);
		textField.setBounds(305, 204, 276, 20);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\divya\\Downloads\\j9.png"));
		lblNewLabel_1.setBounds(193, -35, 530, 247);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnNewButton)
				{
					setVisible(false);
					LoginForm l= new LoginForm();
					l.setVisible(true);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(400, 561, 89, 23);
		contentPane.add(btnNewButton);
		
		rbFemale = new JRadioButton("Female");
		rbFemale.setForeground(Color.BLACK);
		buttonGroup_1.add(rbFemale);
		rbFemale.setFont(new Font("Tahoma", Font.BOLD, 13));
		rbFemale.setBackground(Color.GRAY);
		rbFemale.setBounds(491, 396, 109, 23);
		contentPane.add(rbFemale);
		
		JButton btnNewButton_1 = new JButton("Validate");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean check=EmailValid.isValid(textEmail.getText());
				if(check)
				{
					lblNewLabel_2.setText("Email is valid");
				}
				else
				{
					lblNewLabel_2.setText("Email is invalid");
				}
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID=textField.getText().toString();
				String name=textName.getText().toString();
				String email=textEmail.getText().toString();
				String contact=textContact.getText().toString();
				String addr=textAddress.getText().toString();
				String qual=textQual.getToolkit().toString();
				String nation=textNation.getToolkit().toString();
				String pass=passwordField.getText().toString();
				
				if(ID.equals(""))
				{
					JOptionPane.showMessageDialog(null, "ID is mandatory");
				}
				if(name.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Name is mandatory");
				}
				if(email.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Email is mandatory");
				}
				if(contact.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Contact is mandatory");
				}
				if(addr.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Address is mandatory");
				}
				if(qual.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Qualification is mandatory");
				}
				if(nation.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Nationality is mandatory");
				}
				if(pass.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Password is mandatory");
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBounds(157, 561, 89, 23);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(591, 267, 132, 23);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnNewButton_2)
				{
					setVisible(false);
					Home h= new Home();
					h.setVisible(true);
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBounds(529, 561, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Edit");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
					String value1= textField.getText();
					String value2= textName.getText();
					String value3= textEmail.getText();
					String value4= textContact.getText();
					String value5= textAddress.getText();
					String value6= (String)textQual.getSelectedItem();
					String value7= (String) textNation.getSelectedItem();
					
					String sql="update user_Tb set name= '"+value2+"' ,email= '"+value3+"' ,contact= '"+value4+"' ,address= '"+value5+"' ,qualification= '"+value6+"' ,nationality= '"+value7+"' where uid='"+value1+"' ";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.execute();
					JOptionPane.showMessageDialog(null, "Records Updated");
					
					
					
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		btnNewButton_3.setBounds(600, 203, 89, 23);
		contentPane.add(btnNewButton_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(305, 495, 276, 20);
		contentPane.add(passwordField);
		
		String[] colum = {"--Select--","India", "Australia", "Ëngland"};
		textNation = new JComboBox(colum);
		textNation.setBounds(305, 462, 276, 22);
		contentPane.add(textNation);
		
		String[] columm= {"--Select--","BCA", "MCA", "Student"};
		textQual = new JComboBox(columm);
		textQual.setBounds(305, 431, 276, 22);
		contentPane.add(textQual);
		
		/*JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Class.forName("com.mysql.cj.jdbc.Driver");
				//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
				int no=Integer.parseInt(textField.getText());
				String n=textName.getText();
				String query="update user_Tb set name='"+n+"' where uid="+no;
				//PreparedStatement ps=con.prepareStatement(query);
				int result=ps.executeUpdate(query);
				JOptionPane.showMessageDialog(btnNewButton_3, " done!");
			}
		});*/
		/*btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.setBounds(610, 204, 89, 30);
		contentPane.add(btnNewButton_3);*/
	}
}
