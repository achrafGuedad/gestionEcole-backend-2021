package com.project.Pfe.Pfe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Pfe.Pfe.dao.AbsenceRepository;
import com.project.Pfe.Pfe.entities.Absence;

@Service
public class AbsenceServiceImpl implements AbsenceService {
	
	@Autowired
	private AbsenceRepository absenceRepository;

	@Override
	public Absence createAbsence(Absence absence) {
		return absenceRepository.save(absence);
	}

}
