package pl.jnews.core.news;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface NewsRepository extends JpaRepository<News,Long> {
}
