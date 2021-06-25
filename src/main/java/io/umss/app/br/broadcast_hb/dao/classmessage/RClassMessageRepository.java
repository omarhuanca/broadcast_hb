package io.umss.app.br.broadcast_hb.dao.classmessage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.umss.app.br.broadcast_hb.core.ClassMessage;

@Repository
public interface RClassMessageRepository extends JpaRepository<ClassMessage, Long>{

}
