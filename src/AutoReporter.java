public class AutoReporter extends Thread{
	public void run() {
		while (true) {
			synchronized(this){
				if (((int) (System.currentTimeMillis() / 1000)) %  86400== 0) {//judge if it's the end of the day
					CinemaService.getInstance().getKioskControl().generateReport();
				}
			}
		}
	
	}
}
