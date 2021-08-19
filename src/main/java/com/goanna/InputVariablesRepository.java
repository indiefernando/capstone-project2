package com.goanna.repository;

import com.goanna.InputVariables;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface InputVariablesRepository extends CrudRepository<InputVariables, Integer> {
}
