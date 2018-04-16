package com.hawcode.vinculum.annotations;

import com.hawcode.vinculum.repository.CMDRepository;
import com.hawcode.vinculum.repository.CMDRepositoryImpl;
import com.hawcode.vinculum.service.CMDService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class EnableVinculumAspect {

    @Bean
    public CMDService serviceInit(){
        return new CMDService();
    }

    @Bean
    public CMDRepository repositoryInit(){
        return new CMDRepositoryImpl();
    }

}
