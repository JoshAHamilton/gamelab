import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

public class GameGUI extends JFrame implements KeyListener{
	
	private JTextArea textArea;
	private JTextField inputBox;
	
	public void print(String s) {
		textArea.append(s+"\n\n");
	}
	
	public GameGUI() {
		setTitle("Text Game");
		setSize(755, 510);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		textArea = new JTextArea();
		textArea.setFont(new Font(null, Font.PLAIN, 26));
		textArea.setRows(15);
		textArea.setColumns(30);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		DefaultCaret caret = (DefaultCaret) textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		JScrollPane scroll = new JScrollPane(textArea);
		add(scroll);
		
		inputBox = new JTextField();
		inputBox.setFont(new Font(null, Font.PLAIN, 26));
		inputBox.addKeyListener(this);
		add(inputBox, BorderLayout.SOUTH);
		
		
		setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar() == '\n') {
			print(inputBox.getText());
			inputBox.setText("");
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
