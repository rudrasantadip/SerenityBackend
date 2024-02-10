package com.app.farmers.Farmer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.farmers.Farmer.Models.Bots.SubstituteBot;
import java.util.List;


@Repository
public interface SubBotRepo extends JpaRepository<SubstituteBot, Long>
{
    List<SubstituteBot> findByBotName(String botName);
}
