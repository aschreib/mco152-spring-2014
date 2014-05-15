package schreiber.clock;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JPanel;

public class BasicClock extends JPanel {

	private int hour;
	private int minute;
	private int second;

	// private String readout;

	// default constructor with current time
	public BasicClock() {
		setCurrentTime();
	}

	// constructor with a specific time
	public BasicClock(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	public int getHour() {
		if (hour > 12) {
			hour -= 12;
		}
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
		repaint();
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
		repaint();
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
		repaint();
	}

	// draw the clock
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// initialize clock parameters
		int clockRadius = (int) (Math.min(getWidth(), getHeight()) * 0.8 * 0.5);
		int centerX = getWidth() / 2;
		int centerY = getHeight() / 2;

		// draw circle
		g.setColor(Color.black);
		g.drawOval(centerX - clockRadius, centerY - clockRadius,
				2 * clockRadius, 2 * clockRadius);
		g.drawString("12", centerX - 5, centerY - clockRadius + 12);
		g.drawString("3", centerX + clockRadius - 10, centerY + 3);
		g.drawString("6", centerX - 3, centerY + clockRadius - 3);
		g.drawString("9", centerX - clockRadius + 3, centerY + 5);

		// draw hour hand
		int hourLength = (int) (clockRadius * 0.5);
		int hourX = (int) (centerX + hourLength
				* Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
		int hourY = (int) (centerY - hourLength
				* Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
		g.setColor(Color.black);
		g.drawLine(centerX, centerY, hourX, hourY);

		// draw minute hand
		int minuteLength = (int) (clockRadius * 0.65);
		int minuteX = (int) (centerX + minuteLength
				* Math.sin(minute * (2 * Math.PI / 60)));
		int minuteY = (int) (centerY - minuteLength
				* Math.cos(minute * (2 * Math.PI / 60)));
		g.setColor(Color.black);
		g.drawLine(centerX, centerY, minuteX, minuteY);

		// draw second hand
		int secondLength = (int) (clockRadius * 0.8);
		int secondX = (int) (centerX + secondLength
				* Math.sin(second * (2 * Math.PI / 60)));
		int secondY = (int) (centerY - secondLength
				* Math.cos(second * (2 * Math.PI / 60)));
		g.setColor(Color.red);
		g.drawLine(centerX, centerY, secondX, secondY);

	}

	public void setCurrentTime() {
		Calendar calendar = new GregorianCalendar();
		this.hour = calendar.get(Calendar.HOUR_OF_DAY);
		this.minute = calendar.get(Calendar.MINUTE);
		this.second = calendar.get(Calendar.SECOND);
	}

	public Dimension getPreferredSize() {
		return new Dimension(600, 600);
	}
}
