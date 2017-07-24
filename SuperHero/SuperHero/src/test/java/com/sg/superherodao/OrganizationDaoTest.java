/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherodao;

import com.sg.superheromodel.Organization;
import com.sg.superheromodel.Super;
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
public class OrganizationDaoTest {

    OrganizationDao organizationDao;
    SuperDao superDao;

    public OrganizationDaoTest() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");

        organizationDao = ctx.getBean("organizationDao", OrganizationDao.class);

        List<Organization> organizationList = organizationDao.getAllOrganizations();
        if (organizationList != null) {
            for (Organization currentOrganization : organizationList) {
                organizationDao.deleteOrganization(currentOrganization.getOrganizationID());
            }
        }
    }

    @Test
    public void addGetOrganization() throws Exception {
        Organization organization = new Organization();
        organization.setOrganizationName("YMCA");
        organization.setOrganizationDescription("non profit organization to fight crime");
        organization.setOrganizationAddress("1000 Main Street, St Paul 10294");
        organization.setOrganizationPhone("8493723829");
        organization.setOrganizationEmail("organization@gmail.com");
        List<Super> supers = new ArrayList<>();
        organization.setMembers(supers);
        Organization organizationAdded = organizationDao.addOrganization(organization);

        Organization fromDao = organizationDao.getOrganizationByID(organization.getOrganizationID());
        assertEquals(fromDao.getOrganizationName(), organization.getOrganizationName());
        assertEquals(fromDao.getOrganizationDescription(), organization.getOrganizationDescription());
        assertEquals(fromDao.getOrganizationAddress(), organization.getOrganizationAddress());
        assertEquals(fromDao.getOrganizationPhone(), organization.getOrganizationPhone());
        assertEquals(fromDao.getOrganizationEmail(), organization.getOrganizationEmail());
    }

    @Test
    public void deleteOrganization() {

        Organization organization = new Organization();
        organization.setOrganizationName("YMCA");
        organization.setOrganizationDescription("non profit organization to fight crime");
        organization.setOrganizationAddress("1000 Main Street, St Paul 10294");
        organization.setOrganizationPhone("8493723829");
        organization.setOrganizationEmail("organization@gmail.com");
        List<Super> supers = new ArrayList<>();
        organization.setMembers(supers);
        organizationDao.addOrganization(organization);

        Organization fromDao = organizationDao.getOrganizationByID(organization.getOrganizationID());
        assertNotNull(fromDao);

        organizationDao.deleteOrganization(organization.getOrganizationID());

        Organization newOrganization = organizationDao.getOrganizationByID(organization.getOrganizationID());
        assertNull(newOrganization);
    }

    @Test
    public void UpdateOrganization() {
        Organization organization = new Organization();
        organization.setOrganizationName("YMCA");
        organization.setOrganizationDescription("non profit organization to fight crime");
        organization.setOrganizationAddress("1000 Main Street, St Paul 10294");
        organization.setOrganizationPhone("8493723829");
        organization.setOrganizationEmail("organization@gmail.com");
        List<Super> supers = new ArrayList<>();
        organization.setMembers(supers);
        Organization organizationAdded = organizationDao.addOrganization(organization);

        Organization organization2 = new Organization();
        organization2.setMembers(supers);

        organizationDao.addOrganization(organization);

        Organization fromDao = organizationDao.getOrganizationByID(organization2.getOrganizationID());

        organizationDao.updateOrganization(organization2);

        List< Organization> newOrganization = organizationDao.getAllOrganizations();

        assertNotEquals(organization, organization2);

    }

    @Test
    public void GetOrganizationByID() {
        Organization organization = new Organization();
        organization.setOrganizationName("YMCA");
        organization.setOrganizationDescription("non profit organization to fight crime");
        organization.setOrganizationAddress("1000 Main Street, St Paul 10294");
        organization.setOrganizationPhone("8493723829");
        organization.setOrganizationEmail("organization@gmail.com");
        List<Super> supers = new ArrayList<>();
        organization.setMembers(supers);
        Organization organizationAdded = organizationDao.addOrganization(organization);

        Organization fromDao = organizationDao.getOrganizationByID(organization.getOrganizationID());
        assertEquals(fromDao.getOrganizationName(), organization.getOrganizationName());
        assertEquals(fromDao.getOrganizationDescription(), organization.getOrganizationDescription());
        assertEquals(fromDao.getOrganizationAddress(), organization.getOrganizationAddress());
        assertEquals(fromDao.getOrganizationPhone(), organization.getOrganizationPhone());
        assertEquals(fromDao.getOrganizationEmail(), organization.getOrganizationEmail());

        Organization organization2 = new Organization();
        organization2.setOrganizationName("AAA");
        organization2.setOrganizationDescription("helps you with your car");
        organization2.setOrganizationAddress("100 main Street");
        organization2.setOrganizationPhone("3627389273");
        organization2.setOrganizationEmail("hello@aaa.com");
        List< Super> supers2 = new ArrayList<>();
        organization2.setMembers(supers2);
        Organization organizationAdded2 = organizationDao.addOrganization(organization2);

        Organization fromDao2 = organizationDao.getOrganizationByID(organization2.getOrganizationID());
        assertEquals(fromDao2.getOrganizationName(), organization2.getOrganizationName());
        assertEquals(fromDao2.getOrganizationDescription(), organization2.getOrganizationDescription());
        assertEquals(fromDao2.getOrganizationAddress(), organization2.getOrganizationAddress());
        assertEquals(fromDao2.getOrganizationPhone(), organization2.getOrganizationPhone());
        assertEquals(fromDao2.getOrganizationEmail(), organization2.getOrganizationEmail());

        //assertNotNull(organizationDao.getOrganizationByID(organization2.getOrganizationID()));
    }

    @Test
    public void GetAllOrganizations() {

        Organization organization = new Organization();
        organization.setOrganizationName("YMCA");
        organization.setOrganizationDescription("non profit organization to fight crime");
        organization.setOrganizationAddress("1000 Main Street, St Paul 10294");
        organization.setOrganizationPhone("8493723829");
        organization.setOrganizationEmail("organization@gmail.com");
        List<Super> supers = new ArrayList<>();
        organization.setMembers(supers);
        Organization organizationAdded = organizationDao.addOrganization(organization);

        organization.setMembers(supers);

        organization.setOrganizationID(organizationAdded.getOrganizationID());

        organization.setMembers(supers);
        //organizationDao.addOrganization(organization);

        Organization organization2 = new Organization();
        organization2.setOrganizationName("AAA");
        organization2.setOrganizationDescription("helps you with your car");
        organization2.setOrganizationAddress("100 main Street");
        organization2.setOrganizationPhone("3627389273");
        organization2.setOrganizationEmail("hello@aaa.com");
        List< Super> supers2 = new ArrayList<>();
        organization2.setMembers(supers2);
        Organization organizationAdded2 = organizationDao.addOrganization(organization2);

        organization2.setMembers(supers2);

        organization2.setOrganizationID(organizationAdded2.getOrganizationID());

        organization2.setMembers(supers2);
        //organizationDao.addOrganization(organization2);

        assertEquals(2, organizationDao.getAllOrganizations().size());
    }
}
