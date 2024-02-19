package com.eka.latihan.repository;

import com.eka.latihan.entity.TdBarang;
import com.eka.latihan.entity.TdJenisBarang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface JenisBarangRepository extends JpaRepository<TdJenisBarang, UUID> {
    @Query(value = "select * from inventory.jenis_barang b " +
            "where nama_jenis_barang = :namaJenisBarang ", nativeQuery = true)
    TdJenisBarang getByName(@Param("namaJenisBarang") String namaJenisBarang);
}
