package com.smartCity.weather.services;

import com.smartCity.weather.entities.Location;
import com.smartCity.weather.repositories.LocationRepository;
import com.smartCity.weather.services.location.*;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.grpc.server.service.GrpcService;

import java.util.List;
import java.util.Optional;

@GrpcService
public class LocationService extends LocationServiceGrpc.LocationServiceImplBase {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public void addLocation(AddLocationRequest request, StreamObserver<LocationResponse> responseObserver) {
        Location location = new Location(
                request.getCity(),
                request.getCountry(),
                request.getLatitude(),
                request.getLongitude());

     Location saved=  locationRepository.save(location);

        LocationResponse result = LocationResponse.newBuilder()
                .setId(saved.getId())
                .setCity(saved.getCity())
                .setCountry(saved.getCountry())
                .setLatitude(saved.getLatitude())
                .setLongitude(saved.getLongitude())
                .build();
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }

    @Override
    public void getLocation(LocationRequest request, StreamObserver<LocationResponse> responseObserver) {

        Optional<Location> location = locationRepository.findById(request.getId());
        if (location.isPresent()) {
            LocationResponse result = LocationResponse.newBuilder()
                    .setId(location.get().getId())
                    .setCity(location.get().getCity())
                    .setCountry(location.get().getCountry())
                    .setLatitude(location.get().getLatitude())
                    .setLongitude(location.get().getLongitude())
                    .build();
            responseObserver.onNext(result);
            responseObserver.onCompleted();
        }else
        {
            responseObserver.onError( new Exception("Location not found"));
        }
    }

    @Override
    public void getAllLocations(AllLocationRequest request, StreamObserver<AllLocationResponse> responseObserver) {
        List <Location> locations = locationRepository.findAll();
        AllLocationResponse.Builder responseBuilder = AllLocationResponse.newBuilder();

        for (Location loc : locations) {
            LocationResponse locationProto = LocationResponse.newBuilder()
                    .setId(loc.getId())
                    .setCity(loc.getCity())
                    .setCountry(loc.getCountry())
                    .setLatitude(loc.getLatitude())
                    .setLongitude(loc.getLongitude())
                    .build();

            responseBuilder.addLocations(locationProto);
        }


        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }
}
