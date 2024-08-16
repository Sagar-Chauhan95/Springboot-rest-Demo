package com.practice.restdemo.controller;

import com.practice.restdemo.model.CloudVendor;
import com.practice.restdemo.response.ResponseHandler;
import com.practice.restdemo.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

   CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }


    @GetMapping("{vendorId}")
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        return ResponseHandler.responseBuilder("Requested vendor details are given here", HttpStatus.OK,cloudVendorService.getCloudVendor(vendorId) );
    }

    @GetMapping()
    public List<CloudVendor> getAllCloudVendors(){
        return cloudVendorService.getAllCloudVendors();
    }

    @PostMapping
    public String createCloudVendor(@RequestBody CloudVendor cloudVendor){
       cloudVendorService.createCloudVendor(cloudVendor);
        return "Cloud Vendor Created Successfully";

    }

    @PutMapping
    public String updateCloudVendor(@RequestBody CloudVendor cloudVendor){
      cloudVendorService.updateCloudVendor(cloudVendor);
        return "Cloud Vendor Updated Successfully";
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendor(@PathVariable("vendorId")  String vendorId){
     cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud Vendor Deleted Successfully";
    }
}
