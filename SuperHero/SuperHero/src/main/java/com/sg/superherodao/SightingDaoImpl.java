/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherodao;

import com.sg.superherodao.MapperMethods.LocationMapper;
import com.sg.superherodao.MapperMethods.SightingMapper;
import com.sg.superherodao.MapperMethods.SightingSuperLocationMapper;
import com.sg.superherodao.MapperMethods.SuperMapper;
import com.sg.superheromodel.Location;
import com.sg.superheromodel.Sighting;
import com.sg.superheromodel.Super;
import java.time.LocalDate;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class SightingDaoImpl implements SightingDao {

    PreparedStatements prepared;
    MapperMethods mapmethod;

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Sighting addSighting(Sighting sighting) {
        jdbcTemplate.update(PreparedStatements.SQL_INSERT_SIGHTING, sighting.getSightingDate().toString(), sighting.getLocationID());

        int sightingID = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        sighting.setSightingID(sightingID);
        List< Super> ss = sighting.getSupers();
        for (Super s : ss) {
            jdbcTemplate.update(PreparedStatements.SQL_INSERT_SUPERSIGHTINGS, s.getSuperID(), sighting.getSightingID());
        }
        return sighting;
    }

    @Override
    public void deleteSighting(int sightingID) {
        jdbcTemplate.update(PreparedStatements.SQL_DELETE_SIGHTING, sightingID);
    }

    @Override
    public void updateSighting(Sighting sighting) {
        jdbcTemplate.update(PreparedStatements.SQL_UPDATE_SIGHTING,
                java.sql.Date.valueOf(sighting.getSightingDate()),
                sighting.getLocationID(),
                sighting.getSightingID());
    }

    @Override
    public Sighting getSightingByID(int sightingID) {
        try {
            Sighting sighting = jdbcTemplate.queryForObject(PreparedStatements.SQL_SELECT_SIGHTING_BY_ID, new SightingMapper(), sightingID);
            Location location = jdbcTemplate.queryForObject(PreparedStatements.SQL_SELECT_LOCATION_BY_ID, new LocationMapper(), sighting.getLocationID());
            sighting.setLocation(location);
            List<Super> supers = jdbcTemplate.query(PreparedStatements.SQL_SELECT_SUPERS_BY_SIGHTING, new SuperMapper(), sightingID);
            sighting.setSupers(supers);
            return sighting;
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Sighting> getAllSightings() {
        List<Sighting> sightings = jdbcTemplate.query(PreparedStatements.SQL_SELECT_ALL_SIGHTINGS, new SightingMapper());
        for (Sighting sighting : sightings) {
            Location location = jdbcTemplate.queryForObject(PreparedStatements.SQL_SELECT_LOCATION_BY_ID, new LocationMapper(), sighting.getLocationID());
            sighting.setLocation(location);
            List<Super> supers = jdbcTemplate.query(PreparedStatements.SQL_SELECT_SUPERS_BY_SIGHTING, new SuperMapper(), sighting.getSightingID());
            sighting.setSupers(supers);
        }
        return sightings;
    }

    @Override
    public List<Sighting> getAllSightingsByDate(LocalDate date) {
        List< Sighting> sightingList = jdbcTemplate.query(PreparedStatements.SQL_SELECT_ALL_SIGHTINGS_BY_DATE, new SightingSuperLocationMapper(), date.toString());
        for (Sighting sighting : sightingList) {
            Location location = jdbcTemplate.queryForObject(PreparedStatements.SQL_SELECT_LOCATION_BY_ID, new LocationMapper(), sighting.getLocationID());
            sighting.setLocation(location);
            List<Super> supers = jdbcTemplate.query(PreparedStatements.SQL_SELECT_SUPERS_BY_SIGHTING, new SuperMapper(), sighting.getSightingID());
            sighting.setSupers(supers);
        }
        return sightingList;
    }

    @Override
    public List<Sighting> getTopTenSightings() {
        List<Sighting> sightingList = jdbcTemplate.query(PreparedStatements.SQL_SELECT_TEN_SIGHTINGS, new SightingMapper());
        return sightingList;
    }
}
