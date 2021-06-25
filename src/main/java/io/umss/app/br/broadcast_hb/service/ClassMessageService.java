package io.umss.app.br.broadcast_hb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.umss.app.br.broadcast_hb.core.ClassMessage;
import io.umss.app.br.broadcast_hb.dao.classmessage.MClassMessageMapper;
import io.umss.app.br.broadcast_hb.dao.classmessage.RClassMessageRepository;
import io.umss.app.br.broadcast_hb.dto.ClassMessageDTOV;
import io.umss.app.br.broadcast_hb.util.exception.RepositoryException;

@Service
public class ClassMessageService {

    @Autowired
    RClassMessageRepository repository;

    @Autowired
    MClassMessageMapper mapper;

    public Optional<ClassMessage> findById(Long id) throws RepositoryException {
        return repository.findById(id);
    }

    public Page<ClassMessageDTOV> findAll(Pageable pageable) throws RepositoryException {
        return repository.findAll(pageable).map(mapper::toDTO);
    }

    public ClassMessage save(ClassMessage obj) {
        return repository.save(obj);
    }

    public ClassMessage update(ClassMessage obj) {
        return repository.save(obj);
    }

    public ClassMessage delete(ClassMessage obj) {
        obj.setStatus(ClassStatusEnum.DISABLE.getCode());
        return repository.save(obj);
    }
}
