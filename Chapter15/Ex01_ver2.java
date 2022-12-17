import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;

public class Ex01_ver2{
	public static void main(String[] args){
		new Frame();
	}
}

class Frame extends JFrame implements ActionListener{
	private JLabel label;
	private JButton button1;
	private JButton button2;
	private int cnt;

	public Frame(){
		cnt = 0;

		this.setTitle("Hello");
		this.setSize(400,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		label = new JLabel(String.valueOf(cnt));
		button1 = new JButton("+");
		button2 = new JButton("-");

		button1.addActionListener(this);
		button2.addActionListener(this);

		this.add(label); this.add(button1); this.add(button2);

		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		JButton b = (JButton)e.getSource();

		if (b == button1) cnt++;
		else if (cnt == 0) cnt = 0;
		else cnt--;

		label.setText(String.valueOf(cnt));
	}
}
