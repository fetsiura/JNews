package pl.jnews.core.crypto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.jnews.core.weather.City;

import java.util.List;

@Repository
public interface CryptoRepository extends JpaRepository<Crypto,Long> {
    @Query(nativeQuery = true,
            value = "SELECT * FROM crypto ORDER BY name ASC")
    List<Crypto> findCryptoByNameAtoZ();

    @Query(nativeQuery = true,
            value = "SELECT * FROM crypto ORDER BY price ASC")
    List<Crypto> findCryptoByPriceHighToLow();

    @Query(nativeQuery = true,
            value = "SELECT * FROM crypto ORDER BY price DESC")
    List<Crypto> findCryptoByPriceLowToHigh();

    List<Crypto> findByNameStartsWith(String name);

    @Query(nativeQuery = true,
            value = "SELECT COUNT(*) FROM CRYPTO")
    Integer countAllCrypto();
}
