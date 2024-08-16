package com.practice.restdemo.service;

import com.practice.restdemo.model.CloudVendor;

import java.util.List;

public interface CloudVendorService {

    public String createCloudVendor(CloudVendor cloudVendor);

    public String updateCloudVendor(CloudVendor cloudVendor);
    public String deleteCloudVendor(String cloudVendorId);
    public CloudVendor getCloudVendor(String cloudVendorId);
    public List<CloudVendor> getAllCloudVendors();

//    List<Object> getVendorName(String amazon);
//    public List<CloudVendor>getByVendorName(String vendorName);


}
