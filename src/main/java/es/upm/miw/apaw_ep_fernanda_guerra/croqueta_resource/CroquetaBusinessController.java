package es.upm.miw.apaw_ep_fernanda_guerra.croqueta_resource;

import es.upm.miw.apaw_ep_fernanda_guerra.croqueta_data.Croqueta;
import es.upm.miw.apaw_ep_fernanda_guerra.croqueta_data.CroquetaDao;
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

    public CroquetaBasicDto create(CroquetaBasicDto croquetaBasicDto) {
        Croqueta croqueta = new Croqueta();
        this.croquetaDao.save(croqueta);
        return new CroquetaBasicDto(croqueta);
    }

    public List<CroquetaBasicDto> readAll() {
        List<Croqueta> operators = this.croquetaDao.findAll();
        return operators.stream().map(CroquetaBasicDto::new).collect(Collectors.toList());
    }

}
