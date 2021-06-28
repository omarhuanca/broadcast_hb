package io.umss.app.br.broadcast_hb.dao.broadcastmessage;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.umss.app.br.broadcast_hb.core.BroadcastMessage;
import io.umss.app.br.broadcast_hb.dto.BroadcastMessageDTOV;

@Component
public class MBroadcastMessageMapper {

    @Autowired
    private ModelMapper mapper;

    public BroadcastMessageDTOV toDTO(BroadcastMessage obj) {
        return mapper.map(obj, BroadcastMessageDTOV.class);
    }
}
