import javax.swing.JFrame;

public class Driver {

	public static void main(String[] args) {
		App EvenEval = new App(); //creating app instance
		EvenEval.launch(); //launching the splash applicaton

	    EvenEval.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //terminates program on close
	    EvenEval.pack(); //making program look good
	    EvenEval.setVisible(true); //setting application visible
	}

}
