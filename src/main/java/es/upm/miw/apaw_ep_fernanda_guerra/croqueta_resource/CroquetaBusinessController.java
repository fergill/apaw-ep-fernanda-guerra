package es.upm.miw.apaw_ep_fernanda_guerra.croqueta_resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CroquetaBusinessController {

    private CroquetaDao croquetaDao;

    @Autowired
    public CroquetaBusinessController(CroquetaDao croquetaDao) {
        this.croquetaDao = croquetaDao;
    }

    public CroquetaDto create(CroquetaDto croquetaDto) {
        Croqueta croqueta = new Croqueta(croquetaDto.getFrozen());
        this.croquetaDao.save(croqueta);
        return new CroquetaDto(croqueta);
    }

    public List<CroquetaDto> readAll() {
        List<Croqueta> operators = this.croquetaDao.findAll();
        return operators.stream().map(CroquetaDto::new).collect(Collectors.toList());
    }
}
