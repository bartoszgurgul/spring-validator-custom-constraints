package pl.javastart.springvalidatorcustomconstraints.validator;

import pl.javastart.springvalidatorcustomconstraints.common.Lang;
import pl.javastart.springvalidatorcustomconstraints.constraint.NotBadWord;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BadWordValidator implements ConstraintValidator<NotBadWord, String> {
    private Lang[] lang;

    @Override
    public void initialize(NotBadWord constraintAnnotation) {
        this.lang = constraintAnnotation.lang();
    }

    @Override
    public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {
        boolean valid = true;
        for (Lang oneLang : lang) {
            if (oneLang == Lang.ENG)
                valid &= engFilter(string);
            if (oneLang == Lang.PL)
                valid &= plFilter(string);
        }
        return valid;
    }

    private boolean engFilter(String string) {
        List<String> list = Arrays.asList("duck");
        return generalFilter(string,list );
    }

    private boolean plFilter(String string) {
        List<String> list = Arrays.asList("kurka", "Cholercia");
        return generalFilter(string,list );
    }

    private boolean generalFilter(String text, List<String> badWords) {
        return badWords
                    .stream()
                    .filter(word -> text.toLowerCase().contains(word))
                    .collect(Collectors.toList()).isEmpty();
    }
}
