package io.umss.app.br.broadcast_hb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.umss.app.br.broadcast_hb.core.ClassChannel;
import io.umss.app.br.broadcast_hb.core.Subscription;
import io.umss.app.br.broadcast_hb.dao.subscription.MSubscriptionMapper;
import io.umss.app.br.broadcast_hb.dao.subscription.RSubscriptionRepository;
import io.umss.app.br.broadcast_hb.dto.SubscriptionDTOV;
import io.umss.app.br.broadcast_hb.util.exception.RepositoryException;
import io.umss.app.br.broadcast_hb.util.exception.response.custom.CustomBadRequestException;

@Service
public class SubscriptionService {

    @Autowired
    MSubscriptionMapper mapper;

    @Autowired
    RSubscriptionRepository repository;

    @Autowired
    ClassChannelService classChannelService;

    public Optional<Subscription> findById(Long id) throws RepositoryException {
        return repository.findById(id);
    }

    public Page<SubscriptionDTOV> findAll(Pageable pageable) throws RepositoryException {
        return repository.findAll(pageable).map(mapper::toDTO);
    }

    public Subscription save(Subscription obj) {
        this.verifyForeignKey(obj);
        return repository.save(obj);
    }

    public Subscription update(Subscription obj) {
        this.verifyForeignKey(obj);
        return repository.save(obj);
    }

    public Subscription delete(Subscription obj) {
        obj.setStatus(ClassStatusEnum.DISABLE.getCode());
        return repository.save(obj);
    }

    private void verifyForeignKey(Subscription obj) {
        Optional<ClassChannel> classChannel = classChannelService.findById(obj.getClassChannel().getUid());
        if (!classChannel.isPresent()) {
            throw new CustomBadRequestException("class channel not found");
        }
    }
}
