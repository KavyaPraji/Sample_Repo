package practice.pom.repository;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.Homepage;

import com.crm.generic.baseutility.BaseClass_Original;

public class Create_Contact_Module_Assertion extends BaseClass_Original {

	@Test
	public void createContactTest() throws Throwable {

		// navigate to contact
		Homepage hp = new Homepage(driver);
		hp.getContactLink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewContactButton().click();

		// String LASTNAME = exu.getDataFromExcel("sheet1", 1, 4);

		String LASTNAME = fLib.getDataFromProperties("lastname");

		// create contact
		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.createContact(LASTNAME);
		ccp.getSaveContactBtn().click();

		// verify header message expected result

		String headerInfo = cp.getHeaderMsg().getText();
		boolean flag = headerInfo.contains(LASTNAME);
		Assert.assertEquals(flag, true);

		// verify header contact name info expected result

		String actuaLastName = cp.getActLastName().getText();

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actuaLastName, LASTNAME);
		System.out.println("executed createContactTest succesfully");

	}

	@Test
	public void createContactWithSupportDate() throws Throwable {
		// navigate to contact
		Homepage hp = new Homepage(driver);
		hp.getContactLink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewContactButton().click();

		// String LASTNAME = exu.getDataFromExcel("sheet1", 1, 4);

		String LASTNAME = fLib.getDataFromProperties("lastname");

		// create contact
		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.createContact(LASTNAME);

		// fetch the system date(today's date)

		String CURRENTDATE = jlib.getSystemDateInFormat();

		ccp.getStartDateEdt().clear();
		ccp.getStartDateEdt().sendKeys(CURRENTDATE);

		// fetch day after 30 days
		String LASTDATE = jlib.getRequiredDateInFormat(30);
		ccp.getEndDateEdt().clear();
		ccp.getEndDateEdt().sendKeys(LASTDATE);

		ccp.getSaveContactBtn().click();

		// verify start date and end date
		ContactInfoPage cip = new ContactInfoPage(driver);

		String actCurrentDate = cip.getStartDateInfo().getText();
		if (actCurrentDate.equals(CURRENTDATE)) {
			System.out.println(CURRENTDATE + " information is verified===PASS");
		}

		else {

			System.out.println(CURRENTDATE + " information is  not verified===FAIL");
		}

		String actEndDate = cip.getEndtDateInfo().getText();
		if (actEndDate.equals(LASTDATE)) {
			System.out.println(LASTDATE + " information is verified===PASS");
		}

		else {
			System.out.println(LASTDATE + " information is  not verified===FAIL");
		}
		System.out.println("executed createContactWithSupportDate succesfully ");

	}

	@Test
	public void createContactWithOrg() {
		System.out.println("execute createContactWithOrg succesfully");
	}

}
