package com.affluence.java.util.reports;



import java.io.FileOutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;


import com.affluence.java.util.ImageDetailsBean;
import com.affluence.java.util.Page;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;

import com.itextpdf.text.pdf.BaseFont;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


/**
 * @author satheesh.guduru
 *
 */
public class GenerateReport extends Page{
	
	 public static  Document document=null;
	 static ImageDetailsBean imageDetailsBean=null;
	 
    /**
     * @param testName
     */
    public static void generatePdfReport(String testName) throws Exception  {
    	
        
        		document=new Document();
        		PdfWriter.getInstance(document,new FileOutputStream(testReportsPath+"/"+testName+".pdf"));
         	   document.open();
        	//   System.out.println("screenDetails.size()---->"+screenDetails.size());
        	   @SuppressWarnings("rawtypes")
        	   Set s=screenDetails.keySet();
        	   @SuppressWarnings("rawtypes")
        	   Iterator itr=s.iterator();
        	   boolean flag=true;
        	   while(itr.hasNext()){
        		   	int key=Integer.parseInt(itr.next().toString());
        		   	//System.out.println("key is---->"+key);
        		   	imageDetailsBean=(ImageDetailsBean) screenDetails.get(key);
        		   	String stringlogoPath="TestResults/images/index.jpg";
        		    Image image = Image.getInstance(imageDetailsBean.getImagePath().toString());
        		   image.scaleAbsolute(300, 450);
        		   image.setCompressionLevel(7);
        		   String screenDetail=imageDetailsBean.getStepDescription()+"  ";
        		   if(flag){
        			   Image imageLogo = Image.getInstance(stringlogoPath);
        			   imageLogo.scaleAbsolute(140,30);
        			   Paragraph logoPara=new Paragraph();
        			   logoPara.add(imageLogo);
        			   document.add(logoPara);
        			   Paragraph testNamePara=new Paragraph(imageDetailsBean.getFromTest().toUpperCase());
        			   testNamePara.setAlignment(Paragraph.ALIGN_CENTER);
        			   document.add(testNamePara);
        			   Paragraph headerPara=new Paragraph(new Date().toString());
        			   headerPara.setAlignment(Paragraph.ALIGN_RIGHT);
        			   document.add(headerPara);  
        			   flag=false;
        		   }
        		   PdfPTable table = new PdfPTable(1);
        		   PdfPCell table_cell;
        		   table_cell=new PdfPCell();
        		   table_cell.addElement(image);
        		   table.addCell(table_cell);
        		   Paragraph paragraph=new Paragraph(screenDetail);
        		   paragraph.setAlignment(Paragraph.ALIGN_LEFT);
        		   BaseFont bf=BaseFont.createFont();
        	       Font f= new Font(bf, 11.2f, 2, BaseColor.BLUE);
        	       paragraph.setFont(f);
        	       if(!imageDetailsBean.getPurpose().split(":")[0].equals("notrequired")){
        	    	   paragraph.add("{"+imageDetailsBean.getPurpose().split(":")[0]+"}");
        	       }
        	          if(imageDetailsBean.getPurpose().split(":")[1].equals("passed")){
        	        	  Font f1= new Font(bf, 11.2f, 2, BaseColor.GREEN);
        	        	  paragraph.setFont(f1);
        	        	  paragraph.add(" :"+imageDetailsBean.getPurpose().split(":")[1]);
        	          }else{
        	        	  Font f1= new Font(bf, 11.2f, 2, BaseColor.RED);
         	             	paragraph.setFont(f1);
         	             	paragraph.add(" :"+imageDetailsBean.getPurpose().split(":")[1]);
         	            
        	          }
        	          paragraph.add(table);
        	          document.add(paragraph);
        	          document.newPage();
        	   }
        	   	document.close();
       
        
    }
   
}
/*
 *
 *  String filePath=screenShotsPath+testName;
    	System.out.println("File path--->"+filePath);
    	final File dir = new File(filePath);
    	// array of supported extensions (use a List if you prefer)
        final String[] EXTENSIONS = new String[]{
            "gif", "png", "bmp" // and other formats you need
        };
        // filter to identify images based on their extensions
        final FilenameFilter IMAGE_FILTER = new FilenameFilter() {

            @Override
            public boolean accept(final File dir, final String name) {
                for (final String ext : EXTENSIONS) {
                    if (name.endsWith("." + ext)) {
                        return (true);
                    }
                }
                return (false);
            }
        };
  if (dir.isDirectory()) { // make sure it's a directory
 
for (final File f : dir.listFiles(IMAGE_FILTER)) {
    BufferedImage img = null;
    //img = ImageIO.read(f);
    System.out.println(f.getName());
    Image image = Image.getInstance(f.getAbsolutePath());
    
    image.scaleAbsolute(400f,500f );
	   document.add(new Paragraph("textdata"));
	   
	   document.add(image);
	  
}
document.close();
}*/