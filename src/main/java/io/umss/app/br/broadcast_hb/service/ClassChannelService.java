package io.umss.app.br.broadcast_hb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.umss.app.br.broadcast_hb.core.ClassChannel;
import io.umss.app.br.broadcast_hb.dao.RClassChannelRepository;
import io.umss.app.br.broadcast_hb.util.exception.RepositoryException;

@Service
public class ClassChannelService {

    @Autowired
    RClassChannelRepository repository;

    public Optional<ClassChannel> findById(Long id) throws RepositoryException {
        return repository.findById(id);
    }

    public List<ClassChannel> findAll() throws RepositoryException {
        return repository.findAll();
    }
}
