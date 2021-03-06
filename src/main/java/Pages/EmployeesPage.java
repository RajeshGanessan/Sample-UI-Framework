package Pages;

import Utils.PageUtils.ElementUtils;
import Utils.PageUtils.HelperComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Base.Base;

import Utils.PageUtils.DynamicXpath;

public class EmployeesPage extends Base{

	WebDriver driver;
	ElementUtils elementUtils;
	HelperComponents helperComponents;

	public EmployeesPage(WebDriver driver){
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
		helperComponents = new HelperComponents(driver);
	}


	private final By addEmpBtn = By.xpath("//button[contains(text(),'Add Employee')]");
	private final By employeePageheader = By.xpath("//div[@class='page_title']");
	private final By employeeName = By.xpath("//input[@name='new_employee_name']");
	private final By employeeId = By.xpath("//input[@name='new_employee_id']");
	private final By employeePhoneNumber = By.xpath("//input[@type='tel']");
	private final By employeeEmail = By.xpath("//input[@name='new_employee_email']");
	private final By employeeAddress = By.xpath("//textarea[@name='new_employee_reg_address']");
	private final By employeeNationalityField = By.xpath("//div[contains(@class,'select-group')]//child::div[@class=' css-1hwfws3']");
	private final By empNationality = By.xpath("//div[@class='css-1g6gooi']//child::input");
	private final By selectyear = By.xpath("//div[@class='numInputWrapper']/input");
	private final By arrowDown = By.xpath("//span[@class='arrowDown']");
	private final By calenderTitle = By.xpath("//select[@class='flatpickr-monthDropdown-months']");
	private final By joiningDate = By.xpath("//input[@placeholder='Select date']");
	private final By employeeDesignation = By.xpath("//input[@name='new_employee_designation']");
	private final By grantOptionsNavBar = By.xpath("//a[contains(text(),'Grant Options')]");
	private final By employeePanNo = By.xpath("//input[@name='new_employee_pan']");
	private final By createEmpBtn = By.xpath("//button[contains(text(),'Add Employee')]");
	private final By SuccessMessage = By.xpath("//div[@role='alert' and contains(text(),'Added Successfully')]");

	String nationalityXpath = "//div[contains(@class,'option') and contains(text(),'%replaceable%')]";

	//Get EmployeePage Heading
	public String getEmployeesPageHeader(){
		return elementUtils.doGetText(employeePageheader);
	}

	// Selecting date from calender
	public EmployeesPage selectJoiningDate() {
		helperComponents.selectDateFromCalender(arrowDown,joiningDate,calenderTitle);
		return this;
	}

	// checking successMessage
	public boolean checkSuccessMessage() {
		try{
			helperComponents.scrollIntoView(elementUtils.getElement(createEmpBtn));
			elementUtils.doClick(createEmpBtn);
			elementUtils.waitForElementVisibility(SuccessMessage);
		} catch (Exception e){
			e.printStackTrace();
		}
		return elementUtils.doIsDisplayed(SuccessMessage);
	}

	//Navigating to CreateEmployeePage
	public boolean GoToAddEmployeePage(){
		elementUtils.doClick(addEmpBtn);
		return elementUtils.doIsDisplayed(employeePageheader);
	}

	//setting EmployeeName
	public EmployeesPage setEmployeeName(String employeeNameToEnter){
		elementUtils.doSendKeys(employeeName,employeeNameToEnter);
		return this;
	}

	public EmployeesPage setEmployeeId(String employeeIdToEnter){
		elementUtils.doSendKeys(employeeId,employeeIdToEnter);
		return this;
	}

	public EmployeesPage setEmpEmail(String emailAddressToEnter){
		elementUtils.doSendKeys(employeeEmail,emailAddressToEnter);
		return this;
	}

	public EmployeesPage setEmployeePhoneNumber(String contactNumberToEnter) {
		elementUtils.doSendKeys(employeePhoneNumber,contactNumberToEnter);
		helperComponents.scrollIntoView(elementUtils.getElement(employeeDesignation));
		return this;
	}

	public EmployeesPage setEmployeeAddress(String addressToEnter){
		elementUtils.doSendKeys(employeeAddress,addressToEnter);
		return this;
	}

	public EmployeesPage selectNationality(String nationalityToSelect){
		elementUtils.doSendKeys(empNationality,nationalityToSelect);
        driver.findElement(DynamicXpath.get(nationalityXpath, nationalityToSelect)).click();
        return this;
	}

	public EmployeesPage setPanNumber(String panNoToEnter){
		elementUtils.doSendKeys(employeePanNo,panNoToEnter);
		return this;
	}

	public EmployeesPage setEmployeeDesignation(String designationToEnter){
		elementUtils.doSendKeys(employeeDesignation,designationToEnter);
		return this;
	}

	// Navigating to GrantOptionsPage
	public GrantOptionPage goToGrantOptionsPage() {
		elementUtils.clickElementByJS(grantOptionsNavBar);
		return new GrantOptionPage(driver);
	}
}
