package com.tk.bharat_trains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tk.bharat_trains.model.Train;
import com.tk.bharat_trains.repository.TrainRepository;

@Service
public class TrainService {
	@Autowired
	TrainRepository repository;
	
	public ResponseEntity<Train> saveTrain(Train train){
		try {
			repository.save(train);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public String getTrainName(String trainId) {
		return repository.findByTrainId(trainId).getTrainName();
	}
}
