package es.upm.miw.apaw_ep_fernanda_guerra.filler_resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FillerBusinessController {

    private FillerDao fillerDao;

    @Autowired
    public FillerBusinessController(FillerDao fillerDao) {
        this.fillerDao = fillerDao;
    }

    public FillerDto create(FillerDto fillerDto) {
        Filler filler = new Filler();
        this.fillerDao.save(filler);
        return new FillerDto(filler);
    }

    public List<FillerDto> readAll() {
        List<Filler> operators = this.fillerDao.findAll();
        return operators.stream().map(FillerDto::new).collect(Collectors.toList());
    }

    public void delete(String id) {
        this.fillerDao.deleteById(id);
    }

    private Boolean evaluate(Filler filler) {
        return filler.getLight() && filler.getSpicy() == true;
    }

    public List<FillerDto> findByLightAndSpicy(String q) {
        return this.fillerDao.findAll().stream()
                .filter(filler -> this.evaluate(filler).equals(q))
                .map(FillerDto::new)
                .collect(Collectors.toList());

    }


}