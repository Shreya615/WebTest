package quiz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import feedback.Feedback;
import home.Home;
import registration.Regisform;
import start.Start;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Score extends JFrame {

	private JPanel contentPane;
	String name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Score frame = new Score("user", 0);
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
	public Score(String name, int score) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thankyou " + name + " for playing WebTech!");
		lblNewLabel.setFont(new Font("Viner Hand ITC", Font.BOLD, 22));
		lblNewLabel.setBackground(Color.PINK);
		lblNewLabel.setBounds(217, -11, 470, 84);
		contentPane.add(lblNewLabel);
		
		
		//String score;
		JLabel lblNewLabel_1 = new JLabel("YOUR SCORE IS "+score);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(414, 154, 255, 60);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\divya\\Downloads\\j7.png"));
		lblNewLabel_2.setBounds(-66, -23, 470, 505);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Play Again");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnNewButton)
					{
					setVisible(false);
					Start s= new Start();
					
					s.setVisible(true);
					}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(455, 274, 144, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Give your feedback");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnNewButton_1)
				{
					setVisible(false);
					Feedback f= new Feedback();
					f.setVisible(true);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(472, 413, 144, 30);
		contentPane.add(btnNewButton_1);
	}

	

}
