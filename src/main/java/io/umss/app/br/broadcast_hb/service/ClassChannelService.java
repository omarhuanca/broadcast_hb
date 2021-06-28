package io.umss.app.br.broadcast_hb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.umss.app.br.broadcast_hb.core.ClassChannel;
import io.umss.app.br.broadcast_hb.dao.classchannel.MClassChannelMapper;
import io.umss.app.br.broadcast_hb.dao.classchannel.RClassChannelRepository;
import io.umss.app.br.broadcast_hb.dto.ClassChannelDTOV;
import io.umss.app.br.broadcast_hb.util.exception.RepositoryException;

@Service
public class ClassChannelService {

    @Autowired
    MClassChannelMapper mapper;

    @Autowired
    RClassChannelRepository repository;

    public Optional<ClassChannel> findById(Long id) throws RepositoryException {
        return repository.findById(id);
    }

    public Page<ClassChannelDTOV> findAll(Pageable pageable) throws RepositoryException {
        return repository.findAll(pageable).map(mapper::toDTO);
    }

    public ClassChannel save(ClassChannel obj) {
        return repository.save(obj);
    }

    public ClassChannel update(ClassChannel obj) {
        return repository.save(obj);
    }

    public ClassChannel delete(ClassChannel obj) {
        obj.setStatus(ClassStatusEnum.DISABLE.getCode());
        return repository.save(obj);
    }
}
