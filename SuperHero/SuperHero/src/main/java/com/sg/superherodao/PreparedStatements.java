/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherodao;

/**
 *
 * @author apprentice
 */
public class PreparedStatements {

    //Location//
    public static final String SQL_INSERT_LOCATION
            = "insert into Location "
            + "(LocationName, LocationDescription, LocationAddress, "
            + "LocationLongitude, LocationLatitude)" + "values(?, ?, ?, ?, ?)";

    public static final String SQL_DELETE_LOCATION
            = "DELETE FROM Location where LocationID = ?";

    public static final String SQL_UPDATE_LOCATION
            = "update Location set "
            + "LocationName = ?, LocationDescription = ?, LocationAddress = ?, "
            + "LocationLongitude = ?, LocationLatitude = ? "
            + "where LocationID = ?";

    public static final String SQL_SELECT_LOCATION_BY_ID
            = "SELECT * from Location WHERE LocationID = ?";

    public static final String SQL_GET_ALL_LOCATIONS
            = "SELECT * from Location";

    public static final String SQL_GET_ALL_LOCATIONS_BY_SUPER
            = "SELECT distinct loc.* from Location loc "
            + "JOIN Sighting sight on sight.LocationID = loc.LocationID "
            + "JOIN SuperSighting ss on ss.SightingID = ss.SightingID "
            + "WHERE ss.SuperID = ?";

    public static final String SQL_SELECT_SUPERS_BY_LOCATION
            = "SELECT * FROM SuperHero sh "
            + "JOIN SuperSighting ss on ss.SuperID = sh.SuperID "
            + "JOIN Sighting sight on sight.SightingID = ss.SightingID "
            + "WHERE sight.LocationID = ?";

    //Organization//           
    public static final String SQL_INSERT_ORGANIZATION
            = "insert into Organization "
            + "(OrganizationName, OrganizationDescription, "
            + "OrganizationAddress, OrganizationPhone, OrganizationEmail) "
            + "values (?, ?, ?, ?, ?)";

    public static final String SQL_DELETE_ORGANIZATION
            = "DELETE FROM Organization where OrganizationID = ?";

    public static final String SQL_UPDATE_ORGANIZATION
            = "update Organization set OrganizationName = ?, "
            + "OrganizationDescription = ?, OrganizationAddress = ?, "
            + "OrganizationPhone = ?, OrganizationEmail = ? "
            + "where OrganizationID = ?";

    public static final String SQL_SELECT_ORGANIZATION_BY_ID
            = "SELECT * from Organization where OrganizationID = ?";

    public static final String SQL_GET_ALL_ORGANIZATIONS
            = "SELECT * from Organization";

    //Sighting//
    public static final String SQL_INSERT_SIGHTING
            = "insert into Sighting (SightingDate, LocationID) values (?, ?)";

    public static final String SQL_DELETE_SIGHTING
            = "delete from Sighting where SightingID = ?";

    public static final String SQL_UPDATE_SIGHTING
            = "update Sighting set SightingDate = ?, LocationID = ? "
            + "where SightingID = ?";

    public static final String SQL_SELECT_SIGHTING_BY_ID
            = "SELECT * from Sighting where SightingID = ?";

    public static final String SQL_SELECT_ALL_SIGHTINGS
            = "SELECT * from Sighting";

    public static final String SQL_SELECT_ALL_SIGHTINGS_BY_DATE
            = "SELECT sight.SightingID, sight.SightingDate, loc.* "
            + "from Sighting sight "
//            + "join SuperSighting ss on ss.SightingID = sight.SightingID "
//            + "join SuperHero sh on sh.SuperID = ss.SuperID "
            + "left join Location loc on loc.LocationID = sight.LocationID "
            + "where sight.SightingDate = ?";

    public static final String SQL_SELECT_ALL_SIGHTINGS_BY_LOCATION
            = "SELECT sight.* from from Sighting sight "
            + "join Location loc on loc.LocationID = sight.LocationID "
            + "where loc.LocationID = ?";

    public static final String SQL_SELECT_LOCATION_BY_SIGHTING
            = "SELECT loc.* from Location loc "
            + "join Sighting sight on sight.LocationID = loc.LocationID "
            + "where sight.SightingID = ?";

