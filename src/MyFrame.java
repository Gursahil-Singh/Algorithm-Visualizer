import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame{
   
    MyFrame(){
        ImageIcon resetArrayIcon = new ImageIcon("assests\\Reset.png");
        Image image = resetArrayIcon.getImage();
        Image resizedImage = image.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        JButton resetArray = new JButton();
        resetArray.setBounds(20, 10, 100, 30);
        resetArray.setText("Reset");
        resetArray.setFocusable(false);
        resetArray.setIcon(resizedIcon);
        resetArray.setVerticalTextPosition(JButton.BOTTOM);
        resetArray.setHorizontalTextPosition(JButton.CENTER);
        resetArray.setIconTextGap(-4);
        resetArray.setFont(new Font("Comic Sans", Font.BOLD, 12));
        resetArray.setBackground(Color.LIGHT_GRAY);
        resetArray.setBorder(BorderFactory.createRaisedBevelBorder());


        JPanel header = new JPanel();
        header.setBackground(Color.DARK_GRAY);
        header.setBounds(0, 0, 600, 50);
        header.setLayout(null);
        header.add(resetArray);
        
        this.setTitle("Algorithm Visiualizer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(600, 500);
        this.setVisible(true);
        this.add(header);

        ImageIcon logo = new ImageIcon("assests\\Logo.jpg");
        this.setIconImage(logo.getImage());
        
        this.getContentPane().setBackground(Color.black);

    }
        
}
