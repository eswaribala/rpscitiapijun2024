package com.siemens.customerapisaml.repositories;

import com.siemens.customerapisaml.models.Individual;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualRepository extends JpaRepository<Individual,Long> {
}
