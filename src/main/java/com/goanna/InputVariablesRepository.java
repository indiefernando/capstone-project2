package com.goanna;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface InputVariablesRepository extends JpaRepository<InputVariables, String> {
}
