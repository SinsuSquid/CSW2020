import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Exam4{
	public static void main(String[] args){
		new Frame();
	}
}

class Frame extends JFrame{
	private JButton b1,b2;
	private JLabel l1,l2;
	private double startT, endT;

	public Frame(){
		this.setSize(300,300);
		this.setLayout(new FlowLayout());
		this.setTitle("StopWatch");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		l1 = new JLabel("Stop Watch");
		this.add(l1);

		b1 = new JButton("Start");
		b1.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					startT = System.currentTimeMillis();
					l1.setText("0.000");
					l2.setText("");
				}
			}
		);
		this.add(b1);

		b2 = new JButton("Stop");
		b2.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if (startT == 0.0) return;
					endT = System.currentTimeMillis();
					double lapT = (endT - startT)/(double)1000;
					l1.setText(String.valueOf(lapT));
					String temp = l2.getText();
					l2.setText(temp + " [" + lapT + "]");
				}
			}
		);
		this.add(b2);

		l2 = new JLabel("");
		this.add(l2);

		this.setVisible(true);
	}
}
