package com.back.end.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.end.entity.PlaneEntity;
import com.back.end.entity.RouteEntity;
import com.back.end.model.Route;
import com.back.end.repository.PlaneRepository;
import com.back.end.repository.RouteRepository;

@Service
public class RouteService {
    
    @Autowired
    private RouteRepository repo;

    @Autowired
    private PlaneRepository planeRepo;

    public Route addRoute(RouteEntity route, Long planeId) throws Exception{
        PlaneEntity plane = planeRepo.findById(planeId).get();

        List<RouteEntity> list = repo.findAllByArrival(route.getArrival()).stream().filter(out -> {
            return out.getDeparture().equals(route.getDeparture()) && out.getTimestamp().equals(route.getTimestamp());
        }).toList();

        if(list.size() != 0){
            throw new Exception("Some route error");
        }

        if(plane == null){
            throw new Exception("Wrong plane id");
        }

        route.setPlaneId(plane);

        return Route.toRoute(repo.save(route));
    }

    public List<Route> getAll(){
        Iterable<RouteEntity> pa = repo.findAll();

        List<RouteEntity> stream = StreamSupport.stream(pa.spliterator(), false)
                                                .map(plane -> {
                                                    RouteEntity pl = new RouteEntity();
                                                    BeanUtils.copyProperties(plane, pl);
                                                    return pl;
                                                }).collect(Collectors.toList());
        return stream.stream().map(Route::toRoute).collect(Collectors.toList());
    }

    //.stream().map(Route::toRoute).collect(Collectors.toList())
}
