package io.umss.app.br.broadcast_hb.dao.message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.umss.app.br.broadcast_hb.core.Message;

@Repository
public interface RMessageRepository extends JpaRepository<Message, Long>{

}
