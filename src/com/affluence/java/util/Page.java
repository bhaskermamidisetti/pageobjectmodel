package com.affluence.java.util;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;

import org.apache.commons.io.FileUtils;
import org.junit.runner.notification.RunListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.affluence.java.pages.DoLogOutPage;


@SuppressWarnings("unused")
public class Page extends RunListener{


	 public static WebDriver driver;
     public static Properties props;
     public static final int MAX_WAIT_TIME_IN_MS = 220000;
     public static String base_url;
     public static String browser_type;
     public static  String dataPath;
 	 public static boolean isLoggedin; 
 	 public static String basicuser;
     public static String basicuserpwd;
     public static DoLogOutPage webpage; 	 
 	 public static String screenShotPackageName;
 	 public static String chromeDriverPath;
 	public static String ieDriverPath;
 	 public static String screenShotsPath;
     public static String testName;
 	 @SuppressWarnings("rawtypes")
	 public static Map screenDetails;
 	 public static String testReportsPath;
 	 public static String testReportsPath2;
 	 public static final String   INDEX_PATH="TestResults/testreport/";
 	 public static int imageNumber=1;
 	@SuppressWarnings("rawtypes")
	public static HashMap resultTestData;
 	public static TestDataBean currentTestDataBean;
 	public static String reqID;
 	
 	@SuppressWarnings("rawtypes")
	public static HashMap currentStepsMap;
 	public static String stepWiseResults;
 	public static boolean resultsCSVHeaders=true;
 	public static HashMap finalTestResults;
 	
 	 public static Queue<String> qe=new LinkedList<String>();
	public static String  mannual_testcases_path;
	static{
    	 try{
    		 
    		 loadProperties();
          }catch(Exception e){
        	  e.printStackTrace(); 
           }
     }

    public static void loadProperties(){
                     props = new Properties();
                     try{
                    	 finalTestResults=new HashMap(); 
                    	 props.load(new FileInputStream("src/com/affluence/java/resources/config.properties"));
                    	 base_url = props.getProperty("baseUrl");
                    	 browser_type = props.getProperty("browser_type");
                    	 dataPath=props.getProperty("dataPath");
                    	 basicuser=props.getProperty("basic_user");
                    	 basicuserpwd=props.getProperty("basic_user_pwd");
                    	 chromeDriverPath=props.getProperty("Chrome_Driver_location");
                    	 ieDriverPath=props.getProperty("IE_Driver_location");
                    	 stepWiseResults=props.getProperty("Step_Wise_Results");
                    	// mannual_testcases_path=props.getProperty("mannual_testcases_path");
                    	 System.out.println("---Properties file loaded successfully---");
                     }catch(Exception e)
                     {
                    	 System.out.println("---Properties file not loaded---");
                    	 e.printStackTrace();
                     }
            }
     
    
     
     				/**
     				 * @return
     				 */
     				public static WebDriver getDriver(){
     				try{
     					reqID=null;
     					System.out.println("--enter in to getdriver method--");
     					if(browser_type.equals("chrome")){
     						System.setProperty("webdriver.chrome.driver",chromeDriverPath);
     						driver = new ChromeDriver();
     					}else if(browser_type.equals("firefox")){
     						driver = new FirefoxDriver();
     					}else if(browser_type.equals("IE")){
     						System.setProperty("webdriver.ie.driver",ieDriverPath);
     						driver = new InternetExplorerDriver();
     					}
     					
     					System.out.println("--Driver initialized--");
     				}catch(Exception e){
     					System.out.println("--Driver not initialized--"+e.getMessage());
     				}
     				return driver;
     					}
     				/**
     				 * @return
     				 */
     				public static WebDriverWait getWebDriverWait(){
         			
     					return new WebDriverWait(driver,MAX_WAIT_TIME_IN_MS);
				}
     				  /**
     				 * @param purpose
     				 * @param fromTest
     				 * @param fromPage
     				 * @param fromMethod
     				 */
     				@SuppressWarnings("unchecked")
					public static void takeAScreenShot(String parameter,String stepDescription,String executionTime) throws Exception{
     					 
     						CurrentStepDataBean currentStepDataBean=new CurrentStepDataBean(); 
     						 
     						  ImageDetailsBean imageBean=new ImageDetailsBean();
     						  File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
     						  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
     						
     						  screenShotsPath=INDEX_PATH+screenShotPackageName+"screenshot/";
     						  testReportsPath2=screenShotPackageName+"screenshot/"+testName;
     						  testReportsPath=screenShotsPath+testName;
     						  String imagePath=screenShotsPath+testName+"/image"+imageNumber+".png";
     						  String imagePath2=screenShotsPath+testName+"/"+imageNumber+".png"; 
     						  imageBean.setImagePath(imagePath2);
     						  imageBean.setPurpose(parameter);
     						  imageBean.setFromTest(testName);
     						  imageBean.setStepDescription(stepDescription);
     						  imageBean.setStepExecutionTime(executionTime);
     						  screenDetails.put(imageNumber,imageBean);
     						  currentStepDataBean.setImageDetailsBean(imageBean);
     						  FileUtils.copyFile(file, new File(imagePath));
     					  	  BufferedImage i = ImageIO.read(new File(imagePath));
     					  	  compressImage(i,0.7f,imagePath2) ;
     					  	  deletefile(imagePath);
     					  	  currentStepsMap.put(imageNumber,currentStepDataBean);
     						
     					
     					 imageNumber++;
     				  }
     				
