/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherodao;

import com.sg.superheromodel.Location;
import com.sg.superheromodel.Organization;
import com.sg.superheromodel.Sighting;
import com.sg.superheromodel.Super;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author apprentice
 */
public class MapperMethods {

    public static final class LocationMapper implements RowMapper< Location> {

        @Override
        public Location mapRow(ResultSet rs, int i) throws SQLException {
            Location loc = new Location();
            loc.setLocationID(rs.getInt("LocationID"));
            loc.setLocationName(rs.getString("LocationName"));
            loc.setLocationDescription(rs.getString("LocationDescription"));
            loc.setLocationAddress(rs.getString("LocationAddress"));
            loc.setLocationLongitude(rs.getDouble("LocationLongitude"));
            loc.setLocationLatitude(rs.getDouble("LocationLatitude"));
            return loc;
        }
    }

    public static final class OrganizationMapper implements RowMapper< Organization> {

        @Override
        public Organization mapRow(ResultSet rs, int i) throws SQLException {
            Organization org = new Organization();
            org.setOrganizationID(rs.getInt("OrganizationID"));
            org.setOrganizationName(rs.getString("OrganizationName"));
            org.setOrganizationDescription(rs.getString("OrganizationDescription"));
            org.setOrganizationAddress(rs.getString("OrganizationAddress"));
            org.setOrganizationPhone(rs.getString("OrganizationPhone"));
            org.setOrganizationEmail(rs.getString("OrganizationEmail"));
            return org;
        }
    }

    public static final class SightingMapper implements RowMapper< Sighting> {

        @Override
        public Sighting mapRow(ResultSet rs, int i) throws SQLException {
            Sighting sight = new Sighting();
            sight.setSightingID(rs.getInt("SightingID"));
            sight.setSightingDate(rs.getDate("SightingDate").toLocalDate());
            sight.setLocationID(rs.getInt("LocationID"));
            return sight;
        }
    }
    
    public static final class SightingSuperLocationMapper implements RowMapper< Sighting> {

        @Override
        public Sighting mapRow(ResultSet rs, int i) throws SQLException {
            Sighting sight = new Sighting();
            Location loc = new Location();
            Super supers = new Super();
            sight.setSightingID(rs.getInt("SightingID"));
            sight.setSightingDate(rs.getDate("SightingDate").toLocalDate());
            sight.setLocationID(rs.getInt("LocationID"));
//            supers.setSuperID(rs.getInt("SuperID"));
//            supers.setSuperName(rs.getString("SuperName"));
//            supers.setSuperDescription(rs.getString("SuperDescription"));
//            supers.setSuperPower(rs.getString("SuperPower"));
            loc.setLocationID(rs.getInt("LocationID"));
            loc.setLocationName(rs.getString("LocationName"));
            loc.setLocationDescription(rs.getString("LocationDescription"));
            loc.setLocationAddress(rs.getString("LocationAddress"));
            loc.setLocationLongitude(rs.getDouble("LocationLongitude"));
            loc.setLocationLatitude(rs.getDouble("LocationLatitude"));            
            return sight;
        }
    }
    
    

    public static final class SuperMapper implements RowMapper< Super> {

        @Override
        public Super mapRow(ResultSet rs, int i) throws SQLException {
            Super sups = new Super();
            sups.setSuperID(rs.getInt("SuperID"));
            sups.setSuperName(rs.getString("SuperName"));
            sups.setSuperDescription(rs.getString("SuperDescription"));
            sups.setSuperPower(rs.getString("SuperPower"));
            return sups;
        }
    }
}
