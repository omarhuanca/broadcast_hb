package io.umss.app.br.broadcast_hb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.umss.app.br.broadcast_hb.core.BroadcastMessage;
import io.umss.app.br.broadcast_hb.core.Category;
import io.umss.app.br.broadcast_hb.core.Message;
import io.umss.app.br.broadcast_hb.dao.broadcastmessage.MBroadcastMessageMapper;
import io.umss.app.br.broadcast_hb.dao.broadcastmessage.RBroadcastMessageRepository;
import io.umss.app.br.broadcast_hb.dto.BroadcastMessageDTOV;
import io.umss.app.br.broadcast_hb.util.exception.RepositoryException;
import io.umss.app.br.broadcast_hb.util.exception.response.custom.CustomBadRequestException;

@Service
public class BroadcastMessageService {

    @Autowired
    MBroadcastMessageMapper mapper;

    @Autowired
    RBroadcastMessageRepository repository;

    @Autowired
    CategoryService categoryService;

    @Autowired
    MessageService messageService;

    public Optional<BroadcastMessage> findById(Long id) throws RepositoryException {
        return repository.findById(id);
    }

    public Page<BroadcastMessageDTOV> findAll(Pageable pageable) throws RepositoryException {
        return repository.findAll(pageable).map(mapper::toDTO);
    }

    public BroadcastMessage save(BroadcastMessage obj) {
        this.verifyForeignKey(obj);
        return repository.save(obj);
    }

    public BroadcastMessage update(BroadcastMessage obj) {
        this.verifyForeignKey(obj);
        return repository.save(obj);
    }

    public BroadcastMessage delete(BroadcastMessage obj) {
        obj.setStatus(ClassStatusEnum.DISABLE.getCode());
        return repository.save(obj);
    }

    private void verifyForeignKey(BroadcastMessage obj) {
        Optional<Category> category = categoryService.findById(obj.getCategory().getUid());
        if (!category.isPresent() || category.get().compareStatus(ClassStatusEnum.DISABLE.getCode())) {
            throw new CustomBadRequestException("category not found or status is disable");
        }
        Optional<Message> message = messageService.findById(obj.getMessage().getUid());
        if (!message.isPresent() || message.get().compareStatus(ClassStatusEnum.DISABLE.getCode())) {
            throw new CustomBadRequestException("message not found or status is disable");
        }
    }
}
