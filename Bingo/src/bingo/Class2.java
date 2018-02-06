package assalbingo;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Joey
 */
public class Class2 extends JFrame {
    
    private JLabel item1, item2;
    
    public Class2(){
    super ("Bingo");
    setLayout(new FlowLayout());
    
    item1 = new JLabel("Welcome to my bingo game! Have fun!");
    item2 = new JLabel("Welcome to my bingo game! Have fun!");

    item1.setToolTipText ("This will show on hover");
    add (item1);
    
         

    }
           
}
