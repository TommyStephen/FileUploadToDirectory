package study.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import study.model.Cricketer;

public interface CricketerRepository extends JpaRepository<Cricketer, Integer> {

}
