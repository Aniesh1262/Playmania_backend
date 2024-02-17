package com.playmania.contollers;

import com.playmania.entity.Owner;
import com.playmania.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {
    private OwnerService ownerService;

    @Autowired
    public OwnerController (OwnerService ownerService){
        this.ownerService=ownerService;
    }
    @GetMapping("/")
    public List<Owner> getAllOwners(){
        List<Owner> owners=ownerService.getAllOwners();
        return owners;

    }
    @PostMapping("/addOwner")
    public  Long addOwner(@RequestBody Owner owner){
       Long id= ownerService.save(owner);
       return id;
    }
}
