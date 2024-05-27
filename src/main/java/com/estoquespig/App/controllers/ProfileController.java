package com.estoquespig.App.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estoquespig.App.dto.ProfileDTO;
import com.estoquespig.App.services.ProfileService;

@RestController
@RequestMapping(value = "/profile")
@CrossOrigin
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @PostMapping
    public void insert(@RequestBody ProfileDTO profileDTO) {
        profileService.insert(profileDTO);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        profileService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ProfileDTO edit(@RequestBody ProfileDTO profileDTO) {
        return profileService.edit(profileDTO);
    }

    @GetMapping
    public List<ProfileDTO> listAll() {
        return profileService.listAll();
    }

    @GetMapping("/{id}")
    public ProfileDTO searchById(@PathVariable Long id) {
        return profileService.searchById(id);
    }
}
