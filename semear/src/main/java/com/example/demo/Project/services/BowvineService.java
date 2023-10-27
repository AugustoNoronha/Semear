package com.example.demo.Project.services;

import com.example.demo.Project.interfaces.Repositories.IBowvineRepository;
import com.example.demo.Project.models.Bowvine;
import com.example.demo.Project.models.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BowvineService {
    @Autowired
    private IBowvineRepository _bowvineRepository;

    @Autowired
    private OwnerServices _ownerServices;


    public List<Bowvine> GetAllBowvines(){
        return this._bowvineRepository.findAll();
    }

    public Bowvine GetBowvineById(long id){
        Optional<Bowvine> bowvine = this._bowvineRepository.findById(id);
        return bowvine.orElseThrow(() -> new RuntimeException("Bowvine not find"));
    }

    @Transactional
    public Bowvine CreateBowvine(Bowvine bowvine){
        Owner owner = this._ownerServices.GetOwnerById(bowvine.getOwner().getId());
        bowvine.setId(null);
        bowvine.setOwner(owner);
        bowvine = this._bowvineRepository.save(bowvine);
        return bowvine;
    }

    @Transactional
    public Bowvine UpdateBowvine(Bowvine bowvine){
        Bowvine newBowvine = GetBowvineById(bowvine.getId());

        //informaçoes do bovino que fazem sentido serem atualizadas
        newBowvine.setImage(bowvine.getImage());
        newBowvine.setWeight(bowvine.getWeight());

        return this._bowvineRepository.save(newBowvine);
    }

    //alterar para delet logico no futuro
    public void DeletBowvine(long id){
        GetBowvineById(id);
        try{
            this._bowvineRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Não foi possivel excluir");
        }
    }
}
