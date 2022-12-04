import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils

/*------------------------------------------------------------------------------------------------
 * SUMMARY: Order single product
 *
 * STEPS:
 * 1. 
 * 2. 
 * 3. 
 * 4.
 * 
 * TEARDOWN:
 * - N/A
 *------------------------------------------------------------------------------------------------*/

/*------------------------------------------------------------------------------------------------
 * TEST DATA
 *------------------------------------------------------------------------------------------------*/

def firstName = 'FirstName ' + RandomStringUtils.randomAlphabetic(3)
def lastName = 'LastName' + RandomStringUtils.randomAlphabetic(5)
def email = firstName + '@mailinator.com'
def address1 = RandomStringUtils.randomAlphabetic(20)
def address2 = RandomStringUtils.randomAlphabetic(20)
def city = RandomStringUtils.randomAlphabetic(5)
def companyName = RandomStringUtils.randomAlphanumeric(5)
def phone = RandomStringUtils.randomNumeric(12)
def postCode = RandomStringUtils.randomNumeric(5)
def prdName1 = 'Pink Drop'

//Navigate to url and Search Product
WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('https://' + GlobalVariable.baseUrl + '/', FailureHandling.STOP_ON_FAILURE)
WebUI.verifyMatch(WebUI.getUrl(), ('https://' + GlobalVariable.baseUrl) + '/', true, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Home/link_Search'), GlobalVariable.DelayShort, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/Page_Home/link_Search'))
WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Home/input_Search'), GlobalVariable.DelayShort,)
WebUI.setText(findTestObject('Object Repository/Page_Home/input_Search'), prdName1, FailureHandling.STOP_ON_FAILURE)
WebUI.sendKeys(findTestObject('Object Repository/Page_Home/input_Search'), Keys.chord(Keys.ENTER))

//Cosumize product and add to cart
WebUI.verifyMatch(WebUI.getUrl(), ('https://' + GlobalVariable.baseUrl) + '/product/pink-drop-shoulder-oversized-t-shirt/', true, FailureHandling.STOP_ON_FAILURE)








