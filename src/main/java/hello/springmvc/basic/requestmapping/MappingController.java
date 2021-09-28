package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping({"/hello-basic","/hello-go"})
    public String helloBasic() {
        log.info("hello basic");
        return "ok";
    }
    @GetMapping(value = "/mapping-get-v1")
    public String GetV1() {
        log.info("hello getV1");

        return "ok";
    }

    //Path Variable 스타일
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
        log.info("mappingPath userId={}",data);
        return "ok";
    }

    //Path Variable 사용 - 다중
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String orders(@PathVariable String userId,@PathVariable Long orderId) {
        log.info("mappingPath userId={},orderId={}",userId,orderId);
        return "ok";
    }

    //파라미터로 추가 매핑
    @GetMapping(value = "/mapping-param",params="mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    //헤더로 추가 매핑
    @GetMapping(value = "/mapping-header",headers="mode=debug")
    public String mappingHeaders() {
        log.info("mappingHeader");
        return "ok";
    }

    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type
     * consumes="application/json"
     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     */
    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }
    @PostMapping(value="/mapping-procedure",produces = MediaType.TEXT_PLAIN_VALUE)
    public String mappingProcedues() {
        log.info("mappingProcedure");
        return "ok";
    }
}
