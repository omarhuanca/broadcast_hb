package io.umss.app.br.broadcast_hb.dao.category;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.umss.app.br.broadcast_hb.core.Category;
import io.umss.app.br.broadcast_hb.dto.CategoryDTOV;

@Component
public class MCategoryMapper {

    @Autowired
    private ModelMapper mapper;

    public CategoryDTOV toDTO(Category obj) {
        return mapper.map(obj, CategoryDTOV.class);
    }
}
