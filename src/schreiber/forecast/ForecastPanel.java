package schreiber.forecast;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ForecastPanel extends JPanel {

	private final JLabel city;
	private final JTextField userInput;

	public ForecastPanel() {
		city = new JLabel("Enter the location (city,country):");
		userInput = new JTextField(20);
		this.add(city);
		this.add(userInput);
	}

	// delete unwanted spaces from input
	public String getUserInput() {
		String input = userInput.getText();

		input = input.replace(" ", "");
		return input;
	}

}
