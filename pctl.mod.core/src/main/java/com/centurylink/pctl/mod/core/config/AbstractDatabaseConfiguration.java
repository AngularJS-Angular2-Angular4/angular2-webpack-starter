package com.centurylink.pctl.mod.core.config;


import com.centurylink.pctl.mod.core.utils.JSR310DateConverters;
import com.mongodb.Mongo;
import com.mongodb.MongoClientURI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.ArrayList;
import java.util.List;

/**
 * AbstractDatabaseConfiguration is an abstract class extending  AbstractMongoConfiguration
 * Enabling mongo repositries for com.centurylink.pctl.mod package
 * @author Begin
 */
@Configuration
@EnableMongoRepositories("com.centurylink.pctl.mod")
@Import(value = MongoAutoConfiguration.class)
//@EnableMongoAuditing(auditorAwareRef = "springSecurityAuditorAware")
public abstract class AbstractDatabaseConfiguration extends AbstractMongoConfiguration {


    /**
     * Autowired mongo
     */
    @Autowired
    protected Mongo mongo;

    /**
     * autowired mongoProperties
     */
    @Autowired
    private MongoProperties mongoProperties;

    /**
     * mongoClientURI
     */
    private MongoClientURI mongoClientURI;


    /**
     * validatingMongoEventListener() method
     * @return
     */
    @Bean
    public ValidatingMongoEventListener validatingMongoEventListener() {
        return new ValidatingMongoEventListener(validator());
    }

    /**
     *
     * @return
     */
    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }

    /**
     * getDatabaseName()
     * @return string of mongoclienturi
     */
    @Override
    protected String getDatabaseName() {
        return getMongoClientURI().getDatabase();
    }

    /**
     *mongoDbFactory() method gives mongo db factory
     * @return mongodbfactory informations
     * @throws Exception
     */
    @Override
    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(getMongoClientURI());
    }

    /**
     * mongo() method
     * @return mongo
     * @throws Exception
     */
    @Override
    public Mongo mongo() throws Exception {
        return mongo;
    }

    /**
     * customConversions() method
     * @return customConversions
     */
    @Bean
    public CustomConversions customConversions() {
        List<Converter<?, ?>> converters = new ArrayList<>();
        converters.add(JSR310DateConverters.DateToZonedDateTimeConverter.INSTANCE);
        converters.add(JSR310DateConverters.ZonedDateTimeToDateConverter.INSTANCE);
        converters.add(JSR310DateConverters.DateToLocalDateConverter.INSTANCE);
        converters.add(JSR310DateConverters.LocalDateToDateConverter.INSTANCE);
        converters.add(JSR310DateConverters.DateToLocalDateTimeConverter.INSTANCE);
        converters.add(JSR310DateConverters.LocalDateTimeToDateConverter.INSTANCE);
        return new CustomConversions(converters);
    }

    /**
     * mongoConverter() method returns customConversions with mappingContext
     * @return mongoConverter
     * @throws Exception
     */
    @Bean
    public MappingMongoConverter mongoConverter() throws Exception {
        MongoMappingContext mappingContext = new MongoMappingContext();
        DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory());
        MappingMongoConverter mongoConverter = new MappingMongoConverter(dbRefResolver, mappingContext);
        mongoConverter.setCustomConversions(customConversions());
        return mongoConverter;
    }


    /**
     * getMongoClientURI() returns mongoclienturi
     * @return mongoclienturi
     */
    public MongoClientURI getMongoClientURI() {
        if(mongoProperties.getUri() == null) {
            throw new IllegalArgumentException("Missing mandatory data.mongodb.uri property..");
        }
        if(mongoClientURI == null) {
            mongoClientURI = new MongoClientURI(mongoProperties.getUri());
        }
        return mongoClientURI;
    }
}
