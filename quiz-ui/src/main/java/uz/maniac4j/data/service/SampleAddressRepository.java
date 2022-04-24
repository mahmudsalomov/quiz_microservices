package uz.maniac4j.data.service;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.maniac4j.data.entity.SampleAddress;

public interface SampleAddressRepository extends JpaRepository<SampleAddress, UUID> {

}