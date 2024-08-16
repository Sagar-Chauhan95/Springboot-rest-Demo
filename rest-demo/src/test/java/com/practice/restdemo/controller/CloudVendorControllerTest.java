package com.practice.restdemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.practice.restdemo.model.CloudVendor;
import com.practice.restdemo.service.CloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CloudVendorController.class)
class CloudVendorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CloudVendorService cloudVendorService;
    CloudVendor cloudVendorOne;
    CloudVendor cloudVendorTwo;
    List<CloudVendor> cloudVendorList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        cloudVendorOne = new CloudVendor("1", "Amazon",
                "USA", "4450");

        cloudVendorTwo = new CloudVendor("2", "Google",
                "UK", "2250" );

        cloudVendorList.add(cloudVendorOne);
        cloudVendorList.add(cloudVendorTwo);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testGetCloudVendorDetails() throws Exception {
        when(cloudVendorService.getCloudVendor("1")).thenReturn(cloudVendorOne);
        this.mockMvc.perform(get("/cloudvendor/1"))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    void testGetAllCloudVendors() throws Exception {
        when(cloudVendorService.getAllCloudVendors()).thenReturn(cloudVendorList);
        this.mockMvc.perform(get("/cloudvendor"))
                .andDo(print()).andExpect(status().isOk());

    }

//    @Test
//    void testCreateCloudVendor() throws Exception{
//
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
//        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
//        String requestJson = ow.writeValueAsString(cloudVendorOne);
//
//        when(cloudVendorService.createCloudVendor(cloudVendorOne))
//                .thenReturn("Successfully created CloudVendor");
//        this.mockMvc.perform(post("/cloudvendor"))
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(requestJson)
//                .andDO(print()).andExpect(status().isOk());
//
//
//    }

    @Test
    void testUpdateCloudVendor() {
        // similar to post instead ot post replace with put
    }

    @Test
    void testDeleteCloudVendor() throws Exception {
        when(cloudVendorService.deleteCloudVendor("1")).thenReturn("Successfully deleted");
        this.mockMvc.perform(delete("/cloudvendor/1"))
                .andDo(print()).andExpect(status().isOk());
    }
}