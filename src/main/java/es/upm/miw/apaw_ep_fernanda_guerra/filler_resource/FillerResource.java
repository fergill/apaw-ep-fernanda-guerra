package es.upm.miw.apaw_ep_fernanda_guerra.filler_resource;

import es.upm.miw.apaw_ep_fernanda_guerra.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(FillerResource.FILLERS)
public class FillerResource {

    public static final String FILLERS = "/fillers";

    static final String ID_ID = "/{id}";

    static final String SEARCH = "/search";

    private FillerBusinessController fillerBusinessController;

    @Autowired
    public FillerResource(FillerBusinessController fillerBusinessController) {
        this.fillerBusinessController = fillerBusinessController;
    }

    @PostMapping
    public FillerDto create(@RequestBody FillerDto fillerDto) {
        return this.fillerBusinessController.create(fillerDto);
    }

    @DeleteMapping(value = ID_ID)
    public void delete(@PathVariable String id) {
        this.fillerBusinessController.delete(id);
    }

    @GetMapping(value = SEARCH)
    public List<FillerDto> find(@RequestParam String q) {
        if (!"condition".equals(q.split(":==")[0])) {
            throw new BadRequestException("query param q is incorrect, missing 'condition:=='");
        }
        return this.fillerBusinessController.findByCondition(Boolean.valueOf(q.split(":==")[1]));
    }

}
