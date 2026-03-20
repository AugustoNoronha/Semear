package br.com.semeiar.repository.interfaces;

import br.com.semeiar.models.Mensagem;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface IMensagemRepository extends CrudRepository<Mensagem, Long> {
    List<Mensagem> findByConversaIdOrderByDataEnvioAsc(Long conversaId);
}