    public static final String SQL_SELECT_SUPER_BY_SIGHTING
            = "SELECT sh.* from SuperHero sh "
            + "join SuperSighting ss on ss.SuperID = sh.SuperID "
            + "join Sighting sight on sight.SightingID = ss.SightingID "
            + "where sight.SightID = ?";

    //Supers//
    public static final String SQL_INSERT_SUPER
            = "insert into SuperHero "
            + "(SuperName, SuperDescription, SuperPower) "
            + "values (?, ?, ?)";

    public static final String SQL_DELETE_SUPER
            = "delete from SuperHero where SuperID = ?";

    public static final String SQL_UPDATE_SUPER
            = "update SuperHero "
            + "set SuperName = ?, SuperDescription = ?, SuperPower = ? "
            + "where SuperID = ?";

    public static final String SQL_SELECT_SUPER_BY_ID
            = "SELECT * from SuperHero where SuperID = ?";

    public static final String SQL_SELECT_ALL_SUPERS
            = "SELECT * from SuperHero";

    public static final String SQL_SELECT_ALL_SUPERS_BY_LOCATION
            = "SELECT distinct sh.* from Location loc "
            + "join Sighting sight on sight.LocationID = loc.LocationID "
            + "join SuperSighting ss on ss.SightingID = sight.SightingID "
            + "join SuperHero sh on sh.SuperID = ss.SuperID "
            + "where loc.LocationID = ?";

    //Bridge Tables
    public static final String SQL_INSERT_SUPERORGANIZATION
            = "Insert into SuperOrganization "
            + "(SuperID, OrganizationID) "
            + "values (?, ?)";
    
    public static final String SQL_DELETE_SUPERS_IN_ORGANIZATION
            = "Delete from SuperOrganization where SuperID = ?";
    
    public static final String SQL_UPDATE_SUPERS_IN_ORGANIZATION
            = "update SuperOrganization "
            + "set SuperID = ?, OrganizationID = ? "
            + "where SuperID = ?";
    
    public static final String SQL_SELECT_ALL_SUPERS_IN_ORGANIZATION
            = "SELECT o.OrganizationName, sh* from SuperHero sh "
            + "join SuperOrganization so on sh.SuperID = so.SuperID "
            + "where so.OrganizationID = ?";
    
    public static final String SQL_SELECT_ALL_SUPERS_BY_ORGANIZATION
            = "SELECT distinct sh.* from SuperOrganization "
            + "join Organization org on org.OrganizationID = org.OrganizationID "
            + "join SuperHero sh on sh.SuperID = sh.SuperID "
            + "where SuperOrganization.OrganizationID = ?";

    //Supers at Sighting
    public static final String SQL_INSERT_SUPERSIGHTINGS
            = "INSERT into SuperSighting "
            + "(SuperID, SightingID) "
            + "values (?, ?)";
    
    public static final String SQL_DELETE_SUPERSIGHTINGS
            = "DELETE FROM SuperSighting where SightingID = ?";
    
    public static final String SQL_SELECT_SIGHTING_BY_SUPER
            = "select * from Sighting sight "
            + "join SuperSighting ss on ss.SightingID = sight.SightingID "
            + "where ss SightingID = ?";
    
    public static final String SQL_SELECT_SUPERS_BY_SIGHTING
            = "select * from SuperHero sh "
            + "join SuperSighting ss on ss.SuperID = sh.SuperID "
            + "where ss.SightingID = ?";
    
    public static final String SQL_SELECT_TEN_SIGHTINGS
            = "select Sighting.SightingDate, Location.LocationName, SuperHero.SuperName from Sighting "
            + "inner join SuperSighting on Sighting.SightingID = SuperSighting.SightingID "
            + "inner join Location on Sighting.LocationID = Location.LocationID "
            + "inner join SuperHero on SuperSighting.SuperID = SuperHero.SuperID "
            + "order by SightingDate desc "
            + "limit 10";
    
    public static final String SQL_UPDATE_SUPER_SIGHTING
            = "update SuperSighting set SuperID = ? "
            + "where SightingID = ?";

}
