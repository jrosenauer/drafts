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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class SuperDaoTest {

    SuperDao superDao;
    OrganizationDao organizationDao;
    LocationDao locationDao;
    SightingDao sightingDao;

    public SuperDaoTest() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");

        superDao = ctx.getBean("superDao", SuperDao.class);
        organizationDao = ctx.getBean("organizationDao", OrganizationDao.class);
        locationDao = ctx.getBean("locationDao", LocationDao.class);
        sightingDao = ctx.getBean("sightingDao", SightingDao.class);

        List<Sighting> sightingList = sightingDao.getAllSightings();
        if (sightingList != null) {
            for (Sighting currentSighting : sightingList) {
                sightingDao.deleteSighting(currentSighting.getSightingID());
            }
        }

        List<Super> superList = superDao.getAllSupers();
        if (superList != null) {
            for (Super currentSuper : superList) {
                superDao.deleteSuper(currentSuper.getSuperID());
            }
        }

        List<Location> locationList = locationDao.getAllLocations();
        if (locationList != null) {
            for (Location currentLocation : locationList) {
                locationDao.deleteLocation(currentLocation.getLocationID());
            }
        }

        List<Organization> organizationList = organizationDao.getAllOrganizations();
        if (organizationList != null) {
            for (Organization currentOrganization : organizationList) {
                organizationDao.deleteOrganization(currentOrganization.getOrganizationID());
            }
        }

    }

    @Test
    public void addGetSuper() throws Exception {
        Super superPerson = new Super();
        superPerson.setSuperName("Franny");
        superPerson.setSuperDescription("Loves to fly");
        superPerson.setSuperPower("flying");
        // Organization org = organizationDao.getOrganizationByID(91);

//        Organization organization = new Organization();
//        organization.setOrganizationName("YMCA");
//        organization.setOrganizationDescription("non profit organization to fight crime");
//        organization.setOrganizationAddress("1000 Main Street, St Paul 10294");
//        organization.setOrganizationPhone("8493723829");
//        organization.setOrganizationEmail("organization@gmail.com");
//        List< Organization> organizations = new ArrayList<>();
//        organizations.add(organization);
//        superPerson.setOrganizations(organizations);
//        List< Sighting> sightings = new ArrayList<>();
//        superPerson.setSightings(sightings);
        Super superAdded = superDao.addSuper(superPerson);

        Super fromDao = superDao.getSuperByID(superPerson.getSuperID());
        assertEquals(fromDao.getSuperName(), superPerson.getSuperName());
        assertEquals(fromDao.getSuperDescription(), superPerson.getSuperDescription());
        assertEquals(fromDao.getSuperPower(), superPerson.getSuperPower());
    }

    @Test
    public void DeleteSuper() {

        Super superPerson = new Super();
        superPerson.setSuperName("Franny");
        superPerson.setSuperDescription("Loves to fly");
        superPerson.setSuperPower("flying");
//        List< Organization> organizations = new ArrayList<>();
//        superPerson.setOrganizations(organizations);
//        List< Sighting> sightings = new ArrayList<>();
//        superPerson.setSightings(sightings);
        Super superAdded = superDao.addSuper(superPerson);

        Super fromDao = superDao.getSuperByID(superPerson.getSuperID());
        assertNotNull(fromDao);

        superDao.deleteSuper(superPerson.getSuperID());

        Super newSuperPerson = superDao.getSuperByID(superPerson.getSuperID());
        assertEquals(newSuperPerson, newSuperPerson);
    }

    @Test
    public void UpdateSuper() {

        LocalDate dt = LocalDate.parse("2017-07-17", DateTimeFormatter.ISO_DATE);
        LocalDate dt2 = LocalDate.parse("2015-05-20", DateTimeFormatter.ISO_DATE);

        Super superPerson = new Super();
        superPerson.setSuperName("Franny");
        superPerson.setSuperDescription("Loves to fly");
        superPerson.setSuperPower("flying");
//        List< Organization> organizations = new ArrayList<>();
//        superPerson.setOrganizations(organizations);
//        List< Sighting> sightings = new ArrayList<>();
//        superPerson.setSightings(sightings);
        Super superAdded = superDao.addSuper(superPerson);

        superAdded.setSuperName("Jessica");

        superDao.updateSuper(superAdded);

        Super superIDFinal = superDao.getSuperByID(superAdded.getSuperID());

        assertEquals(superIDFinal.getSuperName(), "Jessica");
    }

    @Test
    public void GetSuperByID() {

        Super superPerson = new Super();
        superPerson.setSuperName("Franny");
        superPerson.setSuperDescription("Loves to fly");
        superPerson.setSuperPower("flying");
//        List< Organization> organizations = new ArrayList<>();
//        superPerson.setOrganizations(organizations);
//        List< Sighting> sightings = new ArrayList<>();
//        superPerson.setSightings(sightings);
        Super superAdded = superDao.addSuper(superPerson);

        Super fromDao = superDao.getSuperByID(superPerson.getSuperID());
        assertEquals(fromDao.getSuperName(), superPerson.getSuperName());
        assertEquals(fromDao.getSuperDescription(), superPerson.getSuperDescription());
        assertEquals(fromDao.getSuperPower(), superPerson.getSuperPower());

    }

    @Test
    public void GetAllSupers() throws Exception {

        Super superPerson = new Super();
        superPerson.setSuperName("Franny");
        superPerson.setSuperDescription("Loves to fly");
        superPerson.setSuperPower("flying");

//        List< Sighting> sightings = new ArrayList<>();
//        superPerson.setSightings(sightings);
        Super superAdded = superDao.addSuper(superPerson);

        Super superPerson2 = new Super();
        superPerson2.setSuperName("Franny2");
        superPerson2.setSuperDescription("Loves to fly2");
        superPerson2.setSuperPower("flying2");

//        List< Sighting> sightings2 = new ArrayList<>();
//        superPerson2.setSightings(sightings);
        Super superAdded2 = superDao.addSuper(superPerson2);

        List< Super> allSupers = superDao.getAllSupers();

        assertEquals(2, superDao.getAllSupers().size());

    }

    @Test
    public void GetAllSupersByOrganization() {

//        Organization organization = new Organization();
//        organization.setOrganizationName("YMCA");
//        organization.setOrganizationDescription("non profit organization to fight crime");
//        organization.setOrganizationAddress("1000 Main Street, St Paul 10294");
//        organization.setOrganizationPhone("8493723829");
//        organization.setOrganizationEmail("organization@gmail.com");
//        List<Super> supers = new ArrayList<>();
//        //Organization organizationAdded = organizationDao.addOrganization(organization);
        Super superPerson = new Super();
        superPerson.setSuperName("Franny");
        superPerson.setSuperDescription("Loves to fly");
        superPerson.setSuperPower("flying");
        Super superAdded = superDao.addSuper(superPerson);

        Super superPerson2 = new Super();
        superPerson2.setSuperName("Franny2");
        superPerson2.setSuperDescription("Loves to fly2");
        superPerson2.setSuperPower("flying2");
        Super superAdded2 = superDao.addSuper(superPerson2);

        Organization organization = new Organization();
        organization.setOrganizationName("YMCA");
        organization.setOrganizationDescription("non profit organization to fight crime");
        organization.setOrganizationAddress("1000 Main Street, St Paul 10294");
        organization.setOrganizationPhone("8493723829");
        organization.setOrganizationEmail("organization@gmail.com");
        List<Super> supers = new ArrayList<>();
        supers.add(superAdded);
        supers.add(superAdded2);
        organization.setMembers(supers);
        Organization orgAdded = organizationDao.addOrganization(organization);

        List< Organization> organizations = new ArrayList<>();
        organizations.add(organization);

        List< Super> members = new ArrayList<>();
        organization.setMembers(supers);

        List< Super> superListFiltered = superDao.getAllSupersByOrganization(organization.getOrganizationID());

        assertEquals(2, superListFiltered.size());

    }

    @Test
    public void GetAllSupersByLocation() {

        List< Super> supers = new ArrayList<>();
        Super superPerson = new Super();
        superPerson.setSuperName("Franny");
        superPerson.setSuperDescription("Loves to fly");
        superPerson.setSuperPower("flying");
        Super superAdded = superDao.addSuper(superPerson);
        supers.add(superAdded);

        Super superPerson2 = new Super();
        superPerson2.setSuperName("Franny2");
        superPerson2.setSuperDescription("Loves to fly2");
        superPerson2.setSuperPower("flying2");
        Super superAdded2 = superDao.addSuper(superPerson2);
        supers.add(superAdded2);

        Location location = new Location();
        location.setLocationName("Minneapolis");
        location.setLocationDescription("Around the block from downtown Minneapolis");
        location.setLocationAddress("500 East Grant Street, Minneapolis, MN 55404");
        location.setLocationLongitude(-93.268233);
        location.setLocationLatitude(44.970184);
        //location.setSupers(supers);
        Location locationAdded = locationDao.addLocation(location);

        Sighting sighting = new Sighting();
        sighting.setLocationID(location.getLocationID());
        sighting.setLocation(location);
        sighting.setSightingDate(LocalDate.now());
        sighting.setSupers(supers);
        sightingDao.addSighting(sighting);

        Sighting sighting2 = new Sighting();
        sighting2.setLocationID(location.getLocationID());
        sighting2.setLocation(location);
        sighting2.setSightingDate(LocalDate.now());
        sighting2.setSupers(supers);
        sightingDao.addSighting(sighting2);

        Super fromDao = superDao.getSuperByID(superAdded.getSuperID());
        List< Super> superListFiltered = superDao.getAllSupersByLocation(locationAdded.getLocationID());

        assertEquals(2, superListFiltered.size());
    }

}
