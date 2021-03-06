/* File name: HW2.java
 * Project name: NCKU-LOSP-TEAM1 project
 * Environment: Eclipse
 * Student ID: F74002206
 * Description: 
 * 		This is a project to parser web site of lecture info, 
 * 		(URL�Btitle�Btime�Blocation...)
 * Design Pattern: 
 * 		1.Simple Factory   
 *  	2.Iterator
 * */

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public class ParserMain
{
	/*simple Factory: Use only one class to get all other web page(object)*/
	public static WebPage getWeb(int i){
		WebPage webPage = null;
		if(i==1)
			webPage = new Business();
		else if(i==2)
			webPage = new Economics();
		else if(i==3)
			webPage = new Engineer();
		else if(i==4)
			webPage = new PoliticalEconomy();
		else if(i==5)
			webPage = new NCKUSpeech();
		else if(i==6)
			webPage = new NCKUSpeechTwo();
		else if(i==7)
			webPage = new NCKUSpeechThree();
		else if(i==8)
			webPage = new NCKUSpeechFour();
		else if(i==9)
			webPage = new NCKUSpeechFive();
		else if(i==10)
			webPage = new NCKUSpeechSix();
		else if(i==11)
			webPage = new CSIE();
		else if(i==12)
			webPage = new NCTSSouth();
		else if(i==13)
			webPage = new statistic();
		return webPage;
	}

	/*Iterator Design pattern to print out the result*/
	public static void foreach(Collection<WebPageInterface.DataUnit> collection) {

		Iterator<WebPageInterface.DataUnit> iterator = collection.iterator();
		WebPageInterface.DataUnit Data;
		
		while(iterator.hasNext()) {
			Data = iterator.next();
			System.out.println(Data.getTime());
			System.out.println(Data.getTitle());
		}
		
	}
	public static void main(String[] args) throws IOException, Exception
	{
		/* URL:
		 * 	1.Business 2.Economics 3.Engineer 4.Political Economics
		 * 	11.CSIE 12.NCTSSouth
		 */
		String url[] = { 
				"",
				"http://www.ba.ncku.edu.tw/design/index.php",
				"http://economics.ncku.edu.tw/seminar.asp",
				"http://www.eng.ncku.edu.tw/files/13-1283-101409.php",
				"http://www.gipe.ncku.edu.tw/newslists.asp?clsid=1&title=%BAt%C1%BF%B0T%AE%A7",
				"http://apps.acad.ncku.edu.tw/lecture/main/show_list_goto.php?deptno=&page=1",
				"http://apps.acad.ncku.edu.tw/lecture/main/show_list_goto.php?deptno=&page=2",
				"http://apps.acad.ncku.edu.tw/lecture/main/show_list_goto.php?deptno=&page=3",
				"http://apps.acad.ncku.edu.tw/lecture/main/show_list_goto.php?deptno=&page=4",
				"http://apps.acad.ncku.edu.tw/lecture/main/show_list_goto.php?deptno=&page=5",
				"http://apps.acad.ncku.edu.tw/lecture/main/show_list_goto.php?deptno=&page=6",
				"http://www.csie.ncku.edu.tw/new/nckucsie/index.php?content=speechntalk&year=102_1",
				"http://www.ncts.ncku.edu.tw/",
				"http://www.stat.ncku.edu.tw/news/speech.asp"
		};

		
		for(int i = 1; i <= 13; i++){
			if(i != 2 && i != 4){
				/*use "polymorphism" to get child web page*/	
			
				WebPage webPage = getWeb(i);
				webPage.setURL(url[i]);
			
				/*parse and store data*/
				webPage.parsingData();		
			
				/*by ascending*/
				webPage.sortByTime();
		
				/*print out the result*/
				foreach(webPage.getDataUnit());
			}
			else
			{
				WebPage webPage = getWeb(i);
				webPage.setURL(url[i]);
			
				/*parse and store data*/
				webPage.parsingData();								
		
				/*print out the result*/
				foreach(webPage.getDataUnit());
			}
			System.out.println();
		}			
	}

}

