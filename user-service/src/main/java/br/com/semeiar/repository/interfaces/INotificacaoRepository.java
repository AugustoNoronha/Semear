package br.com.semeiar.repository.interfaces;

import br.com.semeiar.models.Notificacao;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface INotificacaoRepository extends CrudRepository<Notificacao, Long> {
    List<Notificacao> findByUsuarioId(Long usuarioId);
}
