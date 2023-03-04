package isp.lab9.exercise3;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private DoorLockController doorLockController;
    private JTextField pin;
    private JTextField doorStatus;
    private JButton enterPin;


    private void window() {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame("Design Preview");
        frame.setSize(350, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
//
        JLabel accessCode = new JLabel("Type access code: ");
        accessCode.setBounds(10, 20, 120, 25);
        panel.add(accessCode);
//
        this.pin = new JTextField("");
        this.pin.setBounds(145, 20, 165, 25);
        panel.add(pin);
//
        this.enterPin = new JButton("Enter code");
        this.enterPin.setBounds(10, 50, 299, 25);
        panel.add(enterPin);
//
        JLabel doorStatusLabel = new JLabel("Door status: ");
        doorStatusLabel.setBounds(10,80,80,25);
        panel.add(doorStatusLabel);
//
        this.doorStatus = new JTextField();
        this.doorStatus.setBounds(145,80,165,25);
        panel.add(doorStatus);


      frame.setVisible(true);

    }

}
