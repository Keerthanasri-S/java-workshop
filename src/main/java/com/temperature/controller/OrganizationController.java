package com.temperature.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.temperature.dao.OrganizationDao;
import com.temperature.model.OrganizationRep;

@RestController
public class OrganizationController {
    @Autowired
    private final OrganizationDao organizationDao;

    public OrganizationController(OrganizationDao organizationDao){
        this.organizationDao =organizationDao;
    }

    @GetMapping("/organization")
    public List<OrganizationRep> getList(){
        OrganizationRep organization = new OrganizationRep(2,"tech","tech@gmail.com","70-288403","tech.com");
        return Arrays.asList(organization);
    }
}
