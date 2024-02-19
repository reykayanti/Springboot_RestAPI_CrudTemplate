package com.eka.latihan.repository;

import com.eka.latihan.entity.TdBarang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

public interface BarangRepository extends JpaRepository<TdBarang, UUID> {

    @Query(value = "select * from inventory.barang b " +
            "where id_jenis_barang = :idJenisBarang ", nativeQuery = true)
    List<TdBarang> getByIdJenisBarang(@Param("idJenisBarang") UUID idJenisBarang);

}
