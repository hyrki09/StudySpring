package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}",username,age);

        response.getWriter().write("ok");
    }

    @ResponseBody
    @RequestMapping("request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge){

        log.info("username={}, age={}",memberName,memberAge);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("request-param-v3")
    public String requestParamV3(
            @RequestParam String username,  // 파라미터 이름과 변수이름이 같으면 ("username") 생략 가능
            @RequestParam int age){

        log.info("username={}, age={}",username,age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("request-param-v4")
    public String requestParamV4(String username,int age){ // String, int, Integer 등의 단순 타입이면 @RequestParam도 생략 가능

        log.info("username={}, age={}",username,age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username, // 이 파라미터를 안보냈을경우 400에러 -> 클라이언트 오류
            @RequestParam(required = false) Integer age){

        log.info("username={}, age={}",username,age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String username, // "" 문자가 넘어와도 "guest"로 처리해준다.
            @RequestParam(required = false, defaultValue = "-1") int age){

        log.info("username={}, age={}",username,age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap){

        log.info("username={}, age={}",paramMap.get("username"),paramMap.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData){
//        HelloData helloData = new HelloData();
//        helloData.setUsername(username);
//        helloData.setAge(age);
//        스프링MVC는 ModelAttribute가 있으면
        // 1. HelloData 객체를 생성 2. 요청파라미터 이름으로 HelloData 객체의 프로퍼티를 찾는다. setter를 호출 후 파라미터의 값을 바인딩
        // 3. 파라미터 이름 : username  setUsername()호출

        //**프로퍼티**
        //객체에 `getUsername()` , `setUsername()` 메서드가 있으면, 이 객체는 `username` 이라는 프로퍼티를 가지고 있 다.

        log.info("username={}, age={}",helloData.getUsername(),helloData.getAge());
        log.info("helloData=",helloData);

        return  "ok";
    }


    /**
     * @ModelAttribute 생략 가능
     * String, int 같은 단순 타입 = @RequestParam
     * argument resolver 로 지정해둔 타입 외 = @ModelAttribute */
    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData){

        log.info("username={}, age={}",helloData.getUsername(),helloData.getAge());
        log.info("helloData=",helloData);

        return  "ok";
    }


}
