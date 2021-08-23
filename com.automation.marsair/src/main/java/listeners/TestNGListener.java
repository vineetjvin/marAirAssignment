package listeners;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener{
	
	static Logger log = LogManager.getLogger(TestNGListener.class.getName());
	
	@Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub       
		log.info("on test start");
    }
 
    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub      
		log.info("on test success");      
    	
    }
 
    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub 
    	
    	if(result.getThrowable() != null) {
    		StringWriter sw = new StringWriter();
    		PrintWriter pw = new PrintWriter(sw);
    		result.getThrowable().printStackTrace();
    		System.out.println(sw.toString());
    	}
    	
    	
		log.info("on test failure");   
    }
 
    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub          
		log.info("on test skipped");  
    }
 
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub           
		log.info("test failed success percent"); 
    }
 
    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub            
		log.info(" on start");
    }
 
    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub           
    
    }

}
