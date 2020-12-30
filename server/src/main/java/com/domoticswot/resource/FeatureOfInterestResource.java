package com.domoticswot.resource;

import com.domoticswot.model.FeatureOfInterest;
import com.domoticswot.model.UpdateFeatureOfInterestRequest;
import com.domoticswot.service.UpdateSensorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feature-of-interest")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FeatureOfInterestResource {

    @GetMapping("/list/all")
    public List<FeatureOfInterest> listAllFeatureOfInterest() {
        return UpdateSensorService.listFeatureOfInterests();
    }

    @GetMapping("/list-with-actuators/all")
    public List<FeatureOfInterest> listAllFeatureOfInterestWithActuators() {
        return UpdateSensorService.listFeaturesOfInterestWithActuators();
    }

    @GetMapping("/list-by-property")
    public List<String> listFeatureOfInterestByProperty(
            @RequestParam String property
    ) {
        return null;
    }

    @PostMapping("/new-actuation")
    public String updateFeatureOfInterestProperty(@RequestBody UpdateFeatureOfInterestRequest payload) {
        return UpdateSensorService.getActuation(payload);
    }
}
