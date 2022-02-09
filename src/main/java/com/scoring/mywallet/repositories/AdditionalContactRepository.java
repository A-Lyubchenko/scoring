package com.scoring.mywallet.repositories;

import com.scoring.mywallet.domains.AdditionalContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AdditionalContactRepository extends JpaRepository<AdditionalContact, UUID> {
}
