/**
 * @author fendyridwan
 * Creating Listener
 */
package bases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listener implements ITestListener {
	static FileInputStream fis;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	public static ArrayList<String> resultFail = new ArrayList<String>();
	public static String[] split;
	public static String word ="";
	public static String[] splitWord;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("------" + result.getName() + "------");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("-Pass-");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		BaseWeb bw = new BaseWeb();
		try {
			FileUtils.copyFile(bw.getscreenshot(), new File("screenshot/" + result.getName() + ".jpg"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(result.getThrowable().getMessage());
		System.out.println("-Fail-");
		
		((ArrayList<String>) resultFail).add(result.getName()+"-"+result.getThrowable().getMessage());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
	 
	 try {
			File src = new File("TestCase.xlsx");
			
			fis = new FileInputStream(src);
 		
	 		wb = new XSSFWorkbook(fis);
	 		
	 		sheet = wb.getSheetAt(0);
	     
		    int lastrownumber = sheet.getLastRowNum();

			String getCaseNameonExcel;
			String passResultFromContext = context.getPassedTests().getAllMethods().toString();
			String failResultFromContext = context.getFailedTests().getAllMethods().toString();
			//String skipResultFromContext = context.getSkippedTests().getAllMethods().toString();
			//System.out.println(lastrownumber);

			for(int countRow = 1;countRow<=lastrownumber;countRow++){
				XSSFRow row = sheet.getRow(countRow);
				
				getCaseNameonExcel = row.getCell(1).toString();
				
				/*if(countRow==80) {
					System.out.println("masuk");
				}*/
				//System.out.println(countRow+"-"+getCaseNameonExcel);
				row.getCell(9).setCellValue("-");
				row.getCell(10).setCellValue("-");
				row.getCell(11).setCellValue("-");
				if(getCaseNameonExcel.length()<1||getCaseNameonExcel.isEmpty()||getCaseNameonExcel.equals(""))
				{
					try {
					row.getCell(9).setCellValue("-");
					row.getCell(10).setCellValue("-");
					row.getCell(11).setCellValue("-");
					}catch(Exception e) {
						System.out.println("skip"+e);
					}
					
				}else
				if(passResultFromContext.contains(getCaseNameonExcel)) 
				{
					try {
						
						row.getCell(9).setCellValue("PASS");
						row.getCell(10).setCellValue("-");
						row.getCell(11).setCellValue("-");
					}catch(Exception e) {
						System.out.println("pass"+e);
					}
					
					
				}else 
					if(failResultFromContext.contains(getCaseNameonExcel)) 
					{
						//row.getCell(1).toString();
						row.getCell(9).setCellValue("FAIL");
						row.getCell(10).setCellValue(getCaseNameonExcel+".jpg");
						int count = 0; 		
					      while (resultFail.size() > count) {
					    	  word = resultFail.get(count);
							  splitWord = word.split("-");
					         count++;
					      }
						if(splitWord[0].equals(getCaseNameonExcel)) {
							row.getCell(11).setCellValue(splitWord[1]);
						}
						
						//System.out.println(countRow+" FAIL");
					}/*else {
						System.out.println("masuk skip3");
						//row.getCell(testResult).setCellValue("-");
						try {
							row.getCell(9).setCellValue("-");
							row.getCell(10).setCellValue("-");
							row.getCell(11).setCellValue("-");
						}catch(Exception e) {
							System.out.println("error "+e);
						}
						
					}*/

				
			}
			FileOutputStream fout = new FileOutputStream(src);
			wb.write(fout);
	        fis.close();
	        fout.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	

	}

}