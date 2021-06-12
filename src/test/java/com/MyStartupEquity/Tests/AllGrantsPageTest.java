package com.MyStartupEquity.Tests;

import Base.BaseTest;
import Enums.ConfigProperties;
import Pages.AllGrantsPage;
import Pages.PendingRequestPage;
import Constants.AppConstants;
import Utils.PropertyUtils.ReadProperty;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AllGrantsPageTest extends BaseTest {

    PendingRequestPage pendingRequestPage;
    AllGrantsPage allGrantsPage;

    @BeforeClass
    public void setup(){
        loginPage.doLogin(ReadProperty.getProperty(ConfigProperties.EMAIL),ReadProperty.getProperty(ConfigProperties.PASSWORD));
        pendingRequestPage = new PendingRequestPage(driver);
        allGrantsPage = pendingRequestPage.goToVestingTablePage();
    }

    @Test(priority = 1,description = "verfiying the vestingPage title")
    public void verifyVestingTablePageTitle(){
        String pageTitle = allGrantsPage.getPageHeader();
        Assert.assertEquals(pageTitle,AppConstants.ALL_GRANTS_HEADER);
    }

    @Test(priority = 2,description = "Cancelling a grant")
    public void verifyGrantCancellation(){
      boolean isCancelled =   allGrantsPage.clickCancelGrants()
        .enterCancellationReason("Grant is cancelled")
        .confirmCancellation()
        .checkSuccessMessage();
      Assert.assertTrue(isCancelled,"Grant cancellation failed ");
    }

}