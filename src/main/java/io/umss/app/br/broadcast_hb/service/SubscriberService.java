package io.umss.app.br.broadcast_hb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.umss.app.br.broadcast_hb.core.Subscriber;
import io.umss.app.br.broadcast_hb.dao.subscriber.MSubscriberMapper;
import io.umss.app.br.broadcast_hb.dao.subscriber.RSubscriberRepository;
import io.umss.app.br.broadcast_hb.dto.SubscriberDTOV;
import io.umss.app.br.broadcast_hb.util.exception.RepositoryException;

@Service
public class SubscriberService {

    @Autowired
    RSubscriberRepository repository;

    @Autowired
    MSubscriberMapper mapper;

    public Optional<Subscriber> findById(Long id) throws RepositoryException {
        return repository.findById(id);
    }

    public Page<SubscriberDTOV> findAll(Pageable pageable) throws RepositoryException {
        return repository.findAll(pageable).map(mapper::toDTO);
    }

    public Subscriber save(Subscriber obj) {
        return repository.save(obj);
    }

    public Subscriber update(Subscriber obj) {
        return repository.save(obj);
    }

    public Subscriber delete(Subscriber obj) {
        obj.setStatus(ClassStatusEnum.DISABLE.getCode());
        return repository.save(obj);
    }
}
