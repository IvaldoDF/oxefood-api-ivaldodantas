package br.edu.ifpe.oxefood.api.cliente;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
       this.repository = repository;
    }

    public List<Cliente> listar() {

        return repository.findAll();
    }

    public Cliente buscarPorId(Long id) {

        return repository.findById(id).get();
    }

    public Cliente build(ClienteDTO dto) {

        Cliente cliente = null;

        if (dto.getId() == null) { //Montado para o cadastro

            cliente = new Cliente();

        } else { //Consultado para a alteração

            cliente = repository.findById(dto.getId()).get();
      }

        cliente.setUsuario(dto.getUsuario());
        cliente.setEnderecos(dto.getEnderecos());
        cliente.setNome(dto.getNome());
        cliente.setDataNascimento(dto.getDataNascimento());
        cliente.setCpf(dto.getCpf());
        cliente.setFoneCelular(dto.getFoneCelular());
        cliente.setFoneFixo(dto.getFoneFixo());
        cliente.setEmail(dto.getEmail());

        return cliente;
    }

    @Transactional
    public Cliente cadastrar(ClienteDTO dto) {

        Cliente cliente = build(dto);
        cliente.setHabilitado(true);
        return repository.save(cliente);
    }

    @Transactional
    public Cliente atualizar(ClienteDTO dto) {

        Cliente cliente = build(dto);
        return repository.save(cliente);
    }

    @Transactional
    public void remover(Long id) {

        Cliente cliente = repository.findById(id).get();
        cliente.setHabilitado(false);

        repository.save(cliente);
   }

}
