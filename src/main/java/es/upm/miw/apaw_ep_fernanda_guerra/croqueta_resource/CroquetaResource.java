package es.upm.miw.apaw_ep_fernanda_guerra.croqueta_resource;

import es.upm.miw.apaw_ep_fernanda_guerra.operator_resource.OperatorBusinessController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CroquetaResource.CROQUETAS)
public class CroquetaResource {

    public static final String CROQUETAS = "/croquetas";

    private CroquetaBusinessController croquetaBusinessController;

    @Autowired
    public CroquetaResource(CroquetaBusinessController croquetaBusinessController) {
        this.croquetaBusinessController = croquetaBusinessController;
    }

    @PostMapping
    public CroquetaBasicDto create(@RequestBody CroquetaBasicDto croquetaBasicDto) {
        croquetaBasicDto.validate();
        return this.croquetaBusinessController.create(croquetaBasicDto);
    }

    @GetMapping
    public List<CroquetaBasicDto> readAll() {
        return this.croquetaBusinessController.readAll();
    }

}
