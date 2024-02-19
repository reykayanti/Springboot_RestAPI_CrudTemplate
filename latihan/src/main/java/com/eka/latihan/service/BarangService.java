package com.eka.latihan.service;

import com.eka.latihan.entity.TdBarang;
import com.eka.latihan.entity.TdJenisBarang;
import com.eka.latihan.repository.BarangRepository;
import com.eka.latihan.repository.JenisBarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BarangService {

    @Autowired
    private BarangRepository barangRepository;

    @Autowired
    private JenisBarangRepository jenisBarangRepository;

    public ResponseEntity getAllBarang(){

        try{
            List<TdBarang> tdbarang = barangRepository.findAll();

            if (!tdbarang.isEmpty()) {
                return ResponseEntity.ok(tdbarang);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No data found");
            }
        }catch (Exception e){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error");
        }
    }

    public ResponseEntity getByJenis(String namaJenisBarang){

        try{
            TdJenisBarang tdJenisBarang = jenisBarangRepository.getByName(namaJenisBarang);
            UUID idJenisBarang = tdJenisBarang.getIdJenisBarang();

            List<TdBarang> tdbarang = barangRepository.getByIdJenisBarang(idJenisBarang);

            if (!tdbarang.isEmpty()) {
                return ResponseEntity.ok(tdbarang);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No data found");
            }
        }catch (Exception e){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error");
        }
    }


    public ResponseEntity postBarang(TdBarang tdBarang){

        try{
            TdBarang tdbarang = barangRepository.save(tdBarang);

            if (tdBarang != null) {
                return ResponseEntity.ok(tdbarang);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No data found");
            }
        }catch (Exception e){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error");
        }
    }

    public ResponseEntity deleteBarang(@PathVariable String idBarang) {
        try {
            // Konversi String ke UUID
            UUID uuid = UUID.fromString(idBarang);

            Optional<TdBarang> optionalTdBarang = barangRepository.findById(uuid);

            if (optionalTdBarang.isPresent()) {
                barangRepository.deleteById(uuid);
                return ResponseEntity.ok("Data deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No data found with the given ID");
            }
        } catch (IllegalArgumentException e) {
            // Tangkap kesalahan ketika konversi String ke UUID gagal
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid UUID format");
        } catch (Exception e) {
            // Tangkap kesalahan lainnya dan kembalikan respons INTERNAL_SERVER_ERROR dengan pesan kesalahan
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

}
