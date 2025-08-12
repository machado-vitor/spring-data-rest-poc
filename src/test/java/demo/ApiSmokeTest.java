package demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ApiSmokeTest {
    @Autowired MockMvc mvc;

    @Test void rootExposesBooks() throws Exception {
        mvc.perform(get("/api"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._links.books.href").exists());
    }
}
