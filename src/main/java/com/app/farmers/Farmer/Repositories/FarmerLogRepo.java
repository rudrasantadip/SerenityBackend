package com.app.farmers.Farmer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.farmers.Farmer.Models.FarmerLogs;

@Repository
public interface FarmerLogRepo extends JpaRepository<FarmerLogs,Long>
{

}
