package ru.gvozdev.numbergenerator.utils;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.gvozdev.numbergenerator.entity.CarNumberEntity;

@Component
@Getter
public class LettersUtil {

    private final String[] letters = {"А", "Е", "Т" ,"О", "Р", "Н", "У", "К", "Х", "С", "В", "М"};

    public String calculateLettersPart(int numb){
        return letters[numb % letters.length]
                + letters[numb / letters.length % letters.length]
                + letters[numb / letters.length / letters.length];
    }

    public String getCarNumberView(CarNumberEntity carNumberEntity){
        String letPart = calculateLettersPart(carNumberEntity.getLettersNumb());
        return String
                .format("%s%03d%s %s %s", letPart.charAt(0), carNumberEntity.getNumberValue(), letPart.substring(1, 3), carNumberEntity.getStateValue(), carNumberEntity.getCountry());
    }
}
