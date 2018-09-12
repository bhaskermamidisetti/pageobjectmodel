package com.affluence.java.util.reports;

import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import com.affluence.java.util.ImageDetailsBean;
import com.affluence.java.util.Page;

public class GenerateHTMLReport extends Page{
	 static ImageDetailsBean imageDetailsBean=null;
	
	public static void generateHtmlReport(String testName){
	
	try{
		
		@SuppressWarnings("rawtypes")
		Set s=screenDetails.keySet();
  	    @SuppressWarnings("rawtypes")
		Iterator itr=s.iterator();
  	    boolean flag=true;
  	    String plusImagePath=null;
  	    StringBuilder sb = new StringBuilder();
		sb.append("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
		sb.append("<html>");
		sb.append("\n");
		sb.append("<head>");
		sb.append("\n");
		sb.append("<script type='text/javascript' >" );
		sb.append("\n");
		sb.append("function expandFunction(id,path){");
		sb.append("\n");
		sb.append("	 // alert(document.getElementById('img-plus-'+id).src.indexOf('plus'));");
		sb.append("\n");
		sb.append("	  if(document.getElementById('img-plus-'+id).src.indexOf('plus')!=-1){");
		sb.append("\n");
		sb.append("    document.getElementById('img-span-'+id).style.display='';");
		sb.append("\n");
		sb.append("    document.getElementById('img-plus-'+id).src=path+'images/minus.gif';");
		sb.append("\n");
		sb.append("\n");
		sb.append("\n");
		sb.append("  }else{");
		sb.append("\n");
		sb.append("	  document.getElementById('img-span-'+id).style.display='none';");
		sb.append("\n");
		sb.append("	    document.getElementById('img-plus-'+id).src=path+'images/plus.gif';");
		sb.append("\n");
		sb.append("\n");
		sb.append("  }");
		sb.append("\n");
		sb.append("\n");
		sb.append("  }");
		sb.append("\n");
		sb.append("function expandAll(imagePath){");
		sb.append("\n");
		sb.append("	  spans=document.getElementsByTagName('span');");
		sb.append("\n");
		sb.append("	  for(i=0;i<spans.length;i++){");
		sb.append("\n");
		sb.append("	    if(spans[i].id.indexOf('img')!=-1){");
		sb.append("\n");
		sb.append("	    	spans[i].style.display='';");
		sb.append("\n");
		sb.append("	      	splitIds=spans[i].id.split('-');");
		sb.append("\n");
		sb.append("	      	imgId=splitIds[0]+'-plus-'+splitIds[2];	");
		sb.append("\n");
		sb.append("         	 document.getElementById(imgId).src=imagePath+'images/minus.gif';");
		sb.append("\n");
		sb.append("	    }");
		sb.append("\n");
		sb.append("      }");
		sb.append("\n");
		sb.append("  }");
		sb.append("\n");
		sb.append("\n");
		sb.append(" function contractAll(imagePath){");
		sb.append("\n");
		sb.append("	  spans=document.getElementsByTagName('span');");
		sb.append("\n");
		sb.append("	  for(i=0;i<spans.length;i++){");
		sb.append("\n");
		sb.append("	    if(spans[i].id.indexOf('img')!=-1){	    	");
		sb.append("\n");
		sb.append("	    	spans[i].style.display='none';");
		sb.append("\n");
		sb.append("	      	splitIds=spans[i].id.split('-');");
		sb.append("\n");
		sb.append("	      	imgId=splitIds[0]+'-plus-'+splitIds[2];");
		sb.append("\n");
		sb.append("	      	 document.getElementById(imgId).src=imagePath+'images/plus.gif';");
		sb.append("\n");
		sb.append("	    }");
		sb.append("\n");
		sb.append("      }");
		sb.append("\n");
		sb.append("  }  ");
		sb.append("\n");
		sb.append("</script>");
		sb.append("\n");
		sb.append("<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>");
		sb.append("\n");
		sb.append("<title>Insert title here</title>");
		sb.append("\n");
		sb.append("</head>");
		sb.append("\n");
		sb.append("<body style='min-height:783px;border: thin double #000000;''>");
		sb.append("\n");
		sb.append("<table  width='100%' height='100%' >");
		sb.append("\n");
		sb.append("		<tr>");
		sb.append("\n");
		sb.append("				<td>");
		sb.append("\n");
		sb.append("					<table>");
		sb.append("\n");
		sb.append("						<tr>");
		sb.append("\n");
		sb.append("							<td>");
		sb.append("\n");
		sb.append("		 					<span ><img align='top'   id='seneca-logo' width='60%' height='70%'></span>");
		sb.append("\n");
		sb.append(" 		                  </td>");
		sb.append("\n");
		sb.append(" 		                 </tr>");
		sb.append("\n");
		sb.append(" 		              </table>");
		sb.append("\n");
		sb.append("          </tr>");
		sb.append("\n");
		sb.append("          <tr><td>");
		sb.append("\n");
		sb.append("     <table border='2' bgcolor='#759294' width='100%' height='60%' cellpadding='0' cellspacing='0'>");
		sb.append("\n");
		while(itr.hasNext()){
			int key=Integer.parseInt(itr.next().toString());
			imageDetailsBean=(ImageDetailsBean) screenDetails.get(key);
			if(flag){
				plusImagePath=getImagesPath(imageDetailsBean.getImagePath().toString());
				//System.out.println("plusImagePath---->"+plusImagePath);
				sb.append("<tr>");
				sb.append("\n");
				sb.append("<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><font  size='4'>"+imageDetailsBean.getFromTest().toUpperCase()+"</font></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
				sb.append(new Date().toString()+"</td>");
				sb.append("\n");
				sb.append("</tr>");
				sb.append("\n");
				sb.append("</table>");
				sb.append("\n");
				sb.append("<table  align='right' >");
				sb.append("\n");
				sb.append("<tr>");
				sb.append("<td colspan='2'><span><a href='#' onclick=\"javascript:expandAll('"+plusImagePath+"')\">Expand all</a></span>&nbsp;&nbsp;&nbsp;<span><a href='#' onclick=\"javascript:contractAll('"+plusImagePath+"')\">Contract all</a></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>");
				sb.append("\n");
				sb.append("</tr>");
				sb.append("\n");
				sb.append("</table>");
				sb.append("</td></tr>");
				sb.append("<tr><td style='vertical-align: top;''>");
		         
				sb.append("\n");
				sb.append("<table width='100%' >");
				
				flag=false;		
			}
			sb.append("\n");
			sb.append("<tr>");
			sb.append("\n");
			sb.append("<td></td>");
			sb.append("\n");
			sb.append("</tr>");
			sb.append("\n");
			sb.append("<tr>");
			sb.append("\n");;
			sb.append("<td></td>");
			sb.append("\n");
			sb.append("</tr>");
			sb.append("\n");
			sb.append("<tr>");
			sb.append("\n");
			sb.append("<td><span ><a id='span-"+key+"' alt ='click to expand'  onmouseover=\"\" style=\"cursor: pointer;\" onclick=\"expandFunction('"+key+"','"+plusImagePath+"');\"><img  src='"+plusImagePath+"images/plus.gif' id='img-plus-"+key+"'></img></a></span>&nbsp;&nbsp;&nbsp;<font  size='3'>"+imageDetailsBean.getStepDescription()+"</font>");
			if(!imageDetailsBean.getPurpose().split(":")[0].equals("notrequired")){
				sb.append("&nbsp;&nbsp;&nbsp;{<font color='blue' size='4'>"+imageDetailsBean.getPurpose().split(":")[0]+"</font>}");
			}
			if(imageDetailsBean.getPurpose().split(":")[1].equals("passed")){
				sb.append(" : <font color='green' size='4'>"+imageDetailsBean.getPurpose().split(":")[1]+"</font>");
			}else{
				sb.append(" : <font color='red' size='4'>"+imageDetailsBean.getPurpose().split(":")[1]+"</font>");
			}
		//	sb.append(" &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Time : [ <b><font color='#B45F04' size='2'>"+imageDetailsBean.getStepExecutionTime()+" Sec </font></b>]");
			                                                                                                                                                                                                        			                          
			sb.append("</td>");
			sb.append("\n");
			sb.append("</tr>");
			sb.append("\n");
			sb.append("<tr>");
			sb.append("\n");
			sb.append("<td></td>");
			sb.append("\n");
			sb.append("</tr>");
			sb.append("\n");
			sb.append("<tr>");
			sb.append("\n");
			sb.append("<td></td>");
			sb.append("\n");
			sb.append("</tr>");
			sb.append("\n");
			sb.append("<tr>");
			sb.append("\n");
			sb.append("<td></td>");
			sb.append("\n");
			sb.append("</tr>");
			sb.append("\n");
			sb.append("<tr>");
			sb.append("\n");
			sb.append("<td></td>");
			sb.append("\n");
			sb.append("</tr>");
			sb.append("\n");
			sb.append("<tr>");
			sb.append("\n");
			sb.append("<td><span id='img-span-"+key+"' style='display: none;'><table frame='box' width='80%' ><tr><td><img src='"+key+".png' width='100%' ></img></td></tr></table></span></td>");
			sb.append("\n");
			sb.append("</tr>");
			sb.append("\n");
			sb.append("<tr>");
			sb.append("\n");
			sb.append("<td></td>");
			sb.append("\n");
			sb.append("</tr>");
			sb.append("\n");
			sb.append("<tr>");
			sb.append("\n");
			sb.append("<td></td>");
			sb.append("\n");
			sb.append("</tr>");
			sb.append("\n");
			sb.append("<tr>");
			sb.append("\n");
			sb.append("<td></td>");
			sb.append("\n");
			sb.append("</tr>");
			sb.append("\n");
			sb.append("<tr>");
			sb.append("\n");
			sb.append("<td></td>");
			sb.append("\n");
			sb.append("</tr>");
			sb.append("\n");
			sb.append("<tr>");
			sb.append("\n");
			sb.append("<td></td>");
			sb.append("\n");
			sb.append("</tr>");
			sb.append("\n");
			sb.append("<tr>");
			sb.append("\n");
			sb.append("<td></td>");
			sb.append("\n");
			sb.append("</tr>");
			sb.append("\n");
		}
				  
		sb.append("     </table>");
		sb.append("</td></tr>");		
		sb.append("</table>");
		sb.append("\n");
		sb.append("</body>");
		sb.append("\n");
		sb.append("<script type='text/javascript' >" );
		sb.append("\n");
		sb.append("document.getElementById('seneca-logo').src='"+plusImagePath+"images/index.jpg';");
		sb.append("\n");
		sb.append("document.title='"+testName+"';");
		sb.append("\n");
		sb.append("</script>" );
		sb.append("\n");
		sb.append("</html>");
		PrintWriter writer = new PrintWriter(testReportsPath+"/"+testName+".html", "UTF-8");
		writer.println(sb);
		writer.close();
	}catch(Exception e){
		e.printStackTrace();
	}
  }
	
}
