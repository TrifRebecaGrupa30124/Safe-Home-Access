/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isp.lab9.exercise3;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author mihai.hulea
 */
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Exercise3 {
    public static void main(String[] args) {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame("Design Preview");
        frame.setSize(350, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        JLabel label = new JLabel("Type access code: ");
        label.setBounds(10,20,120,25);
        panel.add(label);

        JTextField text = new JTextField(20);
        text.setBounds(145,20,165,25);
        panel.add(text);

        JButton button = new JButton("Enter code");
        button.setBounds(10,50,299,25);
        panel.add(button);

        JLabel label1 = new JLabel("Door status: ");
        label1.setBounds(10,80,80,25);
        panel.add(label1);

        JTextField text1 = new JTextField("Locked");
        text1.setBounds(145,80,165,25);
        panel.add(text1);




        frame.setVisible(true);

    }

}
