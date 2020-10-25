package br.com.salesmanagerweb.service;

import br.com.salesmanagerweb.client.TrackingClient;
import br.com.salesmanagerweb.model.OrderTracking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackingService {

    @Autowired
    TrackingClient trackingClient;

    public OrderTracking getTrackingByOrderId(String _id) {
        return trackingClient.getTrackingByOrderId(_id);
    }

    public List<String> getStatus() {
        return trackingClient.getStatus();
    }

    public OrderTracking addTrackingStep(String _id, String step) {
        return trackingClient.addTrackingStep(_id, step);
    }
}
