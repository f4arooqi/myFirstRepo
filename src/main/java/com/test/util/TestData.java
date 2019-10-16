
package com.test.util;

	import java.util.ArrayList;

	import com.util.Xls_Reader;

	public class TestData {
		
		static Xls_Reader reader;
		
		public static ArrayList<Object[]> getDataFromexcel(){
			ArrayList<Object[]> mydata= new ArrayList<Object[]>();
			try {
				reader = new Xls_Reader("C:\\Users\\farooqi\\Desktop\\Datadriven.xlsx");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			for(int rowCnt=2; rowCnt<=reader.getRowCount("Sheet1"); rowCnt++) {
				
				String username = reader.getCellData("Sheet1", "Uname", rowCnt);
				String password = reader.getCellData("Sheet1", "Pwd", rowCnt);
				
				Object ob[] = {username, password};
				mydata.add(ob);
			}
			return mydata;
			
		}

	}


