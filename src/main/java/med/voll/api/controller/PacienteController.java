package med.voll.api.controller;

import med.voll.api.paciente.DadosCadastroPaciente;
import med.voll.api.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroPaciente dados) {
        System.out.println("ados recebidos" + dados);
    }

    @GetMapping
    public Page<DadosCadastroPaciente> listar(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosCadastroPaciente::new);
    }
}
