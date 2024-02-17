package com.playmania.service;

import com.playmania.entity.Owner;

import java.util.List;

public interface OwnerService {
    Long save(Owner theOwner);
    List<Owner> getAllOwners();
}
