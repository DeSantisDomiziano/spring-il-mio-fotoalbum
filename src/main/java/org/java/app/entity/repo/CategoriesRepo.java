package org.java.app.entity.repo;

import org.java.app.entity.pojo.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepo extends JpaRepository<Categories, Long>{

}
