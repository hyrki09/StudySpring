package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController // 반환값으로 뷰를 찾는 것이 아니라, HTTP 메시지 바디에 바로 입력한다. 따라서 실행 결과로 ok 메세지를 받을 수 있다.
public class LogTestController {
//    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        System.out.println("name = " + name);

        log.trace("trace log={}",name);
        log.debug("debug log={}",name);
        log.info(" info log ={}", name);
        log.info(" info log =" +  name); // 결과는 같지만 사용하면 안됨 : 더하는 연산이 일어나기 때문에 메모리도 사용하면서 쓸모없는 리소스를 사용한다.
        log.warn("warn log={}",name);
        log.error("error log={}",name);

        return "ok";
    }

}
