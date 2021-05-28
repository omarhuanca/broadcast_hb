package io.umss.app.br.broadcast_hb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.umss.app.br.broadcast_hb.core.ClassChannel;

@Repository
public interface RClassChannelRepository extends JpaRepository<ClassChannel, Long> {
    
}
