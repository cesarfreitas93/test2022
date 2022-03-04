package com.example.demoMoneyExchange;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ServiceCoin {
    private final RepositoryCoin repositoryCoin;

    public ServiceCoin(RepositoryCoin repositoryCoin) {
        this.repositoryCoin = repositoryCoin;
    }

    public DtoCoin SaveCoin(DtoCoin c){
        return repositoryCoin.save(c);
    }
    public DtoCoin UpdateCoin(Long id, DtoCoin c){
        DtoCoin coin = repositoryCoin.findById(id).get();
        coin.setCode(c.getCode());
        coin.setName(c.getName());
        coin.setValue(c.getValue());
        return repositoryCoin.save(coin);
    }
    public List<DtoCoin> GetAll(){
        return repositoryCoin.findAll();
    }
    public DtoCoin GetCoin(Long id){
        return repositoryCoin.findById(id).orElseThrow(()-> {throw new RuntimeException();});
    }
    public boolean DeleteCoin(Long id){
        try
        {
            repositoryCoin.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
