package br.dev.vktgabriel.rotaliteria.upx6.dependencies.implementation;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GoogleMapsService {

    private final GeoApiContext context;

    public LatLng getGeocoding(String address) throws IOException, InterruptedException, ApiException {
        GeocodingResult[] results = GeocodingApi.newRequest(context).address(address).await();
        return results[0].geometry.location;
    }
    public DistanceMatrix requestMatrixDistancia(String[] origins, String[] destinations) throws IOException, InterruptedException, ApiException {
        DistanceMatrixApiRequest request = DistanceMatrixApi.newRequest(context).origins(origins).destinations(destinations);
        return request.await();
    }

    public List<Long> getMatrixDistancia(String origem, List<String> destinations) throws IOException, InterruptedException, ApiException {
        String[] originArray = {origem};
        String[] destinationsArray = destinations.toArray(new String[destinations.size()]);
        return Arrays.stream(requestMatrixDistancia(originArray, destinationsArray).rows[0].elements)
                .map(e -> e.distance.inMeters)
                .toList();
    }
}