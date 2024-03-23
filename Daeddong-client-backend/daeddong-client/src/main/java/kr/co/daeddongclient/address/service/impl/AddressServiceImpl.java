package kr.co.daeddongclient.address.service.impl;

import kr.co.daeddongclient.address.domain.Address;
import kr.co.daeddongclient.address.repository.AddressRepository;
import kr.co.daeddongclient.address.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public List<Address> getSidoList(Map<String,Object> paramMap) {
		return addressRepository.getSidoList(paramMap);
	}
	@Override
	public List<Address> getSiGunguList(String sido) {
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("sido",sido);
		return addressRepository.getSiGunguList(paramMap);
	}

}
