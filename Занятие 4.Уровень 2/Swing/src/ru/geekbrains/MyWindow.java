package ru.geekbrains;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {

    private JTextField jTextField;

    public MyWindow() {
        setTitle("My window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 2));
        JButton jButton = new JButton("Ввод");
        bottomPanel.add(jButton);
        jTextField = new JTextField();
        bottomPanel.add(jTextField);

        JPanel centerPanel = new JPanel(new BorderLayout());
        JTextArea jTextArea = new JTextArea();
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        centerPanel.add(jScrollPane);

        jTextField.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!jTextField.getText().equals("")) {
                    jTextArea.append(jTextField.getText() + System.lineSeparator());
                    jTextField.setText("");
                }
            }
        }); // через Enter поле

        jButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!jTextField.getText().equals("")) {
                    jTextArea.append(jTextField.getText() + System.lineSeparator());
                    jTextField.setText("");
                }
            }
        }); //через кнопку поле

        add(bottomPanel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public JTextField getjTextField() {
        return jTextField;
    }

    public void setjTextField(JTextField jTextField) {
        this.jTextField = jTextField;
    }
}
