// Created by tirel22

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ultraWide extends JFrame implements ActionListener {
    private JLabel insert;
    private JTextField width;
    private JTextField height;
    static JButton click;
    private JLabel X;
    private JButton howtoUse;
    private JButton About;
    public String widthInsert = "";
    public String heightInsert = "";
    public JCheckBox Aproximate;

    Font xFont = new Font("Serif", Font.BOLD, 35);

    public ultraWide() {
        setLayout(null);
        setResizable(false);
        setSize(550, 360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        double version = 1.0;
        setTitle("Ultra Wide Video Calculator v "+ version);

        insert = new JLabel("Enter your video resolution:");
        click = new JButton("Calculate");
        X = new JLabel("X");
        howtoUse = new JButton("How to use");
        About = new JButton("About");
        width = new JTextField();
        height = new JTextField();
        Aproximate = new JCheckBox("Aproximate");

        insert.setBounds(181, 20, 220, 30);
        width.setBounds(150, 60, 80, 30);
        height.setBounds(280, 60, 80, 30);
        X.setBounds(240, 60, 62, 30);
        click.setBounds(195, 190, 110, 30);
        howtoUse.setBounds(40, 260, 117, 30);
        About.setBounds(390, 260, 117, 30);
        Aproximate.setBounds(200, 240, 120, 30);

        X.setFont(xFont);
        X.setForeground(Color.GRAY);

        click.addActionListener(this);
        howtoUse.addActionListener(this);
        About.addActionListener(this);

        add(click);
        add(insert);
        add(width);
        add(height);
        add(X);
        add(howtoUse);
        add(About);
        add(Aproximate);

        HandlerClass handler = new HandlerClass();
        Aproximate.addItemListener(handler);
    }
    public class HandlerClass implements ItemListener {

        public void itemStateChanged (ItemEvent event) {

        }
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == click && width.getText().isEmpty() | height.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null ,"Error. Please provide your video width and height!", "Error" , JOptionPane.ERROR_MESSAGE);

            return;

        }else if (e.getSource() == click && Aproximate.isSelected()) {

            widthInsert = width.getText();
            heightInsert = height.getText();

            double resultWidthi = Double.parseDouble(widthInsert);

            double widthResi = resultWidthi;
            double heightResi = (resultWidthi * 9) / 21;

            double widthResif =Math.round(widthResi);
            double heightResif = Math.round(heightResi);

            int aproxWidth = (int) widthResif;
            int aproxHeight = (int) heightResif;

            JOptionPane.showMessageDialog(null, "Your ultra wide video resolution is: " + aproxWidth + " X " + aproxHeight, "Aproximated Values", JOptionPane.INFORMATION_MESSAGE );

        }else if(e.getSource() == click && Aproximate.isSelected() ==false){

            widthInsert = width.getText();
            heightInsert = height.getText();

            double resultWidth = Double.parseDouble(widthInsert);
            double widthRes = resultWidth;
            double heightRes = (resultWidth * 9) / 21;

            JOptionPane.showMessageDialog(null, "Your ultra wide video resolution is: " + widthRes + " X " + heightRes, "Exact Values", JOptionPane.INFORMATION_MESSAGE);

        }else if (e.getSource() == howtoUse) {

            JOptionPane.showMessageDialog(null, "This program was designed to convert your other aspect ratios, like 16:9 into 21:9.\n" + "Just enter your resolution, press \"Calculate\" (for exact values), or check the\n \"Aproximate\" checkbox for rounded values. After than you can insert your new\n values into your video project.", "How to Use", JOptionPane.INFORMATION_MESSAGE);

        } else if (e.getSource() == About) {
            JOptionPane.showMessageDialog(null, " \"UVC\" stands for \"Ultra Wide Video Calculator \". It's a free, multi platform, simple and open source program \ncreated for anyone how is looking to convert another aspect ratio resolution into a resolution with an aspect\n ratio of 21:9.\n \n Created by tirel22 (GitHub: https://github.com/tirel22 ).", "About", JOptionPane.INFORMATION_MESSAGE );

        }
    }

    public static void main(String[] args) {

        ultraWide s = new ultraWide();

        s.setVisible(true);

        s.getRootPane().setDefaultButton(click);

        click.requestFocus();
    }
}
