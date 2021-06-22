package io.umss.app.br.broadcast_hb.dao.subscription;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.umss.app.br.broadcast_hb.core.Subscription;
import io.umss.app.br.broadcast_hb.dto.SubscriptionDTOV;

@Component
public class MSubscriptionMapper {

    @Autowired
    private ModelMapper mapper;

    public SubscriptionDTOV toDTO(Subscription obj) {
        return mapper.map(obj, SubscriptionDTOV.class);
    }
}
