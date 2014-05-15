package schreiber.clock;

public class ClockThread extends BasicClock implements Runnable {

	public ClockThread() {
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (true) {
			setCurrentTime();
			repaint();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
			}
		}
	}

}
