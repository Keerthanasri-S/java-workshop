package com.temperature.controller;

import org.springframework.web.bind.annotation.RestController;

import com.temperature.dao.OrganizationDao;

@RestController
public class OrganizationController {
    private final OrganizationDao organizationDao;

    public OrganizationController(OrganizationDao organizationDao){
        this.organizationDao =organizationDao;
    }

    

}
