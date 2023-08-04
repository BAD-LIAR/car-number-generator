package ru.gvozdev.numbergenerator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gvozdev.numbergenerator.entity.CarNumberEntity;
import ru.gvozdev.numbergenerator.repository.NumberRepository;
import ru.gvozdev.numbergenerator.utils.LettersUtil;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class NumberService {

    private final NumberRepository numberRepository;

    private final LettersUtil lettersUtil;
    private final String DEFAULT_COUNTRY = "RUS";
    private final Integer DEFAULT_STATE = 116;

    public String generateNextNumber() {
        Optional<CarNumberEntity> lastNumberEntity = numberRepository.findTopByOrderByIdDesc();
        CarNumberEntity nextNumber = lastNumberEntity.map(this::getNextNumber).orElseGet(() -> CarNumberEntity
                .builder()
                .numberValue(0)
                .lettersNumb(0)
                .country(DEFAULT_COUNTRY)
                .stateValue(DEFAULT_STATE)
                .build());
        numberRepository.save(nextNumber);
        return lettersUtil.getCarNumberView(nextNumber);

    }

    public String generateRandomNumber() {
        CarNumberEntity randomNumber;
        while (true) {
            Random random = new Random();
            int numb = random.nextInt(999);
            int lets = random.nextInt(lettersUtil.getLetters().length * lettersUtil.getLetters().length * lettersUtil.getLetters().length - 1);
            if (numberRepository.getCarNumberEntitiesByLettersNumbAndNumberValue(lets, numb).isEmpty()) {
                randomNumber = CarNumberEntity
                        .builder()
                        .numberValue(numb)
                        .lettersNumb(lets)
                        .country(DEFAULT_COUNTRY)
                        .stateValue(DEFAULT_STATE)
                        .build();
                numberRepository.save(randomNumber);
                break;
            }

        }
        return lettersUtil.getCarNumberView(randomNumber);

    }

    private CarNumberEntity getNextNumber(CarNumberEntity carNumberEntity) {
        CarNumberEntity nextNumber = CarNumberEntity.builder()
                .country(DEFAULT_COUNTRY)
                .stateValue(DEFAULT_STATE)
                .build();
        if (carNumberEntity.getNumberValue() < 999) {
            nextNumber.setNumberValue(carNumberEntity.getNumberValue() + 1);
            nextNumber.setLettersNumb(carNumberEntity.getLettersNumb());
        } else {
            nextNumber.setNumberValue(0);
            nextNumber.setLettersNumb(carNumberEntity.getLettersNumb() + 1);
        }
        return nextNumber;
    }

}
