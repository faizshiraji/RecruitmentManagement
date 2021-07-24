package com.recruitmentmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recruitmentmanagement.entities.Message;

@Repository
public interface MessageRepo extends JpaRepository<Message, Integer> {

}
