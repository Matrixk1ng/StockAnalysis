package com.obinna.StockAnalysis.Service;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class FinancialModelingPrepServiceTest {

    @Test
    void isApiKeyInvalid_returnsTrueForEmptyOrPlaceholder() {
        FinancialModelingPrepService emptyService = new FinancialModelingPrepService(new RestTemplate(), "");
        assertTrue(ReflectionTestUtils.invokeMethod(emptyService, "isApiKeyInvalid"));

        FinancialModelingPrepService placeholderService = new FinancialModelingPrepService(new RestTemplate(), "YOUR_FMP_API_KEY");
        assertTrue(ReflectionTestUtils.invokeMethod(placeholderService, "isApiKeyInvalid"));
    }

    @Test
    void isApiKeyInvalid_returnsFalseForNonEmptyKey() {
        FinancialModelingPrepService validService = new FinancialModelingPrepService(new RestTemplate(), "key");
        assertFalse(ReflectionTestUtils.invokeMethod(validService, "isApiKeyInvalid"));
    }
}
