package com.eka.latihan.controller;

import com.eka.latihan.entity.TdBarang;
import com.eka.latihan.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/Barang")
public class BarangController {

    @Autowired
    private BarangService barangService;

    @GetMapping("/getAllUbah")
    public ResponseEntity<?> getAllBarang() {
        ResponseEntity responseEntity = null;
        responseEntity = barangService.getAllBarang();
        return responseEntity;
    }
    @GetMapping("/getById")
    public ResponseEntity<?> getById(String idBarang) {
        ResponseEntity responseEntity = null;
        responseEntity = barangService.getById(idBarang);
        return responseEntity;
    }
    @PostMapping("/postBarang")
    public ResponseEntity<?> postBarang(TdBarang tdBarang){
        ResponseEntity responseEntity = null;
        responseEntity = barangService.postBarang(tdBarang);
        return responseEntity;
    }
    @DeleteMapping("/deleteBarang")
    public ResponseEntity<?> deleteById(String idBarang){
        ResponseEntity responseEntity = null;
        responseEntity = barangService.deleteBarang(idBarang);
        return responseEntity;
    }
}
