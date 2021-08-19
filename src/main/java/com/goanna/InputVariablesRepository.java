package com.goanna;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InputVariablesRepository extends CrudRepository<InputVariables, Long> {


}
