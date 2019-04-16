package com.crm.utiles;

import com.crm.base.TestBase;

public class TestUtiles extends TestBase{

	public static long page_load_timeout=30;
	public static long page_implict_wait=10;
	
	public void swtchtoframe() {
		driver.switchTo().frame("mainpanel");
	}
	

}
