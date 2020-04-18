package com.example.portfolio.service.coach;

import com.example.portfolio.model.Coach;
import com.example.portfolio.service.GeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface ICoachService extends GeneralService<Coach>, UserDetailsService {
    Coach findByEmail(String email);
}
