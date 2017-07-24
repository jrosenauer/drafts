/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherodao;

import com.sg.superherodao.MapperMethods.LocationMapper;
import com.sg.superherodao.MapperMethods.SuperMapper;
import com.sg.superheromodel.Location;
import com.sg.superheromodel.Super;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class LocationDaoImpl implements LocationDao {

    PreparedStatements prepared;
    MapperMethods mapmethod;

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Location addLocation(Location location) {
        jdbcTemplate.update(PreparedStatements.SQL_INSERT_LOCATION,
                location.getLocationName(),
                location.getLocationDescription(),
                location.getLocationAddress(),
                location.getLocationLongitude(),
                location.getLocationLatitude());

        int locationID = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        location.setLocationID(locationID);
        return location;
    }

    @Override
    public void deleteLocation(int locationID) {
        jdbcTemplate.update(PreparedStatements.SQL_DELETE_LOCATION, locationID);
    }

    @Override
    public void updateLocation(Location location) {
        jdbcTemplate.update(PreparedStatements.SQL_UPDATE_LOCATION,
                location.getLocationName(),
                location.getLocationDescription(),
                location.getLocationAddress(),
                location.getLocationLongitude(),
                location.getLocationLatitude(),
                location.getLocationID());

    }

    @Override
    public Location getLocationByID(int locationID) {
        try {
            Location location = jdbcTemplate.queryForObject(PreparedStatements.SQL_SELECT_LOCATION_BY_ID, new LocationMapper(), locationID);
            return location;
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Location> getAllLocations() {
        List<Location> locationList = jdbcTemplate.query(PreparedStatements.SQL_GET_ALL_LOCATIONS, new LocationMapper());
        return locationList;
    }

    @Override
    public List<Location> getAllLocationsBySuper(int superID) {
        List< Location> locationList = jdbcTemplate.query(PreparedStatements.SQL_GET_ALL_LOCATIONS_BY_SUPER, new LocationMapper(), superID);
        return locationList;
    }

    private List< Super> selectSupersAtLocation(Location location) {
        List< Super> superList = jdbcTemplate.query(PreparedStatements.SQL_SELECT_SUPERS_BY_LOCATION, new SuperMapper(), location.getLocationID());
        return superList;
    }

}
