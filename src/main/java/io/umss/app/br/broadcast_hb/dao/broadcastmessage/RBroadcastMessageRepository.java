package io.umss.app.br.broadcast_hb.dao.broadcastmessage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.umss.app.br.broadcast_hb.core.BroadcastMessage;

@Repository
public interface RBroadcastMessageRepository extends JpaRepository<BroadcastMessage, Long>{

}
