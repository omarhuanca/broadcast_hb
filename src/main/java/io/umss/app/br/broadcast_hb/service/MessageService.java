package io.umss.app.br.broadcast_hb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.umss.app.br.broadcast_hb.core.ClassMessage;
import io.umss.app.br.broadcast_hb.core.Message;
import io.umss.app.br.broadcast_hb.dao.message.MMessageMapper;
import io.umss.app.br.broadcast_hb.dao.message.RMessageRepository;
import io.umss.app.br.broadcast_hb.dto.MessageDTOV;
import io.umss.app.br.broadcast_hb.util.exception.RepositoryException;
import io.umss.app.br.broadcast_hb.util.exception.response.custom.CustomBadRequestException;

@Service
public class MessageService {

    @Autowired
    MMessageMapper mapper;

    @Autowired
    RMessageRepository repository;

    @Autowired
    ClassMessageService classMessageService;

    public Optional<Message> findById(Long id) throws RepositoryException {
        return repository.findById(id);
    }

    public Page<MessageDTOV> findAll(Pageable pageable) throws RepositoryException {
        return repository.findAll(pageable).map(mapper::toDTO);
    }

    public Message save(Message obj) {
        this.verifyForeignKey(obj);
        return repository.save(obj);
    }

    public Message update(Message obj) {
        this.verifyForeignKey(obj);
        return repository.save(obj);
    }

    public Message delete(Message obj) {
        obj.setStatus(ClassStatusEnum.DISABLE.getCode());
        return repository.save(obj);
    }

    private void verifyForeignKey(Message obj) {
        Optional<ClassMessage> classMessage = classMessageService.findById(obj.getClassMessage().getUid());
        if (!classMessage.isPresent() || classMessage.get().compareStatus(ClassStatusEnum.DISABLE.getCode())) {
            throw new CustomBadRequestException("class message not found or status is disable");
        }
    }
}
