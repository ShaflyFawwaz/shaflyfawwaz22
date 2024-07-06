package com.sis.app.entitity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name = "pembayaran")
public class Pembayaran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_ta")
    @JsonProperty("id_ta")
    private int idTa;

    @Column(name = "id_siswa")
    @JsonProperty("id_siswa")
    private int idSiswa;

    @Column(name = "tgl_pembayaran")
    @JsonProperty("tgl_pembayaran")
    private LocalDate tglPembayaran;

    @Column(name = "jumlah_bayar")
    @JsonProperty("jumlah_bayar")
    private int jumlahBayar;

    @Column(name = "metode_bayar")
    @JsonProperty("metode_bayar")
    private String metodeBayar;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinColumns({
            @JoinColumn(name = "id_pembayaran", referencedColumnName = "id", insertable = false, updatable = false)
    })
    private List<Transaksi> transaksiList;

}
