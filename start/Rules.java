package start;
import javax.swing.*;

import quiz.Quiz;
import registration.Regisform;

import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame{
	String name;
	JButton start;
	Rules(String name){
		this.name=name;
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		JLabel lblNewLabel_1 = new JLabel("Welcome " + name + " to WebTech Quiz!");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Viner Hand ITC", Font.BOLD, 32));
		lblNewLabel_1.setBounds(50,20,700,30);
		add(lblNewLabel_1);
		
		JLabel rules = new JLabel();
		rules.setForeground(Color.BLACK);
		rules.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		rules.setText(
	            "<html>"+ 
	                "1. You are trained to be a programmer and not a story teller, answer point to point" + "<br><br>" +
	                "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer" + "<br><br>" +
	                "3. You may have lot of options in life but here all the questions are compulsory" + "<br><br>" +
	                "4. Crying is allowed but please do so quietly." + "<br><br>" +
	                "5. Only a fool asks and a wise answers (Be wise, not otherwise)" + "<br><br>" +
	                "6. Do not get nervous if your friend is answering more questions, may be he/she is doing Jai Mata Di" + "<br><br>" +
	                "7. Brace yourself, this paper is not for the faint hearted" + "<br><br>" +
	                "8. May you know more than what John Snow knows, Good Luck" + "<br><br>" +
	            "<html>"
	);
		
		rules.setBounds(20,90,700,350);
		add(rules);
		
		setSize(800,650);
		setLocation(350,100);
		setVisible(true);
		
		start = new JButton("Start");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == start)
				{
					setVisible(false);
					Quiz q = new Quiz(name);
					q.setVisible(true);
				}
			}
		});
		start.setFont(new Font("Times New Roman", Font.BOLD, 14));
		start.setBounds(300, 500, 100, 30);
		add(start);
		
	}
	public static void main(String args[])
	{
		new Rules("user");
	}

}
