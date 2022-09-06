package com.example.moodle.repository;

import com.example.moodle.models.BankTasksModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankTaskRepository extends CrudRepository<BankTasksModel, String> {
    List<BankTasksModel> findBankTasksModelsByPathStartingWith(String path);
}
