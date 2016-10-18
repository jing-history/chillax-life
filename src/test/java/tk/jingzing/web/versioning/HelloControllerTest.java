package tk.jingzing.web.versioning;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import tk.jingzing.Application;
import static org.hamcrest.Matchers.is;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
/**
 * 测试helloController
 * Created by wangyunjing on 2016/10/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class HelloControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void initMockMvc(){
        this.mockMvc = webAppContextSetup(wac).build();
    }

    @Test
    public void should_respond_with_hello_json_on_v1_url() throws Exception {
        mockMvc.perform(get("/apiurl/v1/hello").accept(APPLICATION_JSON)) //
                .andExpect(status().isOk())                                //
                .andExpect(content().contentType(APPLICATION_JSON))        //
                .andExpect(jsonPath("$.hello", is("world")));
    }
}