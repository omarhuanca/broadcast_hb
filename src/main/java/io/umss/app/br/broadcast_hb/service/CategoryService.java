package io.umss.app.br.broadcast_hb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.umss.app.br.broadcast_hb.core.Category;
import io.umss.app.br.broadcast_hb.dao.category.MCategoryMapper;
import io.umss.app.br.broadcast_hb.dao.category.RCategoryRepository;
import io.umss.app.br.broadcast_hb.dto.CategoryDTOV;
import io.umss.app.br.broadcast_hb.util.exception.RepositoryException;

@Service
public class CategoryService {

    @Autowired
    RCategoryRepository repository;

    @Autowired
    MCategoryMapper mapper;

    public Optional<Category> findById(Long id) throws RepositoryException {
        return repository.findById(id);
    }

    public Page<CategoryDTOV> findAll(Pageable pageable) throws RepositoryException {
        return repository.findAll(pageable).map(mapper::toDTO);
    }

    public Category save(Category obj) {
        return repository.save(obj);
    }

    public Category update(Category obj) {
        return repository.save(obj);
    }

    public Category delete(Category obj) {
        obj.setStatus(ClassStatusEnum.DISABLE.getCode());
        return repository.save(obj);
    }
}
