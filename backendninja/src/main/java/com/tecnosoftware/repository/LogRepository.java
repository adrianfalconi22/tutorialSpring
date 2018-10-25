package com.tecnosoftware.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tecnosoftware.entity.Log;

@Repository("LogRepository")
public interface LogRepository extends JpaRepository<Log, Serializable> {

}
