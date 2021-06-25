package io.umss.app.br.broadcast_hb.dao.classmessage;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.umss.app.br.broadcast_hb.core.ClassMessage;
import io.umss.app.br.broadcast_hb.dto.ClassMessageDTOV;

@Component
public class MClassMessageMapper {

    @Autowired
    private ModelMapper mapper;

    public ClassMessageDTOV toDTO(ClassMessage obj) {
        return mapper.map(obj, ClassMessageDTOV.class);
    }
}
