package one.last.time.healing;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.coloroutput.com.Colorme;

import pages.Page1;



public class TestWithPageObjects extends Base {
	
	public Page1 Page;
	
	public TestWithPageObjects() {
		super();
		System.out.println(Colorme.BLUE_BOLD_BRIGHT+"****HomePage Test Started****"+Colorme.RESET);
	}
	
	@BeforeMethod 
	public void setUp() throws Exception {
		intialization();
		//System.out.println(Colorme.BLUE_BOLD_BRIGHT+"****HomePage Test Started****"+Colorme.RESET);
		Page = new Page1();	
	}
    @Test
    public void pageObjectsTest() {
    	
    	Page.enterFirstName("Ada");
    	Page.enterLastName("Lovelace");
    	Page.enterUsername("ALovelace");
    	Page.enterCity("Orlando");
    	Page.enterState("FL");
    	Page.enterZip("32832");
    	Page.clickAcceptTerms();
    	Page.clickRegisterButton();
        assertEquals(Page.getTitle(), "Self Healing Test Page");
      
        	
        
    }
    
    @AfterMethod
    public void quit() 
    {
    	driver.quit();
    }
}