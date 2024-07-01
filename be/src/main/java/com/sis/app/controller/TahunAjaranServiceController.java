package com.sis.app.controller;

import com.sis.app.entitity.TahunAjaran;
import com.sis.app.impl.TahunAjaranServiceImpl;
import com.sis.app.service.TahunAjaranService;
import com.sis.app.web.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tahun-ajaran")
public class TahunAjaranServiceController {

    @Autowired
    private TahunAjaranServiceImpl tahunAjaranServiceImpl;

    @GetMapping
    public BaseResponse getAllTahunAjaran() {
        return tahunAjaranServiceImpl.getAllTahunAjaran();
    }

    @GetMapping("/{id}")
    public BaseResponse getTahunAjaranById(@PathVariable("id") int id) {
        return tahunAjaranServiceImpl.getTahunAjaranById(id);
    }

    @PostMapping
    public BaseResponse saveTahunAjaran(TahunAjaran tahunAjaran) {
        return tahunAjaranServiceImpl.saveTahunAjaran(tahunAjaran);
    }

    @DeleteMapping("/{id}")
    public BaseResponse deleteTahunAjaran(@PathVariable("id") int id) {
        return tahunAjaranServiceImpl.deleteTahunAjaran(id);
    }
}
