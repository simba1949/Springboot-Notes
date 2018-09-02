package top.simba1949.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import top.simba1949.controller.HelloWorldController;

/**
 * @author simba1949@outlook.com
 * @date 2018/9/2 14:52
 * 参考：http://jinnianshilongnian.iteye.com/blog/2004660
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HelloWorldControllerTest.class)
public class HelloWorldControllerTest {

    private MockMvc mockMvc;

    @Before
    public void init(){
        mockMvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
    }

    @Test
    public void sayHelloTest() throws Exception {
        /**
         * mockMvc.perform执行一个请求；
         * MockMvcRequestBuilders.get("/say")
         *                         .header("","")
         *                         .param("","")
         *                         .accept(MediaType.ALL) 构建一个请求
         */
        ResultActions resultActions =
                mockMvc.perform(
                        MockMvcRequestBuilders.get("/say")
                        .header("accept","accept")
                        .param("name","libai")
                        .accept(MediaType.ALL)
                );
        /**
         * resultActions.andExpect(); 添加执行完成后断言
         * resultActions.andDo()：添加结果处理器
         * resultActions..andReturn()：返回相应的MvcResult,然后进行自定义验证
         */
        MvcResult mvcResult = resultActions
                .andExpect(MockMvcResultMatchers.status().is(406))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
    }
}
