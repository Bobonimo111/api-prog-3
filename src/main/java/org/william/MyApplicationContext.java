package org.william;

import java.util.HashMap;
import java.util.Map;


import java.lang.annotation.*;
import java.lang.reflect.Constructor;



class MyApplicationContext {
    private final Map<Class<?>, Object> beans = new HashMap<>();

    public MyApplicationContext(Class<?>... components) {
        try {
            for (Class<?> clazz : components) {
                if (clazz.isAnnotationPresent(MyService.class) || clazz.isAnnotationPresent(MyController.class)) {
                    createBean(clazz);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inicializar o contexto", e);
        }
    }

    private Object createBean(Class<?> clazz) throws Exception {
        if (beans.containsKey(clazz)) {
            return beans.get(clazz);
        }

        /* Codigo de correção - não sei se ta certo*/
        if(clazz.getConstructors().length == 0){
            Object bean = clazz.newInstance();
            beans.put(clazz, bean);
            return bean;
        }
        /* Codigo de correção - não sei se ta certo*/


        // Usa o construtor para injetar dependências
        Constructor<?> constructor = clazz.getConstructors()[0];
        Class<?>[] paramTypes = constructor.getParameterTypes();

        Object[] dependencies = new Object[paramTypes.length];
        for (int i = 0; i < paramTypes.length; i++) {
            dependencies[i] = createBean(paramTypes[i]);
        }

        Object bean = constructor.newInstance(dependencies);
        beans.put(clazz, bean);
        return bean;
    }

    @SuppressWarnings("unchecked")
    public <T> T getBean(Class<T> clazz) {
        return (T) beans.get(clazz);
    }
}
