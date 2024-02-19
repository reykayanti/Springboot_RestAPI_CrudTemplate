package com.eka.latihan.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "barang", schema = "inventory")
public class TdBarang implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_barang")
    private UUID idBarang;

    @Column(name = "id_jenis_barang")
    private UUID idJenisBarang;

    @Column(name = "nama_barang")
    private String namaBarang;

    @Column(name = "harga_barang")
    private Long hargaBarang;

    @Column(name = "keterangan")
    private String keterangan;
}
