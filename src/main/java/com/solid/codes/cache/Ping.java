package com.solid.codes.cache;

public class Ping extends Thread {

	private long sleepTime;
	private Pingable target;

	public Ping(Pingable target, long sleepTime) {
		this.sleepTime = sleepTime;
		this.target = target;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		while (true) {
			try {
				sleep(sleepTime);
			} catch (Exception e) {
				// TODO: handle exception
			}
			target.ping();
		}

	}

}
