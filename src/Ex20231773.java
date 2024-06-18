import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex20231773 extends JFrame implements ActionListener {
    
    private JTextField num1, num2;
    private JLabel resultLabel;
    
    public Ex20231773() {
        setTitle("계산기");
        setSize(300, 250);
        
        // 제목 페널
        JPanel titlePanel = new JPanel();
        titlePanel.setBounds(0, 0, 300, 40);
        add(titlePanel);
        JLabel title = new JLabel("계산기", JLabel.CENTER);
        title.setFont(new Font("함초롬돋움", Font.BOLD, 20));
        titlePanel.add(title);
        
        // 숫자 페널
        JPanel numPanel = new JPanel();
        numPanel.setBounds(0, 40, 300, 40);
        numPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(numPanel);
        
        num1 = new JTextField(5);
        numPanel.add(num1);
        num2 = new JTextField(5);
        numPanel.add(num2);
        
        // 버튼 페널
        JPanel btnPanel = new JPanel();
        btnPanel.setBounds(100, 80, 100, 80);
        btnPanel.setLayout(new GridLayout(2, 2, 10, 5));
        add(btnPanel);
        
        JButton plus = new JButton("+");
        plus.addActionListener(this);
        btnPanel.add(plus);
        JButton minus = new JButton("-");
        minus.addActionListener(this);
        btnPanel.add(minus);
        JButton mult = new JButton("*");
        mult.addActionListener(this);
        btnPanel.add(mult);
        JButton div = new JButton("/");
        div.addActionListener(this);
        btnPanel.add(div);
        
        // 결과 페널
        JPanel resPanel = new JPanel();
        resPanel.setBounds(0, 160, 300, 40);
        add(resPanel);
        JLabel lbl1 = new JLabel("결과값: ");
        resPanel.add(lbl1);
        resultLabel = new JLabel("");
        resPanel.add(resultLabel);
        
        // 프레임 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        double number1 = Double.parseDouble(num1.getText());
        double number2 = Double.parseDouble(num2.getText());
        double result = 0.0;
        
        if (e.getActionCommand().equals("+")) {
            result = number1 + number2;
        } else if (e.getActionCommand().equals("-")) {
            result = number1 - number2;
        } else if (e.getActionCommand().equals("*")) {
            result = number1 * number2;
        } else if (e.getActionCommand().equals("/")) {
            if (number2 != 0) {
                result = number1 / number2;
            } else {
                JOptionPane.showMessageDialog(this, "나누는 수는 0이 될 수 없습니다.", "오류", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        resultLabel.setText(Double.toString(result));
    }
    
    public static void main(String[] args) {
        new Ex20231773();
    }
}