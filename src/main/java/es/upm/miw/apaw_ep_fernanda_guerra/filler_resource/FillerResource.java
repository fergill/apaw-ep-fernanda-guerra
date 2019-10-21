package es.upm.miw.apaw_ep_fernanda_guerra.filler_resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(FillerResource.FILLERS)
public class FillerResource {

    public static final String FILLERS = "/fillers";

    static final String ID_ID = "/{id}";

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

    @PatchMapping(value = ID_ID)
    public void patch(@PathVariable String id, @RequestBody FillerPatchDto fillerPatchDto) {
        fillerPatchDto.validate();
        this.fillerBusinessController.patch(id, fillerPatchDto);
    }

}
