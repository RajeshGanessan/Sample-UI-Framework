package com.MyStartupEquity.Tests;

import Pages.GrantOptionPage;
import Utils.ReadProperty;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.EmployeesPage;
import Utils.AppConstants;
import junit.framework.Assert;

public class grantOptionTest extends BaseTest {

	EmployeesPage employeesPage;
	GrantOptionPage grantOptionsPage;

	@BeforeClass
	public void setup() {
//		getData = new ExcelUtils("GrantOptions");
		loginPage.doLogin(ReadProperty.getProperty("email"),ReadProperty.getProperty("password"));
		employeesPage = new EmployeesPage(driver);
		grantOptionsPage = employeesPage.goToGrantOptionsPage();
	}

	@Test(priority = 1, description = "Checking grant Options page header")
	public void checkGrantOptionsHeader() {
		String grantOptionsHeader = grantOptionsPage.getPageHeader();
		Assert.assertEquals(AppConstants.GRANT_OPTIONS_HEADER,grantOptionsHeader);
	}

	@Test(priority = 2,description ="Creating Existing Grant")
	public void createExistingGrant() {
		grantOptionsPage.selectEmployeeFromList("success");
		grantOptionsPage.selectEquityScheme("ESOP 2021");
		grantOptionsPage.setSelectVestingField("Vesting annual");
		grantOptionsPage.selectTypeOfGrant(GrantOptionPage.GrantType.EXISTINGGRANT);
		grantOptionsPage.uploadGrantLetter();
		grantOptionsPage.selectGrantDate("Existing");
		grantOptionsPage.enterOptionsGranted("30");
		grantOptionsPage.enterExercisePrice("120.45");
		grantOptionsPage.confirmGrant();
		Assert.assertTrue("Existing Grant Creation Failed", grantOptionsPage.checkSuccessMessage());
	}

	@Test(priority = 3,description="Creating Fresh Grant",invocationCount = 2)
	public void createFreshGrant() {
		grantOptionsPage.clearAndRefresh();
		grantOptionsPage.selectEmployeeFromList("success");
		grantOptionsPage.selectEquityScheme("ESOP 2021");
		grantOptionsPage.setSelectVestingField("Vesting annual");
		grantOptionsPage.selectTypeOfGrant(GrantOptionPage.GrantType.FRESHGRANT);
		grantOptionsPage.selectGrantDate("Fresh");
		grantOptionsPage.enterOptionsGranted("30");
		grantOptionsPage.enterExercisePrice("120.45");
		grantOptionsPage.confirmGrant();
		Assert.assertTrue("Fresh Grant Creation Failed", grantOptionsPage.checkSuccessMessage());
	}
}