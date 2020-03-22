// Created by: Jessie Griffin 	
// Date: March 22, 2020		
// Course: 202010-COP-3330-01Z	
// Professor: John Wiggins		
// Assignment: Eclipse Project 4

public class ConcurrencyAndThreads {
	public static void main(String args[]) throws InterruptedException {

	    for (int maxWaitTime = 1; maxWaitTime <= 5;  maxWaitTime++) {
		    Thread messageLoop = new Thread(new MessageLoop());
//	     	messageLoop.join(maxWaitTime * 1000);
	    	System.out.printf("maxWaitTime: %d second(s)\n", maxWaitTime);
	        System.out.printf("%s : Starting MessageLoop thread\n", Thread.currentThread().getName());
	        
	        messageLoop.start();
	        Thread.sleep(maxWaitTime);
	        

	        System.out.printf("%s : Waiting for MessageLoop thread to finish\n", Thread.currentThread().getName());

        	if (!messageLoop.isInterrupted()) {
	        	Thread.sleep(500);
	            System.out.printf("%s : Continuing to wait...\n", Thread.currentThread().getName());
	        } else {
	        	messageLoop.interrupt();
	        }
/*        	while (!messageLoop.isInterrupted()) {
	        	Thread.sleep(500);
	            System.out.printf("%s : Continuing to wait...\n", Thread.currentThread().getName());
	        }
*/		    
        	
        	if (maxWaitTime == 5) {
                System.out.printf("%s : Done!\n", Thread.currentThread().getName());
        	}
        	
        	Thread.currentThread();
			if (Thread.interrupted()) {
        		return;
        	}
	        //messageLoop.interrupt();
			//Thread.interrupted();

	    }
    }
}

class MessageLoop implements Runnable {
	
	String messages[] = {
            "1. All that is gold does not glitter, Not all those who wander are lost",
            "2. The old that is strong does not wither, Deep roots are not reached by the frost",
            "3. From the ashes a fire shall be woken, A light from the shadows shall spring",
            "4. Renewed shall be blade that was broken",
            "5. The crownless again shall be king"
        };

	public void run() {		
    	
//		while (!Thread.currentThread().isInterrupted()) {
			for (int i = 0; i < 5; i++) {

        		try {
        			Thread.sleep(850);
            		System.out.printf("%s : %s\n", Thread.currentThread().getName(), messages[i]);

        	
        		} catch (InterruptedException e) {
        			System.out.printf("%s : MessageLoop interrupted!\n", Thread.currentThread().getName());
//					Thread.currentThread().interrupt();
        			break;
			//e.printStackTrace();
			}
		//System.out.printf("%s : %s\n", Thread.currentThread().getName(), messages[i]);
		}
/*		for (int i = 0; i < 5; i++) {

            try {
            		Thread.sleep(850);
            		//System.out.printf("%s : %s\n", Thread.currentThread().getName(), messages[i]);
            	
			} catch (InterruptedException e) {
	            System.out.printf("%s : MessageLoop interrupted!\n", Thread.currentThread().getName());
	           Thread.currentThread().interrupt();
				return;
				//e.printStackTrace();
			}
    		System.out.printf("%s : %s\n", Thread.currentThread().getName(), messages[i]);

/*             if (Thread.interrupted()) {
	            System.out.printf("%s : MessageLoop interrupted!\n", Thread.currentThread().getName());
	            return;
            }
*/		
        
		
		//}
	}
}
