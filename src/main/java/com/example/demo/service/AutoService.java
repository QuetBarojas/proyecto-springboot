package com.example.demo.service;

import com.example.demo.dto.AutoDTO;
import com.example.demo.form.AutoForm;
import com.example.demo.model.Auto;
import com.example.demo.repository.AutoJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AutoService {


    private final  AutoJPA autoJPA;

    public List<AutoDTO> getAll(){
        final List<Auto> autos= autoJPA.findAll();

        if(autos.isEmpty()){
            return Collections.emptyList();
        }

        // return autos.stream().map(auto -> AutoDTO.build(auto)).toList();
        return autos.stream().map(AutoDTO::build).toList();
    }


    public Auto getById(final long id){
        final Auto auto= autoJPA.findById(id);
        return auto;
    }

    public AutoDTO getAutoDTOById(final long id){
        final Auto auto= autoJPA.findById(id);
        return AutoDTO.build(auto);
    }

    public AutoDTO create(final AutoForm autoForm){
        final Auto auto= new Auto(autoForm);
        autoJPA.save(auto);
        return AutoDTO.build(auto);

    }

    public AutoDTO update(final long id ,final AutoForm autoForm){
        final  Auto auto=getById(id);
        auto.update(autoForm);
        autoJPA.save(auto);
        return AutoDTO.build(auto);

    }
}
