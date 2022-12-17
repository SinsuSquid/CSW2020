import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Ex02{
	public static void main(String[] args){
		new Frame();
	}
}

class Frame extends JFrame{
	private JButton b1,b2,b3,b4,b5;
	private JLabel label;
	private int start,end;

	public Frame(){
		start = 1; end = 2;

		this.setTitle("Hello");
		this.setSize(250,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(2,1));

		JPanel pan1 = new JPanel();
		pan1.setLayout(new FlowLayout());
		label = new JLabel(start + " 부터 " + end + " 까지의 합은?");
		pan1.add(label);

		b1 = new JButton("시작값증가");
		b1.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if (start == end) start = start;
					else start++;
					setLabel();
				}
			}
		);
		b2 = new JButton("시작값감소");
		b2.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if (start == 1) start = 1;
					else start--;
					setLabel();
				}
			}
		);
		b3 = new JButton("끝값증가");
		b3.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					end++;
					setLabel();
				}
			}
		);
		b4 = new JButton("끝값감소");
		b4.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if (start == end) end = start;
					else end--;
					setLabel();
				}
			}
		);
		b5 = new JButton("계산");
		b5.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					int sum = 0;
					for (int i = start; i <= end; i++) sum += i;
					label.setText(start + " 부터 " + end + " 까지의 합은: " + sum);
				}
			}
		);

		JPanel pan2 = new JPanel();
		pan2.setLayout(new FlowLayout());
		pan2.add(b1); pan2.add(b2); pan2.add(b3); pan2.add(b4); pan2.add(b5);

		this.add(pan1);
		this.add(pan2);

		this.setResizable(false);
		this.setVisible(true);
	}

	private void setLabel(){
		label.setText(start + " 부터 " + end + " 까지의 합은?");
	}
}
