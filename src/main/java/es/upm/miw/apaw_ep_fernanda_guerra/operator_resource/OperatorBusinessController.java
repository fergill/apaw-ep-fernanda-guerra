package es.upm.miw.apaw_ep_fernanda_guerra.operator_resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class OperatorBusinessController {

    private OperatorDao operatorDao;

    @Autowired
    public OperatorBusinessController(OperatorDao operatorDao) {
        this.operatorDao = operatorDao;
    }

    public OperatorDto create(OperatorDto operatorDto) {
        Operator operator = new Operator(
                operatorDto.getName(),
                operatorDto.getSurname(),
                operatorDto.getDni());
        this.operatorDao.save(operator);
        return new OperatorDto(operator);
    }

    public List<OperatorDto> readAll() {
        List<Operator> operators = this.operatorDao.findAll();
        return operators.stream().map(OperatorDto::new).collect(Collectors.toList());
    }

}
