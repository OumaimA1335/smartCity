package com.smartCity.weather.services;

import com.smartCity.weather.entities.Location;
import com.smartCity.weather.entities.Weather;
import com.smartCity.weather.repositories.LocationRepository;
import com.smartCity.weather.repositories.WeatherRepository;
import com.smartCity.weather.services.weather.*;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.grpc.server.service.GrpcService;

import java.util.Optional;

@GrpcService
public class WeatherService extends WeatherServiceGrpc.WeatherServiceImplBase {
    @Autowired
    WeatherRepository weatherRepository;
    @Autowired
    LocationRepository locationRepository;
    @Override
    public void addWeather(AddWeatherRequest request,
                           StreamObserver<WeatherResponse> responseObserver) {
        Optional<Location> location = locationRepository.findById(request.getLocationId());
        if (location.isEmpty()) {
            responseObserver.onError(new Exception("Weather not found!"));
            return;
        }

        Weather weather = new Weather(
                location.get(),
                request.getTemperature(),
                (int) request.getHumidity(),
                request.getPressure(),
                request.getWindSpeed(),
                request.getWindDirection(),
                request.getDate()
        );

        Weather saved = weatherRepository.save(weather);
        com.smartCity.weather.services.weather.Location location1 = com.smartCity.weather.services.weather.Location.newBuilder()
                .setId(location.get().getId())
                .setCity(location.get().getCity())
                .setCountry(location.get().getCountry())
                .setLatitude(location.get().getLatitude())
                .setLongitude(location.get().getLongitude())
                .build();

        WeatherResponse response = WeatherResponse.newBuilder()
                .setId(saved.getId())
                .setLocation(location1)
                .setTemperature(saved.getTemperature())
                .setHumidity(saved.getHumidity())
                .setPressure(saved.getPressure())
                .setWindSpeed(saved.getWindSpeed())
                .setWindDirection(saved.getWindDirection())
                .setDate(saved.getDate())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void getWeather(WeatherRequest request, StreamObserver<WeatherResponse> responseObserver) {
       Optional<Weather> weather =  weatherRepository.findById(request.getId());
        if (weather.isEmpty()) {
            responseObserver.onError(new Exception("Weather not found!"));
        }else {
            com.smartCity.weather.services.weather.Location location1 = com.smartCity.weather.services.weather.Location.newBuilder()
                    .setId(weather.get().getLocation().getId())
                    .setCity(weather.get().getLocation().getCity())
                    .setCountry(weather.get().getLocation().getCountry())
                    .setLatitude(weather.get().getLocation().getLatitude())
                    .setLongitude(weather.get().getLocation().getLongitude())
                    .build();

            WeatherResponse result = WeatherResponse.newBuilder()
                    .setId(weather.get().getId())
                    .setLocation(location1)
                    .setTemperature(weather.get().getTemperature())
                    .setHumidity(weather.get().getHumidity())
                    .setPressure(weather.get().getPressure())
                    .setWindSpeed(weather.get().getWindSpeed())
                    .setWindDirection(weather.get().getWindDirection())
                    .setDate(weather.get().getDate())
                    .build();
            responseObserver.onNext(result);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getWeatherByCityAndDate(WeatherCityAndDateRequest request, StreamObserver<WeatherResponse> responseObserver) {
        Optional<Weather> weather = weatherRepository.findByLocationCityAndDate(request.getCity(), request.getDate());
        if(weather.isPresent()){
            com.smartCity.weather.services.weather.Location location1 = com.smartCity.weather.services.weather.Location.newBuilder()
                    .setId(weather.get().getLocation().getId())
                    .setCity(weather.get().getLocation().getCity())
                    .setCountry(weather.get().getLocation().getCountry())
                    .setLatitude(weather.get().getLocation().getLatitude())
                    .setLongitude(weather.get().getLocation().getLongitude())
                    .build();

            WeatherResponse result = WeatherResponse.newBuilder()
                    .setId(weather.get().getId())
                    .setLocation(location1)
                    .setTemperature(weather.get().getTemperature())
                    .setHumidity(weather.get().getHumidity())
                    .setPressure(weather.get().getPressure())
                    .setWindSpeed(weather.get().getWindSpeed())
                    .setWindDirection(weather.get().getWindDirection())
                    .setDate(weather.get().getDate())
                    .build();
            responseObserver.onNext(result);
            responseObserver.onCompleted();
        }else {
            responseObserver.onError(new Exception("Weather not found!"));
        }
    }

    @Override
    public void deleteWeather(WeatherRequest request, StreamObserver<DeleteWeatherResponse> responseObserver) {
        Optional<Weather> weather =  weatherRepository.findById(request.getId());
        if(weather.isPresent()){
            weatherRepository.deleteById(weather.get().getId());
            DeleteWeatherResponse result = DeleteWeatherResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("Success").build();
            responseObserver.onNext(result);
            responseObserver.onCompleted();
        }else {
            DeleteWeatherResponse   response = DeleteWeatherResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Weather not found")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}
