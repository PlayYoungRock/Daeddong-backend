package kr.co.daeddongclient.address.repository;

import kr.co.daeddongclient.address.domain.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AddressRepository {
    List<Address> getSido(Map<String,Object> paramMap);
    List<Address> getSiGunguList(Map<String,Object> paramMap);
}
