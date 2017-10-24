package org.recipe.models.data;

import org.recipe.models.Recipe;
import org.recipe.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Jenn Cai
 * 10/4/17
 */

@Repository
@Transactional
public interface RecipeDao extends CrudRepository<Recipe,Integer> {
    List<Recipe> findByAuthor(User author);
}
