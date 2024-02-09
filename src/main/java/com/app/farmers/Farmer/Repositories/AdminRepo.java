package com.app.farmers.Farmer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.farmers.Farmer.Models.Admin;
import java.util.List;




@Repository
public interface AdminRepo extends JpaRepository<Admin,Long> 
{
        List<Admin> findByUsername(String username);
}
