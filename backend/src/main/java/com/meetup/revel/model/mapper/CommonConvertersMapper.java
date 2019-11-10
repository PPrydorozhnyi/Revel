package com.meetup.revel.model.mapper;

import com.meetup.revel.exception.runtime.CustomRuntimeException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Component
@PropertySource("classpath:date.properties")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CommonConvertersMapper {

    @Value("${api.date.pattern}")
    private static String stringToDatePattern;
    private final ModelMapper modelMapper;

    @PostConstruct
    public void init() {
        registerMappings();
    }

    private void registerMappings() {
        modelMapper.createTypeMap(String.class, Date.class)
                .setConverter(stringToDateConverter);
        modelMapper.createTypeMap(Date.class, String.class)
                .setConverter(dateToStringConverter);
    }

    private static final Converter<String, Date> stringToDateConverter = context -> {
        String source = context.getSource();
        if (StringUtils.isEmpty(source)) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat(stringToDatePattern);

        try {
            return formatter.parse(source);
        } catch (ParseException e) {
            throw new CustomRuntimeException(e);
        }
    };

    private static final Converter<Date, String> dateToStringConverter = context -> {
        Date source = context.getSource();
        if (Objects.isNull(source)) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat(stringToDatePattern);

        return formatter.format(source);
    };

}
