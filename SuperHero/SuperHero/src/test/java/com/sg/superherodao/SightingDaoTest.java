/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherodao;

import com.sg.superheromodel.Location;
import com.sg.superheromodel.Sighting;
import com.sg.superheromodel.Super;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class SightingDaoTest {

    SightingDao sightingDao;
    SuperDao superDao;
    LocationDao locationDao;

    public SightingDaoTest() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");

        sightingDao = ctx.getBean("sightingDao", SightingDao.class);
        superDao = ctx.getBean("superDao", SuperDao.class);
        locationDao = ctx.getBean("locationDao", LocationDao.class);

        List<Sighting> sightingList = sightingDao.getAllSightings();
        if (sightingList != null) {
            for (Sighting currentSighting : sightingList) {
                sightingDao.deleteSighting(currentSighting.getSightingID());
            }
        }

        List<Location> locationList = locationDao.getAllLocations();
        if (locationList != null) {
            for (Location currentLocation : locationList) {
                locationDao.deleteLocation(currentLocation.getLocationID());
            }
        }
    }

    @Test
    public void addGetSighting() throws Exception {

        LocalDate dt = LocalDate.of(2017, 07, 15);

        Super superPerson = new Super();
        superPerson.setSuperName("Franny2");
        superPerson.setSuperDescription("Loves to fly2");
        superPerson.setSuperPower("flying2");
        Super superAdded = superDao.addSuper(superPerson);
        List< Super> supers = new ArrayList<>();
        supers.add(superAdded);

        Location location = new Location();
        location.setLocationName("Minneapolis");
        location.setLocationDescription("Around the block from downtown Minneapolis");
        location.setLocationAddress("500 East Grant Street, Minneapolis, MN 55404");
        location.setLocationLongitude(-93.268233);
        location.setLocationLatitude(44.970184);

        Location locationAdded = locationDao.addLocation(location);

        Sighting sighting = new Sighting();
        sighting.setLocationID(locationAdded.getLocationID());
        sighting.setLocation(locationAdded);
        sighting.setSightingDate(LocalDate.now());
        sighting.setSupers(supers);
        sightingDao.addSighting(sighting);

        Sighting fromDao = sightingDao.getSightingByID(sighting.getSightingID());
        assertEquals(fromDao.getSightingDate(), sighting.getSightingDate());
        assertEquals(fromDao.getLocation(), sighting.getLocation());
    }

    @Test
    public void DeleteSighting() {

        LocalDate dt = LocalDate.of(2017, 07, 15);

        Location location = new Location();
        location.setLocationName("Minneapolis");
        location.setLocationDescription("Around the block from downtown Minneapolis");
        location.setLocationAddress("500 East Grant Street, Minneapolis, MN 55404");
        location.setLocationLongitude(-93.268233);
        location.setLocationLatitude(44.970184);
        List< Super> supers = new ArrayList<>();
//        location.setSupers(supers);
        Location locationAdded = locationDao.addLocation(location);

        Sighting sighting = new Sighting();
        sighting.setSightingDate(dt);

        sighting.setLocationID(locationAdded.getLocationID());

        sighting.setSupers(supers);
        sightingDao.addSighting(sighting);

        Sighting fromDao = sightingDao.getSightingByID(sighting.getSightingID());
        assertNotNull(fromDao);

        sightingDao.deleteSighting(sighting.getSightingID());
        Sighting newSighting = sightingDao.getSightingByID(sighting.getSightingID());
        assertNull(newSighting);

    }

    @Test
    public void UpdateSighting() {

        LocalDate dt = LocalDate.parse("2017-07-17", DateTimeFormatter.ISO_DATE);
        LocalDate dt2 = LocalDate.parse("2015-05-20", DateTimeFormatter.ISO_DATE);

        Location location = new Location();
        location.setLocationName("St Louis, MO");
        location.setLocationDescription("Around the block from downtown St Louis");
        location.setLocationAddress("101 East Circle Street, St Louis, MO 12345");
        location.setLocationLongitude(-75.48394);
        location.setLocationLatitude(48.96482);
        List< Super> supers = new ArrayList<>();
        //location.setSupers(supers);
        Location locationAdded = locationDao.addLocation(location);

        Sighting sighting = new Sighting();
        sighting.setSightingDate(dt);

        sighting.setLocationID(locationAdded.getLocationID());

        sighting.setSupers(supers);
        sightingDao.addSighting(sighting);

        Sighting fromDao = sightingDao.getSightingByID(sighting.getSightingID());

        fromDao.setSightingDate(dt2);

        sightingDao.updateSighting(fromDao);

        Sighting fromDao2 = sightingDao.getSightingByID(fromDao.getSightingID());

        //List<Sighting> newSighting = sightingDao.getAllSightingsByDate(dt2);
        assertEquals(fromDao2.getSightingDate(), dt2);
    }

    @Test
    public void GetSightingByID() {

        LocalDate dt = LocalDate.of(2017, 07, 15);

        Location location = new Location();
        location.setLocationName("Minneapolis");
        location.setLocationDescription("Around the block from downtown Minneapolis");
        location.setLocationAddress("500 East Grant Street, Minneapolis, MN 55404");
        location.setLocationLongitude(-93.268233);
        location.setLocationLatitude(44.970184);
        List< Super> supers = new ArrayList<>();
        //location.setSupers(supers);
        Location locationAdded = locationDao.addLocation(location);

        Sighting sighting = new Sighting();

        sighting.setSightingDate(dt);

        sighting.setLocationID(locationAdded.getLocationID());
        Sighting sightingAdded = sightingDao.addSighting(sighting);

        //sighting.setSightingID(sighting.getSightingID());
        //sighting.setSupers(supers);
        Sighting fromDao = sightingDao.getSightingByID(sightingAdded.getSightingID());
        assertEquals(fromDao.getSightingID(), sightingAdded.getSightingID());
        assertEquals(fromDao.getSightingDate(), sightingAdded.getSightingDate());
        assertEquals(fromDao.getLocationID(), sightingAdded.getLocationID());

    }

    @Test
    public void GetAllSightings() {

        LocalDate dt = LocalDate.of(2017, 07, 15);

        Super superPerson = new Super();
        superPerson.setSuperName("Franny");
        superPerson.setSuperDescription("Loves to fly");
        superPerson.setSuperPower("flying");

        Location location = new Location();
        location.setLocationName("Minneapolis");
        location.setLocationDescription("Around the block from downtown Minneapolis");
        location.setLocationAddress("500 East Grant Street, Minneapolis, MN 55404");
        location.setLocationLongitude(-93.268233);
        location.setLocationLatitude(44.970184);
        List< Super> supers = new ArrayList<>();
        //location.setSupers(supers);
        Location locationAdded = locationDao.addLocation(location);

        Location location2 = new Location();
        location2.setLocationName("Annapolis");
        location2.setLocationDescription("Around the block from downtown Indianapolis");
        location2.setLocationAddress("500 East Monty Street, IN 47384");
        location2.setLocationLongitude(-93.268233);
        location2.setLocationLatitude(44.970184);
        List< Super> supers2 = new ArrayList<>();
        //location2.setSupers(supers2);
        Location locationAdded2 = locationDao.addLocation(location2);

        Sighting sighting = new Sighting();
        sighting.setLocationID(location.getLocationID());
        sighting.setLocation(location);
        sighting.setSightingDate(LocalDate.now());
        sighting.setSupers(supers);
        sightingDao.addSighting(sighting);

        Sighting sighting2 = new Sighting();
        sighting2.setLocationID(location2.getLocationID());
        sighting2.setLocation(location2);
        sighting2.setSightingDate(LocalDate.now());
        sighting2.setSupers(supers);
        sightingDao.addSighting(sighting2);

        List<Sighting> allSightings = sightingDao.getAllSightings();

        assertEquals(2, sightingDao.getAllSightings().size());
    }

    @Test
    public void GetAllSightingsByDate() {

        LocalDate dt = LocalDate.of(2017, 07, 15);

        Location location = new Location();
        location.setLocationName("Minneapolis");
        location.setLocationDescription("Around the block from downtown Minneapolis");
        location.setLocationAddress("500 East Grant Street, Minneapolis, MN 55404");
        location.setLocationLongitude(-93.268233);
        location.setLocationLatitude(44.970184);
        //List< Super> supers = new ArrayList<>();
        //location.setSupers(supers);
        Location locationAdded = locationDao.addLocation(location);

        Sighting sighting = new Sighting();
        sighting.setSightingDate(dt);
        sighting.setLocation(locationAdded);
        sighting.setLocationID(locationAdded.getLocationID());

        //sighting.setSupers(supers);
        sightingDao.addSighting(sighting);

        Sighting fromDao = sightingDao.getSightingByID(sighting.getSightingID());
        assertEquals(fromDao.getSightingDate(), sighting.getSightingDate());
        assertEquals(fromDao.getLocation(), sighting.getLocation());

        LocalDate dt2 = LocalDate.of(2016, 06, 16);

        Location location2 = new Location();
        location2.setLocationName("Minneapolis");
        location2.setLocationDescription("Around the block from downtown Minneapolis");
        location2.setLocationAddress("500 East Grant Street, Minneapolis, MN 55404");
        location2.setLocationLongitude(-93.268233);
        location2.setLocationLatitude(44.970184);
//        List< Super> supers2 = new ArrayList<>();
//        supers2.add(super);
//        location2.setSupers(supers2);
        Location locationAdded2 = locationDao.addLocation(location2);

        Sighting sighting2 = new Sighting();
        sighting2.setSightingDate(dt2);
        
        sighting2.setLocation(locationAdded2);

        sighting2.setLocationID(locationAdded2.getLocationID());

        //sighting2.setSupers(supers2);
        sightingDao.addSighting(sighting2);

        Sighting fromDao2 = sightingDao.getSightingByID(sighting2.getSightingID());
        assertEquals(fromDao2.getSightingDate(), sighting2.getSightingDate());
        assertEquals(fromDao2.getLocation(), sighting2.getLocation());

        List< Sighting> sightingListFiltered = sightingDao.getAllSightingsByDate(dt2);
        assertEquals(1, sightingListFiltered.size());
    }

}
