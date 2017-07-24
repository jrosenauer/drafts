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
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class LocationDaoTest {

    LocationDao locationDao;
    SuperDao superDao;
    SightingDao sightingDao;

    public LocationDaoTest() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");

        locationDao = ctx.getBean("locationDao", LocationDao.class);
        superDao = ctx.getBean("superDao", SuperDao.class);
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
    }

    @Test
    public void addGetLocation() throws Exception {
        Location location = new Location();
        location.setLocationName("Minneapolis");
        location.setLocationDescription("Around the block from downtown Minneapolis");
        location.setLocationAddress("500 East Grant Street, Minneapolis, MN 55404");
        location.setLocationLongitude(-93.268233);
        location.setLocationLatitude(44.970184);
//        List< Super> supers = new ArrayList<>();
//        location.setSupers(supers);
        Location locationAdded = locationDao.addLocation(location);

        Location fromDao = locationDao.getLocationByID(location.getLocationID());
        assertEquals(fromDao.getLocationName(), location.getLocationName());
        assertEquals(fromDao.getLocationDescription(), location.getLocationDescription());
        assertEquals(fromDao.getLocationAddress(), location.getLocationAddress());
        assertEquals(fromDao.getLocationLongitude(), location.getLocationLongitude(), -00.268233);
        assertEquals(fromDao.getLocationLatitude(), location.getLocationLatitude(), 00.970184);
    }

    @Test
    public void DeleteLocation() {
        Location location = new Location();
        location.setLocationName("Minneapolis");
        location.setLocationDescription("Around the block from downtown Minneapolis");
        location.setLocationAddress("500 East Grant Street, Minneapolis, MN 55404");
        location.setLocationLongitude(-93.268233);
        location.setLocationLatitude(44.970184);
//        List< Super> supers = new ArrayList<>();
//        location.setSupers(supers);
        Location locationAdded = locationDao.addLocation(location);

        Location fromDao = locationDao.getLocationByID(location.getLocationID());
        assertNotNull(fromDao);

        locationDao.deleteLocation(location.getLocationID());

        Location newLocation = locationDao.getLocationByID(location.getLocationID());
        assertNull(newLocation);
    }

    @Test
    public void UpdateLocation() {

        Location location = new Location();
        location.setLocationName("Minneapolis");
        location.setLocationDescription("Around the block from downtown Minneapolis");
        location.setLocationAddress("500 East Grant Street, Minneapolis, MN 55404");
        location.setLocationLongitude(-93.268233);
        location.setLocationLatitude(44.970184);
//        List< Super> supers = new ArrayList<>();
//        location.setSupers(supers);
        Location locationAdded = locationDao.addLocation(location);

        locationAdded.setLocationName("Lava Land");

        locationDao.updateLocation(locationAdded);

        Location locationIDFinal = locationDao.getLocationByID(locationAdded.getLocationID());

        assertEquals(locationIDFinal.getLocationName(), "Lava Land");

    }

    @Test
    public void GetLocationByID() {

        Location location = new Location();
        location.setLocationName("Minneapolis");
        location.setLocationDescription("Around the block from downtown Minneapolis");
        location.setLocationAddress("500 East Grant Street, Minneapolis, MN 55404");
        location.setLocationLongitude(-93.268233);
        location.setLocationLatitude(44.970184);
//        List< Super> supers = new ArrayList<>();
//        location.setSupers(supers);
        Location locationAdded = locationDao.addLocation(location);

        Location fromDao = locationDao.getLocationByID(location.getLocationID());
        assertEquals(fromDao.getLocationName(), location.getLocationName());
        assertEquals(fromDao.getLocationDescription(), location.getLocationDescription());
        assertEquals(fromDao.getLocationAddress(), location.getLocationAddress());
        assertEquals(fromDao.getLocationLongitude(), location.getLocationLongitude(), -00.268233);
        assertEquals(fromDao.getLocationLatitude(), location.getLocationLatitude(), 00.970184);

    }

    @Test
    public void GetAllLocations() {

        Location location = new Location();
        location.setLocationName("Minneapolis");
        location.setLocationDescription("Around the block from downtown Minneapolis");
        location.setLocationAddress("500 East Grant Street, Minneapolis, MN 55404");
        location.setLocationLongitude(-93.268233);
        location.setLocationLatitude(44.970184);
//        List< Super> supers = new ArrayList<>();
//        location.setSupers(supers);
        Location locationAdded = locationDao.addLocation(location);

        Location location2 = new Location();
        location2.setLocationName("Minneapolis");
        location2.setLocationDescription("Around the block from downtown Minneapolis");
        location2.setLocationAddress("500 East Grant Street, Minneapolis, MN 55404");
        location2.setLocationLongitude(-93.268233);
        location2.setLocationLatitude(44.970184);
//        List< Super> supers2 = new ArrayList<>();
//        location.setSupers(supers);
        Location locationAdded2 = locationDao.addLocation(location);

        List< Location> allLocations = locationDao.getAllLocations();

        assertEquals(2, locationDao.getAllLocations().size());
    }

    @Test
    public void GetAllLocationsBySuper() {
        
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
        //location.setSupers(supers);

        Location locationAdded = locationDao.addLocation(location);

        Location location2 = new Location();
        location2.setLocationName("Minneapolis2");
        location2.setLocationDescription("Around the block from downtown Minneapolis2");
        location2.setLocationAddress("500 East Grant Street, Minneapolis, MN 554042");
        location2.setLocationLongitude(-90.268233);
        location2.setLocationLatitude(54.970184);
        //location2.setSupers(supers);
        Location locationAdded2 = locationDao.addLocation(location2);

        //Location fromDao = locationDao.getLocationByID(super1.getSuperID());
        //assertEquals(fromDao.getLocationID(), super1.getSuperID());
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
      
        List< Location> locationListFiltered = locationDao.getAllLocationsBySuper(superPerson.getSuperID());
        assertEquals(2, locationListFiltered.size());
    }

}
