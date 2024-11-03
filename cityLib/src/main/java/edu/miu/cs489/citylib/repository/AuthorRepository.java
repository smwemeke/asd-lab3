package edu.miu.cs489.citylib.repository;

import edu.miu.cs489.citylib.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
