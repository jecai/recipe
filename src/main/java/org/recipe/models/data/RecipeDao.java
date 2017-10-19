package org.recipe.models.data;

import org.recipe.models.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Jenn Cai
 * 10/4/17
 */

@Repository
@Transactional
public interface RecipeDao extends CrudRepository<Recipe,Integer> {

}
