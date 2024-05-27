package com.estoquespig.App.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estoquespig.App.dto.ProfileDTO;
import com.estoquespig.App.entities.ProfileEntity;
import com.estoquespig.App.repository.ProfileRepository;

@Service
public class ProfileService {
    @Autowired
    ProfileRepository profileRepository;

    public void insert(ProfileDTO profileDTO) {
        ProfileEntity profileEntity = new ProfileEntity(profileDTO);
        profileRepository.save(profileEntity);
    }

    public List<ProfileDTO>listAll() {
        List<ProfileEntity> profileDTOs = profileRepository.findAll();
        return profileDTOs.stream().map(ProfileDTO::new).toList();
    }

    public ProfileDTO edit(ProfileDTO profileDTO) {
        ProfileEntity profileEntity = new ProfileEntity(profileDTO);
        return new ProfileDTO(profileRepository.save(profileEntity));
    }

    public void delete(Long id) {
        ProfileEntity profileEntity = profileRepository.findById(id).get();
        profileRepository.delete(profileEntity);
    }

    public ProfileDTO searchById(Long id) {
        return new ProfileDTO(profileRepository.findById(id).get());
    }
    
}
