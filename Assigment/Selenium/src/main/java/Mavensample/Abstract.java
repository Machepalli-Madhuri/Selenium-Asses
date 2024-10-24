package Mavensample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Abstract {

		// TODO Auto-generated method stub
		protected WebDriver driver;

		public Abstract(WebDriver driver) {
			
			this.driver = driver;
			PageFactory.initElements(driver, this);
			
		}
	}

