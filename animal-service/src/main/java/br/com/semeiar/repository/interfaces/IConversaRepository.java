package br.com.semeiar.repository.interfaces;

import br.com.semeiar.models.Conversa;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface IConversaRepository extends CrudRepository<Conversa, Long> {
    List<Conversa> findByCompradorIdOrVendedorId(Long compradorId, Long vendedorId);
}