     				/**
     				 * @param className
     				 * @return
     				 */
     				public static void getscreenShotPackageName(String className){
     				
     					String[] str=className.split("\\.");
     					String screenPackageName="";
     					for(int i=0;i<str.length-1;i++){
     						screenPackageName+=str[i]+"/";
     					}
     					System.out.println("screenPackageName in getscreenShotPackageName "+screenPackageName);
     				
     				
     					screenShotPackageName=screenPackageName;
					}
     				
     				 /**
     				 * @param image
     				 * @param quality
     				 * @param imagePath
     				 * @throws IOException
     				 */
     				public static void compressImage(BufferedImage image, float quality,String imagePath) throws IOException
     			       {
     			       
     						Iterator<ImageWriter> writers = ImageIO.getImageWritersBySuffix("jpeg");
     						if (!writers.hasNext()) throw new IllegalStateException("No writers found");
     							ImageWriter writer = (ImageWriter) writers.next();
     							ImageWriteParam param = writer.getDefaultWriteParam();
     							param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
     							param.setCompressionQuality(quality);
     							ByteArrayOutputStream bos = new ByteArrayOutputStream(32768);
     							ImageOutputStream ios = ImageIO.createImageOutputStream(bos);
     							writer.setOutput(ios);
     							writer.write(null, new IIOImage(image, null, null), param);
     							ios.flush(); 
     							ByteArrayInputStream in = new ByteArrayInputStream(bos.toByteArray());
     							RenderedImage out = ImageIO.read(in);
     							int size = bos.toByteArray().length;
     							File file = new File(imagePath);
     							FileImageOutputStream output = new FileImageOutputStream(file);
     							writer.setOutput(output); 
     							writer.write(null, new IIOImage(image, null,null), param);
     			     }
     				 
     				 
     				 
     				/**
     				 * @param fileName
     				 */
     				private static void deletefile(String fileName) {
     					
     					File file = new File(fileName);
     					boolean success = file.delete();
     					if (!success) {
     					//	System.out.println(fileName + " Deletion failed.");
     					} else {
     				//		System.out.println(fileName + " File deleted.");
     					}
     				}
     			
     				public static String getImagesPath(String path){
     					System.out.println("string Path-->"+path);
     					String str[]=path.split("/");
     					String temp="";
     					for(int i=0;i<str.length-2;i++){
     						temp+="../";
     					}
     					return temp;
     					
     				}
     				
     
     
    
      
