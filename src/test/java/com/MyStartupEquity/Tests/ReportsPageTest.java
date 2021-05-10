package com.MyStartupEquity.Tests;

import Base.BaseTest;
import Pages.AllGrantsPage;
import Pages.ReportsPage;
import Utils.AppConstants;
import Utils.DataUtil.DataProviderManager;
import Utils.ReadProperty;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReportsPageTest extends BaseTest {

    AllGrantsPage allGrantsPage;
    ReportsPage reportsPage;

    @BeforeClass
    public void setup(){
        loginPage.doLogin(ReadProperty.getProperty("email"),ReadProperty.getProperty("password"));
        allGrantsPage = new AllGrantsPage(driver);
        reportsPage = allGrantsPage.goToReportsPage();
    }

    @Test(priority = 1, description = "verifying ReportsPage header")
    public void verifyReportsPageHeader(){
      String reportPageHeader = reportsPage.getReportPageHeader();
      Assert.assertEquals(reportPageHeader,AppConstants.REPORTS_PAGE_HEADER,"Page header verification failed");
    }

    @Test(priority = 2,description = "verify Grant-Report")
    public void verifyGrantReport(){
        reportsPage.SelectReportType("Grant Report");
        reportsPage.selectStartDate("January","1");
        reportsPage.selectEndDate();
         boolean isFileDownloaded = reportsPage.verifyFileDownload(AppConstants.fileDownloadPath);
         Assert.assertTrue(isFileDownloaded);
    }

    @Test(priority = 3,description = "verify Transaction",dataProvider = "TransactionTypes",dataProviderClass = DataProviderManager.class)
    public void verifyTransactionReport(String transactionType){
        reportsPage.SelectReportType("Transactions Report",transactionType);
        reportsPage.selectStartDate("January","1");
        reportsPage.selectEndDate();
        boolean isFileDownloaded = reportsPage.verifyFileDownload(AppConstants.fileDownloadPath);
        Assert.assertTrue(isFileDownloaded);
    }

    @AfterMethod(description = "Deleting the Downloaded Reports")
    public void deleteReportFile(){
        reportsPage.isFileDeleted();
    }
}