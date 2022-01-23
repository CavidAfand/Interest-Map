package az.interestmap.interestmap.repository;

import az.interestmap.interestmap.entity.QrCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QrCodeRepository extends JpaRepository<QrCode, Long> {
}
