import java.awt.*; 
import javax.swing.*;

public class GUI extends JFrame
{
	JPanel panel;
	JLabel label;

	// constructor
	MyFrame( String title )
	{
		super( title );                      // invoke the JFrame constructor
		setSize( 150, 100 );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		setLayout( new FlowLayout() );       // set the layout manager
		label = new JLabel("Hello Swing!");  // construct a JLabel
		add( label );                        // add the label to the JFrame
	}

} 

//public class TestFrame2
//{
//	public static void main ( String[] args )
//	{
//		MyFrame frame = new MyFrame("Hello"); // construct a MyFrame object
//		frame.setVisible( true );             // ask it to become visible
//	}
//}
//
//public static void main(String[] args) {
//	// TODO Auto-generated method stub
//
//}

}
