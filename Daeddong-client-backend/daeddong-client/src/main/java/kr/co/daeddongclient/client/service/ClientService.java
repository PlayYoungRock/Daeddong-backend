package kr.co.daeddongclient.client.service;

import kr.co.daeddongclient.address.domain.AddressCoordinates;
import kr.co.daeddongclient.client.domain.ClientLog;

import java.util.List;

public interface ClientService {
    public void insertClientAccessLog(ClientLog clientLog);

}
