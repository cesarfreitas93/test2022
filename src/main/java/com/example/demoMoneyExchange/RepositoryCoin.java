package com.example.demoMoneyExchange;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryCoin extends JpaRepository<DtoCoin, Long> {
}
