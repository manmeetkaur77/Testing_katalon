# Project Documentation

## Overview
This is a dummy markdown file for the **Varuna Marine Assignment** project in Katalon Studio.

---

## Project Structure

```
Varuna_marine_assignment/
├── Test Cases/
│   ├── TC_Login
│   ├── TC_Dashboard
│   └── TC_Logout
├── Object Repository/
│   ├── LoginPage/
│   └── DashboardPage/
├── Keywords/
│   └── CustomKeywords.groovy
├── Profiles/
│   ├── default
│   └── staging
└── Test Suites/
    └── TS_RegressionSuite
```

---

## Test Cases

| Test Case ID | Description          | Status  |
|--------------|----------------------|---------|
| TC_001       | Login with valid credentials | ✅ Pass |
| TC_002       | Login with invalid credentials | ✅ Pass |
| TC_003       | Verify dashboard loads | ⏳ Pending |
| TC_004       | Logout functionality | ✅ Pass |

---

## Setup Instructions

### Prerequisites
- Katalon Studio Enterprise v11.0.1+
- Java JDK 8 or above
- Chrome / Firefox browser

### Steps to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/yourorg/Varuna_marine_assignment.git
   ```
2. Open the project in **Katalon Studio**
3. Configure the execution profile under `Profiles/default`
4. Run the test suite: `Test Suites > TS_RegressionSuite`

---

## Environment Configuration

| Key              | Value                        |
|------------------|------------------------------|
| `BASE_URL`       | `https://varuna-marine.com`  |
| `BROWSER`        | `Chrome`                     |
| `HEADLESS`       | `false`                      |
| `TIMEOUT`        | `30s`                        |

---

## Custom Keywords

### `verifyElementVisible`
Checks if a web element is visible on the page.

```groovy
@Keyword
def verifyElementVisible(TestObject obj) {
    WebUI.waitForElementVisible(obj, 10)
    WebUI.verifyElementVisible(obj)
}
```

### `loginToApp`
Performs login with given credentials.

```groovy
@Keyword
def loginToApp(String username, String password) {
    WebUI.setText(findTestObject('LoginPage/txt_Username'), username)
    WebUI.setText(findTestObject('LoginPage/txt_Password'), password)
    WebUI.click(findTestObject('LoginPage/btn_Login'))
}
```

---

## Known Issues

- [ ] TC_003 fails intermittently on slow network — add explicit wait
- [ ] Object locators need update after UI redesign in Sprint 4

---

## Author

**Manmeet Kaur**  
📧 manmeet@example.com  
🗓️ Last Updated: 16-03-2025

---

> _This file was generated for reference purposes in the Katalon Studio project context._
