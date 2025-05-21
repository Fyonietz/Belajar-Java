package com.method;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlatUIDemo extends JFrame {
    public FlatUIDemo() {
        // Set title and default close operation
        setTitle("Flat UI Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Set the window size
        setSize(400, 300);
        
        // Set background color to white for flat effect
        getContentPane().setBackground(Color.WHITE);
        
        // Create a simple label with flat style
        JLabel label = new JLabel("Welcome to Flat UI!");
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        label.setForeground(Color.BLACK);  // Text color
        
        // Create a flat button
        JButton button = new JButton("Click Me");
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setBackground(new Color(66, 133, 244));  // Flat blue
        button.setForeground(Color.WHITE);  // Text color
        button.setBorder(BorderFactory.createEmptyBorder()); // No border
        button.setFocusPainted(false);  // Remove focus outline
        
        // Add an ActionListener to the button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Button Clicked!");
            }
        });

        // Add the label and button to the frame
        add(label);
        add(button);

        // Set the frame visible
        setLocationRelativeTo(null);  // Center the window
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create the frame
        new FlatUIDemo();
    }
}
