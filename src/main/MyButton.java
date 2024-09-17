package main;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class MyButton extends JButton {
    public MyButton(){
        this.setFocusable(false);
        this.setFont(new Font("Comic Sans", Font.BOLD, 12));
        this.setBorder(BorderFactory.createRaisedBevelBorder());
        this.setVerticalTextPosition(JButton.BOTTOM);
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setIconTextGap(-4);
        this.setBackground(Color.LIGHT_GRAY);
    }
}
