package ru.stepup.spring.coins.core.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.stepup.spring.coins.core.api.ExecuteCoinsRequest;
import ru.stepup.spring.coins.core.api.ExecuteCoinsResponse;
import ru.stepup.spring.coins.core.services.impl.CoinsServiceImpl;

@RestController
@RequestMapping("/api/v1/coins")
public class CoinsController {
    private final CoinsServiceImpl coinsServiceImpl;

    public CoinsController(CoinsServiceImpl coinsServiceImpl) {
        this.coinsServiceImpl = coinsServiceImpl;
    }

    @PostMapping("/execute")
    public ExecuteCoinsResponse execute(@RequestBody ExecuteCoinsRequest request) {
        return coinsServiceImpl.execute(request);
    }
}
