package ansh.springboot_starter;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation  .ResponseBody;
import org.slf4j.Logger;


//import java.util.logging.Logger;

@Controller // this is also used to create beans (inside contains @components )
public class DemoController {
private static final Logger LOG = LoggerFactory.getLogger(DemoController.class);


@GetMapping("/test")
@ResponseBody
public String  getTest(){
    LOG.error("this is error");
    LOG.debug("this is debug log");  // this is only print when api is hit
return "test";
}

}
