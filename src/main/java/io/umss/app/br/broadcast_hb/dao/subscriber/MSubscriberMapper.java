package io.umss.app.br.broadcast_hb.dao.subscriber;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.umss.app.br.broadcast_hb.core.Subscriber;
import io.umss.app.br.broadcast_hb.dto.SubscriberDTOV;

@Component
public class MSubscriberMapper {

    @Autowired
    private ModelMapper mapper;

    public SubscriberDTOV toDTO(Subscriber obj) {
        return mapper.map(obj, SubscriberDTOV.class);
    }
}
