package start;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import quiz.Quiz;
import registration.Regisform;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Start extends JFrame {

	private JPanel contentPane;
	JTextField textField;
	JButton rules,start;
	String name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
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
	public Start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 482);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\divya\\Downloads\\j3.jpg"));
		lblNewLabel.setBounds(10, -58, 225, 501);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("WebTest");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Viner Hand ITC", Font.BOLD, 54));
		lblNewLabel_1.setBounds(280, 35, 303, 74);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter your Name");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_2.setBounds(256, 161, 186, 82);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField.setForeground(new Color(0, 0, 0));
		textField.setBounds(464, 188, 153, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		rules = new JButton("Rules");
		rules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == rules)
				{
					String name= textField.getText();
					setVisible(false);
					new Rules(name);
				}
				
					
			}
		});
		rules.setFont(new Font("Times New Roman", Font.BOLD, 14));
		rules.setBounds(318, 263, 108, 33);
		contentPane.add(rules);
		
		start = new JButton("Start");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == start)
				{
					Quiz q= new Quiz(name);
					
					q.setVisible(true);
				}
			}
		});
		start.setFont(new Font("Times New Roman", Font.BOLD, 14));
		start.setBounds(513, 263, 104, 33);
		contentPane.add(start);
	}

}
