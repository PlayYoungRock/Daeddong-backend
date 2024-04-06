package kr.co.daeddongclient.client.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ClientLog {
    private String clientIp;
    private String referer;
    private String deviceType;

}
