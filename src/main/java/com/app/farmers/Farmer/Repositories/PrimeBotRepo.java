package com.app.farmers.Farmer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.farmers.Farmer.Models.Bots.PrimeBot;
import java.util.List;


@Repository
public interface PrimeBotRepo extends JpaRepository<PrimeBot,Long>
{
    List<PrimeBot> findByBotName(String botName);
}
