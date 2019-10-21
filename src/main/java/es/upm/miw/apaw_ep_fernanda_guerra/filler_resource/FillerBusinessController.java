package es.upm.miw.apaw_ep_fernanda_guerra.filler_resource;

import es.upm.miw.apaw_ep_fernanda_guerra.exceptions.BadRequestException;
import es.upm.miw.apaw_ep_fernanda_guerra.exceptions.NotFoundException;
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

    private Filler findFillerByIdAssured(String id) {
        return this.fillerDao.findById(id).orElseThrow(() -> new NotFoundException("Filler id: " + id));
    }

    public void delete(String id) {
        this.fillerDao.deleteById(id);
    }

    public void patch(String id, FillerPatchDto fillerPatchDto) {
        Filler filler = this.findFillerByIdAssured(id);
        switch (fillerPatchDto.getPath()) {
            case "type":
                filler.setType(fillerPatchDto.getNewValue());
                break;
            case "percentage":
                filler.setPercentage(Double.valueOf(fillerPatchDto.getNewValue()));
                break;
            case "price":
                filler.setPrice(Double.valueOf(fillerPatchDto.getNewValue()));
                break;
            case "spicy":
                filler.setSpicy(Boolean.valueOf(fillerPatchDto.getNewValue()));

                break;
            default:
                throw new BadRequestException("FillerPatchDto is invalid");
        }
        this.fillerDao.save(filler);
    }


}