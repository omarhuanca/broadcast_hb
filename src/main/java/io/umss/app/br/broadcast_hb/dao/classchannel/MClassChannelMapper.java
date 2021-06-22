package io.umss.app.br.broadcast_hb.dao.classchannel;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.umss.app.br.broadcast_hb.core.ClassChannel;
import io.umss.app.br.broadcast_hb.dto.ClassChannelDTOV;

@Component
public class MClassChannelMapper {

    @Autowired
    private ModelMapper mapper;

    public ClassChannelDTOV toDTO(ClassChannel obj) {
        return mapper.map(obj, ClassChannelDTOV.class);
    }
}
