package com.guru99.kdd;

public class TestCaseExecutor {

	public static void main(String[] args) throws Exception {
		ReusableFuntion func=new ReusableFuntion();
		String [][] keywordData=func.fetchDataFromExcelsheet();
		
		for(int i=1;i<keywordData.length;i++) {
			String function=keywordData[i][3];
			String locator=keywordData[i][4];
			String locatorValue=keywordData[i][5];
			String data=keywordData[i][6];
			
			System.out.println(function+"\t"+locator+"\t"+locatorValue+"\t"+data);
			switch(function) {
				case "launchApp":
					func.launchApp();
				case "fillText":
					func.fillText(locator, locatorValue, data);
				case "click":
					func.click(locator, locatorValue);
			}
		}
		
	}

}
