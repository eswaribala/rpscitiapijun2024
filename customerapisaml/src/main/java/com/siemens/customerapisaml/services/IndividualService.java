package com.siemens.customerapisaml.services;

import com.siemens.customerapisaml.dtos.CustomerUpdateDTO;
import com.siemens.customerapisaml.models.Individual;

import java.util.List;

public interface IndividualService {
    Individual addIndividual(Individual individual);
    List<Individual> fetchAllIndividuals();
    Individual fetchIndividualByAccountNo(long accountNo);
    List<Individual> fetchIndividualByContactNo(long contactNo);
    Individual updateIndividual(CustomerUpdateDTO customerUpdateDTO);
    boolean deleteIndividualByAccountNo(long accountNo);
}
