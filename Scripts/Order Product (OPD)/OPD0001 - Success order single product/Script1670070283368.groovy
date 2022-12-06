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
 * GIVEN User add product to the cart
 * WHEN User confirm and checkout the product
 * THEN User shall be able to purchase product
 *
 * STEPS:
 * 1. Navigate to url and Search Product
 * 2. Costumize product and add to cart
 * 3. Verify product data match and Proceed to Checkout
 * 4. Input billing details and Place Order
 * 
 * TEARDOWN:
 * - N/A
 *------------------------------------------------------------------------------------------------*/

/*------------------------------------------------------------------------------------------------
 * TEST DATA
 *------------------------------------------------------------------------------------------------*/

def firstName = 'FirstName' + RandomStringUtils.randomAlphabetic(3)
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

//Costumize product and add to cart
WebUI.verifyMatch(WebUI.getUrl(), ('https://' + GlobalVariable.baseUrl) + '/product/pink-drop-shoulder-oversized-t-shirt/', true, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Product1/select_ColorOption'), GlobalVariable.DelayShort)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Product1/select_ColorOption'), 'Pink', false, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyOptionSelectedByLabel(findTestObject('Object Repository/Page_Product1/select_ColorOption'), 'Pink', false, GlobalVariable.DelayShort, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Product1/select_SizeOption'), GlobalVariable.DelayShort)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Product1/select_SizeOption'), '37', false, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyOptionSelectedByLabel(findTestObject('Object Repository/Page_Product1/select_SizeOption'), '37', false, GlobalVariable.DelayShort, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Product1/input_Qty'), GlobalVariable.DelayShort)
WebUI.setText(findTestObject('Object Repository/Page_Product1/input_Qty'), '2', FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Product1/button_AddtoCart'), GlobalVariable.DelayShort)
WebUI.click(findTestObject('Object Repository/Page_Product1/button_AddtoCart'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_Product1/input_Qty'), 'Value', '2', GlobalVariable.DelayShort, FailureHandling.STOP_ON_FAILURE)
def productName = WebUI.getText(findTestObject('Object Repository/Page_Product1/label_ProductName'))
def productPrice = WebUI.getText(findTestObject('Object Repository/Page_Product1/label_ProductPrice'))
def productColor = WebUI.getAttribute(findTestObject('Object Repository/Page_Product1/select_ColorOption'), 'value')
def productSize = WebUI.getAttribute(findTestObject('Object Repository/Page_Product1/select_SizeOption'), 'value')
def productQty= WebUI.getAttribute(findTestObject('Object Repository/Page_Product1/input_Qty'), 'value')
def cpltProductName = productName + ' - ' + productColor.toUpperCase()

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Product1/button_ViewCart'), GlobalVariable.DelayShort)
WebUI.click(findTestObject('Object Repository/Page_Product1/button_ViewCart'), FailureHandling.STOP_ON_FAILURE)

//Verify product data match and Proceed to Checkout
WebUI.verifyMatch(WebUI.getUrl(), ('https://' + GlobalVariable.baseUrl) + '/cart/', true, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementText(findTestObject('Object Repository/Page_Cart/label_ProductNameColor'), cpltProductName, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementText(findTestObject('Object Repository/Page_Cart/label_ProductPrice'), productPrice, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementText(findTestObject('Object Repository/Page_Cart/label_ProductSize'), productSize, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_Product1/input_Qty'), 'value', productQty, GlobalVariable.DelayShort, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Cart/button_Checkout'), GlobalVariable.DelayShort)
WebUI.click(findTestObject('Object Repository/Page_Cart/button_Checkout'), FailureHandling.STOP_ON_FAILURE)

//Input billing details and Place Order
WebUI.verifyMatch(WebUI.getUrl(), ('https://' + GlobalVariable.baseUrl) + '/checkout/', true, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Checkout/input_FirstName'), GlobalVariable.DelayShort)
WebUI.setText(findTestObject('Object Repository/Page_Checkout/input_FirstName'), firstName, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Checkout/input_LastName'), GlobalVariable.DelayShort)
WebUI.setText(findTestObject('Object Repository/Page_Checkout/input_LastName'), lastName, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Checkout/input_CompanyName'), GlobalVariable.DelayShort)
WebUI.setText(findTestObject('Object Repository/Page_Checkout/input_CompanyName'), companyName, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Checkout/select_Country'), FailureHandling.STOP_ON_FAILURE)
WebUI.setText(findTestObject('Object Repository/Page_Checkout/input_Country'), 'Indonesia', FailureHandling.STOP_ON_FAILURE)
WebUI.sendKeys(findTestObject('Object Repository/Page_Checkout/input_Country'), Keys.chord(Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Checkout/input_Address1'), GlobalVariable.DelayShort)
WebUI.setText(findTestObject('Object Repository/Page_Checkout/input_Address1'), address1, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Checkout/input_City'), GlobalVariable.DelayShort)
WebUI.setText(findTestObject('Object Repository/Page_Checkout/input_City'), city, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Checkout/select_State'), FailureHandling.STOP_ON_FAILURE)
WebUI.setText(findTestObject('Object Repository/Page_Checkout/input_State'), 'Bali', FailureHandling.STOP_ON_FAILURE)
WebUI.sendKeys(findTestObject('Object Repository/Page_Checkout/input_State'), Keys.chord(Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Checkout/input_PostCode'), GlobalVariable.DelayShort)
WebUI.setText(findTestObject('Object Repository/Page_Checkout/input_PostCode'), postCode, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Checkout/input_Phone'), GlobalVariable.DelayShort)
WebUI.setText(findTestObject('Object Repository/Page_Checkout/input_Phone'), phone, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Checkout/input_Email'), GlobalVariable.DelayShort)
WebUI.setText(findTestObject('Object Repository/Page_Checkout/input_Email'), email, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Checkout/input_Agrement'), FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/Page_Checkout/button_PlaceOrder'), FailureHandling.STOP_ON_FAILURE)


