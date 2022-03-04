package com.example.demoMoneyExchange;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/exchange")
public class ExchangeController {
    private final ServiceCoin serviceCoin;
    // FIJAREMOS UNA REFERENCIA COMO BASE EL DOLAR Y EL VALOR DEL CAMBIO EN LA MONEDAS EXTRANJERAS SIENDO usd VALOR 1
    List<Coin> Coins = Arrays.asList(
            new Coin(1L, "Sol Peruano", "PEN", 0.266),
            new Coin(2L, "Euro", "EUR", 1.11),
            new Coin(3L, "Peso Mexicano", "MXN", 0.048),
            new Coin(4L, "Dólar Estadounidense", "USD", 1D)
    );

    public ExchangeController(ServiceCoin serviceCoin) {
        this.serviceCoin = serviceCoin;
    }

    @GetMapping(value = "/fetch/all")
    public List<DtoCoin> fetchAllCoins() {return serviceCoin.GetAll(); }
/*
    @GetMapping(value = "/fetch/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Coin fetchCoinById(@PathVariable(value = "id")String id){
        return Coins.stream().filter(x-> Long.toString(x.getId()).equals(id)).findFirst().get();
    }
    */

/*
    @PostMapping(value = "/convert", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Coin moneyExchange(@RequestBody Convert body){
        Coin obOrigen = Coins.stream().filter(x-> Long.toString(x.getId()).equals(Long.toString((long) body.getId_o()))).findFirst().get();
        Coin obDestin = Coins.stream().filter(x-> Long.toString(x.getId()).equals(Long.toString((long) body.getId_d()))).findFirst().get();
        return this.getChange(obOrigen, obDestin, body.getValue());
    }
    */

    private Coin getChange(DtoCoin objOrigen, DtoCoin objDestin, double value){
        return new Coin(objDestin.getName(), objDestin.getCode(), value * objOrigen.getValue() / objDestin.getValue());
    }

    // Metodos que consumen el servicio

    @PostMapping(value = "/coin/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveCoin(@RequestBody DtoCoin c){
        return new ResponseEntity(serviceCoin.SaveCoin(c), HttpStatus.CREATED);
    }
    @GetMapping(value="/coin/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getCoin(@PathVariable(value = "id")Long id){
        return new ResponseEntity(serviceCoin.GetCoin(id), HttpStatus.OK);
    }

    @PutMapping(value = "/coin/u/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCoin(@PathVariable(value = "id")Long id, @RequestBody DtoCoin dtoCoin)
    {
        return new ResponseEntity(serviceCoin.UpdateCoin(id, dtoCoin), HttpStatus.OK);
    }

    @DeleteMapping(value = "/coin/d/{id}" ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity deleteCoin(@PathVariable(value = "id")Long id){
        boolean res = serviceCoin.DeleteCoin(id);
        if (res == true){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/coin/convert", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Coin moneyExchange(@RequestBody Convert body){
        DtoCoin obOrigen = serviceCoin.GetCoin((long) body.getId_o());
        DtoCoin obDestin = serviceCoin.GetCoin((long) body.getId_d());
        return this.getChange(obOrigen, obDestin, body.getValue());
    }
}
