package com.hb.platform.notemanager;

import com.hb.platform.notemanager.config.SwaggerConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class SwaggerTest {

    @Autowired
    private SwaggerConfig swaggerConfig;

    @Test
    public void swaggerLoads() throws Exception{
        assertThat(swaggerConfig).isNotNull();
    }
}