      public static void generateCsvFile()
      {
             try
             {
            	 
            	 if(!isFolderExist(INDEX_PATH)){
           			createTesreportsDir(INDEX_PATH) ;
           		 }
            	  String fileName= INDEX_PATH+"TestResults.csv";
            	  boolean fileExist=isResultCSVExist(fileName);
                  FileWriter writer = new FileWriter(fileName,true);
                 
                  System.out.println("resultsCSVHeaders:"+resultsCSVHeaders+"      fileExist:"+fileExist);
                  if(resultsCSVHeaders && !fileExist){
                  writer.append("Test Case Name");
                  writer.append(',');
                  writer.append("Steps");
                  writer.append(',');
                  writer.append("Step Description");
                  writer.append(',');
                  writer.append("Step Result");
                  writer.append(',');
                  writer.append("Test Result");
                  writer.append(',');
                  writer.append("Test Requirement");
                  writer.append(',');
                  writer.append("Date");
                  writer.append('\n');
                  resultsCSVHeaders=false;
                 }
                  
               @SuppressWarnings("rawtypes")
			    Set s=resultTestData.keySet();
                System.out.println("keys on result set map"+s);
               
               @SuppressWarnings("rawtypes")
			Iterator itr=s.iterator();
                  
                 while(itr.hasNext()){
                	   String key=itr.next().toString();
                	   TestDataBean tdBean=(TestDataBean)resultTestData.get(key);
                	   finalTestResults.put(tdBean.getTesName(), resultTestData);
                	   writer.append(tdBean.getTesName());
                       writer.append(',');
                       writer.append(',');
                       writer.append(',');
                       writer.append(',');
                       writer.append(tdBean.getTestResult());
                       writer.append(',');
                       writer.append(tdBean.getReqId());
                       writer.append(',');
                       writer.append(new Date().toString());
                       writer.append('\n');
                       if(stepWiseResults.equals("true")){
                       @SuppressWarnings("rawtypes")
					Set stepKeySet=tdBean.getStepDetails().keySet();
                       System.out.println("keys on result stepKeySet"+stepKeySet);
                       @SuppressWarnings("rawtypes")
					Iterator stepIterator=stepKeySet.iterator();
                       int i=1;
                       while(stepIterator.hasNext()){
                    	   int stepKey=Integer.parseInt(stepIterator.next().toString());
                    	   CurrentStepDataBean currentStepDataBean=(CurrentStepDataBean)tdBean.getStepDetails().get(stepKey);
                    	   ImageDetailsBean imageBean=currentStepDataBean.getImageDetailsBean();
                    	   writer.append(",");
                    	   writer.append(""+i+"");
                    	   writer.append(",");
                    	   
                    	   writer.append(imageBean.getStepDescription());
                    	   if(!imageBean.getPurpose().split(":")[0].equals("notrequired")){
                    		   writer.append("{"+imageBean.getPurpose().split(":")[0]+"}");
                    	   }
                    	   writer.append(",");
                    	   writer.append(imageBean.getPurpose().split(":")[1]);
                    	   writer.append('\n');
                    	   i++;
                    	   
                       }
                     }
                       writer.append('\n');
                  }

                  writer.flush();
                  writer.close();
                 
             } catch(Exception e) {
                   e.printStackTrace();
             } 
            
             resultTestData=null;
        }
      public static void cretaeScreebDetailsMap(){
    	  screenDetails=new LinkedHashMap<String,String>();
      }
     		
      public static void setTestName(String fromTest){
    	  testName=fromTest;
      }
     
      
      @SuppressWarnings("rawtypes")
	public static void cretaeResultTestDataMap(){
    	  resultTestData=new HashMap();
      }
      @SuppressWarnings("rawtypes")
	public static void cretaeCurrentStepsMap(){
    	  currentStepsMap=new HashMap();
      }
      @SuppressWarnings("unchecked")
	public static void addToresulTestData(TestDataBean tesDataBean){
    	 
    	  resultTestData.put(tesDataBean.getTesName(),tesDataBean);
    	  System.out.println("resultTestData--in addToresulTestData "+resultTestData);
    	  qe.add(tesDataBean.getTesName());
      }
      public static String getReqID() {
  		return reqID;
  	}



  	@SuppressWarnings("static-access")
	public  void setReqID(String reqID) {
  		this.reqID = reqID;
  	}   
      
  	 @SuppressWarnings("rawtypes")
	public static Map getCurrentStepsMap(){
  		 System.out.println("currentStepsMap--- in getCurrentStepsMap >"+currentStepsMap);
   	  return currentStepsMap;
   	  
     }
  	 public static boolean isResultCSVExist(String fileName){
  		 File f = new File(".");
  		 boolean fileFound=false;
  		// System.out.println(f.getAbsolutePath());
  		 if(f.isDirectory())
  		 {
  			 File[] file= f.listFiles();
        for(File f1 :file)
        {
        	//System.out.println("File Found"+f1.getName());
            if(f1.getName().endsWith(".csv"))
            {
            	//System.out.println("File Found"+f1.getName());
            	if(f1.getName().equals(fileName)){
            		System.out.println("File Found"+f1.getName());
            		fileFound=true;	
            	}
            	//System.out.println("File Found"+f1.getName());
                
            }
        }
    }
  		 return fileFound;
  		
  }
  	 
  	public static String getTestResultHtmlPath(){
  		return testReportsPath2;
  	}
    public static boolean isFolderExist(String folderPath){
    	File f=new File(folderPath);  
        System.out.println("Exists " + f.isDirectory());
		return f.isDirectory();
    }
    public static void createTesreportsDir(String dirPath){
    File dir = new File(dirPath);
    dir.mkdir();
    }
}

				