package com.example.demo.Project.services;

import com.example.demo.Project.interfaces.Repositories.IOwnerRepository;
import com.example.demo.Project.models.Bowvine;
import com.example.demo.Project.models.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class OwnerServices {
    @Autowired
    private IOwnerRepository _ownerRepository;

    public List<Owner> GetAllOwners(){
        return this._ownerRepository.findAll();
    }

    public Owner GetOwnerById(long id){
        Optional<Owner> owner = this._ownerRepository.findById(id);
        return owner.orElseThrow(() -> new RuntimeException("Owner not find"));
    }

    @Transactional
    public Owner CreateOwner(Owner owner){
        //garatia de criação de novo owner
        owner.setId(null);
        owner = this._ownerRepository.save(owner);
        return owner;
    }

    @Transactional
    public Owner UpdateOwner(Owner owner){
        Owner newOwner = GetOwnerById(owner.getId());

        //informaçoes do dono que fazem sentido serem atualizadas
        newOwner.setCellNumber(owner.getCellNumber());
        newOwner.setEmail(owner.getEmail());

        return this._ownerRepository.save(newOwner);
    }

    //alterar para delet logico no futuro
    public void DeletOwner(long id){
        GetOwnerById(id);
        try{
            this._ownerRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Não foi possivel excluir");
        }
    }
}
