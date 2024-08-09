
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;




public class MyFrame extends JFrame implements ActionListener{
    JButton algorithmSelector;
    JPopupMenu menu;
    JButton resetArray;
    ArrayCreater arrayPanel;
    String algorithmName = "Insertion Sort";
    JMenuItem item1;
    JMenuItem item2;
    JMenuItem item3;
    JButton runProgram;
    Algorithm insertionAlg = new Insertion();
    Algorithm currAlgorithm = insertionAlg;
    Algorithm selectionAlg = new Selection();
    Algorithm mergeAlg = new Merge();

    public MyFrame(){
        // RESET BUTTON
        ImageIcon resetArrayIcon = new ImageIcon("assests\\Reset.png");
        Image image = resetArrayIcon.getImage();
        Image resizedImage = image.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        resetArray = new JButton();
        resetArray.setBounds(25, 10, 100, 30);
        resetArray.setText("Reset");
        resetArray.setFocusable(false);
        resetArray.setIcon(resizedIcon);
        resetArray.setVerticalTextPosition(JButton.BOTTOM);
        resetArray.setHorizontalTextPosition(JButton.CENTER);
        resetArray.setIconTextGap(-4);
        resetArray.setFont(new Font("Comic Sans", Font.BOLD, 12));
        resetArray.setBackground(Color.LIGHT_GRAY);
        resetArray.setBorder(BorderFactory.createRaisedBevelBorder());
        resetArray.addActionListener(this);

        //Algorithm Chooser
        menu = new JPopupMenu("Algorithm");

        item1 = new JMenuItem("Insertion Sort");
        item2 = new JMenuItem("Selection Sort");
        item3 = new JMenuItem("Merge Sort");
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        menu.setPopupSize(200,100);
        menu.setFont(new Font("Comic Sans", Font.BOLD, 15));
        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
        
        algorithmSelector = new JButton();
        algorithmSelector.setBounds(375, 10, 200, 30);
        algorithmSelector.setText("Select Algorithm");
        algorithmSelector.setFocusable(false);
        algorithmSelector.setFont(new Font("Comic Sans", Font.BOLD, 12));
        algorithmSelector.setBackground(Color.LIGHT_GRAY);
        algorithmSelector.setBorder(BorderFactory.createRaisedBevelBorder());
        algorithmSelector.addActionListener(this);
       

        // Run Button
        ImageIcon runProgramIcon = new ImageIcon("assests\\run.png");
        Image runImage = runProgramIcon.getImage();
        Image resizedRunImage = runImage.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        ImageIcon resizedRunIcon = new ImageIcon(resizedRunImage);
        runProgram = new JButton();
        runProgram.setBounds(150, 10, 200, 30);
        runProgram.setText("Run: " + algorithmName);
        runProgram.setFocusable(false);
        runProgram.setIcon(resizedRunIcon);
        runProgram.setVerticalTextPosition(JButton.BOTTOM);
        runProgram.setHorizontalTextPosition(JButton.CENTER);
        runProgram.setIconTextGap(-4);
        runProgram.setFont(new Font("Comic Sans", Font.BOLD, 12));
        runProgram.setBackground(Color.LIGHT_GRAY);
        runProgram.setBorder(BorderFactory.createRaisedBevelBorder());
        runProgram.addActionListener(this);


        // HEADER 
        JPanel header = new JPanel();
        header.setBackground(Color.DARK_GRAY);
        header.setBounds(0, 0, 600, 50);
        header.setLayout(null);
        header.add(resetArray);
        header.add(algorithmSelector);
        header.add(runProgram);

        //Array panel
        arrayPanel = new ArrayCreater();
        arrayPanel.setBounds(0, 50, 600, 450);
        //arrayPanel.setSize(getPreferredSize());

        // FRAME
        this.setTitle("Algorithm Visiualizer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(614, 537);
        this.setVisible(true);
        this.add(header);
        this.add(arrayPanel);

        ImageIcon logo = new ImageIcon("assests\\Logo.jpg");
        this.setIconImage(logo.getImage());
        
        this.getContentPane().setBackground(Color.white);

    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==algorithmSelector){
            menu.show(algorithmSelector, 0, 0);
        }
        else if(e.getSource()==resetArray){
            arrayPanel.shuffle();
        }
        else if(e.getSource() == item1){
            algorithmName = "Insertion Sort";
            runProgram.setText("Run: " + algorithmName);
            currAlgorithm = insertionAlg;
        }
        else if(e.getSource() == item2){
            algorithmName = "Selection Sort";
            runProgram.setText("Run: " + algorithmName);
            currAlgorithm = selectionAlg;
        }
        else if(e.getSource() == item3){
            algorithmName = "Merge Sort";
            runProgram.setText("Run: " + algorithmName);
            currAlgorithm = mergeAlg;
        }
        else if(e.getSource() == runProgram){
            currAlgorithm.runSort(arrayPanel);
            arrayPanel.resetColours();
        }
    }

    public static void main(String[] args) { 
        new MyFrame();
    }
}
