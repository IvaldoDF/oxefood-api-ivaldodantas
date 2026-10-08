package br.edu.ifpe.oxefood.api.cliente;

import java.time.LocalDate;
import java.util.List;
import br.edu.ifpe.oxefood.api.endereco.EnderecoCliente; // Verifique se este caminho do pacote está correto
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    private Long id;

    private String usuario;

    private String nome;

    private LocalDate dataNascimento;

    private String cpf;

    private String foneCelular;

    private String foneFixo;

    private List<EnderecoCliente> enderecos;

    private String email;


}