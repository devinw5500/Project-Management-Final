/*
 * Make a GUI in Java that displays flashcards (like quizlet)
 * Read and Write to a text file that holds the "cards"
 * Display the cards in a JFrame 
 * Be able to switch between cards and flip cards
 * Devin Wiggins, Jason Tressler, Frank Work, Seth Ramey, Jacob Young
 */
package flashcards;

//import statements
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Flashcards extends JFrame implements ActionListener
{
    
    JButton flip = new JButton("OK");
    JButton next = new JButton("OK");
    JButton prev = new JButton("OK");
    public Flashcards()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(flip);
        add(next);
        add(prev);
        flip.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if(source == flip)
            System.out.println("flip");
        if(source == next)
            System.out.println("next");
        if(source == prev)
            System.out.println("prev");
            
    }
    
    public static void main(String[] args) 
    {
        //comment thing
        //test
    }
}