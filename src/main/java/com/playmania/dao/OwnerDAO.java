package com.playmania.dao;

import com.playmania.entity.Owner;


import java.util.List;

public interface OwnerDAO {
    void save(Owner theOwner);
    List<Owner> getAllOwners();
    Owner getOwnerById(Long id);
}
