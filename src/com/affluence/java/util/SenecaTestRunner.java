package com.affluence.java.util;




import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;

import org.junit.runners.model.InitializationError;

public class SenecaTestRunner extends BlockJUnit4ClassRunner {
	 @SuppressWarnings("rawtypes")
	public SenecaTestRunner(Class klass) throws InitializationError {
	        super(klass);
	    }
	 private SenecaListener senecaListener;
	    @Override
	    public void run(final RunNotifier notifier) {
	       
	            try {
	                initializeDriversAndListeners(notifier);
	                super.run(notifier);
	            } finally {
	                dropListeners(notifier);
	                Page.generateCsvFile();
	            }
	        }
	    
	    
	    private void initializeDriversAndListeners(RunNotifier notifier) {
	    	SenecaListener listener = getSenecaListener();
	        notifier.addListener(listener);
	    }
	    
	    /**
	     * The Step Listener observes and records what happens during the execution of the test.
	     * Once the test is over, the Step Listener can provide the acceptance test outcome in the
	     * form of an TestOutcome object.
	     */
	    protected SenecaListener getSenecaListener() {
	        if (senecaListener == null) {
	        	senecaListener= new SenecaListener();
	        }
	        return senecaListener;
	    }
	    private void dropListeners(final RunNotifier notifier) {
	    	SenecaListener listener = getSenecaListener();
	        notifier.removeListener(listener);
	       
	    }


		
	}
	   

