package com.arbank.Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

// Your Swing Login class
public class Login5 extends JFrame implements ActionListener {
	// Swing components
	private JLabel l1, l2, l3, l4;
	private JTextField tf1, otpField;
	private JPasswordField pf2;
	private JButton b1, b2, b3;

	// Inject JavaMailSender for email sending
	@Autowired
	private JavaMailSender javaMailSender;

	// Constructor
	public Login5() {
		// Frame setup
		setTitle("Welcome to the ATM");
		// ... (other frame settings)

		// OTP Label
		l4 = new JLabel("OTP:");
		l4.setFont(new Font("Raleway", Font.BOLD, 28));
		l4.setForeground(Color.WHITE);
		l4.setBounds(125, 290, 375, 30);
		add(l4);

		// OTP TextField
		otpField = new JTextField(15);
		otpField.setBounds(300, 290, 230, 30);
		otpField.setFont(new Font("Arial", Font.BOLD, 14));
		add(otpField);

		// Sign-In Button
		b1 = new JButton("SIGN IN");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Arial", Font.BOLD, 14));
		b1.setBounds(300, 350, 100, 30);
		b1.addActionListener(this);
		add(b1);
	}

	// Action event handler
	public void actionPerformed(ActionEvent ae) {
		try {
			if (ae.getSource() == b1) {
				// Generate OTP
				String otp = generateOTP();

				// Send OTP via email
				sendOTPByEmail(otp);

				// Check if entered OTP matches
				String enteredOTP = otpField.getText();

				if (enteredOTP.equals(otp)) {
					// OTP is valid, proceed with login
					Connection connection = YourDatabaseConnectionClass.getConnection();
					Statement statement = connection.createStatement();
					String cardno = tf1.getText();
					String pin = pf2.getText();
					String query = "SELECT * FROM login WHERE cardno = '" + cardno + "' AND pin = '" + pin + "'";

					ResultSet resultSet = statement.executeQuery(query);
					if (resultSet.next()) {
						setVisible(false);
						new Transactions(pin).setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
					}
					resultSet.close();
					statement.close();
					connection.close();
				} else {
					JOptionPane.showMessageDialog(null, "Incorrect OTP");
				}
			}
			// ... (other actions)
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String generateOTP() {
		// Generate a random OTP here
		Random random = new Random();
		int otpValue = 100000 + random.nextInt(900000);
		return String.valueOf(otpValue);
	}

	private void sendOTPByEmail(String otp) {
		try {
			// Create and send an email with the OTP
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo("user@example.com"); // Replace with the user's email address
			message.setSubject("OTP for Login");
			message.setText("Your OTP for login is: " + otp);

			javaMailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Login5().setVisible(true);
	}
}

