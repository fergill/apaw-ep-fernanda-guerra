package es.upm.miw.apaw_ep_fernanda_guerra.operator_resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(OperatorResource.OPERATORS)
public class OperatorResource {

    static final String OPERATORS = "/operators";

    private OperatorBusinessController operatorBusinessController;

    @Autowired
    public OperatorResource(OperatorBusinessController operatorBusinessController) {
        this.operatorBusinessController = operatorBusinessController;
    }

    @PostMapping
    public OperatorDto create(@RequestBody OperatorDto operatorDto) {
        operatorDto.validate();
        return this.operatorBusinessController.create(operatorDto);
    }

    @GetMapping
    public List<OperatorDto> readAll() {
        return this.operatorBusinessController.readAll();
    }

}
