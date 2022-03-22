package pl.jnews.core.crypto;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface CryptoService {
    void addCryptoToDatabase(HttpSession session);

}
