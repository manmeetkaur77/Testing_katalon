package com.varuna.marine.keywords

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.driver.DriverFactory

/**
 * CustomKeywords.groovy
 * Project  : Varuna Marine Assignment
 * Author   : Manmeet Kaur
 * Created  : 16-03-2025
 * Description: Reusable custom keywords for Varuna Marine web application testing
 */

public class CustomKeywords {

    // ─────────────────────────────────────────
    // 🔐 LOGIN KEYWORDS
    // ─────────────────────────────────────────

    /**
     * Login to the Varuna Marine application
     * @param username - valid username string
     * @param password - valid password string
     */
    @Keyword
    def loginToApp(String username, String password) {
        try {
            WebUI.setText(findTestObject('LoginPage/txt_Username'), username)
            WebUI.setText(findTestObject('LoginPage/txt_Password'), password)
            WebUI.click(findTestObject('LoginPage/btn_Login'))
            KeywordUtil.logInfo("Login attempted with user: ${username}")
        } catch (Exception e) {
            KeywordUtil.markFailed("Login failed: ${e.getMessage()}")
        }
    }

    /**
     * Logout from the application
     */
    @Keyword
    def logoutFromApp() {
        WebUI.click(findTestObject('Header/btn_UserMenu'))
        WebUI.click(findTestObject('Header/btn_Logout'))
        KeywordUtil.logInfo("User logged out successfully")
    }

    // ─────────────────────────────────────────
    // 🔍 ELEMENT VERIFICATION KEYWORDS
    // ─────────────────────────────────────────

    /**
     * Verify if an element is visible on the page
     * @param obj - TestObject to verify
     * @param timeout - wait timeout in seconds
     */
    @Keyword
    def verifyElementVisible(TestObject obj, int timeout = 10) {
        boolean isVisible = WebUI.waitForElementVisible(obj, timeout)
        if (isVisible) {
            KeywordUtil.logInfo("Element is visible: ${obj.getObjectId()}")
        } else {
            KeywordUtil.markFailed("Element NOT visible: ${obj.getObjectId()}")
        }
    }

    /**
     * Verify page title matches expected
     * @param expectedTitle - expected page title string
     */
    @Keyword
    def verifyPageTitle(String expectedTitle) {
        String actualTitle = WebUI.getWindowTitle()
        WebUI.verifyEqual(actualTitle, expectedTitle)
        KeywordUtil.logInfo("Page title verified: ${actualTitle}")
    }

    // ─────────────────────────────────────────
    // 🧭 NAVIGATION KEYWORDS
    // ─────────────────────────────────────────

    /**
     * Navigate to a specific module in the app
     * @param moduleName - name of the module (e.g., 'Dashboard', 'Vessels', 'Reports')
     */
    @Keyword
    def navigateToModule(String moduleName) {
        switch (moduleName.toLowerCase()) {
            case 'dashboard':
                WebUI.click(findTestObject('Navbar/lnk_Dashboard'))
                break
            case 'vessels':
                WebUI.click(findTestObject('Navbar/lnk_Vessels'))
                break
            case 'reports':
                WebUI.click(findTestObject('Navbar/lnk_Reports'))
                break
            default:
                KeywordUtil.markFailed("Module '${moduleName}' not found in navigation")
        }
        KeywordUtil.logInfo("Navigated to module: ${moduleName}")
    }

    // ─────────────────────────────────────────
    // 📋 FORM KEYWORDS
    // ─────────────────────────────────────────

    /**
     * Fill a form field with given value
     * @param obj - input TestObject
     * @param value - value to enter
     */
    @Keyword
    def fillFormField(TestObject obj, String value) {
        WebUI.clearText(obj)
        WebUI.setText(obj, value)
        KeywordUtil.logInfo("Field filled with value: ${value}")
    }

    /**
     * Select dropdown option by visible text
     * @param obj - dropdown TestObject
     * @param optionText - visible text of the option
     */
    @Keyword
    def selectDropdownOption(TestObject obj, String optionText) {
        WebUI.selectOptionByLabel(obj, optionText, false)
        KeywordUtil.logInfo("Selected dropdown option: ${optionText}")
    }

    // ─────────────────────────────────────────
    // 🛠️ UTILITY KEYWORDS
    // ─────────────────────────────────────────

    /**
     * Take screenshot with a custom name
     * @param screenshotName - name for the screenshot file
     */
    @Keyword
    def captureScreenshot(String screenshotName) {
        WebUI.takeScreenshot("Reports/Screenshots/${screenshotName}_${new Date().format('yyyyMMdd_HHmmss')}.png")
        KeywordUtil.logInfo("Screenshot captured: ${screenshotName}")
    }

    /**
     * Wait for page to fully load
     * @param timeout - max wait time in seconds
     */
    @Keyword
    def waitForPageLoad(int timeout = 30) {
        WebUI.waitForPageLoad(timeout)
        KeywordUtil.logInfo("Page loaded within ${timeout} seconds")
    }

    /**
     * Scroll to a specific element
     * @param obj - TestObject to scroll into view
     */
    @Keyword
    def scrollToElement(TestObject obj) {
        WebUI.scrollToElement(obj, 5)
        KeywordUtil.logInfo("Scrolled to element: ${obj.getObjectId()}")
    }
}
