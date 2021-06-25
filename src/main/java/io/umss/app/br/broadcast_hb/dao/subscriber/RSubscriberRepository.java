package io.umss.app.br.broadcast_hb.dao.subscriber;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.umss.app.br.broadcast_hb.core.Subscriber;

@Repository
public interface RSubscriberRepository extends JpaRepository<Subscriber, Long>{

}
