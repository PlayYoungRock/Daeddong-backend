package kr.co.daeddongclient.common;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.junit.jupiter.api.Assertions.*;

class CommonUtilTest extends CommonUtil {

    @Test
    void getDeviceType() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        String userAgent = request.getHeader("User-Agent");
        System.out.println("userAgent = " + userAgent);

        // Test case for null user agent
        assertEquals("mac", userAgent);
    }


}