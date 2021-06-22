package io.umss.app.br.broadcast_hb.dao.subscription;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.umss.app.br.broadcast_hb.core.Subscription;

@Repository
public interface RSubscriptionRepository extends JpaRepository<Subscription, Long>{

}
