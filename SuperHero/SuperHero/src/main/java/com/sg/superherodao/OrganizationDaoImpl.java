/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherodao;

import com.sg.superherodao.MapperMethods.OrganizationMapper;
import com.sg.superherodao.MapperMethods.SuperMapper;
import com.sg.superheromodel.Location;
import com.sg.superheromodel.Organization;
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
public class OrganizationDaoImpl implements OrganizationDao {

    PreparedStatements prepared;
    MapperMethods mapmethod;
    Super supermodel;

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Organization addOrganization(Organization organization) {
        jdbcTemplate.update(PreparedStatements.SQL_INSERT_ORGANIZATION,
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationAddress(),
                organization.getOrganizationPhone(),
                organization.getOrganizationEmail());

        int organizationID = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);

        organization.setOrganizationID(organizationID);
        insertSuperOrganization(organization);
        return organization;
    }

    @Override
    public void deleteOrganization(int organizationID) {
        jdbcTemplate.update(PreparedStatements.SQL_DELETE_ORGANIZATION, organizationID);
        jdbcTemplate.update(PreparedStatements.SQL_DELETE_SUPERS_IN_ORGANIZATION, organizationID);
    }

    @Override
    public void updateOrganization(Organization organization) {
        jdbcTemplate.update(PreparedStatements.SQL_UPDATE_ORGANIZATION,
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationAddress(),
                organization.getOrganizationPhone(),
                organization.getOrganizationEmail(),
                organization.getOrganizationID());

        insertSuperOrganization(organization);
    }

    @Override
    public Organization getOrganizationByID(int organizationID) {
        try {
            Organization organization = jdbcTemplate.queryForObject(PreparedStatements.SQL_SELECT_ORGANIZATION_BY_ID, new OrganizationMapper(), organizationID);
            List<Super> supers = jdbcTemplate.query(PreparedStatements.SQL_SELECT_SUPER_BY_ID, new SuperMapper(), organization.getMembers());
            return organization;
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Organization> getAllOrganizations() {
        List<Organization> organizationList = jdbcTemplate.query(PreparedStatements.SQL_GET_ALL_ORGANIZATIONS, new OrganizationMapper());
        for (Organization organization : organizationList) {
            List<Super> supers = jdbcTemplate.query(PreparedStatements.SQL_SELECT_ALL_SUPERS_BY_ORGANIZATION, new SuperMapper(), organization.getOrganizationID());
            organization.setMembers(supers);
        }
        return organizationList;
    }

    private Organization insertSuperOrganization(Organization organization) {
        final int organizationID = organization.getOrganizationID();
        final List< Super> supers = organization.getMembers();
        for (Super currentSuper : supers) {
            jdbcTemplate.update(PreparedStatements.SQL_INSERT_SUPERORGANIZATION, currentSuper.getSuperID(), organization.getOrganizationID());
        }
        return organization;
    }

    private List<Super> getSupersInOrganizations(Organization organization) {
        List<Super> superList = jdbcTemplate.query(PreparedStatements.SQL_SELECT_ALL_SUPERS_BY_ORGANIZATION, new SuperMapper(), organization.getOrganizationID());            
        
        return superList;
    }

    private List<Organization> associateSuperAndOrganization(List<Organization> organizationList) {
        for (Organization currentOrganization : organizationList) {
            currentOrganization.setMembers(getSupersInOrganizations(currentOrganization));
        }
        return organizationList;
    }

}
