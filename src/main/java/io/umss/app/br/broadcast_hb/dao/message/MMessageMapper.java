package io.umss.app.br.broadcast_hb.dao.message;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.umss.app.br.broadcast_hb.core.Message;
import io.umss.app.br.broadcast_hb.dto.MessageDTOV;

@Component
public class MMessageMapper {

    @Autowired
    private ModelMapper mapper;

    public MessageDTOV toDTO(Message obj) {
        return mapper.map(obj, MessageDTOV.class);
    }
}
