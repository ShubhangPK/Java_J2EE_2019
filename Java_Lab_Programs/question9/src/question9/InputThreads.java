package question9;
public class InputThreads {
	
	public static void main(String[] args) throws InterruptedException { 
	GetStringThread getStringThread;
	GetNumberThread getNumberThread;
	getNumberThread = new GetNumberThread();
	getStringThread = new GetStringThread();
	//getNumberThread.start();
	getStringThread.start();
	Thread.sleep(100);
	//getStringThread.start();
	getNumberThread.start();
	}
}

