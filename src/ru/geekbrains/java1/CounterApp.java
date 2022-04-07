package ru.geekbrains.java1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterApp extends JFrame {
    private int counter = 0;

    public CounterApp() {
        setLayout(null);
        setResizable(false);
        setTitle("CounterApp window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 500, 250, 120);

        Font font = new Font("Arial", Font.BOLD, 20);

        JLabel counterView = new JLabel(String.valueOf(counter));
        counterView.setHorizontalAlignment(SwingConstants.CENTER);
        counterView.setFont(font);
        counterView.setBounds(102, 22, 30, 30);

        JButton incrementButton = new JButton(">");
        incrementButton.setBounds(184, 0, 50,81);

        JButton decrementButton = new JButton("<");
        decrementButton.setBounds(0, 0, 50,81);

        JButton incrementTenButton = new JButton("+ 10");
        incrementTenButton.setBounds(117, 66, 67,15);

        JButton decrementTenButton = new JButton("- 10");
        decrementTenButton.setBounds(50, 66, 67,15);

        JButton clearButton = new JButton("clear");
        clearButton.setBounds(85, 0, 65,15);


        add(counterView);
        add(clearButton);
        add(incrementButton);
        add(decrementButton);
        add(incrementTenButton);
        add(decrementTenButton);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == incrementButton) {
                    counter++;
                } else if (e.getSource() == decrementButton) {
                    counter--;
                } else if (e.getSource() == incrementTenButton) {
                    counter += 10;
                } else if (e.getSource() == decrementTenButton) {
                    counter -= 10;
                } else if (e.getSource() == clearButton) {
                    counter = 0;
                }
                refreshCounterView(counterView);
            }
        };

        incrementButton.addActionListener(actionListener);
        decrementButton.addActionListener(actionListener);
        incrementTenButton.addActionListener(actionListener);
        decrementTenButton.addActionListener(actionListener);
        clearButton.addActionListener(actionListener);

        setVisible(true);
    }

    private void refreshCounterView(JLabel counterView) {
        counterView.setText(String.valueOf(counter));
    }

    public static void main(String[] args) {
        new CounterApp();
    }
}