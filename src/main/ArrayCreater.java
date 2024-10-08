package main;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JPanel;
import java.lang.InterruptedException;

public class ArrayCreater extends JPanel {
    private final int panelWidth = 600;
    private final int panelheight = 450;
    private final int barWidth = 5;
    private final int numBar = panelWidth/barWidth;
    private int[] array;
    private int[] barColours;

    ArrayCreater(){
        setBackground(Color.BLACK);
        array = new int[numBar];
        barColours = new int[numBar];
        for (int i = 0; i < numBar; i++) {
            array[i] = i;
            barColours[i] = 0;
        }
    }

    public int arraySize(){
        return array.length;
    }
    
    public int getValue(int index){
        return array[index];
    }

    public void swap(int firstIndex, int secondIndex, long milliSecDelay) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
        
        barColours[firstIndex] = 100;
        barColours[secondIndex] = 100;
        
        repaint();
        update(getGraphics());

        
        sleepFor(millisecondsToNano(milliSecDelay));
        
        
        resetColours();
    }
    
    public void updateSingle(int index, int value, long millisecondDelay) {
        array[index] = value;
        barColours[index] = 100;
        repaint();
        update(getGraphics());
        sleepFor(millisecondsToNano(millisecondDelay));
    }
    
    public void shuffle() {
        Random rng = new Random();
        for (int i = 0; i < arraySize(); i++) {
            int swapWithIndex = rng.nextInt(arraySize() - 1);
            swap(i, swapWithIndex, 5);       
        }
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(panelWidth, panelheight);
    }
    
    public void resetColours() {
        for (int i = 0; i < numBar; i++) {
            barColours[i] = 0;
        }
        repaint();
    }
    

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D)g;
        super.paintComponent(graphics);
       
        graphics.setColor(Color.white);
        for (int x = 0; x < numBar; x++) {
            int height = getValue(x) * 3;
            int xBegin = x + (barWidth - 1) * x;
            int yBegin = panelheight - height;
            
            int val = barColours[x] * 2;
            graphics.setColor(new Color(255, 255 - val, 255 - val));
            graphics.fillRect(xBegin, yBegin, barWidth, height);
            if (barColours[x] > 0) {
                barColours[x]-= 10;
            }
        }
    }

    private void sleepFor(long nanoSec){
        
        long milliseconds = nanoSec / 1000000;
        long remainingNanoseconds = nanoSec % 1000000;
    
        try {
            Thread.sleep(milliseconds, (int)remainingNanoseconds); 
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
        }
    }

    public static long secondsToNano(long time) {
        return time * (long)Math.pow(10, 9);
    }
    
    public static long millisecondsToNano(long time) {
        return time * (long)Math.pow(10, 6); 
    }
    
    public static long microsecondsToNano(long time) {
        return time * (long)Math.pow(10, 3); 
    }

}
