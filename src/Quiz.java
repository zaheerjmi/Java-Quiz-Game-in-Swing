import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class Quiz implements ActionListener{ //The Java ActionListener (interface) is notified whenever you click on the button or menu item.It consists of only one method.It has only one method: actionPerformed().
	String []questions= {
			             
	                     "Which company created Java?",
	                     "Which year was Java created?",
	                     "What was Java originally called?",
	                     "Who is crdited with creating Java?",
	                     "Multiple Inheritance achieved in Java?",
	                     "private access modifiers can be accessed in Java?",
	                     "Which programming language mostly used for ML?",
	                     "Encapsulation data member should be?",
	                     "What is String?",
	                     "Abstraction achieved by abstract class?"
	                    
	                     
			
	};
	String[][] options= {
			             
			            {"Sun Microsystems","Starbucks","Microsoft","Alphabet"},
			            {"1996","1999","1995","1998"},
			            {"Apple","Oak","Latte","Koffing"},
			            {"Games Gosling","Bill Gates","Steve Jobs","Mark Zukerburg"},
			            {"Interface","Abstract Class","Inheritance","Encapsulation"},
			            {"outside subclass","outside the class","with in the class","outside package"},
			            {"Javascript","Java","Python","C++"},
			            {"private","public","static","default"},
			            {"mutable class","abstract class","non abstract class","immutable class"},
			            {"100%","0 to 100%","50%","90%"}
			            
			            
	
			
	};
	char[] answers= {
			         
			         'A',
			         'C',
			         'B',
			         'A',
			         'A',
			         'C',
			         'C',
			         'A',
			         'D',
			         'B'
	                     
			};
	char guess;
	char answer;
	int index;
	int correct_guesses;
	int total_questions=questions.length;
	int result;
	int seconds=10;
	JFrame frame=new JFrame();
	JTextField textfield=new JTextField();
	JTextArea textarea=new JTextArea();
	JButton buttonA=new JButton();
	JButton buttonB=new JButton();
	JButton buttonC=new JButton();
	JButton buttonD=new JButton();
	
	JLabel answer_labelA=new JLabel();
	JLabel answer_labelB=new JLabel();
	JLabel answer_labelC=new JLabel();
	JLabel answer_labelD=new JLabel();
	JLabel time_label=new JLabel();
	JLabel second_left=new JLabel();
	JTextField number_right= new JTextField();
	JTextField percentage=new JTextField();
	
	Timer pause=new Timer(2000, new ActionListener() {
		
		
		@Override
		
	public void actionPerformed(ActionEvent e) { // Clicking on the registered component automatically calls the actionPerformed() method. When you click a button or menu item.
			seconds--;
			second_left.setText(String.valueOf(seconds));
			if(seconds<=0) {
				displayAnswer();
			}
	
		}
	});

	public Quiz() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Setting minimum size limit for a window in java swing.
		frame.setSize(650,650);
		frame.getContentPane().setBackground(new Color(50,50,50)); // The Java Swing GUI utilizes a content pane (getContentPane)to hold objects.
		frame.setLayout(null);
		frame.setResizable(false);
		textfield.setBounds(0,0,650,50); //The setBounds() method is used in such a situation to set the position and size.
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("Ink Free",Font.BOLD,30));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER); // set Horizontal Alignment for JLabel to CENTER.
		textfield.setEditable(false); // The setEditable() method has one Boolean parameter. If the parameter is false, then the user cannot type into the field.
		frame.add(textfield);
		frame.setVisible(true); // SetVisible() - if you set it true ,it means you want that thing to be visible in your screen . 
		
		
		textarea.setBounds(0,50,650,50);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(new Color(25,25,25));
		textarea.setForeground(new Color(25,255,0));
		textarea.setFont(new Font("MV Boli",Font.BOLD,25));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);
		
		buttonA.setBounds(0,100,100,100);
		buttonA.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("A");
		
		buttonB.setBounds(0,200,100,100);
		buttonB.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonB.setFocusable(false); // setFocusable(false) simply says that the component cannot have focus (ie. it cannot be the target of keyboard events).
		buttonB.addActionListener(this);
		buttonB.setText("B");
		
		buttonC.setBounds(0,300,100,100);
		buttonC.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("C");
		
		buttonD.setBounds(0,400,100,100);
		buttonD.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("D");
		
		answer_labelA.setBounds(125,100,500,100);
		answer_labelA.setBackground(new Color(50,50,50));
		answer_labelA.setForeground(new Color(25,255,0));
		answer_labelA.setFont(new Font("MV Boli",Font.PLAIN,35));
		
		answer_labelB.setBounds(125,200,500,100);
		answer_labelB.setBackground(new Color(50,50,50));
		answer_labelB.setForeground(new Color(25,255,0));
		answer_labelB.setFont(new Font("MV Boli",Font.PLAIN,35));
		
		answer_labelC.setBounds(125,300,500,100);
		answer_labelC.setBackground(new Color(50,50,50));
		answer_labelC.setForeground(new Color(25,255,0));
		answer_labelC.setFont(new Font("MV Boli",Font.PLAIN,35));
		
		answer_labelD.setBounds(125,400,500,100);
		answer_labelD.setBackground(new Color(50,50,50));
		answer_labelD.setForeground(new Color(25,255,0));
		answer_labelD.setFont(new Font("MV Boli",Font.PLAIN,35));
		second_left.setBounds(535,510,100,100);
		second_left.setBackground(new Color(25,25,25));
		second_left.setForeground(new Color(255,0,0));
		second_left.setFont(new Font("Ink Free",Font.BOLD,65));
		second_left.setBorder(BorderFactory.createBevelBorder(1));
		second_left.setOpaque(true); // If a component is opaque, it's obligated to paint its background completely.
		second_left.setHorizontalAlignment(JTextField.CENTER);
		second_left.setText(String.valueOf(seconds));
		
		time_label.setBounds(535,475,100,25);
		time_label.setBackground(new Color(50,50,50));
		time_label.setForeground(new Color(255,0,0));
		time_label.setFont(new Font("MV Boli",Font.PLAIN,16));
		time_label.setHorizontalAlignment(JTextField.CENTER);
		time_label.setText("timer >:D");
		
		number_right.setBounds(225,225,200,100);
		number_right.setBackground(new Color(25,25,25));
		number_right.setForeground(new Color(25,255,0));
		number_right.setFont(new Font("Ink Free",Font.BOLD,50));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setEditable(false);
		
		percentage.setBounds(225,325,200,100);
		percentage.setBackground(new Color(25,25,25));
		percentage.setForeground(new Color(25,255,0));
		percentage.setFont(new Font("Ink Free",Font.BOLD,50));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setEditable(false);
		
		
		//frame.add(number_right);
	    //frame.add(percentage);
		frame.add(time_label);
		frame.add(second_left);
		frame.add(answer_labelA);
		frame.add(answer_labelB);
		frame.add(answer_labelC);
		frame.add(answer_labelD);
		
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(buttonD);
		frame.add(textarea);
		frame.add(textfield);
		frame.setVisible(true);
	
		nextQuestion();
		}
	public void nextQuestion() {
		if(index>=total_questions) {
			results();
		}
		else {
			textfield.setText("Question "+(index+1));
			textarea.setText(questions[index]);
			answer_labelA.setText(options[index][0]);
			answer_labelB.setText(options[index][1]);
			answer_labelC.setText(options[index][2]);
			answer_labelD.setText(options[index][3]);
			pause.start();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(e.getSource()==buttonA) { // The getSource() method is used in the actionPerformed method to determine which button was clicked.
			answer='A';
			if(answer==answers[index]) {
				correct_guesses++;
				
			}
			
		}
		if(e.getSource()==buttonB) {
			answer='B';
			if(answer==answers[index]) {
				correct_guesses++;
				
			}
	}
		if(e.getSource()==buttonC) {
			answer='C';
			if(answer==answers[index]) {
				correct_guesses++;
			}
			}
		if(e.getSource()==buttonD) {
			answer='D';
			if(answer==answers[index]) {
				correct_guesses++;
				
		}
			}
		displayAnswer();
		}
	public void displayAnswer() {
	    pause.stop();
	    buttonA.setEnabled(false); // setEnabled(false) disables the button and bttn.
	    buttonB.setEnabled(false);
	    buttonC.setEnabled(false);
	    buttonD.setEnabled(false);
	    
	    
	    if (answers[index] != 'A') {
	        answer_labelA.setForeground(new Color(255, 0, 0));
	    }
	    
	    if (answers[index] != 'B') {
	        answer_labelB.setForeground(new Color(255, 0, 0));
	    }
	    
	    if (answers[index] != 'C') {
	        answer_labelC.setForeground(new Color(255, 0, 0));
	    }
	    
	    if (answers[index] != 'D') {
	        answer_labelD.setForeground(new Color(255, 0, 0));
	    }
	    

	    Timer pause = new Timer(2000, new ActionListener() {
	    	
	    	
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            answer_labelA.setForeground(new Color(25, 255, 0));
	            answer_labelB.setForeground(new Color(25, 255, 0));
	            answer_labelC.setForeground(new Color(25, 255, 0));
	            answer_labelD.setForeground(new Color(25, 255, 0));

	            
	            answer = ' ';
	            seconds = 10;

	            second_left.setText(String.valueOf(seconds));
	            buttonA.setEnabled(true);
	            buttonB.setEnabled(true);
	            buttonC.setEnabled(true);
	            buttonD.setEnabled(true);
	            index++;
	            nextQuestion();
	        }
	    });
	    pause.start();
	    pause.setRepeats(false); // setRepeats. If flag is false , instructs the Timer to send only one action event to its listeners.
	}

	public void results() {
	    buttonA.setEnabled(true);
		buttonB.setEnabled(true);
		buttonC.setEnabled(true);
		buttonD.setEnabled(true);
		
		result= (int)((correct_guesses/(double)total_questions)*100);
		textfield.setText("RESULTS!");
		textarea.setText("");
		answer_labelA.setText("");
		answer_labelB.setText("");
		answer_labelC.setText("");
		answer_labelD.setText(""); 
		number_right.setText("("+correct_guesses+"/"+total_questions+")");
		percentage.setText(result+"%");
		frame.add(number_right);
		frame.add(percentage);
		
}
}
