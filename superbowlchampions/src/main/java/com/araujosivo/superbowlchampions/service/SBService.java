package com.araujosivo.superbowlchampions.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.araujosivo.superbowlchampions.dtos.SBRequest;
import com.araujosivo.superbowlchampions.dtos.SBResponse;
import com.araujosivo.superbowlchampions.entities.SBChampions;
import com.araujosivo.superbowlchampions.mapper.SBMapper;
import com.araujosivo.superbowlchampions.repositories.SuperBowlRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SBService {
    
    @Autowired
    private SuperBowlRepository repository;

    //1 service
    public List<SBResponse> getAllSuperbowls(){
        return repository.findAll().stream().map(p -> SBMapper.toDTO(p)).collect(Collectors.toList());
    }

    //2 Service
    public SBResponse getSuperBowlById(long id){
        SBChampions sb = repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Não há agendamento")
        );

        return SBMapper.toDTO(sb);
    }

    //3 Service
    public SBResponse saveNewSbChampions(SBRequest superbowl){
        SBChampions newSB = repository.save(SBMapper.toEntity(superbowl));
        return SBMapper.toDTO(newSB);
    }

    //4 Service 
    public void updateSbChampions(SBRequest superbowl, long id){
        SBChampions updsb = repository.getReferenceById(id);

        updsb.setChampions(superbowl.champions());
        updsb.setScore(superbowl.score());
        updsb.setOpponent(superbowl.score());
        updsb.setMvp(superbowl.mvp());
        updsb.setSeason(superbowl.season());
        updsb.setLocal(superbowl.local());

        repository.save(updsb);
    }

    //5 Service
    public void deleteSbChampions(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }else{
            throw new EntityNotFoundException("Não há campeão");
        }
    }
}
