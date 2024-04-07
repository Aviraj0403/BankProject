package AviBank;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class BankBot extends JFrame implements ActionListener {
    JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;
    JLabel labelmsg;
    private String[] hello = {"hi", "is anyone there?", "hello", "good day", "hello there", "hey"};
    private String[] bye = {"see you later", "bye", "goodbye", "i am Leaving", "have a Good day"};
    private String[] howAre = {"how are you", "whats up", "how you doing?", "how are you?", "how you doing", "Whats up?"};
    private String[] botname = {"My name is Avi bot", "You can call me RBI bot", " Bot in your service", "My friends call HelpDesk"};
    private String[] bank = {"Laxmi chit fund", "info about this", "SBI", "RBI", "Reserve Bank of India", "BOI", "ShareHOlder"};
    String pin;
    mbank mbankFrame;
    BankBot bankBotFrame;

    public BankBot(String pin) {

        if (bankBotFrame!= null) {
            bankBotFrame.setVisible(false);
        }
        bankBotFrame = this;
        this.pin = pin;

        setTitle("Bank Bot");
        setLocation(350, 100);
        setSize(500, 500);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(0, 4, 84));
        p1.setBounds(0, 0, 500, 50);
        p1.setLayout(null);
        add(p1);

        JPanel p2 = new JPanel();
        p2.setBackground(Color.white);
        p2.setBounds(0, 50, 500, 450);
        p2.setLayout(null);
        add(p2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("AviBank/icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel back = new JLabel(i3);
        back.setBounds(5, 15, 25, 20);
        p1.add(back);

        back.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae) {
                setVisible(false);
             if(mbankFrame==null) {
                 mbank mbankFrame = new mbank(pin);
             }
              mbankFrame.setVisible(true);
            }
        });

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("AviBank/icons/lcf.jpeg"));
        Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel profile = new JLabel(i6);
        profile.setBounds(40, 10, 50, 50);
        p1.add(profile);

        inputField = new JTextField();
        inputField.setBounds(0, 380, 400, 30);
        p2.add(inputField);

        chatArea = new JTextArea();
        chatArea.setBounds(5, 55, 490, 320);
        chatArea.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        chatArea.setEditable(false);
        p2.add(chatArea);

        sendButton = new JButton("Send");
        sendButton.setBounds(400, 380, 80, 30);
        p2.add(sendButton);

        sendButton.addActionListener(this);
        inputField.addActionListener(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sendButton || e.getSource() == inputField) {
            sendMessage();
        }
    }

    private void sendMessage() {
        String userMessage = inputField.getText().toLowerCase();
        chatArea.append("You: " + userMessage + "\n");
        inputField.setText("");

        String response = generateResponse(userMessage.toLowerCase());
        chatArea.append("Bank Executive: " + response + "\n");
    }

    private String generateResponse(String userMessage) {
        if (contains(userMessage, hello)) {
            String[] botAnswers = {"Hello!", "hi", "hi there", "welcome"};
            return botAnswers[new Random().nextInt(botAnswers.length)];
        } else if (contains(userMessage, howAre)) {
            String[] botAnswers = {"I am fine, how can I help you?", "Happy, how can I help you?", "I am good, how can I help you?"};
            return botAnswers[new Random().nextInt(botAnswers.length)];
        } else if (contains(userMessage, botname)) {
            String[] botAnswers = {"My name is Avi 2.0", "You can call me Bank bot", "avi 2.0 in your service", "My friends call me HelpDesk"};
            return botAnswers[new Random().nextInt(botAnswers.length)];
        } else if (contains(userMessage, bye)) {
            String[] botAnswers = {"Sad to see you go :(", "Talk to you later", "Goodbye!", "Have a nice day"};
            return botAnswers[new Random().nextInt(botAnswers.length)];
        }
        else if (contains(userMessage, bank)) {
            return "Bot said - Go to: " + new mbank("");
        } else {
            return "Bot said - Sorry, I could not understand...";
        }
    }

    private boolean contains(String input, String[] array) {
        for (String item : array) {
            if (input.contains(item)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BankBot bankBotFrame=new BankBot("");
                bankBotFrame.setVisible(true);
            }
        });
    }
}
