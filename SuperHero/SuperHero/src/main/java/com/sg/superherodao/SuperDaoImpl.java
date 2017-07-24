/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherodao;

import com.sg.superherodao.MapperMethods.SuperMapper;
import com.sg.superheromodel.Location;
import com.sg.superheromodel.Organization;
import com.sg.superheromodel.Sighting;
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
public class SuperDaoImpl implements SuperDao {

    PreparedStatements prepared;
    MapperMethods mapmethod;

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Super addSuper(Super superhero) {
        jdbcTemplate.update(PreparedStatements.SQL_INSERT_SUPER,
                superhero.getSuperName(),
                superhero.getSuperDescription(),
                superhero.getSuperPower());

        int superID = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        superhero.setSuperID(superID);
        return superhero;
    }

    @Override
    public void deleteSuper(int superID) {
        jdbcTemplate.update(PreparedStatements.SQL_DELETE_SUPER, superID);
    }

    @Override
    public void updateSuper(Super superhero) {
        jdbcTemplate.update(PreparedStatements.SQL_UPDATE_SUPER,
                superhero.getSuperName(),
                superhero.getSuperDescription(),
                superhero.getSuperPower(),
                superhero.getSuperID());
    }

    @Override
    public Super getSuperByID(int superID) {
        try {
            Super supers = jdbcTemplate.queryForObject(PreparedStatements.SQL_SELECT_SUPER_BY_ID, new SuperMapper(), superID);

            return supers;
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Super> getAllSupers() {
        List<Super> supers = jdbcTemplate.query(PreparedStatements.SQL_SELECT_ALL_SUPERS, new SuperMapper());
        return supers;
    }

    @Override
    public List<Super> getAllSupersByOrganization(int organizationID) {
        List<Super> superList = jdbcTemplate.query(PreparedStatements.SQL_SELECT_ALL_SUPERS_BY_ORGANIZATION, new SuperMapper(), organizationID);
        return superList;
    }

    @Override
    public List<Super> getAllSupersByLocation(int locationID) {
        List< Super> superList = jdbcTemplate.query(PreparedStatements.SQL_SELECT_ALL_SUPERS_BY_LOCATION, new SuperMapper(), locationID);
        return superList;
    }

    /*
    private Super insertOrganizationSuper(Super superhero) {

    }
     */
    private List<Super> findSuperLocations(Location location) {
        return jdbcTemplate.query(PreparedStatements.SQL_SELECT_SUPERS_BY_LOCATION, new SuperMapper(), location.getLocationID());
    }

    private List< Super> findSuperSighting(Sighting sighting) {
        return jdbcTemplate.query(PreparedStatements.SQL_INSERT_SUPERSIGHTINGS, new SuperMapper(), sighting.getSuperID());
    }
}
