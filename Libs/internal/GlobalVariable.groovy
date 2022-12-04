package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object baseUrl
     
    /**
     * <p></p>
     */
    public static Object DelayShort
     
    /**
     * <p></p>
     */
    public static Object DelayMedium
     
    /**
     * <p></p>
     */
    public static Object DelayLong
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += TestCaseMain.getParsedValues(RunConfiguration.getOverridingParameters())
    
            baseUrl = selectedVariables['baseUrl']
            DelayShort = selectedVariables['DelayShort']
            DelayMedium = selectedVariables['DelayMedium']
            DelayLong = selectedVariables['DelayLong']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
