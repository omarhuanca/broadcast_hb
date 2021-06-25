package io.umss.app.br.broadcast_hb.dao.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.umss.app.br.broadcast_hb.core.Category;

@Repository
public interface RCategoryRepository extends JpaRepository<Category, Long>{

}
