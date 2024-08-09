
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    JMenuItem item3 ;
    JButton runProgram;
    Algorithm insertionAlg = new Insertion();
    Algorithm currAlgorithm = insertionAlg;
    Algorithm selectionAlg = new Selection();
    Algorithm mergeAlg = new Merge();
    

    public MyFrame(){
        // RESET BUTTON
        ImageIcon resizedIcon = imageResizer("assests\\Reset.png");
        resetArray = new MyButton();
        resetArray.setBounds(25, 10, 100, 30);
        resetArray.setText("Reset");
        resetArray.setIcon(resizedIcon);
        resetArray.addActionListener(this);


        //Algorithm Chooser
        createMenu();
        algorithmSelector = new MyButton();
        algorithmSelector.setBounds(375, 10, 200, 30);
        algorithmSelector.setText("Select Algorithm");
        algorithmSelector.addActionListener(this);
       

        // Run Button
        ImageIcon resizedRunIcon = imageResizer("assests\\run.png");
        runProgram = new MyButton();
        runProgram.setBounds(150, 10, 200, 30);
        runProgram.setText("Run: " + algorithmName);
        runProgram.setIcon(resizedRunIcon);
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

    public static void main(String[] args) { 
        new MyFrame();
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

    private ImageIcon imageResizer(String file){
        ImageIcon img = new ImageIcon(file);
        Image image = img.getImage();
        Image resizedImg = image.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }

    private void createMenu(){
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
    } 
}
