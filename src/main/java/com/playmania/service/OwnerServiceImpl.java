package com.playmania.service;

import com.playmania.dao.OwnerDAO;
import com.playmania.entity.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OwnerServiceImpl implements OwnerService{
    private OwnerDAO ownerDAO;
    private UUIDGenService uuidGenService;
    @Autowired
    public OwnerServiceImpl (OwnerDAO ownerDAO,UUIDGenService uuidGenService){
        this.ownerDAO=ownerDAO;
        this.uuidGenService=uuidGenService;
    }
    @Override
    public Long save(Owner theOwner) {
        Long id=uuidGenService.generateUniqueId();
        theOwner.setOwnerId(id);
        ownerDAO.save(theOwner);
        return theOwner.getOwnerId();
    }

    @Override
    public List<Owner> getAllOwners() {
        List<Owner> owners=ownerDAO.getAllOwners();
        return owners;
    }
}
