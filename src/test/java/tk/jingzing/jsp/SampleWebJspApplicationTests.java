package tk.jingzing.jsp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tk.jingzing.web.WelcomeController;

/**
 * Created by Louis Wang on 2016/6/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class SampleWebJspApplicationTests {

    /*@LocalServerPort
    private int port;*/

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(
                new WelcomeController()).build();
    }

    @Test
    public void getHello() throws Exception {
        /*mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello World")));*/
    }


    /*@Test
    public void testJspWithEl() throws Exception {
        ResponseEntity<String> entity = new TestRestTemplate()
                .getForEntity("http://localhost:" + this.port, String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).contains("/resources/text.txt");
    }*/
}
