package org.recipe.models.data;

import java.util.List;

import javax.transaction.Transactional;

import org.recipe.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Integer> {

    User findByUsername(String username);
    // TODO - add method signatures as needed

}