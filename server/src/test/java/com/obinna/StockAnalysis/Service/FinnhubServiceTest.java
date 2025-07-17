package com.obinna.StockAnalysis.Service;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class FinnhubServiceTest {

    @Test
    void isApiKeyInvalid_returnsTrueForEmptyOrPlaceholder() {
        FinnhubService emptyKeyService = new FinnhubService(new RestTemplate(), "");
        assertTrue(ReflectionTestUtils.invokeMethod(emptyKeyService, "isApiKeyInvalid"));

        FinnhubService placeholderService = new FinnhubService(new RestTemplate(), "YOUR_FINNHUB_API_KEY");
        assertTrue(ReflectionTestUtils.invokeMethod(placeholderService, "isApiKeyInvalid"));
    }

    @Test
    void isApiKeyInvalid_returnsFalseForNonEmptyKey() {
        FinnhubService validService = new FinnhubService(new RestTemplate(), "key");
        assertFalse(ReflectionTestUtils.invokeMethod(validService, "isApiKeyInvalid"));
    }
}
