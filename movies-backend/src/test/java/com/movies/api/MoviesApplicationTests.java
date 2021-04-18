package com.movies.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles(profiles = "test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = {MoviesApplication.class})
class MoviesApplicationTests {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    MoviesApplicationTests() {
    }

    @BeforeEach
    void beforeEachTestCase() {
        final String urlTemplate = "/";
        final MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get(urlTemplate);
        mockMvc = MockMvcBuilders.webAppContextSetup(context).defaultRequest(mockHttpServletRequestBuilder).build();
    }

    @Test
    void moviesByYearAndGenreTest() throws Exception {
        final String urlTemplate = "/movies/yearAndGenre/2020/Terror/";
        final MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get(urlTemplate);
        mockMvc.perform(mockHttpServletRequestBuilder).andExpect(status().isOk());
    }

    @Test
    void topFiveRatedMoviesTest() throws Exception {
        final String urlTemplate = "/ratings/byTop/5";
        final MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get(urlTemplate);
        mockMvc.perform(mockHttpServletRequestBuilder).andExpect(status().isOk());
    }
}
