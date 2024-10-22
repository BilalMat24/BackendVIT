package com.example.pubblicazione.Immagine;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ImmagineRepository extends JpaRepository<Immagine, Long>{

    @Query("select i from Immagine i where i.data = ?1 AND i.webcam.id = ?2")
    List<Immagine> hasSaved(java.time.LocalDateTime data,Long webcamId);
}
