import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class quiz implements ActionListener{
    String questions [] = {
            "Which company created Java?",
            "Which year was Java created?",
            "What was Java originally called?",
            "Who is the father of Java?",
            "Which keyword is used to inherit a class in Java?",
            "Which of these is not a Java feature?",
            "Which method is the entry point of a Java program?",
            "Which package contains the Scanner class?",
            "Which symbol is used to end a statement in Java?",
            "Which collection class does not allow duplicates?",
            "Which operator is used for multiplication in Java?",
            "Which of these is a valid access modifier?",
            "What is the default value of int in Java?",
            "Which keyword is used to stop a loop?",
            "Which method is used to start a thread in Java?"
    };

    String options [][] = {
            {"Sun Microsystems","Microsoft","Google","Meta"},
            {"1989","1994","1996","1972"},
            {"Apple","Oak","Koffing","JavaScript"},
            {"Steve Jobs","Bill Gates","James Gosling","James Cameron"},
            {"extends","implements","inherit","using"},
            {"Object-oriented","Platform Independent","Pointers","Robust"},
            {"start()","main()","run()","program()"},
            {"java.io","java.util","java.lang","java.net"},
            {"?",";",":","."},
            {"ArrayList","HashSet","LinkedList","Vector"},
            {"x","*","%","/"},
            {"public","package","include","default"},
            {"0","1","null","undefined"},
            {"exit","end","stop","break"},
            {"start()","run()","execute()","begin()"}
    };
    char answers[]= {
            'A',
            'B',
            'B',
            'C',
            'A',
            'C',
            'B',
            'B',
            'B',
            'B',
            'B',
            'A',
            'A',
            'D',
            'A'
    };

    char guess;
    int answer;
    int index;
    int correct_guesses;
    int total_questions = questions.length;
    int result;
    int seconds=10;

    JFrame frame = new JFrame();
    JTextField textfield =new JTextField(); //hold the current question we are on
    JTextArea textarea = new JTextArea();//hold the current question
    JButton buttonA= new JButton();
    JButton buttonB= new JButton();
    JButton buttonC= new JButton();
    JButton buttonD= new JButton();
    JLabel answerA = new JLabel();
    JLabel answerB = new JLabel();
    JLabel answerC = new JLabel();
    JLabel answerD = new JLabel();
    JLabel time =new JLabel();
    JLabel seconds_left =new JLabel();
    JTextField number_right =new JTextField();
    JTextField percentage = new JTextField();

    Timer timer =new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            seconds_left.setText(String.valueOf(seconds));
            if(seconds<=0){
                displayAnswer();
            }
        }
    });

    quiz(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650,650);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(null);
        frame.setResizable(false);
        textfield.setBounds(0,0,650,50);
        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("MV Boli",Font.BOLD,30));
        textfield.setEditable(false);
        textfield.setBorder(BorderFactory.createBevelBorder(1));


        textarea.setBounds(0,50,650,50);
        textarea.setLineWrap(true);
        textarea.setBackground(new Color(25,25,25));
        textarea.setForeground(new Color(25,255,0));
        textarea.setFont(new Font("MV Boli",Font.BOLD,25));
        textarea.setBorder(BorderFactory.createBevelBorder(1));
        textarea.setEditable(false);
        ;

        buttonA.setBounds(0,100,100,100);
        buttonA.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonA.addActionListener(this);
        buttonA.setFocusable(false);
        buttonA.setText("A");

        buttonB.setBounds(0,200,100,100);
        buttonB.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonB.addActionListener(this);
        buttonB.setFocusable(false);
        buttonB.setText("B");

        buttonC.setBounds(0,300,100,100);
        buttonC.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonC.addActionListener(this);
        buttonC.setFocusable(false);
        buttonC.setText("C");

        buttonD.setBounds(0,400,100,100);
        buttonD.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonD.addActionListener(this);
        buttonD.setFocusable(false);
        buttonD.setText("D");

        answerA.setBounds(125,100,500,100);
        answerA.setBackground(new Color(50,50,50));
        answerA.setForeground(new Color(25,255,0));
        answerA.setFont(new Font("MV Boli",Font.PLAIN,35));


        answerB.setBounds(125,200,500,100);
        answerB.setBackground(new Color(50,50,50));
        answerB.setForeground(new Color(25,255,0));
        answerB.setFont(new Font("MV Boli",Font.PLAIN,35));

        answerC.setBounds(125,300,500,100);
        answerC.setBackground(new Color(50,50,50));
        answerC.setForeground(new Color(25,255,0));
        answerC.setFont(new Font("MV Boli",Font.PLAIN,35));


        answerD.setBounds(125,400,500,100);
        answerD.setBackground(new Color(50,50,50));
        answerD.setForeground(new Color(25,255,0));
        answerD.setFont(new Font("MV Boli",Font.PLAIN,35));
        seconds_left.setBounds(535,510,100,100);
        seconds_left.setBackground(new Color(25,25,25));
        seconds_left.setForeground(new Color(255,0,0));
        seconds_left.setFont(new Font("Ink Free", Font.BOLD,60));
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true);
        seconds_left.setText(String.valueOf(seconds));

        number_right.setBounds(225,225,200,100);
        number_right.setBackground(new Color(25,25,25));
        number_right.setForeground(new Color(25,255,0));
        number_right.setFont(new Font("Ink Free",Font.BOLD,50));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setEditable(false);

        percentage.setBounds(225,325,200,100);
        percentage.setBackground(new Color(25,25,25));
        percentage.setForeground(new Color(25,225,0));
        percentage.setFont(new Font("Ink Free",Font.BOLD,50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setEditable(false);

        frame.add(seconds_left);
        frame.add(answerA);
        frame.add(answerB);
        frame.add(answerC);
        frame.add(answerD);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(textfield);
        frame.add(textarea);

        frame.setVisible(true);
        nextQuestion();

    }
    public void nextQuestion(){//button for nextQuestion
        if(index>=total_questions){
            results();
        }else{
            textfield.setText("Question "+(index+1));
            textarea.setText(questions[index]);
            answerA.setText(options[index][0]);
            answerB.setText(options[index][1]);
            answerC.setText(options[index][2]);
            answerD.setText(options[index][3]);
            timer.start();
        }

    }
    public void actionPerformed(ActionEvent e){//method for any type of action performed
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(e.getSource()==buttonA){
            answer ='A';
            if(answer==answers[index]){
                correct_guesses++;
            }
        }
        if(e.getSource()==buttonB){
            answer ='B';
            if(answer==answers[index]){
                correct_guesses++;
            }
        }
        if(e.getSource()==buttonC){
            answer ='C';
            if(answer==answers[index]){
                correct_guesses++;
            }
        }
        if(e.getSource()==buttonD){
            answer ='D';
            if(answer==answers[index]){
                correct_guesses++;
            }
        }
        displayAnswer();

    }
    public void displayAnswer(){
        timer.stop();
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        if(answers[index]!='A'){
            answerA.setForeground(new Color(255,0,0));
        }
        if(answers[index]!='B'){
            answerB.setForeground(new Color(255,0,0));
        }
        if(answers[index]!='C'){
            answerC.setForeground(new Color(255,0,0));
        }
        if(answers[index]!='D'){
            answerD.setForeground(new Color(255,0,0));
        }
        Timer T = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerA.setForeground(new Color(25,255,0));
                answerB.setForeground(new Color(25,255,0));
                answerC.setForeground(new Color(25,255,0));
                answerD.setForeground(new Color(25,255,0));
                answer=' ';
                seconds=10;
                seconds_left.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();

            }
        });

        T.setRepeats(false);
        T.start();

    }
    public void results(){
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        result= (int)((correct_guesses/(double)total_questions)*100);

        textfield.setText("Results!!");
        textarea.setText("");
        answerA.setText("");
        answerB.setText("");
        answerC.setText("");
        answerD.setText("");
        System.out.println(correct_guesses);
        number_right.setText("("+correct_guesses+"/"+total_questions+")");
        percentage.setText(result+"%");

        frame.add(percentage);
        frame.add(number_right);

    }
}
public class project
{
    public static void main(String[] args) {
        quiz q= new quiz();
    }
}