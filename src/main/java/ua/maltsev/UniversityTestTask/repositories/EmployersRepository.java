package ua.maltsev.UniversityTestTask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.maltsev.UniversityTestTask.entities.Employer;

import java.util.List;

@Repository
public interface EmployersRepository extends JpaRepository<Employer, Long> {
    @Override
    <S extends Employer> List<S> saveAll(Iterable<S> iterable);

    List<Employer> getAllByNameContains(String template);
}
