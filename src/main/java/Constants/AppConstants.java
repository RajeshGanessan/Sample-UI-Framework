package Constants;

import java.io.File;

public class AppConstants {

    public static final String HUB_HOST = System.getProperty("HUB_HOST");

    public static final String FILEDOWNLOADPATH_CHROME = System.getProperty("user.dir") + File.separator + "MSE-Reports" +File.separator + "Chrome";
    public static final String FILEDOWNLOADPATH_FIREFOX = System.getProperty("user.dir") + File.separator + "MSE-Reports" + File.separator + "Firefox";

    public static final String EXCELFILE_PATH = System.getProperty("user.dir") + "/src/main/java/TestData/ExcelData.xlsx";

    public static final String LOGINPAGE_TITLE = "s";

    public static final String DASHBOARD_PAGE_HEADER = "ESOP Overview";

    public static final String EXITPAGE_HEADER = "Employee Exits";

    public static final String ALL_GRANTS_HEADER = "All Grants";

    public static final String REPORTS_PAGE_HEADER = "Reports";

    public static final String ESOP_HEADER = "Equity Schemes";

    public static final String VESTING_SCHEDULE_HEADER = "Vesting Schedules";

    public static final String EXERCISEOPTIONS_HEADER = "Exercise Options";

	public static final String DASHBOARD_PAGE_FOOTER = ".";

	public static final String APP_PASS = "evighxbsxmecjeiw";

    public static final String EMPLOYEES_HEADER = "Employees Book";

    public static final String GRANT_OPTIONS_HEADER = "Grant Options";

    public static final String GRANTED_OPTIONS_HEADER = "Granted Options";

    public static final String PENDING_REQUEST_HEADER = "Pending Request";


}
