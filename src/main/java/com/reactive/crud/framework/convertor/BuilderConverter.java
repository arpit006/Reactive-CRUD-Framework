package com.reactive.crud.framework.convertor;

import com.reactive.crud.framework.entity.BaseEntity;
import com.reactive.crud.framework.vo.BaseVo;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingBuilder;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.util.ReflectionUtils.findMethod;
import static org.springframework.util.ReflectionUtils.invokeMethod;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
public abstract class BuilderConverter<T extends BaseEntity<T>, V extends BaseVo<V>, B> extends AbstractConverter<T, V> {

    private Class<T> sourceClass;

    private Class<V> destinationClass;

    private Class<B> destinationBuilderClass;

    private DozerBeanMapper mapper;

    public BuilderConverter(DozerBeanMapper mapper, Class<T> source, Class<V> destination, Class<B> destinationBuilderClass) {
        super(mapper, source, destination);
        this.sourceClass = source;
        this.destinationClass = destination;
        this.destinationBuilderClass = destinationBuilderClass;
        this.mapper = mapper;
    }

    private Stream<String> getDesiredFields(Class<?> clazz) {
        List<String> notMappingFields = notMappingFields();
        return Arrays.stream(clazz.getDeclaredFields())
                .map(Field::getName)
                .filter(field -> !notMappingFields.contains(field));
    }

    public List<String> notMappingFields() {
        return Collections.emptyList();
    }

    private static <T, V> V invoke(Class<T> classOfT, T t, String methodName) {
        return (V) invokeMethod(findMethod(classOfT, methodName), t);
    }

    @PostConstruct
    public void initialize() {
        mapper.addMapping(
                new BeanMappingBuilder() {
                    @Override
                    protected void configure() {
                        TypeMappingBuilder mapping = mapping(sourceClass, destinationBuilderClass);
                        Set<String> destFields = getDesiredFields(sourceClass).collect(Collectors.toSet());
                        getDesiredFields(destinationClass)
                                .filter(destFields::contains)
                                .forEach(field -> mapping.fields(field, field(field).setMethod(field)));
                        TypeMappingBuilder voToBuilderMapping = mapping(destinationClass, sourceClass);
                        notMappingFields().forEach(voToBuilderMapping::exclude);
                    }
                });
    }

    @Override
    public final V convert(T t) {
        B b = mapper.map(t, destinationBuilderClass);
        return invoke(destinationBuilderClass, b, "build");
    }
}
