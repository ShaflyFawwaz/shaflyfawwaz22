package com.sis.app.controller;

import com.sis.app.entitity.Pembayaran;
import com.sis.app.impl.PembayaranServiceImpl;
import com.sis.app.service.PembayaranService;
import com.sis.app.web.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pembayaran")
public class PembayaranServiceController {

    @Autowired
    private PembayaranServiceImpl pembayaranServiceImpl;

    @GetMapping
    public BaseResponse getAllPembayaran() {
        return pembayaranServiceImpl.getAllPembayaran();
    }

    @GetMapping("/{id}")
    public BaseResponse getPembayaranById(@PathVariable("id") int id) {
        return pembayaranServiceImpl.getPembayaranById(id);
    }

    @PostMapping
    public BaseResponse savePembayaran(Pembayaran pembayaran) {
        return pembayaranServiceImpl.savePembayaran(pembayaran);
    }

    @DeleteMapping("/{id}")
    public BaseResponse deletePembayaran(@PathVariable("id") int id) {
        return pembayaranServiceImpl.deletePembayaran(id);
    }
}
