package com.eka.latihan.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "jenis_barang", schema = "inventory")

public class TdJenisBarang implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_jenis_barang")
    private UUID idJenisBarang;

    @Column(name = "nama_jenis_barang")
    private String namaJenisBarang;
}
