package bbjs.practice.log;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jTest {
	private static Logger logger = Logger.getLogger(Log4jTest.class);  

    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        // System.out.println("This is println message.");  
    	//PropertyConfigurator.configure(System.getProperty("user.dir") + "\\src\\log4j.properties");
        // ��¼debug�������Ϣ  
    	logger.info("test");
        //logger.debug("This is debug message.");  
        // ��¼info�������Ϣ  
        logger.info("This is info message.");  
        // ��¼error�������Ϣ  
        //logger.error("This is error message.");  
    }  
}
