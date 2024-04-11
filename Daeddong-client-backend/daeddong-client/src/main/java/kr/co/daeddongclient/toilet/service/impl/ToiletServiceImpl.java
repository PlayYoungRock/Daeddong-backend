package kr.co.daeddongclient.toilet.service.impl;

import kr.co.daeddongclient.address.domain.AddressCoordinates;
import kr.co.daeddongclient.toilet.domain.Toilet;
import kr.co.daeddongclient.toilet.repository.ToiletRepository;
import kr.co.daeddongclient.toilet.service.ToiletService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ToiletServiceImpl implements ToiletService {
	@Autowired
	private ToiletRepository toiletRepository;

	@Override
	public List<Toilet> getToiletList(double distance, double latitude, double longitude) {

		AddressCoordinates addressCoordinates = new AddressCoordinates(distance,latitude,longitude);
		addressCoordinates.latMaxValue();
		addressCoordinates.latMinValue();
		addressCoordinates.lonMaxValue();
		addressCoordinates.lonMinValue();
		if(toiletRepository.getToiletList(addressCoordinates).isEmpty()){
			throw new IllegalArgumentException("데이터 없음");
		}
		return toiletRepository.getToiletList(addressCoordinates);
	}

}
