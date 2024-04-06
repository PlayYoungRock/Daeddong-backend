package kr.co.daeddongclient.client.service.impl;

import kr.co.daeddongclient.address.domain.AddressCoordinates;
import kr.co.daeddongclient.client.domain.ClientLog;
import kr.co.daeddongclient.client.repository.ClientRepository;
import kr.co.daeddongclient.client.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public void insertClientAccessLog(ClientLog clientLog) {
		clientRepository.insertClientAccessLog(clientLog);
	}

}
