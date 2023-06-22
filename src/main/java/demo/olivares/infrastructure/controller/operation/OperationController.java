package demo.olivares.infrastructure.controller.operation;

import io.corp.calculator.TracerImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/operation/v1")
public class OperationController {


    private final TracerImpl tracerUtil;

    @GetMapping("/home")
    public String Home() {

        tracerUtil.trace("Dummy method implemented to test the connection to the controller layer");

        return "Hello World!";
    }

    @GetMapping(value = "/sum")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> addition(@QueryParam("firstvalue") String firstvalue, @QueryParam("secondvalue") String secondvalue) {

        tracerUtil.trace("executing add operation. firstvalue: " + firstvalue + " secondvalue: " + secondvalue);

        return ResponseEntity.status(HttpStatus.OK).body("ok");
    }

    @GetMapping(value = "/substract")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> subtraction(@QueryParam("firstvalue") String firstvalue, @QueryParam("secondvalue") String secondvalue) {

        tracerUtil.trace("executing subtract operation. firstvalue: " + firstvalue + " secondvalue: " + secondvalue);

        return ResponseEntity.status(HttpStatus.OK).body("ok");
    }
}
