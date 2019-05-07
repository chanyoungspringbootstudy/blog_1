package kr.hs.dgsw.blog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Post,Long> {
}
