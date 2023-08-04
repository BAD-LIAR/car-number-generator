package ru.gvozdev.numbergenerator.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gvozdev.numbergenerator.entity.CarNumberEntity;

import java.util.Optional;

@Repository
public interface NumberRepository extends CrudRepository<CarNumberEntity, Long> {

    @Query("select car_number from car_number order by lettersNumb, numberValue limit 1")
    Optional<CarNumberEntity> getLastNumber();

    Optional<CarNumberEntity> findTopByOrderByIdDesc();

    Optional<CarNumberEntity> getCarNumberEntitiesByLettersNumbAndNumberValue(Integer lettersNumb, Integer numberValue);
}
