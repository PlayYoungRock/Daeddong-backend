package kr.co.daeddongclient.address.service;

import kr.co.daeddongclient.address.domain.Address;

import java.util.List;
import java.util.Map;

public interface AddressService {
    public List<Address> getSidoList(Map<String, Object> paramMap);
    public List<Address> getSiGunguList(String sido);

}
