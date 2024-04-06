package kr.co.daeddongclient.client.repository;

import kr.co.daeddongclient.client.domain.ClientLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClientRepository {
    void insertClientAccessLog(ClientLog clientLog);
}
