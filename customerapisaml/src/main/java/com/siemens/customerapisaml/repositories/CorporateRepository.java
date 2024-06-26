package com.siemens.customerapisaml.repositories;

import com.siemens.customerapisaml.models.Corporate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorporateRepository extends JpaRepository<Corporate,Long> {
}
