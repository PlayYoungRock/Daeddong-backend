package kr.co.daeddongclient.toilet.repository;

import kr.co.daeddongclient.address.domain.AddressCoordinates;
import kr.co.daeddongclient.toilet.domain.Toilet;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ToiletRepository {
    List<Toilet> getToiletList(AddressCoordinates addressCoordinates);
}
