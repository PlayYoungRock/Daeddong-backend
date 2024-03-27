package kr.co.daeddongclient.toilet.service;

import kr.co.daeddongclient.address.domain.AddressCoordinates;
import kr.co.daeddongclient.toilet.domain.Toilet;
import java.util.List;

public interface ToiletService {
    public List<Toilet> getToiletList(AddressCoordinates addressCoordinates);

}
