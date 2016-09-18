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
        // 记录debug级别的信息  
    	logger.info("test");
        //logger.debug("This is debug message.");  
        // 记录info级别的信息  
        logger.info("This is info message.");  
        // 记录error级别的信息  
        //logger.error("This is error message.");  
    }  
}
