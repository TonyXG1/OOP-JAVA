package studentsProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StudentApllication extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Name1;
	private JTextField textField_Name2;
	private JTextField textField_Name3;
	private JTextField textField_EGN;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JPanel panel_Checker;
	private JPanel panel_2;
	private JLabel lblResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentApllication frame = new StudentApllication();
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
	public StudentApllication() {
		setResizable(false);
		setTitle("\u0423\u0447\u0435\u043D\u0438\u0447\u0435\u0441\u043A\u0430 \u043F\u0440\u043E\u0432\u0435\u0440\u043A\u0430");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 347);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 563, 190);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField_Name1 = new JTextField();
		textField_Name1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_Name1.setBounds(121, 29, 120, 29);
		panel.add(textField_Name1);
		textField_Name1.setColumns(10);
		
		textField_Name2 = new JTextField();
		textField_Name2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_Name2.setColumns(10);
		textField_Name2.setBounds(121, 140, 120, 29);
		panel.add(textField_Name2);
		
		textField_Name3 = new JTextField();
		textField_Name3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_Name3.setColumns(10);
		textField_Name3.setBounds(433, 29, 120, 29);
		panel.add(textField_Name3);
		
		textField_EGN = new JTextField();
		textField_EGN.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String s = textField_EGN.getText();
				EGN checkegn = new EGN(s);
				if(checkegn.isCorrect()) panel_Checker.setBackground(Color.GREEN);
				else panel_Checker.setBackground(Color.RED);
			}
		});

		textField_EGN.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_EGN.setColumns(10);
		textField_EGN.setBounds(433, 140, 120, 29);
		panel.add(textField_EGN);
		
		JLabel lblNewLabel = new JLabel("\u0418\u043C\u0435 :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(6, 29, 105, 29);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u041F\u0440\u0435\u0437\u0438\u043C\u0435 :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(6, 140, 105, 29);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("\u0424\u0430\u043C\u0438\u043B\u0438\u044F :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(318, 29, 105, 29);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("\u0415\u0413\u041D :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(318, 140, 70, 29);
		panel.add(lblNewLabel_3);
		
		panel_Checker = new JPanel();
		panel_Checker.setBackground(Color.RED);
		panel_Checker.setBounds(398, 140, 25, 29);
		panel.add(panel_Checker);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\u0418\u043D\u0444\u043E\u0440\u043C\u0430\u0446\u0438\u044F \u0437\u0430 \u0443\u0447\u0435\u043D\u0438\u043A", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(70, 130, 180)));
		panel_2.setBounds(10, 250, 563, 55);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		lblResult = new JLabel("");
		lblResult.setBounds(54, 22, 454, 22);
		panel_2.add(lblResult);
		
		JButton btn_Start = new JButton("\u0412\u044A\u0432\u0435\u0436\u0434\u0430\u043D\u0435");
		btn_Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name1 = textField_Name1.getText();
				String name2 = textField_Name2.getText();
				String name3 = textField_Name3.getText();
				String egn = textField_EGN.getText();
				EGN studentEGN = new EGN(egn);
				
				if(studentEGN.isCorrect()) {
					Student student = new Student(name1, name2, name3, egn);
					String result = student.toString();
					lblResult.setText(result);
				}
			}
		});
		btn_Start.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Start.setBounds(175, 212, 233, 27);
		contentPane.add(btn_Start);
	}
}
