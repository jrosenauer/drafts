/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherodao;

import com.sg.superheromodel.Sighting;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface SightingDao {

    public Sighting addSighting(Sighting sighting);

    public void deleteSighting(int sightingID);

    public void updateSighting(Sighting sighting);

    public Sighting getSightingByID(int sightingID);

    public List< Sighting> getAllSightings();

    public List< Sighting> getAllSightingsByDate(LocalDate date);

    //public List<Sighting> getTopTenSightings();
}
