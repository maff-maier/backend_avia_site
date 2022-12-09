package com.back.end.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.end.entity.PlaneEntity;
import com.back.end.model.Plane;
import com.back.end.repository.PlaneRepository;

@Service
public class PlaneService {
    
    @Autowired
    private PlaneRepository repo;

    public PlaneEntity addPlane(PlaneEntity plane) throws Exception{
        if(repo.findBySideNumber(plane.getSideNumber()) != null){
            throw new Exception("Some error");
        }
        
        return repo.save(plane);
    }

    public List<Plane> getAll(){
        Iterable<PlaneEntity> pa = repo.findAll();

        List<PlaneEntity> stream = StreamSupport.stream(pa.spliterator(), false)
                                                .map(plane -> {
                                                    PlaneEntity pl = new PlaneEntity();
                                                    BeanUtils.copyProperties(plane, pl);
                                                    return pl;
                                                }).collect(Collectors.toList());
        return stream.stream().map(Plane::toPlane).collect(Collectors.toList());
    }
}
