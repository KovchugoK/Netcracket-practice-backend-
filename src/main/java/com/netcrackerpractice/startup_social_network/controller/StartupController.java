package com.netcrackerpractice.startup_social_network.controller;

import com.netcrackerpractice.startup_social_network.entity.Startup;
import com.netcrackerpractice.startup_social_network.payload.SearchStartupsRequest;
import com.netcrackerpractice.startup_social_network.service.StartupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/startup")
public class StartupController {

    @Autowired
    private StartupService startupService;

    @GetMapping("/startup-list")
    public List<Startup> getStartupList() {
        return startupService.findAll();
    }

    @GetMapping("/search-startups")
    public List<Startup> searchStartups(SearchStartupsRequest searchStartupsRequest) {
        return startupService.searchStartups(
                searchStartupsRequest.getStartupNameContains(),
                searchStartupsRequest.getCreator(),
                searchStartupsRequest.getSortBy(),
                searchStartupsRequest.getSortDirection(),
                searchStartupsRequest.getAccountID()
        );
    }

    @GetMapping("/{id}")
    public Optional<Startup> getStartupById(@PathVariable(name = "id") UUID id) {
        return startupService.findStartupById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStartup(@PathVariable(name = "id") UUID id) {
        startupService.deleteStartupById(id);
    }

    @PostMapping("/create")
    public Startup saveStartup(@RequestBody Startup startup) {
        System.out.println(startup);
        return startupService.saveStartup(startup);
    }

    @PutMapping("/update/{id}")
    public Startup updateStartup(@PathVariable(name = "id") UUID id, @RequestBody Startup startup) {
        try {
            return startupService.updateStartup(id, startup,"");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}