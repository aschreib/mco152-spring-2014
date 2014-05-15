package schreiber.weather;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WeatherPanel extends JPanel {

	private final JLabel city;
	private final JTextField userInput;

	public WeatherPanel() {
		city = new JLabel("Enter the location in the format of city,country");
		userInput = new JTextField(10);
		this.add(city);
		this.add(userInput);
	}

	public String getUserInput() {
		String input = userInput.getText();

		input = input.replace(" ", "");
		return input;
	}

	public void reset() {
		userInput.setText("");
	}

}