package com.book.server.config;

import com.book.server.model.Book;
import com.book.server.view.BookRequest;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(Book.class, BookRequest.class);

//        modelMapper.addMappings(new PropertyMap<Branch, BranchDTO>() {
//
//            @Override
//            protected void configure() {
//                map().setDisabled(source.getUser().getAttributes().get("disability_status").getIntValue() == 0);
//            }
//        });

        modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STRICT);

        return modelMapper;
    }
}
