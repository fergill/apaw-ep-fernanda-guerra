package es.upm.miw.apaw_ep_fernanda_guerra.croqueta_resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CroquetaResource.CROQUETAS)
public class CroquetaResource {

    public static final String CROQUETAS = "/croquetas";

    static final String ID_ID = "/{id}";

    private CroquetaBusinessController croquetaBusinessController;

    @Autowired
    public CroquetaResource(CroquetaBusinessController croquetaBusinessController) {
        this.croquetaBusinessController = croquetaBusinessController;
    }

    @PostMapping
    public CroquetaDto create(@RequestBody CroquetaDto croquetaDto) {
        return this.croquetaBusinessController.create(croquetaDto);
    }

    @GetMapping
    public List<CroquetaDto> readAll() {
        return this.croquetaBusinessController.readAll();
    }

}