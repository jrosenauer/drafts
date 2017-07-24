/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherodao;

import com.sg.superheromodel.Location;
import com.sg.superheromodel.Organization;
import com.sg.superheromodel.Super;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface SuperDao {

    public Super addSuper(Super superhero);

    public void deleteSuper(int superID);

    public void updateSuper(Super superhero);

    public Super getSuperByID(int superID);

    public List< Super> getAllSupers();

    public List< Super> getAllSupersByOrganization(int organizationID);

    public List< Super> getAllSupersByLocation(int locationID);
}
