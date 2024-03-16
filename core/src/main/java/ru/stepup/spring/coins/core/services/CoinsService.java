package ru.stepup.spring.coins.core.services;

import ru.stepup.spring.coins.core.api.ExecuteCoinsRequest;
import ru.stepup.spring.coins.core.api.ExecuteCoinsResponse;

public interface CoinsService {
    ExecuteCoinsResponse execute(ExecuteCoinsRequest request);
}
