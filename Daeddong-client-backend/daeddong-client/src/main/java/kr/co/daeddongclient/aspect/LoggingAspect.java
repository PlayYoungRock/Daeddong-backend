package kr.co.daeddongclient.aspect;

import kr.co.daeddongclient.client.domain.ClientLog;
import kr.co.daeddongclient.client.service.ClientService;
import kr.co.daeddongclient.common.CommonUtil;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
@Component
public class LoggingAspect {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ClientService clientService;

    private static final Map<String, Boolean> ipAccessedMap = new ConcurrentHashMap<>();

    @Before("@annotation(org.springframework.web.bind.annotation.RequestMapping) " +
            "|| @annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void logBeforeRequest() {
        ClientLog clientLog = new ClientLog();
        String clientIP = CommonUtil.getClientIp(request);
        //아이피당 최초 1회만 방문기록 DB 저장
        if (!ipAccessedMap.containsKey(clientIP)) {
            ipAccessedMap.put(clientIP, true);
            clientLog.setClientIp(clientIP);
            clientLog.setReferer(CommonUtil.getClientReferer(request));
            clientLog.setDeviceType(CommonUtil.getDeviceType(request));
            clientService.insertClientAccessLog(clientLog);
        }


    }
}
