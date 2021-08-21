package com.goanna.repository;

import com.goanna.entity.InputVariables;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InputVariablesRepository extends CrudRepository<InputVariables, Long> {

}
