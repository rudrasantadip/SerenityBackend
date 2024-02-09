package com.app.farmers.Farmer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.farmers.Farmer.Models.Farmer;
import java.util.List;


@Repository
public interface FarmerRepo extends JpaRepository<Farmer,Long>
{
    List<Farmer> findByUserName(String userName);
}
